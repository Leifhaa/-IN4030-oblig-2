import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestResults {

    @Test
    public void testAll() throws IOException {
        //Run tests with 100 rows & columsn in order to produce text output
        TestSequential testSequential = new TestSequential();
        testSequential.test_classicAlgorithm_sequential_100();
        testSequential.test_TransposeA_Algorithm_sequential_100();
        testSequential.test_TransposeB_Algorithm_sequential_100();

        TestParallel testParallel = new TestParallel();
        testParallel.test_classicAlgorithm_parallel_100();
        testParallel.test_TransposeA_parallel_100();

        File folder = new File(".");
        File[] listOfFiles = folder.listFiles();
        List<String> results = new ArrayList<>();

        /**
         * Read result files into array string
         */
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains("Result")) {
                String outPut = Files.readString(Path.of(listOfFiles[i].getPath()));
                //Skip first line
                int readFrom = outPut.indexOf("\n\n");
                outPut = outPut.substring(readFrom, outPut.length());
                results.add(outPut);
            }
        }

        //Ensure results for all algorithms are equal
        for (int i = 0; i < results.size(); i++){
            for (int j = i + 1; j < results.size(); j++){
                Assertions.assertEquals(results.get(i), results.get(j));
            }
        }
    }
}

