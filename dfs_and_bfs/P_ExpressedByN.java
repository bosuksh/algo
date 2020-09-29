package org.example.programmers;

public class ExpressedByN {
    private int answer = -1;
    public static void main(String[] args) {
        ExpressedByN expressedByN = new ExpressedByN();
        expressedByN.solution(5,12);
    }


    public int solution(int N, int number) {
        dfs(0,N,0,number);
        return answer;
    }
    private void dfs(int currentCount, int N, int currentValue, int num) {
        if(currentValue == num){
            if(answer == -1 || answer > currentCount)
                answer = currentCount;
            return;
        }
        if(currentCount > 8) {
            return;
        }

        for(int i = 0; i < 8 - currentCount; i++) {
            String tmp  = "";
            for(int j = 0; j<= i; j++){
                tmp += N;
            }
            int tmpN = 0;
            if(!tmp.equals("")){
                tmpN = Integer.parseInt(tmp);
            }
            dfs(currentCount+i+1,N,currentValue+tmpN,num);
            dfs(currentCount+i+1,N,currentValue-tmpN,num);
            dfs(currentCount+i+1,N,currentValue*tmpN,num);
            dfs(currentCount+i+1,N,currentValue/tmpN,num);

        }
    }
}
