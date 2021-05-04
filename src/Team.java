//Gustav Lagneborg, gula4048.
import java.util.ArrayList;

public class Team {

	private String team;
	private int gold;
	private int silver;
	private int bronze;
	
	private ArrayList<Integer> teamMemberList = new ArrayList<>();
	
	
	public Team(String team){
		this.team = team;
		gold = 0;
		silver = 0;
		bronze = 0;
	
	}
	
	public String getTeam(){
		return team;
	}
	
	public void addTeamMember(int teamMemberNumber){
		teamMemberList.add(teamMemberNumber);
	}
	
	public ArrayList<Integer> getTeamMemberLit(){
		return teamMemberList;
	}
	
	public void setGold(){
		this.gold = gold;
	}
	
	public void setSilver(){
		this.silver = silver;
	}
	
	public void setBronze(){
		this.bronze = bronze;
	}
	
	
	public String toString(){
		return String.format("%d      %d      %d      %s",gold,silver,bronze,team);
	}
	
	
}
