package com.yi.project.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.project.mvc.CommandHandler;
import com.yi.project.service.ProjectService;



public class ArticleInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/articleInsertForm.jsp";
		} else if (req.getMethod().equalsIgnoreCase("post")) {

			String name = req.getParameter("name");
			String content = req.getParameter("content");
			String start_date = req.getParameter("start");
			String end_date = req.getParameter("end");
			String progress = req.getParameter("progress");
			System.out.println("ArticleInsertHandler");
			
			ProjectService service = ProjectService.getInstance();
			int error = service.insertProject(name, content, start_date, end_date, progress);
			
			if(error <0){
				System.out.println("error : "+ error);
			}
			return"/WEB-INF/view/articleInsertSuccess.jsp";
		}
		return null;
	}

}
