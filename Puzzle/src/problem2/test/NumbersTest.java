package problem2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problem2.main.Numbers;

import java.util.ArrayList;
import java.util.Collections;

public class NumbersTest {

    @Test
    void print_numbers() {
        Numbers numbers = Numbers.createNumbers();

        System.out.println(numbers.toString());
    }

    @Test
    void puzzle_validation_checkInversionNum() {
        int[] arr = {13, 2, 10, 3, 1, 12, 8, 4, 5, 0, 9, 6, 15, 14, 11, 7};

        // inversion의 합계
        int idx = -1;
        int inversion = 0;
        for(int i = 0; i < 15; i++){
            int num = arr[i];

            if(num == 0){
                idx = i;
                continue;
            }

            for(int j = i + 1; j <= 15; j++){
                if(num > arr[j] && arr[j] != 0)
                    inversion++;
            }
        }

        int expectedInversion = 41;

        Assertions.assertEquals(expectedInversion, inversion);
    }
}
