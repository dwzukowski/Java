class ElevatorPitchTest{
    public static void main(String[] args) {
        Project test1 = new Project("Project 500", "Training for local small businesses", 5000.00);
        Project test2 = new Project("Project 600", "Cyber security training", 20000.00);
        Portfolio myPortfolio = new Portfolio();
        myPortfolio.addProjectToPortfolio(test1);
        myPortfolio.addProjectToPortfolio(test2);
        myPortfolio.showPortfolio();
    }
}