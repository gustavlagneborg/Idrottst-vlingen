//Gustav Lagneborg, gula4048.

import java.util.ArrayList;

public class Result {

	private ArrayList<EventResult> eventResultList = new ArrayList<EventResult>();
	
	private int startNumberForResult;
	
	public Result(int startNumberForResult){
	
		this.startNumberForResult = startNumberForResult;
	
	}
	
	
	public int getStartNumberForResult(){
		return startNumberForResult;
	}
	
	public void setStartNumberForResult(int startNumberForResult){
		this.startNumberForResult = startNumberForResult;
	}
	
	public void addResult(String event, double result){
		
		boolean eventExist = false;
		
		for(int i=0;i<eventResultList.size();i++){
			if(event.equals(eventResultList.get(i).getEventType())){
				eventResultList.get(i).addResultToList(result);
				//if(result == eventResultList.get(i).getResultList().get(0)){
					//Program.addToResultTable(result);
				//}
				eventExist = true;
				
			}
		}
	
		if(eventExist == false){
			eventResultList.add(new EventResult(event));
			eventResultList.get(eventResultList.size() - 1).addResultToList(result);
		}
	}
	
	public int sizeEventResultList(){
		return eventResultList.size();
	}
	
	public ArrayList <EventResult> getEventResultList(){
		return eventResultList;
	}
	
	
	
}
