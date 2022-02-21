import org.junit.jupiter.api.Test;

public class TestSequential {
    private final int seed = 5;
    private final int totalRuns = 7;

    private void printMedianTime(int arrSize, double [] times, Oblig2Precode.Mode mode){
        double medianTime = times[(times.length) / 2];
        System.out.println("Array size: " + arrSize + ". Mode: " + mode + ". Median time: " + medianTime );
    }

    @Test
    void test_classicAlgorithm_sequential_100() {
        int size = 100;
        double[] times = runClassicAlgorithmSequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_NOT_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_NOT_TRANSPOSED);
    }

    @Test
    void test_classicAlgorithm_sequential_200() {
        int size = 200;
        double[] times = runClassicAlgorithmSequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_NOT_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_NOT_TRANSPOSED);
    }

    @Test
    void test_classicAlgorithm_sequential_500() {
        int size = 500;
        double[] times = runClassicAlgorithmSequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_NOT_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_NOT_TRANSPOSED);
    }


    @Test
    void test_classicAlgorithm_sequential_1000() {
        int size = 1000;
        double[] times = runClassicAlgorithmSequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_NOT_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_NOT_TRANSPOSED);
    }

    private double[] runClassicAlgorithmSequential(int size, int seed, int totalRuns, Oblig2Precode.Mode mode) {
        double[] times = new double[totalRuns];
        double[][] matrixA = Oblig2Precode.generateMatrixA(seed, size);
        double[][] matrixB = Oblig2Precode.generateMatrixB(seed, size);

        for (int i = 0; i < totalRuns; i++) {
            long time = System.nanoTime();
            double[][] result = MatrixCalculator.calculate(matrixA, matrixB);
            Oblig2Precode.saveResult(seed, mode, result);
            times[i] = (System.nanoTime() - time) / 1000000.0;
        }
        return times;
    }


    @Test
    void test_TransposeB_Algorithm_sequential_100() {
        int size = 100;
        double[] times = runClassicAlgorithm_TransposeB_Sequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_B_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_B_TRANSPOSED);
    }

    @Test
    void test_TransposeB_Algorithm_sequential_200() {
        int size = 200;
        double[] times = runClassicAlgorithm_TransposeB_Sequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_B_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_B_TRANSPOSED);
    }

    @Test
    void test_TransposeB_Algorithm_sequential_500() {
        int size = 500;
        double[] times = runClassicAlgorithm_TransposeB_Sequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_B_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_B_TRANSPOSED);
    }


    @Test
    void test_TransposeB_Algorithm_sequential_1000() {
        int size = 1000;
        double[] times = runClassicAlgorithm_TransposeB_Sequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_B_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_B_TRANSPOSED);
    }


    private double[] runClassicAlgorithm_TransposeB_Sequential(int size, int seed, int totalRuns, Oblig2Precode.Mode mode) {
        double[] times = new double[totalRuns];
        double[][] matrixA = Oblig2Precode.generateMatrixA(seed, size);
        double[][] matrixB = Oblig2Precode.generateMatrixB(seed, size);
        double[][] matrixBTransposed = MatrixUtil.transpose(matrixB);

        for (int i = 0; i < totalRuns; i++) {
            long time = System.nanoTime();
            double[][] result = MatrixCalculator.calculateTransitionedB(matrixA, matrixBTransposed);
            Oblig2Precode.saveResult(seed, mode, result);
            times[i] = (System.nanoTime() - time) / 1000000.0;
        }
        return times;
    }


    @Test
    void test_TransposeA_Algorithm_sequential_100() {
        int size = 100;
        double[] times = runClassicAlgorithm_TransposeA_Sequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_A_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_A_TRANSPOSED);
    }

    @Test
    void test_TransposeA_Algorithm_sequential_200() {
        int size = 200;
        double[] times = runClassicAlgorithm_TransposeA_Sequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_A_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_A_TRANSPOSED);
    }

    @Test
    void test_TransposeA_Algorithm_sequential_500() {
        int size = 500;
        double[] times = runClassicAlgorithm_TransposeA_Sequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_A_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_A_TRANSPOSED);
    }

    //@Test
    void test_TransposeA_Algorithm_sequential_1000() {
        int size = 1000;
        double[] times = runClassicAlgorithm_TransposeA_Sequential(size, seed, totalRuns, Oblig2Precode.Mode.SEQ_A_TRANSPOSED);
        printMedianTime(size, times, Oblig2Precode.Mode.SEQ_A_TRANSPOSED);
    }


    private double[] runClassicAlgorithm_TransposeA_Sequential(int size, int seed, int totalRuns, Oblig2Precode.Mode mode) {
        double[] times = new double[totalRuns];
        double[][] matrixA = Oblig2Precode.generateMatrixA(seed, size);
        double[][] matrixB = Oblig2Precode.generateMatrixB(seed, size);
        double[][] matrixATransposed = MatrixUtil.transpose(matrixA);

        for (int i = 0; i < totalRuns; i++) {
            long time = System.nanoTime();
            double[][] result = MatrixCalculator.calculateTransitionedA(matrixATransposed, matrixB);
            Oblig2Precode.saveResult(seed, mode, result);
            times[i] = (System.nanoTime() - time) / 1000000.0;
        }
        return times;
    }
}
