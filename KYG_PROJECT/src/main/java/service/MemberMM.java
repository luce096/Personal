package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.MemberDao;
import dto.Forward;
import dto.Member;


public class MemberMM {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public MemberMM(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	
	public Forward memberJoin() {
	      Member mb=new Member();
	      mb.setCustname(request.getParameter("name"));
	      mb.setPhone(request.getParameter("tel"));
	      mb.setAddress(request.getParameter("address"));
	      mb.setGrade(request.getParameter("grade"));
	      mb.setCity(request.getParameter("city"));
	      MemberDao mDao=new MemberDao();  //커넥션 얻어옴
	      boolean result=mDao.memberJoin(mb);
	      mDao.close(); //커넥션 반납
	      
	      Forward fw=new Forward();
	      if(result) {
	         fw.setPath("index.jsp");
	         fw.setRedirect(false);
	      }else {
	         fw.setPath("join.jsp");
	         fw.setRedirect(false);
	      }
	      return fw;
	   }
	
	
	public Forward memberList() {
		Forward fw=new Forward();
		MemberDao mDao=new MemberDao();
		List<Member> mList=mDao.memberlist();
		mDao.close();
		if(mList!=null) {
			request.setAttribute("mList", mList);
			fw.setPath("memberList.jsp");
			fw.setRedirect(false);
		}
		return fw;
	}

	
	public Forward memberUpdate(){
		MemberDao mDao=new MemberDao();
		boolean result=mDao.memberUpdate(request, response); 
		mDao.close();
		Forward fw=new Forward();
	      if(result) {
	         fw.setPath("update.jsp");
	         fw.setRedirect(false);
	      }else {
	         fw.setPath("index.jsp");
	         fw.setRedirect(false);
	      }
	      return fw;
	}
	

}








