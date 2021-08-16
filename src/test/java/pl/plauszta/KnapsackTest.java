package pl.plauszta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class KnapsackTest {

    @Test
    @DisplayName("Testing algorithm for the in.txt file")
    public void checkResultOfAlgorithm() {
        Knapsack knapsack = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/java/pl/plauszta/resources/in.txt"))) {
            String line = bufferedReader.readLine();
            String[] splittedLine = line.split(" ");
            knapsack = new Knapsack(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[1]));

            while ((line = bufferedReader.readLine()) != null) {
                splittedLine = line.split(" ");
                knapsack.add(new Thing(
                        Integer.parseInt(splittedLine[0]),
                        Integer.parseInt(splittedLine[1]),
                        Integer.parseInt(splittedLine[2]))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (knapsack == null) {
            return;
        }
        Result expectedResult = new Result(5, Arrays.asList(1, 3));
        Result result = knapsack.getResult();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Testing algorithm for the in1.txt file")
    public void checkResultOfAlgorithm2() {
        Knapsack knapsack = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/java/pl/plauszta/resources/in1.txt"))) {
            String line = bufferedReader.readLine();
            String[] splittedLine = line.split(" ");
            knapsack = new Knapsack(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[1]));

            while ((line = bufferedReader.readLine()) != null) {
                splittedLine = line.split(" ");
                knapsack.add(new Thing(
                        Integer.parseInt(splittedLine[0]),
                        Integer.parseInt(splittedLine[1]),
                        Integer.parseInt(splittedLine[2]))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (knapsack == null) {
            return;
        }
        Result expectedResult = new Result(11, Arrays.asList(1, 2, 5, 6));
        Result result = knapsack.getResult();
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Testing algorithm for the in2.txt file")
    public void checkResultOfAlgorithm3() {
        Knapsack knapsack = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/java/pl/plauszta/resources/in2.txt"))) {
            String line = bufferedReader.readLine();
            String[] splittedLine = line.split(" ");
            knapsack = new Knapsack(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[1]));

            while ((line = bufferedReader.readLine()) != null) {
                splittedLine = line.split(" ");
                knapsack.add(new Thing(
                        Integer.parseInt(splittedLine[0]),
                        Integer.parseInt(splittedLine[1]),
                        Integer.parseInt(splittedLine[2]))
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (knapsack == null) {
            return;
        }
        Result expectedResult = new Result(25, Arrays.asList(1, 3, 4, 5, 8, 9));
        Result result = knapsack.getResult();
        Assertions.assertEquals(expectedResult, result);
    }
}
