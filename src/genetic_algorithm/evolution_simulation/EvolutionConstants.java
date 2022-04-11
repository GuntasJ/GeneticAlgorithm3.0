package genetic_algorithm.evolution_simulation;

public class EvolutionConstants {
    static final int PEAK_CHROMOSOME_POPULATION = 100_000;
    static final int MAX_GENERATIONS =  9_999;
    static final int FITNESS_SCORE_THRESHOLD = 5;
    static final int NUM_OF_SURVIVING_CHROMOSOMES = 50_000;
    public static final int STARTING_GENE_MULTIPLIER = 10_000;
    static int NUM_OF_GENES_PER_CHROMOSOMES = 3;

    //Private constructor
    //Prevents this class from being instantiated.
    private EvolutionConstants() {}
}
