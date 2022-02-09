package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dto.Forward;


@WebServlet({"/menu","/LOL_Win", "/first", "/LOL_Dam", "/LOL_Tak", "/main","/championinfo"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getServletPath();
		System.out.println("cmd="+cmd);
		Forward fw = new Forward();
		switch(cmd) {
		case "/championinfo":
			fw.setPath("championinfo.jsp");
			fw.setRedirect(false);
			break;
		case "/main":
			fw.setPath("main.jsp");
			fw.setRedirect(false);
			break;
		case "/menu":
			//원래는 DB에 최신 메뉴리스틀 가져와야함.
			fw = new Forward();
			fw.setPath("menu.jsp");
			fw.setRedirect(false);
			break;
		case "/first":
			//원래는 DB에 최신 메뉴리스틀 가져와야함.
			fw = new Forward();
			fw.setPath("index.jsp");
			fw.setRedirect(false);
			break;
		case "/LOL_Win": 
			fw = new Forward();
			fw.setPath("LOL_Win.jsp");
			fw.setRedirect(false);
			break;
		case "/LOL_Dam":
			fw = new Forward();
			fw.setPath("LOL_Dam.jsp");
			fw.setRedirect(false);
			break;	
		case "/LOL_Tak":
			fw = new Forward();
			fw.setPath("LOL_Tak.jsp");
			fw.setRedirect(false);
			break;	
		}
		if(fw!=null) {
			if(fw.isRedirect()) {
				response.sendRedirect(fw.getPath());
			}else {
				request.getRequestDispatcher(fw.getPath()).forward(request,response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
