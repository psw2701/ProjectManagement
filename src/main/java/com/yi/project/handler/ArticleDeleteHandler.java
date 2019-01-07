package com.yi.project.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.project.mvc.CommandHandler;
import com.yi.project.service.ProjectService;

public class ArticleDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			String projectNo = req.getParameter("no");
			
			int no = Integer.parseInt(projectNo);
			req.setAttribute("no", projectNo);
			ProjectService service = ProjectService.getInstance();
			service.deleteProject(no);
			return "list.do";
		}
		return null;
	}

}
