public class Club {
	//-----------------------------------------------------
		// Title: Club class
		// Author: Arda Baran
		// Description: In this class , a football club in the league table is defined with its basic compenents such as
		// name of the club,number of played games,won,drawn,loss ,goals for,goals against,goals difference and points.
		//-----------------------------------------------------

String clubName;
int position,won,drawn,loss,goalsFor,goalsAgainst,goalsDifference,point,played;
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
}
// getter and setters
public int getPosition() {
	return position;
}

public void setPosition(int position) {
	this.position = position;
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
}