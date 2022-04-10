package genetic_algorithm.genetics;

import java.util.Random;

public class Gene {

    private final Random random;
    private double geneValue;

    public Gene(double geneValue) {
        this.geneValue = geneValue;
        random = new Random();
    }

    public void mutate(double mutationFactor) {
        geneValue = geneValue * (random.nextDouble() * mutationFactor + (1.0 - mutationFactor / 2.0));
    }

    public double getGeneValue() {
        return geneValue;
    }

    @Override
    public String toString() {
        return Double.toString(geneValue);
    }
}
