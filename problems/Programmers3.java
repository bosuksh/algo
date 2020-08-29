
class Programmers3 {
    public static void main(String[] args) {
        int[] height = { 1, 5, 3, 6, 7, 6, 5};
        int[] answer = solution(height);
        for(int i= 0; i < answer.length; i++) {
            System.out.print(answer[i]+ " ");
        }
        System.out.println();
    }

    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for(int i = heights.length-1; i>0; i--) {
            for(int j = i-1; j >= 0 ; j--) {
                if(heights[i]< heights[j]) {
                    answer[i] = j+1;
                    break;
                }
            }
        }
        
        return answer;
    }
}