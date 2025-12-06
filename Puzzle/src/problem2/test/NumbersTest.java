package problem2.test;

import org.junit.jupiter.api.Test;
import problem2.main.Numbers;

import java.util.ArrayList;

public class NumbersTest {

    @Test
    void print_numbers() {
        Numbers numbers = Numbers.createNumbers();

        System.out.println(numbers.toString());
    }
}
