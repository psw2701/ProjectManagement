package com.yi.project.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.project.mvc.CommandHandler;
import com.yi.project.service.ProjectService;


public class ArticleReadHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		if(req.getMethod().equalsIgnoreCase("get")){
			//수정할 게시물 번호가 넘어와야 함.
			String projectNo = req.getParameter("no");
			int no = Integer.parseInt(projectNo);
			
			ProjectService service = ProjectService.getInstance();
			Map<String, Object> map = service.readProject(no);
			
			req.setAttribute("map", map);
			
			return "/WEB-INF/view/projectRead.jsp";
		} 

		return null;
	}

}
