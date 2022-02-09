package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Forward;

public class MovingPage {
	HttpServletRequest request;
	HttpServletResponse response;
	
	Forward fw;
	HttpSession session;
	
	public MovingPage(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	private void joinFrmShow() {
		fw=new Forward();
		session=request.getSession();
		if(session.getAttribute("id")!=null) {
			//로그인 된 경우
			fw.setPath("main.jsp");
			fw.setRedirect(true);
		}else {
			fw.setPath("joinFrm.jsp");
			fw.setRedirect(false);
		}
	}
	private void loginFrmShow() {
		fw=new Forward();
		session=request.getSession();
		if(session.getAttribute("id")!=null) {
			//로그인 된 경우
			fw.setPath("main.jsp");
			fw.setRedirect(true);
		}else {
			fw.setPath("loginFrm.jsp");
			fw.setRedirect(false);
		}
	}

}
