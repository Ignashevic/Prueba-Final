package com.ipartek.pruebafinal.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.pruebafinal.vo.Curso;

public class CursoMapper implements RowMapper<Curso> {

	@Override()
	public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
		Curso cur = new Curso();

		cur.setId(rs.getLong("id"));
		cur.setNombrecur(rs.getString("nomcurso"));
		cur.setCodigocur(rs.getString("codcurso"));

		return cur;
	}


}