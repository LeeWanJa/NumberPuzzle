package problem2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import problem2.main.Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumbersTest {

    @Test
    void print_numbers() {
        Numbers numbers = Numbers.createNumbers();

        System.out.println(numbers.toString());
    }

    @Test
    void puzzle_validation_check() {
        // int[] arr = {13, 2, 10, 3, 1, 12, 8, 4, 5, 0, 9, 6, 15, 14, 11, 7};
        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 14, 0};
        // int[] arr = {6, 13, 7, 10, 8, 9, 11, 0, 15, 2, 12, 5, 14, 3, 1, 4};
        // int[] arr = {3, 9, 1, 15, 14, 11, 4, 6, 13, 0, 10, 12, 2, 7, 8, 5};
        int[] arr = {12, 8, 11, 10, 2, 5, 14, 15, 6, 1, 0, 4, 13, 9, 7, 3};

        // inversion의 합계
        int idx = -1;
        int inversion = 0;
        for(int i = 0; i <= 15; i++){
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

        //int expectedInversion = 41;
        //int expectedInversion = 1;
        //int expectedInversion = 62;
        //int expectedInversion = 56;
        int expectedInversion = 63;
        System.out.println(inversion + " | " + expectedInversion);
        Assertions.assertEquals(expectedInversion, inversion);

        System.out.println(Arrays.toString(arr));
        System.out.println("0의 위치는? " + idx);
        // 짝수 홀수 검증
        boolean idx_row = (idx / 4) % 2 == 0;
        boolean resultBool = false;
        if(idx_row && !(inversion % 2 == 0)) // 짝수인 경우
            resultBool = true;

        if(!idx_row && (inversion % 2 == 0)) // 홀수인 경우
            resultBool = true;

        //boolean expectedBool = true;
        //boolean expectedBool = false;
        //boolean expectedBool = true;
        //boolean expectedBool = false;
        boolean expectedBool = true;

        System.out.println(resultBool + " | " + expectedBool);
        Assertions.assertEquals(expectedBool, resultBool);
    }
}
