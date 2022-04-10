package driver;

import genetic_algorithm.evolution_simulation.EvolutionSimulation;

public class Main {

    public static void main(String[] args) {

        EvolutionSimulation.setChromosomeScoreFunction(chromosome ->
                        Math.pow(chromosome.getGenes().get(0).getGeneValue(), 4)
                - Math.pow(chromosome.getGenes().get(0).getGeneValue(), 2)
                - 12);
        //x^4 - x^2 - 12 = 0
        //expected: ???

        EvolutionSimulation.setNumOfGenesPerChromosomes(1);

        EvolutionSimulation.simulate();
    }

}
