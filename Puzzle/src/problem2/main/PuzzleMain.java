package problem2.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PuzzleMain {
    public static void main(String[] args) {
        Numbers numbers = Numbers.createNumbers();
        Scanner scan = new Scanner(System.in);
        int turn = 1;
        int inputValue;

        System.out.println("재밌는 15 퍼즐!");
        System.out.println("Turn " + turn);
        while(true){
            System.out.println(numbers.toString());
            System.out.print("숫자 입력>");
            // 입력 유효성 검증
            String input = scan.nextLine();
            if((inputValue = checkInput(input)) == -1)
                continue;

            // swap
            if(!numbers.swap(inputValue)){
                System.out.println("빈칸에 '상/하/좌/우'로 인접한 숫자를 입력해주세요!");
                continue;
            }
//
//            // 정렬 검증
//            if(numbers.isSort()){
//                System.out.println("축하합니다! " + turn + "턴만에 퍼즐을 완성하셨습니다!");
//                break;
//            }
            System.out.println("Turn " + ++turn);
        }
    }

    public static int checkInput(String input){
        String str = input.trim();
        int result;
        try {
            result = Integer.parseInt(str);
        }  catch (NumberFormatException e) {
            System.out.println("유효하지 않은 입력입니다!");
            return -1;
        }

        if(!(1 <= result && result <= 15)){
            System.out.println("유효하지 않은 입력입니다!");
            return -1;
        }

        return result;
    }
}
