import java.util.ArrayList;

class Portfolio{
    private ArrayList<Project> projectsList = new ArrayList<>(); 
    //setter
    public void addProjectToPortfolio(Project newProject){
        projectsList.add(newProject);
    }
    //getter
    public void showPortfolio(){
        for(int i = 0; i < projectsList.size(); i++){
            Project test = projectsList.get(i);
            test.elevatorPitch();  
        }
    }
}