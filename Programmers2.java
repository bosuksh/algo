import java.util.HashMap;

class Programmers2 {
    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        //HashMap<String, Integer>map = new HashMap<>();
        
        for(int i = 0; i< phone_book.length; i++) {
            for(int j = 0; j< phone_book.length; j++) {
                if((i != j) && phone_book[j].contains(phone_book[i])) {
                    answer = false;
                    break;
                }
            }

        }        
        return answer;
    }
}