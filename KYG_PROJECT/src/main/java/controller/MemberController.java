package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Forward;
import service.MemberMM;
import service.MovingPage;

@WebServlet({"/memberJoin","/main","/memberList","/memberInfo","/memberUpdate","/join","/list","/plist"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd=request.getServletPath();
		System.out.println("cmd="+cmd);
		//회원관리 서비스클래스
		MemberMM mm=new MemberMM(request,response);
		//화면 이동 서비스클래스
		MovingPage mp=new MovingPage(request,response);
		
		Forward fw=null;
		if(cmd.equals("/memberJoin")) {
			fw=mm.memberJoin();
		}else if(cmd.equals("/main")) {
			fw=new Forward();
			fw.setPath("main.jsp");
			fw.setRedirect(false);
		}else if(cmd.equals("/memberList")) {
			fw=mm.memberList();
		}else if(cmd.equals("/memberUpdate")) {
			fw=mm.memberUpdate();
		}else if(cmd.equals("/join")) {
			fw=new Forward();
			fw.setPath("join.jsp");
			fw.setRedirect(false);
		}else if(cmd.equals("/menu")) {
			fw=new Forward();
			fw.setPath("menu.jsp");
			fw.setRedirect(false);
		}
		//포워딩
		if(fw!=null) {
			if(fw.isRedirect()) {
				response.sendRedirect(fw.getPath());
			}else {
				RequestDispatcher dis=request.getRequestDispatcher(fw.getPath());
				dis.forward(request, response);
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