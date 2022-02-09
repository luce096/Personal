package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dto.LoLData;


public class LoLDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public LoLDao() {
		con=JdbcUtil.getConnection();
	}
	public void close() {
		JdbcUtil.close(rs, pstmt, con);
	}
	public List<String> getLaneList() {
		List<String> laneList=null;
		String sql="select DISTINCT(lane) lane from r";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			laneList=new ArrayList<String>();
			while(rs.next()) {
				laneList.add(rs.getNString("LANE"));
			}
			return laneList;
		} catch (SQLException e) {
			System.out.println("mDao getLaneList 예외");
			e.printStackTrace();
		}
		return null; //실패
	}
	public List<String> getChamList() {
		List<String> chamList=null;
		String sql="SELECT c.champion_name_kr c_name FROM C";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			chamList=new ArrayList<String>();
			while(rs.next()) {
				chamList.add(rs.getNString("C_NAME"));
			}
			return chamList;
		} catch (SQLException e) {
			System.out.println("mDao getChamList 예외");
			e.printStackTrace();
		}
		return null; //실패
	}
	
	public List<String[]> chamwin(String cham) {
		String sql="SELECT CNAME, WINRATE, LANE "
				+ " FROM (SELECT CNAME, LANE, WINRATE "
				+ "      FROM TOTAL_WINRATE WHERE CNAME = ? "
				+ "      ORDER BY WINRATE DESC)"
				+ " WHERE ROWNUM <= 5";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, cham);
			
			rs=pstmt.executeQuery();
			List<String[]> lList=new ArrayList<String[]>();
			int i=0;
			while(rs.next()) {
				//LoLData lData=new LoLData();
				String[] row=new String[2];   //["애니", "100.0"],[], []
				row[0]=rs.getString("LANE");
				row[1]=String.valueOf(rs.getDouble("WINRATE"));
				lList.add(row);
			}
			return lList;
		} catch (SQLException e) {
			System.out.println("chamwin 예외");
			e.printStackTrace();
		}
		return null;
	}	
	
	public List<String[]> DamageDealt(String lane) {
		String sql = "SELECT CNAME, DAMAGEDEALT FROM"
				+ " (SELECT CNAME, DAMAGEDEALT"
				+ " FROM TOTAL_DAMAGEDEALT WHERE LANE = ?"
				+ " ORDER BY DAMAGEDEALT DESC) WHERE ROWNUM <= 3";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, lane);
			rs=pstmt.executeQuery();
			List<String[]> dList=new ArrayList<String[]>();
			int i=0;
			while(rs.next()) {
				//LoLData lData=new LoLData();
				String[] row=new String[2];   //["애니", "100.0"],[], []
				row[0]=rs.getString("CNAME");  
				row[1]=String.valueOf(rs.getInt("DAMAGEDEALT"));
				dList.add(row);
			}
			return dList;
		} catch (SQLException e) {
			System.out.println("DAMAGEDEALT 예외");
			e.printStackTrace();
		}
		return null;
	}	
	

	public List<String[]> DamageTaken(String lane) {
		String sql = "SELECT CNAME, DAMAGETAKEN"
				+ " FROM (SELECT CNAME, DAMAGETAKEN"
				+ " FROM TOTAL_DAMAGETAKEN WHERE LANE = ?"
				+ " ORDER BY DAMAGETAKEN DESC)"
				+ " WHERE ROWNUM <= 3";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, lane);
			rs=pstmt.executeQuery();
			List<String[]> dList=new ArrayList<String[]>();
			int i=0;
			while(rs.next()) {
				//LoLData lData=new LoLData();
				String[] row=new String[2];   //["애니", "100.0"],[], []
				row[0]=rs.getString("CNAME");  
				row[1]=String.valueOf(rs.getInt("DAMAGETAKEN"));
				dList.add(row);
			}
			return dList;
		} catch (SQLException e) {
			System.out.println("DAMAGETAKEN 예외");
			e.printStackTrace();
		}
		return null;
	}	
	
	public List<String[]> winrate(String lane) {
		String sql="SELECT CNAME, WINRATE"
				+ " FROM (SELECT CNAME, WINRATE"
				+ "      FROM TOTAL_WINRATE WHERE LANE = ?"
				+ "      ORDER BY WINRATE DESC)"
				+ " WHERE ROWNUM <= 3";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, lane);
			rs=pstmt.executeQuery();
			List<String[]> lList=new ArrayList<String[]>();
			int i=0;
			while(rs.next()) {
				//LoLData lData=new LoLData();
				String[] row=new String[2];   //["애니", "100.0"],[], []
				row[0]=rs.getString("CNAME");  
				row[1]=String.valueOf(rs.getDouble("WINRATE"));
				lList.add(row);
			}
			return lList;
		} catch (SQLException e) {
			System.out.println("winrate 예외");
			e.printStackTrace();
		}
		return null;
	}	
	
}














