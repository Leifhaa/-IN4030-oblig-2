public class MatrixCalculator {

    public static double[][] calculate(double[][] a, double[][] b){
        int length = a.length;
        int width = b[0].length;
        double[][]c = new double[length][width];
        for (int row = 0; row < length; row++){
            for (int col = 0; col < width; col++){
                c[row][col] = multiplyCells(a, b, row, col);
            }
        }
        return c;
    }

    private static double multiplyCells(double[][] matrixA, double[][] matrixB, int row, int col){
        double val = 0;
        for (int i = 0; i < matrixB.length; i++){
            val += matrixA[row][i] * matrixB[i][col];
        }
        return val;
    }

    public static double[][] calculateTransitionedB(double[][] a, double[][] b){
        int length = a.length;
        int width = b[0].length;
        double[][]c = new double[length][width];
        for (int row = 0; row < length; row++){
            for (int col = 0; col < width; col++){
                c[row][col] = multiplyCellsTransitionedB(a, b, row, col);
            }
        }
        return c;
    }

    private static double multiplyCellsTransitionedB(double[][] matrixA, double[][] matrixB, int row, int col){
        double val = 0;
        for (int i = 0; i < matrixB.length; i++){
            val += matrixA[row][i] * matrixB[col][i];
        }
        return val;
    }


    public static double[][] calculateTransitionedA(double[][] a, double[][] b){
        int length = a.length;
        int width = b[0].length;
        double[][]c = new double[length][width];
        for (int row = 0; row < length; row++){
            for (int col = 0; col < width; col++){
                c[row][col] = multiplyCellsTransitionedA(a, b, row, col);
            }
        }
        return c;
    }


    private static double multiplyCellsTransitionedA(double[][] matrixA, double[][] matrixB, int row, int col){
        double val = 0;
        for (int i = 0; i < matrixB.length; i++){
            val += matrixA[i][row] * matrixB[i][col];
        }
        return val;
    }
}
