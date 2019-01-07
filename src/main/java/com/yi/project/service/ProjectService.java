package com.yi.project.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yi.project.dao.ProjectContentDao;
import com.yi.project.dao.ProjectDao;

import com.yi.project.model.Content;
import com.yi.project.model.ProjectManagement;
import com.yi.project.mvc.MySqlSessionFactory;



public class ProjectService {
	private static ProjectService service = new ProjectService();

	public static ProjectService getInstance() {
		return service;
	}

	// -1 : id에 해당하는 member가 없을수 있음
	// -2 : article 저장실패
	// -3 : articleContent 저장 실패
	// -4 : 특수경우
	// 0 : sucess
	public int insertProject(String name, String content, String start_date, String end_date, String progress) {
		/*
		 * 1.id에 해당하는 name값 가져오기 2. article 저장 3. article_content 저장
		 */

		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();

			// 2. article 저장
			ProjectDao projectDao = session.getMapper(ProjectDao.class);
			Date now = new Date();
			ProjectManagement projectManagement = new ProjectManagement(0, name, start_date, end_date, progress);
			projectDao.insert(projectManagement);
			int article_no = projectDao.selectLastNo();
			if (article_no < 0) {
				return -2;
			}

			// 3. article content 저장
			ProjectContentDao contentDao = session.getMapper(ProjectContentDao.class);
			Content pContent = new Content(article_no, content);
			int result = contentDao.insert(pContent);
			if (result < 0) {
				return -3;
			}
			session.commit();
			return 0;
		} catch (Exception e) {
			session.rollback(); // isnert과정 sqlException발생 하면 rollback처리함
			e.printStackTrace();
		} finally {
			session.close();
		}
		return -4;
	}

	public List<ProjectManagement> projectList() {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao projectDao = session.getMapper(ProjectDao.class);
			return projectDao.select();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public Map<String, Object> readProject(int no) {
		SqlSession session = null;

		try {
			session = MySqlSessionFactory.openSession();
			ProjectDao projectDao = session.getMapper(ProjectDao.class);
			ProjectContentDao contentDao = session.getMapper(ProjectContentDao.class);

			ProjectManagement projectManagement = projectDao.selectByNo(no);
			Content content = contentDao.selectByNo(no);

			// article, content 두개 다 return 해야함
			Map<String, Object> map = new HashMap<>();
			map.put("projectManagement", projectManagement);
			map.put("content", content);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public int deleteProject(int no){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			
			//1. project
			ProjectDao projectDao = session.getMapper(ProjectDao.class);
			//project_no 검색해서 그 내용들을 삭제해야 함
			ProjectManagement project = projectDao.selectByNo(no);
			//project에 있는 project_no와 매개변수로 받은 no와 같아야만 삭제 가능
			if(project.getNo() == no){
				projectDao.delete(no);
			} else{
				return -1;
			}
			
			//2. project_content
			ProjectContentDao contentDao = session.getMapper(ProjectContentDao.class);
			Content content = contentDao.selectByNo(no);
			if(content.getNo() == no){
				contentDao.delete(no);
			} else{
				return -2;
			}
			
			//둘 다 삭제 성공했을 경우
			session.commit();
			return 0;
			
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return -3;
	}

	public int modifyProject(ProjectManagement newProject, Content newContent){
		SqlSession session = null;
		
		try {
			session = MySqlSessionFactory.openSession();
			
			//1. project
			ProjectDao projectDao = session.getMapper(ProjectDao.class);
			projectDao.update(newProject);
			
			//2. project_content
			ProjectContentDao contentDao = session.getMapper(ProjectContentDao.class);
			contentDao.update(newContent);
			
			session.commit();
			
			return 0;
			
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return -1;
	}
}
