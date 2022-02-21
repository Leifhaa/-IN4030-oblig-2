public class MatrixUtil {
    /**
     * The transpose of a matrix is simply a flipped version of the original matrix. We can transpose a matrix by switching its rows with its columns.
     */
    public static double[][] transpose(double[][] original){
        int newWidth = original.length;
        int newHeight = original[0].length;
        double[][] newTable = new double[newHeight][newWidth];

        for (int x = 0; x < newWidth; x++) {
            for (int y = 0; y < newHeight; y++) {
                newTable[y][x] = original[x][y];
            }
        }
        return newTable;
    }
}
