//Gustav Lagneborg, gula4048.

public class Participant {

	private String name;
	private String lastName;
	private String team;
	private int startNumber;
	
	
	public Participant(String name, String lastName, String team, int startNumber){
		this.name = name;
		this.lastName = lastName;
		this.team = team;
		this.startNumber = startNumber;
		
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public String getTeam(){
		return team;
	}
	
	public void setTeam(String team){
		this.team = team;
	}
	
	public int getStartNumber(){
		return startNumber;
	}
	
	public void setStartNumber(){
		this.startNumber = startNumber;
		
		}
	
	public String toString(){
		return String.format("%s %s från laget %s med startnummer %d", name, lastName, team, startNumber);
	}
	
}
