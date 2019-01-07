package com.yi.project.dao;

import java.sql.SQLException;

import com.yi.project.model.Content;


public interface ProjectContentDao {
	public int insert(Content content) throws SQLException;

	public Content selectByNo(int no) throws SQLException;
	
	public int delete(int no) throws SQLException;
	
	public int update(Content content) throws SQLException;

}
