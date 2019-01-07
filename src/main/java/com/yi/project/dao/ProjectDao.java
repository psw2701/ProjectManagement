package com.yi.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.yi.project.model.ProjectManagement;




public interface ProjectDao {
	public int insert(ProjectManagement projectManagement) throws SQLException;

	public int selectLastNo() throws SQLException;

	public List<ProjectManagement> select() throws SQLException;
	
	public ProjectManagement selectByNo(int no) throws SQLException;
	
	public int delete(int no) throws SQLException;
	
	public int update (ProjectManagement projectManagement) throws SQLException;
}
