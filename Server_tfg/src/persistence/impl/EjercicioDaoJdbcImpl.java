package persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import business.model.Ejercicio;
import persistence.EjercicioDao;
import persistence.util.JdbcTemplate;
import persistence.util.RowMapper;

public class EjercicioDaoJdbcImpl implements EjercicioDao {
	
	public class EjercicioDtoMapper implements RowMapper<Ejercicio> {

		@Override
		public Ejercicio toObject(ResultSet rs) throws SQLException {
			return new Ejercicio(rs.getString("nombre"), rs.getString("descripcion"), rs.getString("consejo"), rs.getString("foto1"), rs.getString("foto2"), rs.getString("musculo"));
		}
	}

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Override
	public Long save(Ejercicio dto) {
		return (long) jdbcTemplate.execute("EJERCICIO_INSERT", 
				dto.getNombre(),
				dto.getDescripcion(),
				dto.getConsejo(),
				dto.getMusculo(),
				dto.getFoto1(),
				dto.getFoto2()
			);
	}

	@Override
	public int update(Ejercicio dto) {
		return jdbcTemplate.execute("EJERCICIO_UPDATE", 
				dto.getDescripcion(),
				dto.getConsejo(),
				dto.getMusculo(),
				dto.getFoto1(),
				dto.getFoto2(),
				dto.getNombre()
		);
	}

	@Override
	public int delete(Long id) {
		return jdbcTemplate.execute("EJERCICIO_DELETE", id);

	}

	@Override
	public Ejercicio findById(Long id) {
		return jdbcTemplate.queryForObject(
				"EJERCICIO_FIND_BY_ID", 
				new EjercicioDtoMapper(), 
				id
			);
	}

	@Override
	public List<Ejercicio> findAll() {
		return jdbcTemplate.queryForList(
				"EJERCICIO_FIND_ALL", 
				new EjercicioDtoMapper()
			);
	}

	@Override
	public int deleteByName(String name) {
		return jdbcTemplate.execute("EJERCICIO_DELETE_NAME", name);
		
	}

	@Override
	public List<Ejercicio> findByMusculo(String musculo) {
		return jdbcTemplate.queryForList(
				"EJERCICIO_FIND_BY_MUSCULO", 
				new EjercicioDtoMapper(),
				musculo
			);
	}


}
