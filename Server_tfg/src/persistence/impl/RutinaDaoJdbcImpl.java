package persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import business.model.Rutina;
import persistence.RutinaDao;
import persistence.util.JdbcTemplate;
import persistence.util.RowMapper;

public class RutinaDaoJdbcImpl implements RutinaDao {
	
	public class RutinaDtoMapper implements RowMapper<Rutina> {

		@Override
		public Rutina toObject(ResultSet rs) throws SQLException {
			return new Rutina(rs.getString("nombrerutina"), rs.getString("descripcion"),  
					rs.getString("somatotipo"),  rs.getString("objetivo"));
		}
	}

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Override
	public Long save(Rutina dto) {
		jdbcTemplate.execute("RUTINA_INSERT", 
				dto.getNombre(),
				dto.getDescripcion(),
				dto.getSomatotipo(),
				dto.getObjetivo()
			);
		return null;
	}

	@Override
	public int update(Rutina dto) {
		return jdbcTemplate.execute("RUTINA_UPDATE", 
				dto.getDescripcion(),
				dto.getSomatotipo(),
				dto.getObjetivo(),
				dto.getNombre()
		);
	}

	@Override
	public int delete(Long id) {
		return jdbcTemplate.execute("RUTINA_DELETE", id);

	}

	@Override
	public Rutina findById(Long id) {
		return jdbcTemplate.queryForObject(
				"RUTINA_FIND_BY_ID", 
				new RutinaDtoMapper(), 
				id
			);
	}
	
	@Override
	public Rutina findById(String id) {
		return jdbcTemplate.queryForObject(
				"RUTINA_FIND_BY_ID", 
				new RutinaDtoMapper(), 
				id
			);
	}

	@Override
	public List<Rutina> findAll() {
		return jdbcTemplate.queryForList(
				"RUTINA_FIND_ALL", 
				new RutinaDtoMapper()
			);
	}

	@Override
	public int deleteByName(String name) {
		return jdbcTemplate.execute("RUTINA_DELETE_NAME", name);
		
	}


}
