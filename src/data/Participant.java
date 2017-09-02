package data;

import java.util.ArrayList;
import java.util.UUID;

public class Participant {
    /**
     * attended project
     */
    private Project project;
    /**
     * class Level of the participant
     */
    private int classLevel;
    /**
     * unique id of the participant
     */
    private static int idCount;
    /**
     * non-unique name of the participant
     */
    private String name;
    /**
     * Arraylist with the ratings of the participant for all the projects
     */
    private ArrayList<Rating> ratings;


    /**
     * Constructs participant with non-random name, class level and an arraylist with ratings for the projects
     * @param name Name of the participant
     * @param classLevel class level of the participant
     * @param ratings ratings of the participant for the projects
     */
    public Participant(String name, int classLevel, ArrayList<Rating> ratings) {
        this.name = name;
        this.classLevel = classLevel;
        this.ratings = ratings;
    }

    /**
     * Constructs participant with random name, class level and an arraylist with ratings for the projects
     * @param classLevel class level of the participant
     * @param ratings ratings of the participant for the projects
     */
    public Participant(int classLevel, ArrayList<Rating> ratings){
        name = UUID.randomUUID().toString();
        this.classLevel = classLevel;
        this.ratings = ratings;
    }

    /**
     * {@link Participant#project}
     */
    public Project getProject() {
        return project;
    }

    /**
     * {@link Participant#classLevel}
     */
    public int getClassLevel() {
        return classLevel;
    }

    /**
     * {@link Participant#name}
     */
    public String getName() {
        return name;
    }

    /**
     * @param rating ratings of the participant for the projects
     * @return all projects participant voted for with specified rating
     */
    public Project getProjectWithRating(int rating){
        Project searchedProject = null;
        for (Rating r : ratings){
            if(r.getRating() == rating){
                searchedProject = r.getProject();
            }
        }
        if (searchedProject == null){
            System.out.println("No project with a rating of " + rating + " was found");
            System.exit(0);
            return null;
        }
        return searchedProject;
    }

    /**
     * @param p specified project from which you want to get to know the rating
     * @return Rating for specified p Project
     */
    public int getRating(Project p){
        int ratingOfP = 100;
        for (Rating r:ratings) {
            if(r.getProject().getID() == p.getID()) {
                ratingOfP = r.getRating();
            }
        }
        if (ratingOfP == 100){
            System.out.println("Rating for this Project was not Found");
            System.exit(0);
            return 100;
        }
        else
            return ratingOfP;
    }

    /**
     * {@link Participant#ratings
     */
    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    /**
     * Allocates the Participant to specified project p
     * @param p project you want to set for the participant
     */
    public void setProject(Project p){
        project = p;
    }
}
