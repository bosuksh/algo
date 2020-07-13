import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Programmers5 {
    
    public static void main(String[] args) {
        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};
        String answer1 = solution(numbers1);
        String answer2 = solution(numbers2);

        System.out.println(answer1);
        System.out.println(answer2);
    }
    
    public static String solution(int[] number) {
        String answer = "";
        Comparator<String> comparator = (n1, n2) -> n1.compareToIgnoreCase(n2);
        List<String> numbers = new ArrayList<>();
        for (Integer num : number) {
            numbers.add(num.toString());
        }
        while (!numbers.isEmpty()) {
            String maxOne = numbers.stream().max(comparator).get();
            answer += maxOne;
            numbers.remove(maxOne);
        }
        return answer;
    }
}