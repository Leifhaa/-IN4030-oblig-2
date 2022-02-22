public class TestUtil {

    public static void printMedianTime(int arrSize, double [] times, Oblig2Precode.Mode mode){
        double medianTime = times[(times.length) / 2];
        System.out.println("Array size: " + arrSize + ". Mode: " + mode + ". Median time: " + medianTime );
    }
}
