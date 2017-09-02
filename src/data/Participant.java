package data;

import java.util.ArrayList;
import java.util.UUID;

public class Participant {
    private Project attendsProject;
    private int classLevel;
    private static int idCount;
    private String name;
    private ArrayList<Rating> ratings;


    /**
     * Constructs participant with non-random name, class level and an arraylist with ratings for the projects
     * @param name
     * @param classLevel
     * @param ratings
     */
    public Participant(String name, int classLevel, ArrayList<Rating> ratings) {
        this.name = name;
        this.classLevel = classLevel;
        this.ratings = ratings;
    }

    /**
     * Constructs participant with random name, class level and an arraylist with ratings for the projects
     * @param classLevel
     * @param ratings
     */
    public Participant(int classLevel, ArrayList<Rating> ratings){
        name = UUID.randomUUID().toString();
        this.classLevel = classLevel;
        this.ratings = ratings;
    }

    /**
     * {@link Participant#attendsProject}
     */
    public Project getAllocatedProject() {
        return attendsProject;
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
     * Allocates the Participant to specified project p
     * @param p
     */
    public void setProject(Project p){
        attendsProject = p;
    }

    /**
     * @param rating
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
     * @param p
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
}
