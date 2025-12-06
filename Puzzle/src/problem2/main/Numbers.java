package problem2.main;

import java.util.ArrayList;
import java.util.Collections;

public class Numbers {
    int[][] numbers;
    int[] coordinate;

    private Numbers(int[][] numbers,  int[] coordinate) {
        this.numbers = numbers;
        this.coordinate = coordinate;
    }

    // 1 ~ 15의 퍼즐 생성
    public static Numbers createNumbers(){
        int[][] newNumbers = new int[4][4];
        int[] newCoordinate = new int[2];
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
            for(int j = 0; j < 4; j++){
                newNumbers[i][j] = temp.get(idx++);

                if(newNumbers[i][j] == 0){
                    newCoordinate[0] = j; // x축
                    newCoordinate[1] = i; // y축
                }
            }

        return new Numbers(newNumbers, newCoordinate);
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

    // 입력한 값과 빈칸 swap
    public boolean swap(int inputValue) {
        int[] inputCoordinate = getCoordinate(inputValue);

        // 입력값의 위치가 빈칸의 위치에 인접해있는가?
        if(isNeighbor(coordinate, inputCoordinate)) {
            // 위치 바꾸고 빈칸 위치 갱신
            numbers[coordinate[1]][coordinate[0]] = inputValue;
            numbers[inputCoordinate[1]][inputCoordinate[0]] = 0;
            coordinate[0] = inputCoordinate[0];
            coordinate[1] = inputCoordinate[1];

            return true;
        }

        return false;
    }

    // 해당 값의 좌표 추출
    private int[] getCoordinate(int value) {
        int[] resultCoordinate = new int[2];

        // 입력값의 위치 추출
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                if(numbers[i][j] == value){
                    resultCoordinate[0] = j;
                    resultCoordinate[1] = i;
                    break;
                }

        return resultCoordinate;
    }

    // 상/하/좌/우 좌표 검사
    private boolean isNeighbor(int[] coordinate, int[] inputCoordinate) {
        int blankX = coordinate[0];
        int blankY = coordinate[1];
        int inputX = inputCoordinate[0];
        int inputY = inputCoordinate[1];

        // 왼쪽 숫자 입력
        if(blankX - 1 == inputX && blankY == inputY)
            return true;

        // 오른쪽 숫자 입력
        if(blankX + 1 ==  inputX && blankY == inputY)
            return true;

        // 위 숫자 입력
        if(blankX == inputX && blankY - 1 == inputY)
            return true;

        // 아래 숫자 입력
        if(blankX == inputX && blankY + 1 == inputY)
            return true;

        return false;
    }

    // 정렬 검사
    public boolean isSort(){
        int value = 1;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(numbers[i][j] == 0){
                    value++;
                    continue;
                }

                if(numbers[i][j] != value++)
                    return false;
            }
        }

        return true;
    }

    // 정렬 검사를 위한 치트 메서드
    public void cheat() {
        int value = 1;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(i == 3 && j == 2){
                    numbers[i][j] = 0;
                    coordinate[0] = j;
                    coordinate[1] = i;
                    continue;
                }

                numbers[i][j] = value++;
            }
        }
    }
}
