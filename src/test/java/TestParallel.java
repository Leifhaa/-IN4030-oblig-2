import org.junit.jupiter.api.Test;

public class TestParallel {
    private final int seed = 5;
    private final int totalRuns = 7;

    @Test
    void test_classicAlgorithm_sequential_100() {
        int size = 100;

        double[] times = new double[totalRuns];
        double[][] matrixA = Oblig2Precode.generateMatrixA(seed, size);
        double[][] matrixB = Oblig2Precode.generateMatrixB(seed, size);

        double[][] res = MatrixCalculator.calculateAsync(matrixA, matrixB);

    }
}
