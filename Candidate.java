import java.util.ArrayList;

public class Candidate {
    protected static final int ELECTORALTOTAL = 538;

    private String name;
    int electoralVotesEarned;
    ArrayList<String> statesEarned;
    private String politicalParty;

    public Candidate(String name, String politicalParty){
        this.name = name;
        this.electoralVotesEarned = 0;
        this.politicalParty = politicalParty;
        this.statesEarned = new ArrayList<String>();
    }

    public void stateWon(String e, int number){
        this.statesEarned.add(e);

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
        return this.statesEarned;
    }
}
