//Gustav Lagneborg, gula4048.

public class Event {

	private String eventName;
	private int attempt;
	
	
	public Event(String eventName, int attempt){
		this.eventName = eventName;
		this.attempt = attempt;
		
		
	}
	
	public String getEventName(){
		return eventName;
	}
	
	public void setEventName(String eventName){
		this.eventName = eventName;
		
		
			
	}
	
	public int getAttempt(){
		return attempt;
	}
	
	public void setAttempt(int attempt){
		this.attempt = attempt;
	}
	
	
	
	
	public String toString(){
		return String.format("%s har lagts till",eventName);
		
	}
	
	
}