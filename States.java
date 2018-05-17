public class States {
    //Washington, D.C. can vote in U.S. presidential elections in addition to the 50 states.
    private static final int NUMBEROFSTATES = 51;
    public static int StatesAdded = 0;

    private int electoral_Votes;
    private String state;

    public States(String state, int electoral_Votes){
        if (StatesAdded <= States.NUMBEROFSTATES) {
            this.state = state;
            this.electoral_Votes = electoral_Votes;
            States.StatesAdded++;
        } else {
            System.out.println("There are no more states in the United States, and thus you cannot create another object of such state.");
        }
    }

    public int getElectoral_Votes() {
        return this.electoral_Votes;
    }

    public String getStateName() {
        return this.state;
    }

    public String toString(){
        return this.state + ", " + this.electoral_Votes;
    }
}
