package pl.plauszta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

class KnapsackTest {

    @Test
    @DisplayName("Testing algorithm for the in.txt file")
    void checkResultOfAlgorithm() {
        Knapsack knapsack = readKnapsackFromFile("in.txt");
        if (knapsack == null) {
            return;
        }
        Result expectedResult = new Result(5, Arrays.asList(1, 3));
        Result result = knapsack.getResult();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Testing algorithm for the in1.txt file")
    void checkResultOfAlgorithm2() {
        Knapsack knapsack = readKnapsackFromFile("in1.txt");
        if (knapsack == null) {
            return;
        }
        Result expectedResult = new Result(11, Arrays.asList(1, 2, 5, 6));
        Result result = knapsack.getResult();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Testing algorithm for the in2.txt file")
    void checkResultOfAlgorithm3() {
        Knapsack knapsack = readKnapsackFromFile("in2.txt");
        if (knapsack == null) {
            return;
        }
        Result expectedResult = new Result(25, Arrays.asList(1, 3, 4, 5, 8, 9));
        Result result = knapsack.getResult();
        Assertions.assertEquals(expectedResult, result);
    }

    private Knapsack readKnapsackFromFile(String filepath) {
        URL fileUrl = KnapsackTest.class.getClassLoader().getResource(filepath);
        if (fileUrl == null) {
            throw new RuntimeException("Cannot find file '" + filepath + "'");
        }

        try {
            List<String> fileContent = Files.readAllLines(Paths.get(fileUrl.toURI()));
            String[] knapsackConstraintsLine = fileContent.get(0).split(" ");
            Knapsack knapsack = new Knapsack(Integer.parseInt(knapsackConstraintsLine[0]), Integer.parseInt(knapsackConstraintsLine[1]));

            for (int i = 1; i < fileContent.size(); i++) {
                String[] thingLine = fileContent.get(i).split(" ");
                knapsack.add(new Thing(
                        Integer.parseInt(thingLine[0]),
                        Integer.parseInt(thingLine[1]),
                        Integer.parseInt(thingLine[2]))
                );
            }

            return knapsack;
        } catch (IOException | URISyntaxException ex) {
            throw new RuntimeException("Cannot read knapsack", ex);
        }
    }
}
