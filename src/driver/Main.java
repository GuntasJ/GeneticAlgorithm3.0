package driver;

import genetic_algorithm.evolution_simulation.EvolutionSimulation;
import genetic_algorithm.genetics.Gene;

public class Main {

    public static void main(String[] args) {

        EvolutionSimulation.setChromosomeScoreFunction(chromosome -> chromosome.getGenes()
                        .stream()
                        .mapToDouble(Gene::getGeneValue)
                        .sum() - 10_000);

        EvolutionSimulation.setNumOfGenesPerChromosomes(10);

        EvolutionSimulation.simulate();


    }

}
