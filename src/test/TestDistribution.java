package test;

import algorithm.Distributionalgorithm;
import data.Distribution;
import data.Participant;
import data.Project;
import data.Rating;

import java.util.ArrayList;

public class TestDistribution {
    /**
     * Generates a random generated
     * @return Distribution which is generated
     */
    public static Distribution generateDistribution(){
        int amountOfParticipants=(int) (Math.random()*550 +200);
        int amountOfProjects=(int)(amountOfParticipants/20);
        int amountOfClassLevels=(int)((Math.random()*2+4));
        return generateDistribution(amountOfParticipants,amountOfProjects,amountOfClassLevels);
    }

    /**
     * Genereates a Distribution
     * @param amountOfParticipants amountOfParticipants which will be in the generated distribution
     * @param amountOfProjects amountOfProjects which will be in the generated distribution
     * @param amountOfClassLevels amountOfClassLevels which will be in the generated distribution
     * @return random generated Distribution
     */
    public static  Distribution generateDistribution(int amountOfParticipants, int amountOfProjects,int amountOfClassLevels){
        ArrayList<Participant> participants= generateParticipants(amountOfParticipants,amountOfClassLevels);
        ArrayList<Project> projects = generateProjects(amountOfProjects,amountOfParticipants,amountOfClassLevels);
        for(Participant p: participants){
            generateRatings(projects,p);
        }
        return new Distribution(projects,participants);
    }

    /**
     *
     * @param amountOfParticipants amountOfParticipants to be generated
     * @param amountOfClassLevels amountOfClassLevels which the participants will have
     * @return randomly generated ArrayList of participants
     */
    private static ArrayList<Participant> generateParticipants(int amountOfParticipants,int amountOfClassLevels){
        ArrayList<Participant> participants= new ArrayList<Participant>();
        /*
         Generates Classes of estimated size: amountOfParticipants/amountOfClassLevels
         Because this is an Integer division, the last layer of the Classes is calculated by substracting the amountOfParticipants with the amountOfAddedParticipants
         */
        int[] classSizes= new int[amountOfClassLevels];
        int amountOfAddedParticipants=0;
        for(int i=0;i<classSizes.length-1;i++){
            amountOfAddedParticipants=amountOfParticipants/amountOfClassLevels;
            classSizes[i]=amountOfAddedParticipants;
        }
        classSizes[classSizes.length-1]=amountOfParticipants-amountOfAddedParticipants;
        for(int i=0;i<amountOfParticipants;i++){
            int classLevel=0;
            while(classSizes[classLevel]==0){
                classLevel++;
            }
            classSizes[classLevel]-=1;
            Participant p= new Participant(classLevel+5);
            participants.add(p);
        }
        return participants;
    }

    /**
     *
     * @param amountOfProjects amountOfProjects to be generated
     * @param amountOfParticipants amountOfParticipants to be generated
     * @param amountOfClassLevels amountOfClassLevels to be generated
     * @return ArrayList of generatedProjects
     */
    private static ArrayList<Project> generateProjects(int amountOfProjects,int amountOfParticipants,int amountOfClassLevels){

        ArrayList<Project> projects= new ArrayList<Project>();
        int size=0;
        int averageSizeOfClass=amountOfParticipants/amountOfProjects;
        while(size<amountOfParticipants*1.05){
            int maxSize=(int)(averageSizeOfClass*(1+(Math.random()*0.2-0.1)));
            size+=maxSize;
            int minSize=(int)(maxSize*(Math.random()*0.2+0.3));
            //TODO do this shit with classlevels
            ArrayList<Integer> classLevels= new ArrayList<Integer>();
            for(int k=0;k<amountOfClassLevels;k++){
                classLevels.add(k);
            }
            Project p= new Project(classLevels,minSize,maxSize);
            projects.add(p);
        }
        return projects;
    }

    /**
     *
     * @param projects projects which the ratings should be generated for
     * @param participant Participant which the rating should be generated for
     */
    private static void generateRatings(ArrayList<Project> projects,Participant participant){
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        ArrayList<Integer> availableRatings= new ArrayList<Integer>();
        //TODO make this -3 thing shit parameterized
        for(int i=-3;i<=3;i++){
            availableRatings.add(new Integer(i));
        }
        int count=0;
        while(availableRatings.size()>0 && count<projects.size()){
            int ratingIndex= (int)(Math.random()*availableRatings.size());
            int rating = availableRatings.get(ratingIndex);
            availableRatings.remove(ratingIndex);
            Project project=null;
            ArrayList<Project> projects1= new ArrayList<Project>(projects);
            do{
                project =projects1.get((int)(Math.random()*projects1.size()));
                if(!Distributionalgorithm.isParticipantAllowedOnProject(participant,project)){
                    projects1.remove(project);
                }

            }while(!Distributionalgorithm.isParticipantAllowedOnProject(participant,project)&&projects1.size()>0);
            Rating r= null;
            if(project==null){
                System.out.println("our project generation sucks");//DEBUG
                System.exit(0);
            }else {
                r = new Rating(project, rating);
            }
            ratings.add(r);
            count++;
        }
        participant.setRatings(ratings);
    }
}
