import org.junit.jupiter.api.Test;

public class TestParallel {
    private final int seed = 5;
    private final int totalRuns = 7;

    @Test
    void test_classicAlgorithm_parallel_100() {
        int size = 100;
        double[] times = runClassicAlgorithm_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_NOT_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_NOT_TRANSPOSED);
    }

    @Test
    void test_classicAlgorithm_parallel_200() {
        int size = 200;
        double[] times = runClassicAlgorithm_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_NOT_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_NOT_TRANSPOSED);
    }

    @Test
    void test_classicAlgorithm_parallel_500() {
        int size = 500;
        double[] times = runClassicAlgorithm_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_NOT_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_NOT_TRANSPOSED);
    }

    @Test
    void test_classicAlgorithm_parallel_1000() {
        int size = 1000;
        double[] times = runClassicAlgorithm_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_NOT_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_NOT_TRANSPOSED);
    }


    private double[] runClassicAlgorithm_Parallel(int size, int seed, int totalRuns, Oblig2Precode.Mode mode) {
        double[] times = new double[totalRuns];
        double[][] matrixA = Oblig2Precode.generateMatrixA(seed, size);
        double[][] matrixB = Oblig2Precode.generateMatrixB(seed, size);

        for (int i = 0; i < totalRuns; i++) {
            long time = System.nanoTime();
            double[][] result = MatrixCalculator.calculateAsync(matrixA, matrixB, mode);
            Oblig2Precode.saveResult(seed, mode, result);
            times[i] = (System.nanoTime() - time) / 1000000.0;
        }
        return times;
    }

    @Test
    void test_TransposeA_parallel_100() {
        int size = 100;
        double[] times = runTransposeA_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_A_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_A_TRANSPOSED);
    }

    @Test
    void test_TransposeA_parallel_200() {
        int size = 200;
        double[] times = runTransposeA_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_A_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_A_TRANSPOSED);
    }

    @Test
    void test_TransposeA_parallel_500() {
        int size = 500;
        double[] times = runTransposeA_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_A_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_A_TRANSPOSED);
    }

    @Test
    void test_TransposeA_parallel_1000() {
        int size = 1000;
        double[] times = runTransposeA_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_A_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_A_TRANSPOSED);
    }

    private double[] runTransposeA_Parallel(int size, int seed, int totalRuns, Oblig2Precode.Mode mode) {
        double[] times = new double[totalRuns];
        double[][] matrixA = Oblig2Precode.generateMatrixA(seed, size);
        double[][] matrixB = Oblig2Precode.generateMatrixB(seed, size);

        for (int i = 0; i < totalRuns; i++) {
            long time = System.nanoTime();
            double[][] matrixATransposed = MatrixUtil.transpose(matrixA);
            double[][] result = MatrixCalculator.calculateAsync(matrixATransposed, matrixB, mode);
            Oblig2Precode.saveResult(seed, mode, result);
            times[i] = (System.nanoTime() - time) / 1000000.0;
        }
        return times;
    }


    @Test
    void test_TransposeB_parallel_100() {
        int size = 100;
        double[] times = runTransposeB_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_B_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_B_TRANSPOSED);
    }

    @Test
    void test_TransposeB_parallel_200() {
        int size = 200;
        double[] times = runTransposeB_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_B_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_B_TRANSPOSED);
    }

    @Test
    void test_TransposeB_parallel_500() {
        int size = 500;
        double[] times = runTransposeB_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_B_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_B_TRANSPOSED);
    }

    @Test
    void test_TransposeB_parallel_1000() {
        int size = 1000;
        double[] times = runTransposeB_Parallel(size, seed, totalRuns, Oblig2Precode.Mode.PARA_B_TRANSPOSED);
        TestUtil.printMedianTime(size, times, Oblig2Precode.Mode.PARA_B_TRANSPOSED);
    }


    private double[] runTransposeB_Parallel(int size, int seed, int totalRuns, Oblig2Precode.Mode mode) {
        double[] times = new double[totalRuns];
        double[][] matrixA = Oblig2Precode.generateMatrixA(seed, size);
        double[][] matrixB = Oblig2Precode.generateMatrixB(seed, size);

        for (int i = 0; i < totalRuns; i++) {
            long time = System.nanoTime();
            double[][] matrixBTransposed = MatrixUtil.transpose(matrixB);
            double[][] result = MatrixCalculator.calculateAsync(matrixA, matrixBTransposed, mode);
            Oblig2Precode.saveResult(seed, mode, result);
            times[i] = (System.nanoTime() - time) / 1000000.0;
        }
        return times;
    }


}
