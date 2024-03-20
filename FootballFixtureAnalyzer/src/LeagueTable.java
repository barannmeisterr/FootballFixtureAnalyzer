import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
public class LeagueTable extends Fixture{
	// Title: LeagueTable class
	// Author: Arda Baran
   // Description: In this class , a football league table is derived from a fixture.That's why Inheritance is used for
// proccessing fixture.
//Hash Map,Comparator and List Data structures are used to process fixture, print the league orderly , print the qualified
//teams for europe cups,champion of the league and relegated teams.Also Fundamental statistics are calculated and printed.	
//-----------------------------------------------------	
	
	public void processFixture(HashMap<String, Club> clubs, String homeTeamName, String awayTeamName, int homeTeamGoals, int awayTeamGoals) {
	//Since each team in the league are unique,HashMap is used.			
		Club homeTeam=clubs.getOrDefault(homeTeamName, new Club(homeTeamName));
	    Club awayTeam=clubs.getOrDefault(awayTeamName, new Club(awayTeamName));
	Fixture games=new Fixture(homeTeamName,awayTeamName,homeTeamGoals,awayTeamGoals);
	//Updates each team.
	games.updateLeague(homeTeam, awayTeam, homeTeamGoals, awayTeamGoals);
	clubs.put(homeTeamName, homeTeam);
	clubs.put(awayTeamName, awayTeam);
	}
	
	public void printLeagueTable(HashMap<String, Club> clubs) {
//sort the club with respect to their total points.if points of two team in the league are equal then compare to goal
//difference , if the differences are equal then compare to goals for.		
		
		List<Club> sortedClubs = new ArrayList<>(clubs.values());
	    sortedClubs.sort(Comparator.comparingInt(Club::getPoint).reversed()
	            .thenComparingInt(Club::getGoalsDifference).reversed()
	            .thenComparingInt(Club::getGoalsFor).reversed());

	    
	    System.out.printf("%-10s %-30s %-10s %-10s %-10s %-10s %-7s %-7s %-7s %-10s%n", "Position", "Club", "Played", "Won", "Drawn", "Lost", "GF", "GA", "GD", "Points");
	    
	    int position = 1;
	    for (Club club : sortedClubs) {
	    	club.setPosition(position++);
	    	System.out.printf("%-10d %-30s %-10d %-10d %-10d %-10d %-7d %-7d %-7d %-10d%n", club.getPosition(), club.getClubName(),
                     club.getPlayed(), club.getWon(), club.getDrawn(), club.getLoss(), club.getGoalsFor(),
                     club.getGoalsAgainst(), club.getGoalsDifference(), club.getPoint());
	
	    }
	}
	 public void printClubStatus(HashMap<String, Club> clubs) {
//prints the champion.Then prints champions league ,europe league ,conference league qualified teams and relegated teams.   
		 
		 List<Club> sortedClubs = new ArrayList<>(clubs.values());
	        sortedClubs.sort(Comparator.comparingInt(Club::getPoint).reversed()
	                .thenComparingInt(Club::getGoalsDifference).reversed()
	                .thenComparingInt(Club::getGoalsFor).reversed());
          ArrayList<String> leagueChampion= new ArrayList<>();
	        ArrayList<String> championsLeague= new ArrayList<>();
	        ArrayList<String> europeLeague= new ArrayList<>();
	        ArrayList<String > conferenceLeague=new ArrayList<>();  
	        ArrayList<String> relegated=new ArrayList<>();
	        int position = 1;
		    for (Club club : sortedClubs) {
		    club.setPosition(position++);
		   if(club.getPosition()==1) {
		    leagueChampion.add(club.getClubName());
		   }
		    if(club.getPosition()>=1 && club.getPosition()<=4) {
		    	championsLeague.add(club.getClubName());
		    }else if(club.getPosition()>4 && club.getPosition()<=6) {
		    	europeLeague.add(club.getClubName());
		    }else if(club.getPosition()==7) {
		    	conferenceLeague.add(club.getClubName());
		    }
		    else if(club.getPosition()>17 && club.getPosition()<=20) {
		    	relegated.add(club.getClubName());
		    }
		    }
	 System.out.println("League Champion: ");
	 printStatusHelper(leagueChampion);	    
     System.out.println("Qualified Teams For UEFA Champions League Group Stage: ");
	 printStatusHelper(championsLeague);
	 System.out.println("Qualified Teams For UEFA Europe League Group Stage: ");
	 printStatusHelper(europeLeague);
	 System.out.println("Qualified Teams For UEFA Conference League play-off round: ");
	 printStatusHelper(conferenceLeague);
	 System.out.println("Relegated Teams: ");
	 printStatusHelper(relegated);
	 }
	 public void printStatusHelper(List<String> teams) {
	        for (String team : teams) {
	            System.out.println(team);
	        }
	        System.out.println();
	    }
public void LeagueStatistics(HashMap<String, Club> clubs) {
//prints the league table statistics.
int matchesPlayed=getNumberOfPlayedGames();
int goalsScored=0;
double goalsScoredPerGame=0.0;	
List<Club> sortedClubs = new ArrayList<>(clubs.values());
sortedClubs.sort(Comparator.comparingInt(Club::getPoint).reversed()
        .thenComparingInt(Club::getGoalsDifference).reversed()
        .thenComparingInt(Club::getGoalsFor).reversed());

for(Club club : sortedClubs) {
	goalsScored=goalsScored+club.getGoalsFor();
       
}
goalsScoredPerGame=goalsScored / (double) matchesPlayed; // casting 
System.out.println("Played Matches: " + matchesPlayed);
System.out.println("Goals Scored: "+goalsScored);
System.out.printf("Goals Scored Per Matches: %.2f\n",goalsScoredPerGame );
}	 
}