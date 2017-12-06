package persistence.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import business.model.Serie;
import persistence.SerieDao;
import persistence.util.JdbcTemplate;
import persistence.util.RowMapper;

public class SerieDaoJdbcImpl implements SerieDao {

	public class SerieDtoMapper implements RowMapper<Serie> {

		@Override
		public Serie toObject(ResultSet rs) throws SQLException {
			return new Serie(rs.getInt("serieid"), rs.getInt("diaid"), rs.getString("nombreejercicio"), rs.getInt("series"),
					rs.getInt("repeticiones"), rs.getInt("descanso"));
		}
	}

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Override
	public int save(Serie serie, int diaid) {
		jdbcTemplate.execute("SERIE_INSERT", diaid, serie.getEjercicioId(), serie.getSeries(), serie.getRepeticiones(),
				serie.getDescanos());
		return jdbcTemplate.getGeneratedKey();
	}

}
