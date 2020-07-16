## 3. DFS

DFS란 Depth First Search(깊이 우선 탐색)으로 재귀함수를 통해서 그래프의 방문을 체크할 수 있다. 

시작점으로부터 연결되어 있는 점을 타고 타고 들어가서 가장 깊이까지 들어간 다음 다시 순차적으로 나오고 그다음 연결 점을 찾아서 또 가장 깊숙이 들어갔다 나오는 방법을 반복하는 방식이다. 



**장점**

목표 노드의 뎁스가 깊은 경우는 빠르게 탐색할 수 있다. 

현재 경로상의 노드들만 기억하면 되므로, 저장 공간의 수요가 비교적 적다. 



**단점**

단순 검색 속도는 BFS보다 느리다. 

구한 해가 최단 경로가 아닐 가능성이 있다. 



그렇다면 DFS를 구현해보겠다. 



```java
public class Graph {

    public int solution(int n, int[][] graph) {
        boolean[] visited = new boolean[n];

        for(int i = 0; i< n; i++) {
            visited[i]= false;
        }
        int answer  = 0;
        for(int i = 0; i < n; i++) {
            answer += dfs(i, graph, visited);
        }
        return answer;
    }
    public int dfs(int idx, int[][] graph, boolean[] visited) {
        if(visited[idx]) {
            return 0;
        }
        visited[idx] = true;

        for(int i = 0; i< graph.length; i++) {
            if(!visited[i] && graph[i][idx] == 1) {
                dfs(i,graph,visited);
            }
        }
        return 1;

    }
}
```

전제는 그래프가 인접행렬로 이루어져있고 양방향 그래프이다. 연결되어있는 점 두개의 행과 열이 1로 표시되어있다는 가정으로 진행된다. 

> 기본적인 메커니즘은 점의 방문 체크를 visited 배열을 통해서 하고 방문하지 않고 점이 연결되어 있으면 재귀로 연결되어 있는 target점을 타고 들어가면 된다.



이 코드는 방문한 점은 return 0으로 해주고 dfs로 들어갔다가 나올 때는 1을 return을 해줬다. 이렇게 함으로써 얻게되는 효과는 한 점으로부터 연결되어 있는 점을 모두 방문하고 나올때마다 return 1이 되고 그 값을 더해주기 때문에 점끼리 연결되어 있는 group이 총 몇개인지를 알 수 있다는 점이다. 

총 몇 개의 그룹이 형성되어 있는 지를 알고 싶을 때는 이 메서드를 사용하면 된다.  

[관련문제](https://programmers.co.kr/learn/courses/30/lessons/43162#)