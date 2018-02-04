package persistence.impl;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import business.model.GymUser;
import business.model.Usuario;
import persistence.UserDao;
import persistence.util.JdbcTemplate;
import persistence.util.RowMapper;

public class UserDaoJdbcImpl implements UserDao {

	public class UserDtoMapper implements RowMapper<Usuario> {

		@Override
		public Usuario toObject(ResultSet rs) throws SQLException {
			return new Usuario(rs.getString("userid"), rs.getString("password"), rs.getString("rutinaasignada"), rs.getInt("altura"),
					rs.getInt("peso"), rs.getBoolean("personalizar"), rs.getInt("userGym"), rs.getString("somatotipo"), rs.getString("objetivo"));
		}
	}
	
	public class UserGymDtoMapper implements RowMapper<GymUser> {
		@Override
		public GymUser toObject(ResultSet rs) throws SQLException {
			return new GymUser(rs.getInt("gym_id"), rs.getString("app_code"));
		}
	}

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Override
	public Long save(Usuario dto) {
		jdbcTemplate.execute("USER_INSERT", 
				dto.getUserid(),
				dto.getPassword(),
				dto.getRutinaasig(),
				dto.getAltura(),
				dto.getPeso(),
				dto.isPersonalizar(),
				dto.getGymId(),
				dto.getSomatotipo(),
				dto.getObjetivo()
			);
		return null;
	}

	@Override
	public int update(Usuario dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findLoggableUser(String login, String password) {
		return jdbcTemplate.queryForObject("USER_LOGIN", new UserDtoMapper(), 
				login,
				password
			);
	}

	@Override
	public GymUser verifyUser(int numberCard, String key) {
		return jdbcTemplate.queryForObject("USER_VERIFY", new UserGymDtoMapper(), 
				numberCard,
				key
			);
	}
	
}
