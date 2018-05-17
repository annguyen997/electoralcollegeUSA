import com.sun.istack.internal.NotNull;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Electoral {

    protected static final int ELECTORALWIN = 270;

    public static void main(String[] args) {
        //Create Scanner object to read console input.
        Scanner in = new Scanner(System.in);

        //Get the list of all states and their associated electoral votes.
        ArrayList<States> electoralMap = new ArrayList<States>(CreateStates());

        //Create presidential candidates.
        String[] candidateInfo = createCandidate(in, 1);
        Candidate candidate1 = new Candidate(candidateInfo[0], candidateInfo[1]);
        candidateInfo = createCandidate(in, 2);
        Candidate candidate2 = new Candidate(candidateInfo[0], candidateInfo[1]);

        //Assign states to candidates and display overall election results.
        electionResults(electoralMap, in, candidate1, candidate2);
        printResults(candidate1, candidate2);
    }

    public static ArrayList<States> CreateStates(){
        /* Collect all U.S. states and their electoral votes into an ArrayList from files */
        ArrayList<States> electoralMap = new ArrayList<States>();

        try {
            File fileStates = new File("src/States.txt");
            Scanner in = new Scanner(fileStates);

            File fileNumbers = new File("src/ElectoralVotes.txt");
            Scanner in2 = new Scanner(fileNumbers);

            while (in.hasNextLine()){
                String stateName = in.nextLine();
                int electoralVotes = in2.nextInt();
                electoralMap.add(new States(stateName, electoralVotes));
            }

        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        return electoralMap;
    }

    public static String[] createCandidate(Scanner in, int number){
        /* Collect information about presidential candidates */
        String[] candidateInfo = new String[2];
        System.out.print("What is the name of Candidate " + number + "?: ");
        candidateInfo[0] = in.next();

        System.out.print("What is " + candidateInfo[0] + "'s political party?: ");
        candidateInfo[1] = in.next();

        return candidateInfo;
    }

    public static void electionResults(ArrayList<States> electoralMap, Scanner in,
                                Candidate candidate1, Candidate candidate2){
        /* Assign states and electoral votes to candidates*/

        Random random = new Random(); //For testing purposes

        for (int i = 0; i < electoralMap.size(); i++){
            //For each U.S. state and its electoral votes.
            String stateName = electoralMap.get(i).getStateName();
            int electoralVotes = electoralMap.get(i).getElectoral_Votes();

            //Randomly assign states (for testing purposes)
            int value = random.nextInt(2);
            if (value == 0){
                candidate1.stateWon(stateName, electoralVotes);
            } else {
                candidate2.stateWon(stateName, electoralVotes);
            }

            /*
            System.out.println("\nCandidates: " + candidate1.name + ", " + candidate2.name);
            System.out.print("Who is the winner of " + stateName + " and its " +
                    electoralVotes + " electoral votes?: ");
            String getName = in.next();

            boolean InvalidResponse = true;
            while (InvalidResponse) {
                if (getName.equalsIgnoreCase(candidate1.getName().toLowerCase())) {
                    candidate1.stateWon(stateName, electoralVotes);
                    InvalidResponse = false;
                } else if (getName.equalsIgnoreCase(candidate2.getName().toLowerCase())) {
                    candidate2.stateWon(stateName, electoralVotes);
                    InvalidResponse = false;
                } else {
                    System.out.print("\nInvalid response. Please try again.");
                    System.out.println("Candidates: " + candidate1.name + ", " + candidate2.name);
                    System.out.print("Who is the winner of " + stateName + " and its " +
                            electoralVotes + " electoral votes?: ");
                    getName = in.nextLine();
                }
            }*/
        }
    }

    public static void printResults(Candidate candidate1, Candidate candidate2){
        /* Print the overall results of the election as output */

        //Print the overall presidential winner
        System.out.println("");
        if (candidate1.getElectoralVotesEarned() >= ELECTORALWIN){
            System.out.println(candidate1.getName() + " wins the presidency.");
        } else if (candidate2.getElectoralVotesEarned() >= ELECTORALWIN){
            System.out.println(candidate2.getName() + " wins the presidency.");
        } else {
            System.out.println("No candidate won the presidency.");
        }

        //Print the overall number of electoral votes and list of states each candidate won
        System.out.println("Electoral Votes of " + candidate1.getName() + " (" + candidate1.getPoliticalParty()
                + "): " + candidate1.getElectoralVotesEarned());
        System.out.println("States Won: " + candidate1.statesCandidateEarned());

        System.out.println("Electoral Votes of " + candidate2.getName() + " (" + candidate2.getPoliticalParty()
                + "): " + candidate2.getElectoralVotesEarned());
        System.out.println("States Won: " + candidate2.statesCandidateEarned());
    }

}
