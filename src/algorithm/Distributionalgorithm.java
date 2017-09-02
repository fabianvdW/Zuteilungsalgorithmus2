package algorithm;

import data.Distribution;
import data.Participant;

public class Distributionalgorithm {

    /**
     * Distributes the dataset
     * @param d Dataset to distribute
     * @return distributed dataset
     */
    public static Distribution finishDistribution(Distribution d){
        Distribution distribution = d;
        shuffleDistribution(d);
        return distribution;
    }

    /**
     * returns whether the participant is able to join the project or not
     * @param participant who is supposed ot be checked for joining the project
     * @return true if able to join & false if not able to join
     */
    public static boolean isParticipantAllowedOnProject(Participant participant){
        return false;
    }

    /**
     * Shuffles the dataset for the distribution
     * @param d Distribution to be shuffled
     */
    public static void shuffleDistribution(Distribution d){

    }
}
