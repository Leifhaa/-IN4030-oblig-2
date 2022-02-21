package async;

public class ThreadWorker implements Runnable {

    private int readFrom;
    private int rowsToRead;
    private double[][] a;
    private double[][] b;
    private double[][] c;

    public ThreadWorker(int readFrom, int rowsToRead, double[][] a, double[][] b, double[][] result) {
        this.readFrom = readFrom;
        this.rowsToRead = rowsToRead;
        this.a = a;
        this.b = b;
        this.c = result;
    }

    @Override
    public void run() {
        for (int row = readFrom; row < readFrom + rowsToRead; row++){
            for (int col = 0; col < a[0].length; col++){
                c[row][col] = multiplyCells(a, b, row, col);
            }
        }
    }

    private static double multiplyCells(double[][] matrixA, double[][] matrixB, int row, int col){
        double val = 0;
        for (int i = 0; i < matrixB.length; i++){
            val += matrixA[row][i] * matrixB[i][col];
        }
        return val;
    }
}
