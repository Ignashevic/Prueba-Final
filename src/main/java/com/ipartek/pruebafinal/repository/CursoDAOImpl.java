package com.ipartek.pruebafinal.repository;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.pruebafinal.mapper.CursoMapper;
import com.ipartek.pruebafinal.vo.Curso;



@Repository(value ="cursodao")
public class CursoDAOImpl implements CursoDAO {
	
	
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired()
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired()
	@Override()
	public void setDatasource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	
	private static final String SQL_GET_ALL = "SELECT * FROM `cursos` ORDER BY `id` DESC;";
	private static final String SQL_GET_LAST_TEN = "SELECT * FROM `cursos` ORDER BY `id` DESC LIMIT 10;";
	private static final String SQL_INSERT = "INSERT INTO `cursos` (`nomcurso`, `codcurso`) VALUES (?,?);";
	private static final String SQL_UPDATE = "UPDATE `cursos` SET `nomcurso`= ? , `codcurso`= ?  WHERE `id`= ? ;";
	private static final String SQL_DELETE = "DELETE FROM `cursos` WHERE `id` = ?;";
	private static final String SQL_GET_BY_ID = "SELECT `id`, `nomcurso`, `codcurso` FROM `cursos` WHERE `id` = ?";

	@Override
	public List<Curso> getAll() {
		ArrayList<Curso> lista = new ArrayList<Curso>();
		
		try {
			lista = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_GET_ALL, new CursoMapper());
		
		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existen cursos todavia");
		
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		
		return lista;
	}
	
	@Override
	public List<Curso> getAllTen() {
		ArrayList<Curso> lista = new ArrayList<Curso>();
		
		try {
			lista = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_GET_LAST_TEN, new CursoMapper());
		
		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existen cursos todavia");
		
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public Curso getById(long id) {
		Curso cur = null;
		try {
			cur = this.jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[] { id }, new CursoMapper());
		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existen el curso");
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}

		return cur;
	}

	@Override
	public boolean insert(final Curso cur) {
		boolean resul = false;
		try {
			int affectedRows = -1;
			KeyHolder keyHolder = new GeneratedKeyHolder();

			affectedRows = this.jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					final PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
						ps.setString(1, cur.getNombrecur());
						ps.setString(2, cur.getCodigocur());
					return ps;
				}
			}, keyHolder);

			if (affectedRows == 1) {
				resul = true;
				cur.setId(keyHolder.getKey().longValue());
			}

		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return resul;
	}

	@Override
	public boolean update(Curso cur) {
		boolean resul = false;
		int affectedRows = -1;
		try {
			Object[] argumentos = {cur.getNombrecur(),cur.getCodigocur(),cur.getId() };
			affectedRows = this.jdbcTemplate.update(SQL_UPDATE, argumentos);
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		try {
			int affectedRows = this.jdbcTemplate.update(SQL_DELETE, id);
			if (affectedRows == 1) {
				resul = true;
			}
		} catch (DataIntegrityViolationException e) {
			this.logger.warn(e.getMessage());
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return resul;
	}
	
	

}
