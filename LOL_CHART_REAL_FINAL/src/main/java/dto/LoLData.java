package dto;

public class LoLData {
	private String cname;
	private double winrate;
	private double damagedealt;
	private double damagedefeat;
	
	public double getWinrate() {
		return winrate;
	}
	public void setWinrate(double winrate) {
		this.winrate = winrate;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getDamagedealt() {
		return damagedealt;
	}
	public void setDamagedealt(double damagedealt) {
		this.damagedealt = damagedealt;
	}
	public double getDamagedefeat() {
		return damagedefeat;
	}
	public void setDamagedefeat(double damagedefeat) {
		this.damagedefeat = damagedefeat;
	}
		
	
}
