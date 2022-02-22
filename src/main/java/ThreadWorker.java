public class ThreadWorker implements Runnable {

    private int readFrom;
    private int readElements;
    private double[][] a;
    private double[][] b;
    private double[][] c;
    private Oblig2Precode.Mode mode;

    public ThreadWorker(int readFrom, int readElements, double[][] a, double[][] b, double[][] result, Oblig2Precode.Mode mode) {
        this.readFrom = readFrom;
        this.readElements = readElements;
        this.a = a;
        this.b = b;
        this.c = result;
        this.mode = mode;
    }

    @Override
    public void run() {
        if (mode == Oblig2Precode.Mode.PARA_NOT_TRANSPOSED) {
            calculate();
        } else if (mode == Oblig2Precode.Mode.PARA_A_TRANSPOSED) {
            calculateTransitionedA();
        }
        else if (mode == Oblig2Precode.Mode.PARA_B_TRANSPOSED){
            calculateTransitionedB();
        }
    }

    private void calculate() {
        for (int row = readFrom; row < readFrom + readElements; row++) {
            for (int col = 0; col < a[0].length; col++) {
                c[row][col] = multiplyCells(a, b, row, col);
            }
        }
    }

    private static double multiplyCells(double[][] matrixA, double[][] matrixB, int row, int col) {
        double val = 0;
        for (int i = 0; i < matrixB.length; i++) {
            val += matrixA[row][i] * matrixB[i][col];
        }
        return val;
    }

    public double[][] calculateTransitionedA() {
        for (int col = readFrom; col < readFrom + readElements; col++) {
            for (int row = 0; row < a.length; row++) {
                c[row][col] = multiplyCellsTransitionedA(a, b, col, row);
            }
        }
        return c;
    }

    private static double multiplyCellsTransitionedA(double[][] matrixA, double[][] matrixB, int col, int row) {
        double val = 0;
        for (int i = 0; i < matrixB.length; i++) {
            val += matrixA[i][row] * matrixB[i][col];
        }
        return val;
    }


    public double[][] calculateTransitionedB() {
        int width = b[0].length;
        for (int row = readFrom; row < readFrom + readElements; row++) {
            for (int col = 0; col < width; col++) {
                c[row][col] = multiplyCellsTransitionedB(a, b, row, col);
            }
        }
        return c;
    }


    private static double multiplyCellsTransitionedB(double[][] matrixA, double[][] matrixB, int row, int col) {
        double val = 0;
        for (int i = 0; i < matrixB.length; i++) {
            val += matrixA[row][i] * matrixB[col][i];
        }
        return val;
    }
}
