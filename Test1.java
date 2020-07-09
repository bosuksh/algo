class Test1 {

    public static void main(String[] args) {
        String[] input = {"S4","H4","D4","D9","H9","H4","H2","S2"};
        String[] input2 = { "C5", "H5", "D2", "D6", "D3", "S3"};
        System.out.println(solution(input2));
        
    }

    public static boolean solution(String[] input) {
        boolean flag = true;

        for(int i = 0; i<input.length-1; i++) {
            if((input[i].charAt(0) != input[i+1].charAt(0)) && (input[i].charAt(1) != input[i+1].charAt(1))){
                flag = false;
                break;
            }
        }

        return flag;
    }
}