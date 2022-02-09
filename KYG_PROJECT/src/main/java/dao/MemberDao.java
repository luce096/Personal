package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;

public class MemberDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDao() {
		con=JdbcUtil.getConnection();
	}
	
	public void close() {
		JdbcUtil.close(rs, pstmt, con);
	}
	
	public boolean memberJoin(Member mb) {
	      String sql="insert into member_tbl_02 values(cn.nextval,?,?,?,default,?,?)";
	      int result=0; //성공 0아닌값
	      try {
	         pstmt=con.prepareStatement(sql);
	         /* pstmt.setNString(1, mb.getCustno()); */
	         pstmt.setNString(1, mb.getCustname());
	         pstmt.setNString(2, mb.getPhone());
	         pstmt.setNString(3, mb.getAddress());
	         pstmt.setNString(4, mb.getGrade());
	         pstmt.setNString(5, mb.getCity());
	         result=pstmt.executeUpdate(); //insert,delete,update
	         if(result!=0) {
	            return true; //회원가입 성공
	         }
	      } catch (SQLException e) {
	         System.out.println("회원가입 예외 발생");
	         e.printStackTrace();
	      } 
	      return false;
	   }
	
	
	public List<Member> memberlist() {
		List<Member> mList=new ArrayList<Member>();
		String sql="SELECT * FROM member_tbl_02";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=new Member();
				m.setCustno(rs.getInt("custno"));
				m.setCustname(rs.getNString("custname"));
				m.setPhone(rs.getNString("phone"));
				m.setAddress(rs.getNString("address"));
				m.setJoindate(rs.getNString("joindate"));
				m.setGrade(rs.getNString("grade"));
				m.setCity(rs.getNString("city"));
				mList.add(m);
			}
			return mList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
			
		return null;
	}
	

	public boolean memberUpdate(HttpServletRequest request, HttpServletResponse response) {
		String sql = "UPDATE MEMBER_TBL_02 SET CUSTNAME= ?, PHONE=?, ADDRESS=?, JOINDATE=?, GRADE=?, CITY=? WHERE CUSTNO = ?";
		try {
			pstmt = con.prepareStatement(sql); // 파싱
			// submit을 눌렀을 때 form안의 name이 Parameter값으로 변환된다.
			int num = Integer.parseInt(request.getParameter("num"));
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			String joindate = request.getParameter("joindate");
			String grade = request.getParameter("grade");
			String city = request.getParameter("city");
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, address);
			pstmt.setString(4, joindate);
			pstmt.setString(5, grade);
			pstmt.setString(6, city);
			pstmt.setInt(7, num);
			int cnt = pstmt.executeUpdate();
			// 결과값이 0일 경우 실패, 1일 경우 성공이다
			System.out.println(cnt);
		} catch (SQLException e) {
			System.out.println("삭제 실패");
			e.printStackTrace();
		}
		return false; // 삭제 실패
	}
	


}









