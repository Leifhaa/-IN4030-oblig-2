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

    public static double[][] calculateAsync(double[][] a, double[][] b, Oblig2Precode.Mode mode){
        int length = a.length;
        int width = b[0].length;
        double[][] c = new double[length][width];

        int numProcessors = Runtime.getRuntime().availableProcessors();
        Thread[] t = new Thread[numProcessors];

        int readFrom = 0;
        for (int i = 0; i < numProcessors; i++){
            int readRows = (length / numProcessors);
            if (i < length % numProcessors){
                //This modulo operator returns how many threads has to include one extra element.
                readRows++;
            }
            ThreadWorker tw = new ThreadWorker(readFrom, readRows, a, b, c, mode);
            t[i] = new Thread(tw);
            t[i].start();
            readFrom += readRows;
        }

        //Wait for threads to finish
        for (int i = 0; i < numProcessors; i++) {
            try {
                t[i].join();
            } catch (Exception e) {
                System.out.println("Exception : " + e);
            }
        }

        Oblig2Precode.saveResult(5, Oblig2Precode.Mode.PARA_NOT_TRANSPOSED, c);
        return c;
    }
}
