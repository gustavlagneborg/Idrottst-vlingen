import java.util.ArrayList;
import java.util.Collections;

public class EventResult {

	private String eventType;
	private int numberOfResults;
	private ArrayList<Double> resultList;
	
	public EventResult(String eventType){
		this.eventType = eventType;
		numberOfResults = 0;
		resultList = new ArrayList<Double>();
	}
	
	public String getEventType(){
		return eventType;
	}
	
	public void setEventType(String eventType){
		this.eventType = eventType;
	}

	public int getNumberOfResults(){
		return numberOfResults;
	}
	
	public void setNumberOfResults(int numberOfResults){
		this.numberOfResults = numberOfResults;
	}


	public ArrayList <Double> getResultList(){
		return resultList;
	}
	

	public void addResultToList(Double result){
		resultList.add(result);
		Collections.sort(resultList);
		Collections.reverse(resultList);
		
		numberOfResults++;
		
	}

	public double getResult(int i){
		return resultList.get(i);
	}
	

	public int sizeResultList(){
		return resultList.size();
	}

}

