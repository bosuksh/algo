import java.util.ArrayList;
import java.util.List;

class Line2 {
    static List<Integer> arr = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) {
    }
    public int solution(String answer_sheet, String[] sheets) {

       // Solution.combination(answer_sheet, sheets, 0, 0);
        return answer;
    }

    public static void combination(String answer_sheet, String[] sheets, int r, int idx) {
        if (idx > answer_sheet.length() - 1) {
            return;
        }

        if (r == 2) {
            System.out.println(arr.size());
            // int ans = sol(answer_sheet,sheets);
            // if(answer < ans) {
            // answer = ans;
            // }
            return;
        }
        arr.add(idx);
        combination(answer_sheet, sheets, r + 1, idx + 1);
        arr.remove(idx);
        combination(answer_sheet, sheets, r, idx + 1);
    }

    public static int sol(String answer_sheet, String[] sheets) {
        int num1 = arr.get(0);
        int num2 = arr.get(1);
        int count = 0;
        int seqCnt = 0;
        int longSeq = 0;
        for (int i = 0; i < answer_sheet.length(); i++) {
            if ((answer_sheet.charAt(i) != sheets[num1].charAt(i))
                    && (sheets[num1].charAt(i) == sheets[num2].charAt(i))) {
                seqCnt++;
                count++;
            } else {
                if (longSeq < seqCnt)
                    longSeq = seqCnt;
                seqCnt = 0;
            }
        }
        return count + (longSeq * longSeq);
    }
}