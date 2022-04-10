package genetic_algorithm.evolution_simulation;

import genetic_algorithm.genetics.Chromosome;
import genetic_algorithm.genetics.Gene;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvolutionSimulation {

    private static final Random random = new Random();

    private static List<Chromosome> chromosomes;

    private static Function<Chromosome, Double> scoreFunction;

    public static void simulate() {

        if(scoreFunction == null) {
            throw new RuntimeException("A valid score function must be provided for the genetic algorithm");
        }

        introduceInitialChromosomes();

        for(int generation = 1; generation < EvolutionConstants.MAX_GENERATIONS; generation++) {
            sortChromosomesByFitness();
            displayGenerationMessage(generation);
            displayBestChromosomeFromChromosomeList();
            if(hasFitnessScoreBeenMet()) {
                System.out.println(EvolutionFitness.calculateChromosomeScore(chromosomes.get(0), scoreFunction));
                break;
            }
            applyEnvironmentalPressure();
            reproduceChromosomes();
        }

    }

    private static void displayGenerationMessage(int generation) {
        System.out.printf("%s %d %s\n", "=== Gen", generation, "best solution ===");
    }

    private static void introduceInitialChromosomes() {
        chromosomes = Stream.generate(() -> new Chromosome(EvolutionConstants.NUM_OF_GENES_PER_CHROMOSOMES))
                .limit(EvolutionConstants.PEAK_CHROMOSOME_POPULATION)
                .collect(Collectors.toList());
    }

    private static void sortChromosomesByFitness() {
        chromosomes.sort((a, b) -> Double.compare(
                EvolutionFitness.calculateFitness(b, scoreFunction),
                EvolutionFitness.calculateFitness(a, scoreFunction)));
    }

    private static void displayBestChromosomeFromChromosomeList() {
        System.out.println(EvolutionFitness.calculateFitness(chromosomes.get(0), scoreFunction)
                + ", " + chromosomes.get(0));
        System.out.println();
    }

    private static void applyEnvironmentalPressure() {
        chromosomes = chromosomes.stream()
                .limit(EvolutionConstants.NUM_OF_SURVIVING_CHROMOSOMES).collect(Collectors.toList());
    }

    private static boolean hasFitnessScoreBeenMet() {
        return EvolutionFitness.calculateFitness(chromosomes.get(0), scoreFunction)
                >= EvolutionConstants.FITNESS_SCORE_THRESHOLD;
    }

    private static void reproduceChromosomes() {
        List<Chromosome> dummyList = new ArrayList<>();
        for(int i = 0; i < EvolutionConstants.PEAK_CHROMOSOME_POPULATION; i++) {
            List<Gene> genes = new ArrayList<>();
            for(int j = 0; j < EvolutionConstants.NUM_OF_GENES_PER_CHROMOSOMES; j++) {
                genes.add(chromosomes.get(random.nextInt(EvolutionConstants.NUM_OF_SURVIVING_CHROMOSOMES)).getGenes().get(j));
            }
            Chromosome chromosome = new Chromosome(genes);
            chromosome.mutate(0.02);
            dummyList.add(chromosome);
        }
        chromosomes = new ArrayList<>(dummyList);
    }

    public static void setNumOfGenesPerChromosomes(int numOfGenesPerChromosomes) {
        EvolutionConstants.NUM_OF_GENES_PER_CHROMOSOMES = numOfGenesPerChromosomes;
    }

    public static void setChromosomeScoreFunction(Function<Chromosome, Double> scoreFunction) {
        EvolutionSimulation.scoreFunction = scoreFunction;
    }

    //debug








}
