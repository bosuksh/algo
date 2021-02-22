import java.util.*;
public class OddOccurencesInArray {
  public static void main(String[] args) {
    int[] a = {3,5,5,3,5,5,6};
    System.out.println(solution(a));
  }

  public static int solution(int[] a) {
    Map<Integer, Integer> map = new HashMap<>();

    for(int i = 0; i< a.length; i++) {
      map.put(a[i], map.getOrDefault(a[i], 0) + 1);
    }

    for(Map.Entry<Integer, Integer> element: map.entrySet()) {
      if(element.getValue() %2 ==1)
        return element.getKey();
    }
    return 0;
  }
}
