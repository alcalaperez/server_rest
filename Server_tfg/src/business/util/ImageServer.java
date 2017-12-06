package business.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class ImageServer {
	private Cloudinary cloudinary;

	public String uploadImage(String url) {
		initialise();
		Map<String, String> uploadResult = null;
		try {
			uploadResult = cloudinary.uploader().upload(new File(url), ObjectUtils.emptyMap());
		} catch (IOException e) {
			System.out.println("Seleccione una imagen");
		}
		return uploadResult.get("url").toString();
	}

	private void initialise() {
		cloudinary = new Cloudinary(ObjectUtils.asMap("api_key", "676226828892524", "api_secret", "tt8FSbHbufxxWpfCrb-W-JaACx0",
				"cloud_name", "uo226321"));

	}

}
