import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMatrixCalc {

    @Test
    public void TestMe(){
        double[][] matrixA = new double[2][3];
        double[][] matrixB = new double[3][2];

        matrixA[0][0] = 1;
        matrixA[0][1] = 2;
        matrixA[0][2] = 3;
        matrixA[1][0] = 4;
        matrixA[1][1] = 5;
        matrixA[1][2] = 6;

        matrixB[0][0] = 7;
        matrixB[0][1] = 8;
        matrixB[1][0] = 9;
        matrixB[1][1] = 10;
        matrixB[2][0] = 11;
        matrixB[2][1] = 12;

        double[][] res = MatrixCalculator.Calculate(matrixA, matrixB);

        Assertions.assertEquals(res[0][0], 58);
        Assertions.assertEquals(res[0][1], 64);
        Assertions.assertEquals(res[1][0], 139);
        Assertions.assertEquals(res[1][1], 154);
    }
}
