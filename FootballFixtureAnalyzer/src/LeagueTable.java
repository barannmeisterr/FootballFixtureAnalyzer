import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
public class LeagueTable extends Fixture{
	// Title: LeagueTable class
	// Author: Arda Baran
   // Description: In this class , a football league table is derived from a fixture.That's why Inheritance is used for
// proccessing fixture.
//Hash Map,Comparator and List Data structures are used to process fixture, print the league orderly , print the qualified
//teams for europe cups,champion of the league and relegated teams.Also Fundamental statistics are calculated and printed.	
// The Forms of all clubs in the league , (from the beginning of the league to end of the league) are printed.
// longest winning run ,longest losing run ,longest unbeaten run are calculated and printed.
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
	    // Sort the clubs with respect to their total points. If points of two teams in the league are equal, then compare to goal
	    // difference. If the differences are equal, then compare to goals for.
	    List<Club> sortedClubs = new ArrayList<>(clubs.values());
	    sortedClubs.sort(Comparator.comparingInt(Club::getPoint).reversed()
	            .thenComparingInt(Club::getGoalsDifference).reversed()
	            .thenComparingInt(Club::getGoalsFor).reversed());

	    System.out.printf("%-10s %-30s %-10s %-10s %-10s %-10s %-7s %-7s %-7s %-10s %-20s%n", "Position", "Club", "Played", "Won", "Drawn", "Lost", "GF", "GA", "GD", "Points", "Last 5 Games");

	    int position = 1;
	    for (Club club : sortedClubs) {
	        club.setPosition(position++);
	        System.out.printf("%-10d %-30s %-10d %-10d %-10d %-10d %-7d %-7d %-7d %-10d %-20s%n", club.getPosition(), club.getClubName(),
	                club.getPlayed(), club.getWon(), club.getDrawn(), club.getLoss(), club.getGoalsFor(),
	                club.getGoalsAgainst(), club.getGoalsDifference(), club.getPoint(), Arrays.toString(club.getLastFiveGames()));
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
printLongestRunsInTheLeague(clubs);

}	 
public void printForm(HashMap<String, Club> clubs) {
	 List<Club> sortedClubs = new ArrayList<>(clubs.values());
	    sortedClubs.sort(Comparator.comparingInt(Club::getPoint).reversed()
	            .thenComparingInt(Club::getGoalsDifference).reversed()
	            .thenComparingInt(Club::getGoalsFor).reversed());
	    
	    
	    System.out.printf("%-30s", "Club");
	    for (int i = 1; i <= 38; i++) {
	        System.out.printf("%-10s", "Week " + i);
	    }
	    System.out.println();
	    
	   
	    for (Club club : sortedClubs) {
	        System.out.printf("%-30s", club.getClubName());
	        int count = 0;
	        for (String result : club.getForm()) {
	            count++;
	            System.out.printf("%-10s", result);
	            if (count >= 38) // If 38 weeks are already printed, break the loop
	                break;
	        }
	        System.out.println();
	    }
	}
public int getLongestRun(String[]clubForm,String longestRun) {
//this method finds the longest winning run or longest losing run or longest unbeaten run or longest drawing run.
// for example if club's match results are W W D W L W W W W W W W then longest winning run and longest unbeaten running of
//the club is 7.	
//another example if club's match results are W W W D W W W W L W L L L then longest winning run = 4 , longest unbeaten run= 8
// longest losing run = 3 .

int formLength=clubForm.length;	
int longestStartIdx = -1;	
int longestEndIdx = -1;	
int currentLength = 1 ;
int maxLength = 1;
int currentStartIdx=-1;	
int currentEndIdx=-1;

for(int i =0,j=i+1;j<formLength;i++,j++) {
	boolean longestRunDetected=false;
if(longestRunHelper(longestRun)) { //  detects longest running if desired longest running is 
	                               //longest winning run or longest losing run or  longest drawing run
	if(clubForm[i].equals(clubForm[j]) && clubForm[i].equals(longestRun)&&clubForm[j].equals(longestRun)) {
	longestRunDetected =true;
	
}
else {
	longestRunDetected=false;
	currentLength=1;
    currentStartIdx=j;
}
if(longestRunDetected) {
	currentLength++;
    currentEndIdx=j;
if(currentLength > maxLength) {
	maxLength=currentLength;
    longestStartIdx=currentStartIdx;
    longestEndIdx=currentEndIdx;
}
}
}else {//  detects longest running if desired longest running is unbeaten longest run.      
if(!clubForm[i].equals("L") && !clubForm[j].equals("L")) {
longestRunDetected=true;	
}else {
	longestRunDetected=false;
	currentLength=1;
    currentStartIdx=j;
}
if(longestRunDetected) {
	currentLength++;
    currentEndIdx=j;
if(currentLength > maxLength) {
	maxLength=currentLength;
    longestStartIdx=currentStartIdx;
    longestEndIdx=currentEndIdx;
}
}
}
}
if(longestStartIdx!=-1 && longestEndIdx!=-1) {
	return maxLength;
}
return 1;
}
public boolean longestRunHelper(String longestRun) {
//if desired longest run is winning or losing or drawing runnings then return true 
//if desired longest run is unbeaten running then returns false	
	
	int inputLength=longestRun.length();
if(inputLength==1) {
	return true;
}
return false;
}
public int getBiggestLongestRun(int [] clubsLongestRun) {
//calculates largest longest run in the league.
//takes each club's longest runs as input , finds the which club has longest run.
	
	int biggestRun = 1;
for(int i = 0 ; i<clubsLongestRun.length;i++) {
	if(clubsLongestRun[i] > biggestRun) {
		biggestRun = clubsLongestRun[i];
	}
}

return biggestRun;
}
public void printLongestRunsInTheLeague(HashMap<String, Club> clubs) {
	 List<Club> sortedClubs = new ArrayList<>(clubs.values());
	    sortedClubs.sort(Comparator.comparingInt(Club::getPoint).reversed()
	            .thenComparingInt(Club::getGoalsDifference).reversed()
	            .thenComparingInt(Club::getGoalsFor).reversed());
	    int[] longestWinningRunForms = new int[sortedClubs.size()];
	    int[] longestLosingRunForms = new int[sortedClubs.size()];
	    int[] longestUnbeatenRunForms = new int[sortedClubs.size()];
	    int[] longestDrawingRunForms = new int[sortedClubs.size()];
	    
	    for(int i = 0; i < sortedClubs.size(); i++) {
	        Club club = sortedClubs.get(i);
	        longestWinningRunForms[i] = getLongestRun(club.getForm(), "W");
	        longestLosingRunForms[i] = getLongestRun(club.getForm(), "L");
		    longestUnbeatenRunForms[i] = getLongestRun(club.getForm(), "WD");
		     longestDrawingRunForms[i] = getLongestRun(club.getForm(), "D");
		    
	    }	
int longestWinningRunInTheLeague=getBiggestLongestRun(longestWinningRunForms);
int longestLosingRunInTheLeague=getBiggestLongestRun(longestLosingRunForms);
int longestDrawingRunInTheLeague=getBiggestLongestRun(longestDrawingRunForms);
int longestUnbeatenRunInTheLeague=getBiggestLongestRun(longestUnbeatenRunForms);

int LongestWinnerTeamIdx=findIndexOfTheTeam(longestWinningRunForms,longestWinningRunInTheLeague);
int LongestLoserTeamIdx=findIndexOfTheTeam(longestLosingRunForms,longestLosingRunInTheLeague);
int LongestDrawingTeamIdx=findIndexOfTheTeam(longestDrawingRunForms,longestDrawingRunInTheLeague);
int LongestUnbeatenTeamIdx=findIndexOfTheTeam(longestUnbeatenRunForms,longestUnbeatenRunInTheLeague);

String winningRunClubName = sortedClubs.get(LongestWinnerTeamIdx).getClubName();
String LosingRunClubName = sortedClubs.get(LongestLoserTeamIdx).getClubName();
String DrawingRunClubName = sortedClubs.get(LongestDrawingTeamIdx).getClubName();
String UnbeatenRunClubName = sortedClubs.get(LongestUnbeatenTeamIdx).getClubName();
System.out.println();
System.out.println("Longest Winning Run: ");
System.out.println(longestWinningRunInTheLeague +" matches");
System.out.println("Club: "+winningRunClubName);
System.out.println();
System.out.println("Longest Losing Run: "+longestLosingRunInTheLeague);
System.out.println(longestLosingRunInTheLeague+" matches");
System.out.println("Club: "+LosingRunClubName);
System.out.println();
System.out.println("Longest Drawing Run: "+longestDrawingRunInTheLeague);
System.out.println(longestDrawingRunInTheLeague+" matches");
System.out.println("Club: "+DrawingRunClubName);
System.out.println();
System.out.println("Longest Unbeaten Run: "+longestUnbeatenRunInTheLeague);
System.out.println(longestUnbeatenRunInTheLeague+" matches");
System.out.println("Club: "+UnbeatenRunClubName);
}
public int findIndexOfTheTeam(int[] array, int key) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == key) {
            return i;
        }
    }
    return -1;
}
} 
