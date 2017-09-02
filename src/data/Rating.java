package data;

public class Rating {
    private Participant p;
    private Project project;
    private int rating;

    Rating(Participant p, Project project, int rating){
        this.p = p;
        this.project = project;
        this.rating = rating;
    }

    public Participant getP() {
        return p;
    }

    public Project getProject() {
        return project;
    }

    public int getRating() {
        return rating;
    }
}
