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
        Collections.shuffle(temp);

        int idx = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                newNumbers[i][j] = temp.get(idx++);
            }
        }

        return new Numbers(newNumbers);
    }

    // 유효한 퍼즐인지 검증
    private boolean checkNumbers(){
        return false;
    }

    // 2차원 배열 출력
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
