package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.LoLDao;

import dto.Forward;
import dto.LoLData;


public class LoLMM {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public LoLMM(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String chartfrm() {
		//String id=request.getParameter("id");
		LoLDao lDao=new LoLDao();
		List<String> laneList=lDao.getLaneList();
		List<String> chamList=lDao.getChamList();
		Map<String,List<String>> hMap=new HashMap<>();
		hMap.put("laneList",laneList);
		hMap.put("chamList",chamList);
		lDao.close();
		String json=new Gson().toJson(hMap);
		if(json!=null)
			return json;
		return null;	
	}

	
	
	public String chamwin() {
		String cham=request.getParameter("cham");
		System.out.println(cham);
		LoLDao lDao=new LoLDao();
		List<String[]> lData=lDao.chamwin(cham);
		lDao.close();
		if(lData!=null) {
			return new Gson().toJson(lData);
		}
		return null;
	}
	
	public String damagedealt() {
		String lane=request.getParameter("lane");
		LoLDao lDao=new LoLDao();
		List<String[]> LOL_DAMAGEDEALT_Data=lDao.DamageDealt(lane);
		lDao.close();
		if(LOL_DAMAGEDEALT_Data!=null) {
			return new Gson().toJson(LOL_DAMAGEDEALT_Data);
		}
		return null;
	}
	
	public String damagetaken() {
		String lane=request.getParameter("lane");
		LoLDao lDao=new LoLDao();
		List<String[]> LOL_DAMAGEDEALT_Data=lDao.DamageDealt(lane);
		lDao.close();
		if(LOL_DAMAGEDEALT_Data!=null) {
			return new Gson().toJson(LOL_DAMAGEDEALT_Data);
		}
		return null;
	}
	
	public String winrate() {
		String lane=request.getParameter("lane");
		System.out.println(lane);
		LoLDao lDao=new LoLDao();
		List<String[]> lData=lDao.winrate(lane);
		lDao.close();
		if(lData!=null) {
			return new Gson().toJson(lData);
		}
		return null;
	}
}






