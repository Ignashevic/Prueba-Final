package com.ipartek.pruebafinal.repository;



import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
	
	
	private static final String SQL_GET_ALL = "SELECT * FROM `cursos`";
	private static final String SQL_INSERT = "INSERT INTO `cursos` (`nomcurso`, `codcurso`) VALUES (?,?);";
	private static final String SQL_UPDATE = "UPDATE `cursos` SET `nomcurso`= ? , `codcurso`= ?  WHERE `id`= ? ;";
	private static final String SQL_DELETE = "DELETE FROM `cursos` WHERE `id` = ?;";

	@Override
	public List<Curso> getAll() {
		return null;
	}

}
