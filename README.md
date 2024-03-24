# FootballFixtureAnalyzer
 FootballFixtureAnalyzer is a Java application designed to analyze football match fixtures then derive league table from fixture and provide insights into team performance in various leagues. It processes match results, calculates team statistics, and generates reports to help users understand team standings, goal differentials, points earned,longest winning run ,longest losing run,longest drawing run and longest unbeaten run and more
## Author
Arda Baran
## Description
-Parses CSV files containing match data, including match number, round number, date, location, home team, away team, and result.
-Calculates team statistics such as total matches played, wins, draws, losses, goals for, goals against, goal difference, and points earned.
-Generates league tables and standings based on team performance by using Inheritance and Comparator.
-Identifies team champion of the league.
-Identifies teams qualified for UEFA Champions League, UEFA Europa League, and UEFA Conference League group stages.
-Identifies teams relegated from the league.
-Utilizes object-oriented programming principles and data structures for efficient data processing.
-Provides clear and concise output for easy interpretation of match results and team standings.
-Displays all 38 weekly forms for each club.
-Calculates longest winning run ,longest losing run,longest drawing run and longest unbeaten run for all clubs in the league.
-Stores form of the club by using queue.
## Features
- View all data in the csv file
- Generate league table from fixture
- Sort teams by point with comparator
- Calculate and display league table ,league champion ,qualified teams for europe cups,relegated teams
- Calculate and display league statistics such as total goals , played games goal per game etc.
## Technologies And Data Structures Used
-Java
-Hash Map
-ArrayList
-Linked List
-Inheritance
-Object Oriented Programming
-csv
-Comparator
-Queue Array Implementation
-Arrays
## Usage
-Clone the repository to your local machine.
-Compile and run the Java application.
-Provide the path to the CSV file containing match data.
-View the generated reports to analyze match results and team standings.

## File Structure
- `src/`: Contains the Java source code
- `resources/`: csv file (e.g., `epl-2022-UTC.csv`)
