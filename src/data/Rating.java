package data;

public class Rating {
    /**
     * Participant who rated
     */
    private Participant participant;

    /**
     * Project which is rated
     */
    private Project project;

    /**
     * rating for project of participant who rated
     */
    private int rating;

    /**
     *
     * @param participant participant who rated
     * @param project project which is rated
     * @param rating rating for project of participant who rated
     */
    Rating(Participant participant, Project project, int rating){
        this.participant = participant;
        this.project = project;
        this.rating = rating;
    }

    /**
     * returns participant who rated
     * @return participant who rated
     */
    public Participant getP() {
        return participant;
    }

    /**
     * returns project which is rated
     * @return project which is rated
     */
    public Project getProject() {
        return project;
    }

    /**
     * returns rating for project of participant who rated
     * @return rating for project of participant who rated
     */
    public int getRating() {
        return rating;
    }
}
