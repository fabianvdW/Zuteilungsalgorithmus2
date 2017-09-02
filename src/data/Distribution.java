package data;

import java.util.ArrayList;

public class Distribution {
    private ArrayList<Participant> participants;
    private ArrayList<Project> projects;
    public Distribution(ArrayList<Project> projects,ArrayList<Participant> participants){
        this.projects=projects;
        this.participants=participants;
    }
}
