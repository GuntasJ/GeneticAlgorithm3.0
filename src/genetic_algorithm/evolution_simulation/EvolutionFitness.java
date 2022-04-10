package genetic_algorithm.evolution_simulation;

import genetic_algorithm.genetics.Chromosome;
import genetic_algorithm.genetics.Gene;

import java.util.function.Function;

public class EvolutionFitness {

    public static double calculateChromosomeScore(Chromosome chromosome, Function<Chromosome, Double> scoreFunction) {
        return scoreFunction.apply(chromosome);
    }

    public static double calculateFitness(Chromosome chromosome, Function<Chromosome, Double> scoreFunction) {
        double answer = calculateChromosomeScore(chromosome, scoreFunction);
        if(answer == 0) {
            return Double.MAX_VALUE;
        }
        //next time, try different vals for numerator.
        return Math.abs(2 / answer);
    }

}
