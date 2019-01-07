package com.yi.project.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.project.model.Content;
import com.yi.project.model.ProjectManagement;
import com.yi.project.mvc.CommandHandler;
import com.yi.project.service.ProjectService;

public class ArticleUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			//수정할 게시물 번호가 넘어와야 함.
			String projectNo = req.getParameter("no");
			int no = Integer.parseInt(projectNo);
			
			ProjectService service = ProjectService.getInstance();
			Map<String, Object> map = service.readProject(no);
			
			req.setAttribute("map", map);
			
			return "/WEB-INF/view/projectUpdateForm.jsp";

		}else if(req.getMethod().equalsIgnoreCase("post")){
			//수정할 게시물 번호
			String projectNo = req.getParameter("no");
			int no = Integer.parseInt(projectNo);
			
			//수정해야 할 내용들 : 이름, 내용, 날짜, 진행 상태
			String name = req.getParameter("name");
			String content = req.getParameter("content");
			String start = req.getParameter("start");
			String end = req.getParameter("end");
			String progress = req.getParameter("progress");
			
			ProjectService service = ProjectService.getInstance();
			
			ProjectManagement project = new ProjectManagement();
			project.setNo(no);
			project.setName(name);
			project.setStart_date(start);
			project.setEnd_date(end);
			project.setProgress(progress);
			
			Content projectContent = new Content();
			projectContent.setNo(no);
			projectContent.setContent(content);
			
			//수정 결과 -> int로 받음(0: 성공, -1: 실패)
			int isModify = service.modifyProject(project, projectContent);
			
			//수정결과가 0보다 작으면 수정 실패
			if(isModify < 0){
				System.out.println("수정에 실패했습니다. isModify = " + isModify);
			}
			
			req.setAttribute("isModify", isModify);
			
			//수정 성공 후 상세보기 화면으로 돌아가기
			res.sendRedirect("read.do?no=" + no);
		}
		return null;
	}
}
