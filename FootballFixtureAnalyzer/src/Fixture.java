public class Fixture {
	// Title: Fixture class
	// Author: Arda Baran
   // Description: In this class , a football league fixture is defined with its basic compenents such as
// name of the home team and away team clubs and their scores.After a competition is proccessed , clubs are updated.
//-----------------------------------------------------		
int game_id;
int week;
int homeTeamGoal,awayTeamGoal;
String homeTeamName,awayTeamName;
Club club;
public static int playedGames = 0;
public Fixture(String homeTeamName,String awayTeamName,int homeTeamGoal,int awayTeamGoal) {
	// Summary: consturctor of a fixture. A competition in the fixture consists of two teams and their scores	
	//------------------------------------------------------
		
	this.club=null;	 
    this.homeTeamName=homeTeamName;
    this.awayTeamName=awayTeamName;
this.homeTeamGoal=homeTeamGoal;
this.awayTeamGoal=awayTeamGoal;
playedGames++;
}
public Fixture() {
	// Summary:  default constructor	
	//--------------------------------------------------------
	
	super();
}
public int getNumberOfPlayedGames() {
	return playedGames;
}


public Club getClub() {
	return club;
}
public void setClub(Club club) {
	this.club = club;
}

public int getGame_id() {
	return game_id;
}
public void setGame_id(int game_id) {
	this.game_id = game_id;
}
public int getWeek() {
	return week;
}
public void setWeek(int week) {
	this.week = week;
}

public int getHomeTeamGoal() {
	return homeTeamGoal;

}
public void setHomeTeamGoal(int homeTeamGoal) {
	this.homeTeamGoal = homeTeamGoal;

}
public int getAwayTeamGoal() {
	return awayTeamGoal;
}
public void setAwayTeamGoal(int awayTeamGoal) {
	this.awayTeamGoal = awayTeamGoal;
}
public String getHomeTeamName() {
	return homeTeamName;
}
public void setHomeTeamName(String homeTeamName) {
	this.homeTeamName = homeTeamName;

}
public String getAwayTeamName() {
	return awayTeamName;
}
public void setAwayTeamName(String awayTeamName) {
	this.awayTeamName = awayTeamName;
	
}
public void  updateLeague(Club homeTeam,Club awayTeam,int homeTeamGoal,int awayTeamGoal) {
	//--------------------------------------------------------
	// Summary: updates all club's Pld,W,D,L,GF,GA,GD,Pts during fixture is proccessing.
	// Precondition: a football competition must have two teams as home team and away team
	//               and teams must have score such as 0,1,2 etc	
	//--------------------------------------------------------
	
	if(homeTeam!=null&&awayTeam!=null) {//condition that teams are present
	int homeWon=homeTeam.getWon();
int awayWon=awayTeam.getWon();	
int homeLoss=homeTeam.getLoss();
int awayLoss=awayTeam.getLoss();
int drawnHomeTeam=homeTeam.getDrawn();
int drawnAwayTeam=awayTeam.getDrawn();
int homeTeamGoalsFor=homeTeam.getGoalsFor();
int awayTeamGoalsFor=awayTeam.getGoalsFor();
int homeTeamAgainst=homeTeam.getGoalsAgainst();
int awayTeamAgainst=awayTeam.getGoalsAgainst();
int homePoint=homeTeam.getPoint();
int awayPoint=awayTeam.getPoint();
int homePlayed=homeTeam.getPlayed();
int awayPlayed=awayTeam.getPlayed();
if(homeTeamGoal > awayTeamGoal) {
//if home team scores more than away team this means that the winner of the competition is home team which leads to
//home team gets 3 points,away team gets no point, and the total number won games of home team increments by 1 ,the total
//number of lost games of away team increments by 1.the total number of drawn games are doesn't changed since there is
//a winner of the competition.goals for and goal againts are updated for both teams
	homeWon=homeWon+1; 
	homeTeam.setWon(homeWon); 
	awayLoss=awayLoss+1; 
	awayTeam.setLoss(awayLoss);
	homeTeamGoalsFor=homeTeamGoalsFor+homeTeamGoal;
	awayTeamGoalsFor=awayTeamGoalsFor+awayTeamGoal;
 
	homeTeamAgainst=homeTeamAgainst+awayTeamGoal; 
awayTeamAgainst=awayTeamAgainst+homeTeamGoal;	


homeTeam.setGoalsFor(homeTeamGoalsFor);
awayTeam.setGoalsFor(awayTeamGoalsFor);
homeTeam.setGoalsAgainst(homeTeamAgainst);
awayTeam.setGoalsAgainst(awayTeamAgainst);

homePoint=homePoint + 3;
awayPoint=awayPoint + 0;

homeTeam.setPoint(homePoint);
awayTeam.setPoint(awayPoint);

}else if(awayTeamGoal > homeTeamGoal) {
	//if away team scores more than home team this means that the winner of the competition is away team which leads to
	//away team gets 3 points,home team gets no point, and the total number won games of away team increments by 1 ,the total
	//number of lost games of home team increments by 1.the total number of drawn games are doesn't changed since there is
	//a winner of the competition.goals for and goal againts are updated for both teams. 	

	awayWon=awayWon+1;
	awayTeam.setWon(awayWon);
	homeLoss=homeLoss+1;
	homeTeam.setLoss(homeLoss);
	homeTeamGoalsFor=homeTeamGoalsFor+homeTeamGoal;
	awayTeamGoalsFor=awayTeamGoalsFor+awayTeamGoal;

homeTeamAgainst=homeTeamAgainst+awayTeamGoal; 
awayTeamAgainst=awayTeamAgainst+homeTeamGoal;	

homeTeam.setGoalsFor(homeTeamGoalsFor);
awayTeam.setGoalsFor(awayTeamGoalsFor);
homeTeam.setGoalsAgainst(homeTeamAgainst);
awayTeam.setGoalsAgainst(awayTeamAgainst);

homePoint=homePoint + 0;
awayPoint=awayPoint + 3;

homeTeam.setPoint(homePoint);
awayTeam.setPoint(awayPoint);

}else {
// if home team score equals to away team score this means that there is no winner of the competition so both teams earn 
// 1 point .the total number of drawn is incremented by 1 for both team.the total number of won and loss doesnt changed 
//since there is no winner of this competition.goals for and goal againts are updated for both teams.	

	drawnHomeTeam=drawnHomeTeam+1;
	homeTeam.setDrawn(drawnHomeTeam);
	drawnAwayTeam=drawnAwayTeam+1;
	awayTeam.setDrawn(drawnAwayTeam);
	
	homeTeamGoalsFor=homeTeamGoalsFor+homeTeamGoal;
	awayTeamGoalsFor=awayTeamGoalsFor+awayTeamGoal;

homeTeamAgainst=homeTeamAgainst+awayTeamGoal; 
awayTeamAgainst=awayTeamAgainst+homeTeamGoal;	

homeTeam.setGoalsFor(homeTeamGoalsFor);
awayTeam.setGoalsFor(awayTeamGoalsFor);
homeTeam.setGoalsAgainst(homeTeamAgainst);
awayTeam.setGoalsAgainst(awayTeamAgainst);

homePoint=homePoint + 1;
awayPoint=awayPoint + 1;

homeTeam.setPoint(homePoint);
awayTeam.setPoint(awayPoint);


}
//updates goal difference and total number of played for both team.
int homeTeamGoalDifference = homeTeamGoalsFor - homeTeamAgainst;
int awayTeamGoalDifference = awayTeamGoalsFor - awayTeamAgainst;
homeTeam.setGoalsDifference(homeTeamGoalDifference);
awayTeam.setGoalsDifference(awayTeamGoalDifference);
homePlayed=homePlayed+1;
	awayPlayed=awayPlayed+1;
homeTeam.setPlayed(homePlayed);
awayTeam.setPlayed(awayPlayed);	
	}
}
}