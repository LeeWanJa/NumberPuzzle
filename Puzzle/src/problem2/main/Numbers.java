package problem2.main;

import java.util.ArrayList;
import java.util.Collections;

public class Numbers {
    int[][] numbers;

    private Numbers(int[][] numbers) {
        this.numbers = numbers;
    }

    // 1 ~ 15의 퍼즐 생성
    public static Numbers createNumbers(){
        int[][] newNumbers = new int[4][4];
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < 16; i++)
            temp.add(i);

        // 검증
        while(true){
            Collections.shuffle(temp);
            if(checkNumbers(temp))
                break;
        }

        int idx = 0;
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                newNumbers[i][j] = temp.get(idx++);

        return new Numbers(newNumbers);
    }

    // 유효한 퍼즐인지 검증
    private static boolean checkNumbers(ArrayList<Integer> numbers){
        // https://www.geeksforgeeks.org/dsa/check-instance-15-puzzle-solvable/ 참고
        
        // inversion의 합계
        int idx = -1;
        int inversion = 0;
        for(int i = 0; i <= 15; i++){
            int num = numbers.get(i);

            if(num == 0){
                idx = i;
                continue;
            }

            for(int j = i + 1; j <= 15; j++){
                if(num > numbers.get(j) && numbers.get(j) != 0)
                    inversion++;
            }
        }

        // 0은 아래를 기준으로 홀수 열에 위치했는가, 짝수 열에 위치했는가?
        boolean idx_row = checkEvenOdd(idx / 4);
        if(idx_row && !checkEvenOdd(inversion)) // 짝수열에 위치한 경우 inversion은 홀수여야 함
            return true;

        if(!idx_row && checkEvenOdd(inversion)) // 홀수열에 위치한 경우 inversion은 짝수여야 함
            return true;

        return false;
    }

    // 짝수 홀수 체크
    public static boolean checkEvenOdd(int num){
        return num % 2 == 0;
    }

    public int[][] getNumbers() {
        return numbers;
    }

    // 2차원 배열 문자열로 출력
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (numbers[i][j] == 0){
                    result += "[  ]";
                    continue;
                }

                String tmp = String.format("[%2d]",  numbers[i][j]);
                result += tmp;
            }
            result += "\n";
        }

        return result;
    }
}
