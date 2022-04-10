package genetic_algorithm.genetics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chromosome {

    private List<Gene> genes;
    private final Random random;
    public static int numOfGenes;

    public Chromosome(int numOfGenes) {
        Chromosome.numOfGenes = numOfGenes;
        random = new Random();
        generateGenes(1_000);
    }

    public Chromosome(List<Gene> genes) {
        Chromosome.numOfGenes = genes.size();
        random = new Random();
        this.genes = new ArrayList<>(genes);
    }

    private void generateGenes(int startingGeneMultiplier) {
        genes = Stream.generate(() -> new Gene(random.nextDouble() * startingGeneMultiplier))
                .limit(numOfGenes)
                .collect(Collectors.toList());
    }

    public void mutate(double mutationFactor) {
        genes.forEach(g -> g.mutate(mutationFactor));
    }

    public List<Gene> getGenes() {
        return genes;
    }

    @Override
    public String toString() {
        return genes.toString();
    }

}
