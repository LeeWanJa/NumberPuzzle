package problem1;

import java.util.Scanner;

public class PuzzleMain {
    public static void main(String[] args) {
        System.out.println("간단 숫자 퍼즐");

        int turn = 1;
        int first, second;
        Numbers numbers = new Numbers();
        Scanner scan = new Scanner(System.in);

        // 퍼즐 시작!
        System.out.println("Turn " + turn);
        System.out.println(numbers.toString());
        while(!numbers.isSort()){
            // 정수 입력
            System.out.println("교환할 두 숫자를 입력>");
            String[] inputs = scan.nextLine().split(",");

            // 검증
            if(!checkValues(inputs)){
                System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요");
                continue;
            }

            first = Integer.parseInt(inputs[0]);
            second = Integer.parseInt(inputs[1].trim());

            // 두 수 swap
            numbers.swap(first, second);

            turn++;
            System.out.println("Turn " + turn);
            System.out.println(numbers.toString() + "\n");
        }
        System.out.println("축하합니다! " + turn + "턴만에 퍼즐을 완성하셨습니다!");
    }

    private static boolean checkValues(String[] arr) {
        // 입력이 두 개가 아닌 경우
        if(arr.length != 2)
            return false;
        arr[1] = arr[1].trim();

        // 시작에 공백이 있는 경우
        if(arr[0].contains(" "))
            return false;

        // 둘 중 하나라도 정수 변환이 안 되는 경우
        int first, second;
        try {
            first = Integer.parseInt(arr[0]);
            second = Integer.parseInt(arr[1]);
        } catch (NumberFormatException e) {
            return false;
        }

        // 범위 확인
        if(!((1 <= first && first <= 8) && (1 <= second && second <= 8)))
            return false;

        return true;
    }
}
