package data;

import java.util.ArrayList;

public class Distribution {
    /**
     * Contains all participants which belong to one distribution
     */
    private ArrayList<Participant> participants;
    /**
     * Contains all projects which belong to one distribution
     */
    private ArrayList<Project> projects;

    /**
     * Initializes new Distirbution Object
     * @param projects Projects to be added to distribution
     * @param participants Participants to be added to distribution
     */
    public Distribution(ArrayList<Project> projects,ArrayList<Participant> participants){
        this.projects=projects;
        this.participants=participants;
    }

    /**
     * Checks if all participants are allocated
     * @return true if all participants are allocated
     */
    public boolean allParticipantsAreAllocated(){
        for(Participant p: participants){
            if(p.getProject()==null){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if all projects can take place
     * @return true if all projects can take place
     */
    public boolean allProjectsTakePlace(){
        for(Project p: projects){
            if(!p.canTakePlace()){
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the score of a Distribution. This score represents how good the distributionalgorithm did on the distribution.
     * The perfect score is 0 and every score higher than 0 is worse than the perfect score.
     * @return  the score of the distribution
     */
    public double getScore(){
        return 0;
    }

    /**
     * {@link Distribution#participants}
     * @return attribute participants
     */
    public ArrayList<Participant> getParticipants(){
        return this.participants;
    }

    /**
     * Returns all the participants that are not allocated to a project yet
     * @return participants not allocated
     */
    public ArrayList<Participant> getParticipantsNotAllocated(){
        ArrayList<Participant> notAllocated= new ArrayList<Participant>();
        for(Participant p: participants){
            if(p.getProject()==null){
                notAllocated.add(p);
            }
        }
        return notAllocated;
    }

    /**
     * {@link Distribution#projects}
     * @return attribute projects
     */
    public ArrayList<Project> getProjects(){
        return this.projects;
    }

    /**
     * Returns all projects not taking place
     * @return projects not taking place
     */
    public ArrayList<Project> getProjectsNotTakingPlace(){
        ArrayList<Project> notTakingPlace= new ArrayList<Project>();
        for(Project p: projects){
            if(!p.canTakePlace()){
                notTakingPlace.add(p);
            }
        }
        return notTakingPlace;
    }

}
