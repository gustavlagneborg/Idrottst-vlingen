//Gustav Lagneborg, gula4048.sssssss

import java.util.Scanner;
import java.util.ArrayList;

public class Program {

	private Scanner keyboard = new Scanner(System.in);
	
	private ArrayList<Participant> participantRegister = new ArrayList<Participant>();
	private ArrayList<Event> eventRegister = new ArrayList<Event>();
	private ArrayList<Result> resultRegister = new ArrayList<Result>();
	private ArrayList<Team> teamRegister = new ArrayList<Team>();
	private ArrayList<PersonalRecord> resultTable = new ArrayList<PersonalRecord>(); 
	
	private int latestStartNumber = 100;
	
	public static void main(String[] args){
		new Program().run();
		return;
	}
	
	
	private void run() {
		setUp();
		runCommandLoop();
		closedown();
		return;
	}

	private String readString(){
		return keyboard.nextLine();
	}
	
	private int readInt(){
		int i = keyboard.nextInt();
		keyboard.nextLine();
		return i;
	}
	
	private double readDouble(){
		double d = keyboard.nextDouble();
		keyboard.nextLine();
		return d;
	}

	private void setUp(){
	 System.out.println("Idrottstävlingen\n");
	 System.out.println("Välj kommandon mellan 1 till 9 \n1. Lägg till gren \n2. Lägg till deltagare \n3. Ta bort deltagare \n4. Dokumentera resultat \n5. Visa resultatlista för deltagare \n6. Visa resultatlisa för vald gren \n7. Visa resultatlista för deltagande lag \n8. Skriv utt ett meddelande genom att skriva ut \"message\" i programmet \n9. Avsluta programmet ");
	 return;
	}

	private void runCommandLoop(){
		
		boolean running = true;
		while(running){
			System.out.println("Kommando: ");
			String cmd = readString().trim().toLowerCase();
			String cmdArray[] = cmd.split(" ",2);
			if(cmdArray[0].equals("message")){
				cmd = cmdArray[0];
			}
			switch (cmd) {
				case "1":
					addEvent();
					break;
					
				case "2":
					addParticipant();
					latestStartNumber++;
					break;
					
				case "3":
					removeParticipant();
					break;
					
				case "4":
					addResult();
					break;
				
				case "5":
					showSelectedParticipantResult();
					break;
					
				case "6":
					showSelectedEventResult();
					break;
					
				case "7":
					showTeamResult();
					break;
					
				case "message":
					message(cmdArray[1]);

					break;
					
				case "9":
					running = false;
					break;
				default:
					System.out.println("Wrong command");
					
			}
			
			
		}
		return;
	}

	private void addEvent() {
		String temporaryEventName;
		int temporaryEventAttempt;
	
		
		System.out.println("Skriv in gren: ");
		temporaryEventName = normalize(readString());
		
		
		if(searchThroughEventRegister(eventRegister,temporaryEventName) == null){
			
		}else{
			System.out.println(temporaryEventName + " has already been added");
			return;
		}
		
		
		
		
				
		System.out.println("Skriv in antal försök inom vald gren: ");
		
		temporaryEventAttempt = readInt();
		
		controllAttempt(temporaryEventAttempt);
		
		
		Event event;
		event = new Event(temporaryEventName, temporaryEventAttempt);
		
		eventRegister.add(event);
		
		System.out.println(event.toString());
	
		
		return;
		
		
		}

	private void addParticipant() {
		String testName;
		String testLastName;
		String testTeam;
		boolean test = false;
		
		System.out.println("Skriv in förnamn: ");
		testName = normalize(readString());
		
		System.out.println("Skriv in efternamn: ");
		testLastName = normalize(readString());
		
		System.out.println("Skriv in lagtillhörighet: ");
		testTeam = normalize(readString());
		
		Participant participant;
		participant = new Participant(testName, testLastName, testTeam, latestStartNumber);
		
		participantRegister.add(participant);
		
		System.out.println(participant.toString());
		System.out.println();
		
		for(int i=0;i<teamRegister.size();i++){
			if(testTeam.equals(teamRegister.get(i).getTeam())){
				teamRegister.get(i).addTeamMember(latestStartNumber);
				System.out.println(teamRegister.get(i).getTeam());
				test = true;
				}
			}
		
		if(test == false){
			System.out.println("test2");
			Team team;
			team = new Team(testTeam);
			
			team.addTeamMember(latestStartNumber);
			teamRegister.add(team);
		}
		
		System.out.println(teamRegister.size());
		
		
	return;	
	}

	private void removeParticipant() {
		int startNumber;
		
		System.out.println("Skriv startnummret på deltagaren som du önskar ta bort: ");
		startNumber = readInt();
		
		Participant removeObject = searchTroughParticipantRegister(participantRegister, startNumber);
				
		if(removeObject != null){
			for(int i=0;i<participantRegister.size();i++){
				System.out.println(removeObject.toString() + " är nu borttagen.");
			participantRegister.remove(i);
			
			}
		}else{
			System.out.println("Det finns ingen deltagare med startnummer " + startNumber);
			return;
		}
		
		
		
		
		
		
	return;
	} 		
	
	private void addResult() {
	
		int testStartNumberForResult;
		String testEvent;
		double testResult;
		
		
		System.out.println("Skriv startnummer för deltagaren i fråga: ");
		testStartNumberForResult = readInt();
		
		if(searchTroughParticipantRegister(participantRegister, testStartNumberForResult) != null){
			
			}else{
				System.out.println("Det finns ingen deltagare med startnummer " + testStartNumberForResult);
				return;
			}
		
		
		System.out.println("Skriv grenen som resultatet gäller i: ");
		testEvent = normalize(readString());
		
		
		if(searchThroughEventRegister(eventRegister, testEvent) == null){
			System.out.println("Det finns ingen gren med namnet " + testEvent);
			return;
		}
			
		
		for(int i=0;i<resultRegister.size();i++){
			if(testStartNumberForResult == resultRegister.get(i).getStartNumberForResult()){
				System.out.println("test2");
				for(int a=0;a<resultRegister.get(i).sizeEventResultList();a++){
					if(testEvent.equals(resultRegister.get(i).getEventResultList().get(a).getEventType())){
						if(resultRegister.get(i).getEventResultList().get(a).getNumberOfResults() == (searchThroughEventRegister(eventRegister, testEvent)).getAttempt()){
							System.out.println(participantRegister.get(i).toString() + " har redan gjort sina försök i denna gren.");
							return;
						}System.out.println("test3");
						for(int b=0;b<participantRegister.size();b++){
							if(testStartNumberForResult == participantRegister.get(b).getStartNumber()){
								System.out.println("test4");
								System.out.print("Resultat för " + participantRegister.get(b).toString() + " i grenen " + testEvent + " : " );
								testResult = readDouble();
								controllResult(testResult);
								resultRegister.get(i).addResult(testEvent, testResult);
								return;
							}
						}
					}
				}
				
				for(int b=0;b<participantRegister.size();b++){
					if(testStartNumberForResult == participantRegister.get(b).getStartNumber()){
						System.out.print("Resultat för " + participantRegister.get(b).toString() + " i grenen " + testEvent + " : " );
						testResult = readDouble();
						controllResult(testResult);
						resultRegister.get(i).addResult(testEvent, testResult);
						return;
					}
				}
			}
		}
		
		
		Result result;
		result = new Result(testStartNumberForResult);
		
		for(int i=0;i<participantRegister.size();i++){
			if(testStartNumberForResult == participantRegister.get(i).getStartNumber()){
				System.out.print("Resultat för " + participantRegister.get(i).toString() + " i grenen " + testEvent + " : " );
				testResult = readDouble();
				controllResult(testResult);
				System.out.println("test");
				result.addResult(testEvent, testResult);
			}
		}
		
		resultRegister.add(result);
		
		//boolean participantExistsInResultTable = false;
		
		//for(int i=0;i<resultTable.size();i++){
			//if(testStartNumberForResult == teamRegister.get(i).getTeamMemberLit().get(i)){
				
			//}
		//}
		
		
		return;
	}
	
	private void showSelectedParticipantResult(){
		
		int testStartNumberForResult;
		
		boolean participantHasResult = false;

		System.out.println("Skriv startnummer för deltagaren i fråga: ");
		testStartNumberForResult = readInt();
		
		if(searchTroughParticipantRegister(participantRegister, testStartNumberForResult) != null){
			
		}else{
			System.out.println("Det finns ingen deltagare med startnummer " + testStartNumberForResult);
			return;
		}
		
		
		
		
		
		
		for(int i=0;i<resultRegister.size();i++){
			if(testStartNumberForResult == resultRegister.get(i).getStartNumberForResult()){
				for(int b=0;b<resultRegister.get(i).sizeEventResultList();b++){
					System.out.print("Resultat för deltagaren med startNummer " + testStartNumberForResult + " i grenen " + resultRegister.get(i).getEventResultList().get(b).getEventType() + " ");
					for(int a=0;a<resultRegister.get(i).getEventResultList().get(b).sizeResultList();a++){
						System.out.print(resultRegister.get(i).getEventResultList().get(b).getResultList().get(a) + "\n");
						participantHasResult = true;
					}	
				}
			}
		}
		
		if( participantHasResult == false){
			System.out.println("Deltagaren har inga resultat att presentera!");
		}
		
		return;
	}
	
	private void showSelectedEventResult(){
		String testEvent;
		
		System.out.println("Skriv in grenen som du vill se en resultat tabell på: ");
		testEvent = normalize(readString());
		
		if(searchThroughEventRegister(eventRegister, testEvent) == null){
			System.out.println("Det finns ingen gren med namnet " + testEvent);
			return;
		}
		
		
		
		
		
		return;
	}
	
	private void showTeamResult(){
		System.out.println("1st    2st    3st    Team name");
		System.out.println("*************************************");
		
		for(int i=0;i<teamRegister.size();i++){
			System.out.println(teamRegister.get(i).toString());
		}
		
		
		return;
	}
	
	private void message(String message){
	
		
		
		
		 message = " " + message;
	
		if(message.length() > 57){
			message = message.substring(0,57) + " ";
		}
		
		boxString(message.toUpperCase());
		
		return;
	}
	
	
	public String normalize(String input){
		
		input = input.trim().toLowerCase();
		while (input.isEmpty()){
				System.out.println("Names can´t be empty");
				input = readString().trim().toLowerCase();
		}
			
		input = input.substring(0, 1).toUpperCase() + input.substring(1);
		
		return input;
	}
	
	
	private static void boxString(String contents){
		int n = 58;
		contents = String.format("%-58s", contents);
	
		for(int i=0;i<n+2;i++){
			System.out.print("#");
		}
		System.out.println();
		
		System.out.print("#");
		for(int i=0;i<n;i++){
			System.out.print(" ");
		}
		System.out.println("#");
		
		System.out.println("#" + contents + "#");
		
		System.out.print("#");
		for(int i=0;i<n;i++){
			System.out.print(" ");
		}
		System.out.println("#");
		
		for(int i=0;i<n+2;i++){
			System.out.print("#");
		}
	System.out.println();
	
	}
	
	
	public Event searchThroughEventRegister(ArrayList<Event> eventRegister, String testEvent){
		
		for(int i=0;i<eventRegister.size();i++){
		if(testEvent.equals(eventRegister.get(i).getEventName())){
		return eventRegister.get(i);
		
			}
		}
		return null;
	}

	
	
	public Participant searchTroughParticipantRegister(ArrayList<Participant> participantRegister, int startNumber){

	for(int i=0;i<participantRegister.size();i++){
		if(startNumber == participantRegister.get(i).getStartNumber()){
			return participantRegister.get(i);
		}
	}
	
	return null;
	
}


public int controllAttempt(int number){
	
	while(number<=0){
		System.out.println("Too low, must allow at least one attempt: ");
		number = readInt();
	}
	
	return number;
}
	

public double  controllResult(double number){

	while(number<0){
		System.out.println("Must be greater than or equal to zero! ");
		number = readDouble();
	}
	
	return number;
}

public void addToResultTable(PersonalRecord result){
	resultTable.add(result);
}


	private void closedown() {
		keyboard.close();
		return;
	}

}
