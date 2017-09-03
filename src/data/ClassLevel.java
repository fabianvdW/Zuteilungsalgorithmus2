package data;


import java.util.ArrayList;

public class ClassLevel{
    /**
     *
     */
    ArrayList<ArrayList<Integer>> summarizeLevel;
    /**
     * Amount of participants in this classLevel
     */
    int amountOfParticipants;
    /**
     * the classLevel we are in
     */
    ArrayList<Integer> classLevel;
    /**
     * the participants of one classlevel
     */
    ArrayList<Participant> participants;
    /**
     * All the projects which contain this classLevel
     */
    ArrayList<Project> projects;
    /**
     * Constructs new classlevel object out of existing one
     * @param classlevel  to be cloned
     */
    public ClassLevel(ClassLevel classlevel){
        this.amountOfParticipants=classlevel.amountOfParticipants;
        this.participants= new ArrayList<Participant>();
        for(Participant p: classlevel.participants){
            this.participants.add(new Participant(p));
        }
        this.summarizeLevel=classlevel.summarizeLevel;
    }
    /**
     * Initializes new classLevel object
     * @param amountOfParticipants amountOfParticipants in the classLevel
     * @param classLevel the classLevel
     * @param participants the list of participants in one classLevel
     */
    public ClassLevel(int amountOfParticipants, ArrayList<Integer> classLevel,ArrayList<Participant> participants){
        this.amountOfParticipants=amountOfParticipants;
        this.classLevel=classLevel;
        this.participants=participants;
        projects = new ArrayList<Project>();
        this.summarizeLevel=new ArrayList<ArrayList<Integer>>();

    }

    /**
     *
     * @return the classLevels of this class
     */
    public ArrayList<Integer> getClassLevels(){
        return this.classLevel;
    }
}