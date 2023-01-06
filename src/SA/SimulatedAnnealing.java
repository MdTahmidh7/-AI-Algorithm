package SA;

public class SimulatedAnnealing {
    public static void main(String[] args) {
        // Create and add our cities

        City city2 = new City("Cox's Bazaar",10, 10);
        TourManager.addCity(city2);
        City city3 = new City("Khulna",15, 11);
        TourManager.addCity(city3);
        City city4 = new City("Barishal",16, 15);
        TourManager.addCity(city4);
        City city5 = new City("Sylhet",50, 30);
        TourManager.addCity(city5);


        //Set initial temp
        double temp = 100000;

        //Cooling rate
        double coolingRate = 0.003;

        //create random intial solution
        Tour currentSolution = new Tour();
        currentSolution.generateIndividual();

        System.out.println("Total distance of initial solution: " + currentSolution.getTotalDistance());
        System.out.println("Tour: " + currentSolution);

        // We would like to keep track if the best solution
        // Assume best solution is the current solution
        Tour best = new Tour(currentSolution.getTour());

        // Loop until system has cooled
        while (temp > 1) {
            // Create new neighbour tour
            Tour newSolution = new Tour(currentSolution.getTour());

            // Get random positions in the tour
            int tourPos1 = Utility.randomInt(0 , newSolution.tourSize());
            int tourPos2 = Utility.randomInt(0 , newSolution.tourSize());

            //to make sure that tourPos1 and tourPos2 are different
            while(tourPos1 == tourPos2) {tourPos2 = Utility.randomInt(0 , newSolution.tourSize());}

            // Get the cities at selected positions in the tour
            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            // Swap them
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);

            // Get energy of solutions
            int currentDistance   = currentSolution.getTotalDistance();
            int neighbourDistance = newSolution.getTotalDistance();

            // Decide if we should accept the neighbour
            double rand = Utility.randomDouble();
            if (Utility.acceptanceProbability(currentDistance, neighbourDistance, temp) > rand) {
                currentSolution = new Tour(newSolution.getTour());
            }

            // Keep track of the best solution found
            if (currentSolution.getTotalDistance() < best.getTotalDistance()) {
                best = new Tour(currentSolution.getTour());
            }

            temp *= 1 - coolingRate;
        }

        System.out.println("Final solution distance: " + best.getTotalDistance());
        System.out.println("Tour: " + best);
    }
}
