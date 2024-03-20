import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Main {
	// Title: Main class
	// Author: Arda Baran
   // Description: In this class ,2022/2023 Premier League fixture csv file which consists of 380 matches and 38 weeks
//and 20 different teams and their scores is opened and proccessed.
//Hash Map,Comparator and List Data structures are used to process fixture, print the league orderly , print the qualified
//teams for europe cups,champion of the league and relegated teams.Also Fundamental statistics are calculated and printed.	
//-----------------------------------------------------	
	public static void main(String[] args) {
    	LeagueTable league = new LeagueTable();
        HashMap<String, Club> clubs = new HashMap<>();
        //name of the csv file
        String fileName = "epl-2022-UTC.csv";
        //location of the csv file
        String filePath = "src/resources/" + fileName;
//Splitters
        String line = "";
        String csvSplitBy = ",";
        
        int ch;                                 
		Scanner sc = new Scanner(System.in);

System.out.println(" =======================================================================================================");
System.out.println("|    Press 1 To See 2022/2023 Premier League Season League Table                                       |");
System.out.println("|    Press 2 To See 2022/2023 Premier League Season Champion,Qualified For Europe Cups,Relegated Teams |");
System.out.println("|    Press 3 To See 2022/2023 Premier League Season Statistics                                         |");
System.out.println(" =======================================================================================================");
System.out.println("");
System.out.print("Choice: ");
ch = sc.nextInt();
sc.close();    
          //read csv file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // skip the header line 
            br.readLine();
            // this while loop read lines in order to proccess the game results 
            while ((line = br.readLine()) != null) {                
                String[] matchData = line.split(csvSplitBy);
                // get required data for league table
               
                String homeTeam = matchData[4];
                String awayTeam = matchData[5];
                //result field in the csv file consists of home team goal + '-' splitter + away team goal
                String result = matchData[6];

                // split the result as home team score and away teams score
                String[] resultParts = result.split(" - ");
                int homeTeamScore = Integer.parseInt(resultParts[0]);
                int awayTeamScore = Integer.parseInt(resultParts[1]);

                // proccess the fixture with data from the csv file
               league.processFixture(clubs, homeTeam, awayTeam, homeTeamScore, awayTeamScore);
            }
        //After entire fixture in csv file  proccessed ,print league table;print champion,qualified teams for europe and
        //relegated teams ; print league statistics based on the choice.    
      switch(ch) {
      case 1 :           
      league.printLeagueTable(clubs);
      break;
      case 2 :
      league.printClubStatus(clubs);
      break;
      case 3 :
      league.LeagueStatistics(clubs);
      break;
      default:
      System.out.println("Invalid Choice...");
      } 
      } catch (IOException e) {
            e.printStackTrace();
        }
  
	}
}
