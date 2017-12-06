package persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import business.model.DiaEntreno;
import persistence.DiaRutinaDao;
import persistence.util.JdbcTemplate;
import persistence.util.RowMapper;

public class DiaRutinaDaoJdbcImpl implements DiaRutinaDao {
	
	public class DiaRutinaDtoMapper implements RowMapper<DiaEntreno> {
		@Override
		public DiaEntreno toObject(ResultSet rs) throws SQLException {
			return new DiaEntreno(rs.getInt("diaid"), rs.getString("nombrerutina"),
					rs.getInt("calorias"), rs.getInt("ordensemanal"));
		}
	}

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Override
	public int save(DiaEntreno diaEntreno, String nombreRutina) {
		jdbcTemplate.execute("DIA_RUTINA_INSERT", 
				nombreRutina, 
				diaEntreno.getCalorias(),
				diaEntreno.getOrdenSemanal()
			);
		return jdbcTemplate.getGeneratedKey();
	}



}
