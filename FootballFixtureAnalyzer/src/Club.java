public class Club {
	//-----------------------------------------------------
		// Title: Club class
		// Author: Arda Baran
		// Description: In this class , a football club in the league table is defined with its basic compenents such as
		// name of the club,number of played games,won,drawn,loss ,goals for,goals against,goals difference and points.
		//Club forms for 38 weeks are stored by using array implementation of queue
	    //-----------------------------------------------------
	public static final int FORM_CAPACITY=38;
String clubName;
int position,won,drawn,loss,goalsFor,goalsAgainst,goalsDifference,point,played, formTrackFirstGame,formTrackLastGame;
String [] form; // Queue Bag                                                     //front             //rear
String formResult;//Store Won,Loss Draw to add queue
public Club(String clubName) {//constructor of a club
	this.clubName=clubName;
    this.won=0;
    this.drawn=0;
    this.loss=0;
   this.goalsFor=0;
   this.goalsAgainst=0;
  this.goalsDifference=0;
   this.point=0;
this.played=0;
this.position=0;
this.formTrackFirstGame=-1;
this.formTrackLastGame=-1;
this.form= new String[FORM_CAPACITY];
this.formResult="";
}
// getter and setters

public int getPosition() {
	return position;
}

public void setPosition(int position) {
	this.position = position;
}
public boolean isFormStatisticsEmpty() {
	return (formTrackFirstGame==-1&&formTrackLastGame==-1);
}
public boolean isFormStatisticsFull() {
	return(formTrackLastGame==FORM_CAPACITY-1);
}
public void addFormToClub(String gameResult) {//add result of the club to queue
	if(isFormStatisticsFull()) {
		System.out.println("The Club Played Its All Games...");		
	}else if(isFormStatisticsEmpty()) {
		formTrackFirstGame=formTrackLastGame=0;
		form[formTrackLastGame]=gameResult;
	}else {
		formTrackLastGame++;
		form[formTrackLastGame]=gameResult;
	}

}
public void deleteFormStatisticFromClub() {
	if(isFormStatisticsEmpty()) {//can be used for displaying last 5 games of the club
		System.out.println("The Club Has No Played A Match Yet..");
	}else if(formTrackFirstGame==0 && formTrackLastGame==0) {
		formTrackFirstGame=formTrackLastGame=-1;	
	}else {
		formTrackFirstGame++;
	}
}
public String peek() {
	if(isFormStatisticsEmpty()) {
		return "";
	}
	return form[formTrackFirstGame];
}
public String[] getForm() {
	return form;//get all data from queue bag
}

public String getFormResult() {
	return formResult;
}

public void setFormResult(String formResult) {
	this.formResult = formResult;
}

public String getClubName() {
	return clubName;
}
public void setClubName(String clubName) {
	this.clubName = clubName;
}
public int getWon() {
	return won;
}
public void setWon(int won) {
	this.won = won;
}
public int getDrawn() {
	return drawn;
}
public void setDrawn(int drawn) {
	this.drawn = drawn;
}
public int getLoss() {
	return loss;
}
public void setLoss(int loss) {
	this.loss = loss;
}
public int getGoalsFor() {
	return goalsFor;
}
public void setGoalsFor(int goalsFor) {
	this.goalsFor = goalsFor;
}
public int getGoalsAgainst() {
	return goalsAgainst;
}
public void setGoalsAgainst(int goalsAgainst) {
	this.goalsAgainst = goalsAgainst;
}
public int getGoalsDifference() {
	return goalsDifference;
}
public void setGoalsDifference(int goalsDifference) {
	this.goalsDifference =goalsDifference;
}
public int getPoint() {
	return point;
}
public void setPoint(int point) {
	this.point = point;
}
public int getPlayed() {
	return played;
}
public void setPlayed(int played) {
	this.played = played;
}
public String[] getLastFiveGames() {
    String[] lastFiveGames = new String[5];
    int index = 0;
    for (int i = formTrackLastGame; i >= Math.max(0, formTrackLastGame - 4); i--) {
        lastFiveGames[index++] = form[i];
    }
    String[] reversedLastFiveGames = new String[5];
    for (int i = 0; i < 5; i++) {
        reversedLastFiveGames[i] = lastFiveGames[4 - i];
    }
    
    return reversedLastFiveGames;
}

}
