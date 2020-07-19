## 4. 백트래킹 (Backtracking)

DFS나 BFS와 같은 그래프 탐색에서 자주 따라오는 것이 백트래킹이다. 

> 백트래킹의 포인트는 필요없는 부분을 가지치기 하는 과정이다.



백 트래킹의 가장 유명한 문제인 N-Queen 문제를 통해서 살펴볼 수 있다.



**N-Queen 문제란**

N x N 체스판에 N개의 Queen을 놓을 때 서로 공격할 수 없도록 놓는 경우의 수를 찾는 것을 말한다. 



문제 해결 방법은 backtracking을 이용해서 k번째 위치의 열(또는 행)을 기준으로 k+1번째 열(또는 행)을 하나씩 돌면서 
가능한 위치인가 판별하고 아닐 경우 전 단계로 돌아온다.

이렇게 모든 경우를 찾으면서 아닌 경우는 더 깊이 들어가지 않고 가지치기를 하면서 모든 경우를 찾아가는 방법이다. 

```java
private static void dfs(int current,boolean[][] chessMap,int n) {

  	if(current == n) {      //끝까지 도착
        totalCount++;
        return;
    }
    for(int i = 0; i < n; i++) {
       if(isValid(chessMap,current,i,n)) {
            chessMap[i][current] = true;
            dfs(current+1,chessMap,n);               
            chessMap[i][current] = false;
       }
    }
}

private static boolean isValid(boolean[][] chessMap, int x, int y, int n) {

    for(int i = x-1; i >= 0; i--) {         // 가로
        if(chessMap[y][i])
            return false;
    }

    for(int i = y-1, j = x-1; j >= 0 && i >= 0; j--, i-- ) {    //대각선 11시방향
        if(chessMap[i][j])
            return false;
        }

    for(int i = y+1, j = x-1; j >= 0 && i < n; j--, i++) {    //대각선 7시 방향
        if(chessMap[i][j])
            return false;
    }

    return true;
}
```

내 개인적인 생각으로는 백트래킹에서 포인트는  2가지이다.

1. 전 단계로 가는 상황에서 이전 상태로 되돌려주는 상황

   Ex) 여기서는 chessMap을 true로 한 후 dfs 이후 상황에서 다시 false로 바꿔주는 상황

2. 그 다음에 종료조건을 체크해서 끝날때를 걸러주는 것 

   Ex) current == n일때, 종료해주는 것을 의미한다. 

이 두가지를 잘 체크하면 백트래킹에 대한 핵심을 짚을 수 있을것 같다. 

[관련문제](https://www.acmicpc.net/problem/9663)

