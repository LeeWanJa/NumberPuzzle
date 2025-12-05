package problem1;

import java.util.ArrayList;
import java.util.Collections;

public class Numbers {
    private ArrayList<Integer> numbers;

    public Numbers() {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= 8; i++)
            temp.add(i);

        Collections.shuffle(temp);

        numbers = temp;
    }

    // Numbers의 멤버가 정렬되어 있는가 체크
    public boolean isSort() {
        for(int i = 1; i <= 8; i++)
            if(i != this.numbers.get(i - 1))
                return false;

        return true;
    }

    // swap 메서드
    public void swap(int first, int second) {
        int first_idx = -1, sec_idx = -1;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == first)
                first_idx = i;

            if (numbers.get(i) == second)
                sec_idx = i;
        }

        int tmp = numbers.get(first_idx);
        numbers.set(first_idx, numbers.get(sec_idx));
        numbers.set(sec_idx, tmp);
    }

    // numbers의 목록들 출력
    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
