import java.util.ArrayList;

public class Candidate {
    protected static final int ELECTORALTOTAL = 538;

    private String name;
    int electoralVotesEarned;
    ArrayList<String> statesAbbreviationsEarned;
    private ArrayList<States> statesEarned;
    private String politicalParty;

    public Candidate(String name, String politicalParty){
        this.name = name;
        this.electoralVotesEarned = 0;
        this.politicalParty = politicalParty;
        this.statesAbbreviationsEarned = new ArrayList<String>();
        statesEarned = new ArrayList<States>();
    }

    public void stateWon(States state, String e, int number){
        this.statesAbbreviationsEarned.add(e);
        statesEarned.add(state);

        if (electoralVotesEarned <= ELECTORALTOTAL) {
            this.electoralVotesEarned += number;
        } else {
            System.out.println("Candidate " + this.name + " has too many electoral votes allocated.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getElectoralVotesEarned() {
        return this.electoralVotesEarned;
    }

    public String getPoliticalParty(){
        return this.politicalParty;
    }

    public ArrayList<String> statesCandidateEarned(){
        return this.statesAbbreviationsEarned;
    }
}
