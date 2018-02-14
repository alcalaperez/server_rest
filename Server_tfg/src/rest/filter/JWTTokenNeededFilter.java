package rest.filter;

import java.io.IOException;


import java.util.Base64;
import javax.annotation.Priority;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Jwts;
import rest.JWTTokenNeeded;

@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter {

	byte[] decodedKey = Base64.getDecoder().decode("11162210");
	SecretKey keySign = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES"); 
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		// Get the HTTP Authorization header from the request
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (authorizationHeader != null) {

			// Extract the token from the HTTP Authorization header
			String token = authorizationHeader.substring("Bearer".length()).trim();

			try {
				Jwts.parser().setSigningKey(keySign).parseClaimsJws(token);

			} catch (Exception e) {
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
		} else {
            System.out.println("JWT missing");
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());


		}
	}
}
