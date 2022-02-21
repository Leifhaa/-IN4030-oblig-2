import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMatrixUtil {

    @Test
    public void TestTransition(){
        double[][] testArray = new double[3][2];
        testArray[0][0] = 1;
        testArray[1][0] = 2;
        testArray[2][0] = 3;
        testArray[0][1] = 4;
        testArray[1][1] = 5;
        testArray[2][1] = 6;

        double[][] transitionedArray = MatrixUtil.transpose(testArray);

        Assertions.assertEquals(transitionedArray[0][0],1);
        Assertions.assertEquals(transitionedArray[1][0],4);
        Assertions.assertEquals(transitionedArray[0][1],2);
        Assertions.assertEquals(transitionedArray[1][1],5);
        Assertions.assertEquals(transitionedArray[0][2],3);
        Assertions.assertEquals(transitionedArray[1][2],6);
    }
}
