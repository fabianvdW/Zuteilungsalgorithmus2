package data;
import java.util.ArrayList;

public class Project {
    /**
     * Contains the classes allowed to participate in this project
     */
    private ArrayList<Integer> allowedClasses;
    /**
     * Unique id for Person
     */
    private int id;
    /**
     * Counts up, contains level of id for the next id
     */
    private static int idCount;
    /**
     * Contains the maximum amount of participants for the project
     */
    private int maxSize;
    /**
     * Contains the minimum amout of participants for the project
     */
    private int  minSize;
    /**
     * Contains the name of the project
     */
    private String name;
    /**
     * Contains the participants of the project
     */
    private ArrayList<Participant> participants;
    /**
     * Contains the ratings of the partcipants for this project
     */
    private ArrayList<ArrayList<Participant>> ratings;

    /**
     * Constructs new Project
     * @param allowedClasses  Contains the classes allowed to participate in this project
     * @param name Contains the name of the project
     * @param minSize Contains the minimum amout of participants for the project
     * @param maxSize Contains the minimum amout of participants for the project
     */
    public Project(ArrayList<Integer> allowedClasses,String name, int minSize, int maxSize){
        this.id=idCount;
        idCount++;
        this.name=name;
        this.minSize=minSize;
        this.maxSize=maxSize;
        this.allowedClasses=allowedClasses;
        this.participants=new ArrayList<Participant>();
    }

    /**
     * Adds participant to project. Additionally it will remove the participant from the project he was in before adding.
     * @param p Partcipant to be added to project
     * @return true if participant was added succesfully, false if  project is already full so participant cant be added
     */
    public boolean addParticipant(Participant p){
        if(this.isFull()){
            System.out.println("Tried adding Participant although Project is full!");//DEBUG
            return false;
        }
        this.participants.add(p);
        if(p.getProject()!=null) {
            p.getProject().removeParticipant(p);
        }
        p.setProject(this);
        return true;
    }

    /**
     *
     * @return true if the Project can take place, false if the Project can't take place
     */
    public boolean canTakePlace(){
        return this.participants.size()>=minSize;
    }

    /**
     * {@link Project#allowedClasses}
     * @return attribute allowedClasses
     */
    public ArrayList<Integer> getAllowedClasses(){
        return this.allowedClasses;
    }

    /**
     * {@link Project#allowedClasses}
     * @return size of allowedClasses
     */
    public int getAmountOfParticipants(){
        return this.participants.size();
    }

    /**
     * {@link Project#id}
     * @return attribute id
     */
    public int getID(){
        return this.id;
    }

    /**
     * {@link Project#maxSize}
     * @return attribute maxSize
     */
    public int getMaxSize(){
        return this.maxSize;
    }

    /**
     * {@link Project#minSize}
     * @return attribute minSize
     */
    public int getMinSize(){
        return this.minSize;
    }

    /**
     * {@link Project#name}
     * @return attribute name
     */
    public String getName(){
        return this.name;
    }

    /**
     *{@link Project#participants}
     * @return attribute participants
     */
    public ArrayList<Participant> getParticipants(){
        return this.participants;
    }

    /**
     * {@link Project#ratings}
     * @param rating The rating the participants returned should have voted for
     * @return the participants that rated that project with specified rating
     */
    public  ArrayList<Participant> getRating(int rating){
        //DEBUG
        if(this.ratings.size()<7){
            System.out.println("Ratings are not initialized correctly!");
            System.exit(0);
        }
        return this.ratings.get(3-rating);
    }

    /**
     * {@link Project#ratings}
     * @return attribute ratings
     */
    public ArrayList<ArrayList<Participant>> getRatings(){
        //DEBUG
        if(this.ratings.size()<7){
            System.out.println("Ratings are not initialized correctly!");
            System.exit(0);
        }
        return this.ratings;
    }

    /**
     *
     * @return true if the Project is full
     */
    public boolean isFull(){
        return this.participants.size()==maxSize;
    }

    /**
     *  Removes specified participant from Project. Additionally sets Participants Project to null.
     * @param p Participant to be removed
     * @return true if participant was removed, false if project doesn't contain participant
     */
    public boolean removeParticipant(Participant p){
        if(this.participants.contains(p)){
            this.participants.remove(p);
            p.setProject(null);
            return true;
        }
        System.out.println("Tried to remove Participant from Project although Participant is not in Project");//DEBUG
        return false;
    }

    /**
     * Sets attribute {@link Project#ratings} to speciefied param
     * @param ratings Ratings that should be cloned into attribute
     */
    public void setRatings(ArrayList<ArrayList<Participant>> ratings){
        this.ratings=ratings;
    }
}
