package pl.plauszta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

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

    private Knapsack readKnapsackFromFile(String file) {
        Knapsack knapsack = null;
        final URL resource = KnapsackTest.class.getClassLoader().getResource(file);
        if (resource == null){
            throw new RuntimeException("File not found");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(resource.getFile()))) {
            String line = bufferedReader.readLine();
            String[] splitLine = line.split(" ");
            knapsack = new Knapsack(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));

            while ((line = bufferedReader.readLine()) != null) {
                splitLine = line.split(" ");
                knapsack.add(new Thing(
                        Integer.parseInt(splitLine[0]),
                        Integer.parseInt(splitLine[1]),
                        Integer.parseInt(splitLine[2]))
                );
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return knapsack;
    }
}
