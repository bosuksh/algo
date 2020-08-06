## 8.  프림 알고리즘(Prim Algorithm)

프림 알고리즘은 Minimum Spanning Tree(MST)를 만들 때 사용하는 알고리즘이다.

이 알고리즘은 **탐욕 알고리즘(Greedy Algorithm)**의 기반을 두고 있다.

MST는 Spanning Tree중에 cost의 합이 가장 작은 Spanning Tree이다. 

> Spanning Tree란 모든 정점을 포함하는 트리이다. 



알고리즘은 하나의 정점에서 출발해서 가장 cost가 작은 정점으로 연결을 하면서 모든 정점을 체크하는 것이다. 

이렇게 해서 모든 간선의 개수가 **(정점 - 1)**이 나올때까지 체크하면 된다. 

그것을 구현한 코드이다. 

```java
 public int solution(int n, int[][] costs) {
   int answer = 0;
   int visitedCnt = 0;
   List<AdjVertex>[] adjList = new ArrayList[n];
   boolean[] visited = new boolean[n];
   Arrays.fill(visited,false);

   for(int i = 0; i< n; i++) {
     adjList[i] = new ArrayList<>();
   }
	 // 인접리스트로 모든 간선을 표현한다.
   for(int i = 0; i< costs.length; i++) {
     int start = costs[i][0];
     int end = costs[i][1];
     int cost = costs[i][2];

     AdjVertex v1 = new AdjVertex(end,cost);
     AdjVertex v2 = new AdjVertex(start,cost);
     adjList[start].add(v1);
     adjList[end].add(v2);
   }
   //우선순위 큐를 이용하여 연결된 정점중에 가장 cost가 작은 것을 뽑아낸다.
   PriorityQueue<AdjVertex> pq = new PriorityQueue<>();
   for(int i = 0; i< adjList[0].size(); i++) {
     pq.offer(adjList[0].get(i));
   }
   visited[0] = true;
   int totalCost = 0;
   // queue를 체크하면서 연결된 정점의 방문체크를 하고 방문하지 않은 경우 해당 정점에서 연결된
   // 다른 정점을 다시 queue에 넣는다. 
   // 모든 점을 방문했으면 탈출한다.
   while(!pq.isEmpty()) {
     AdjVertex vertex = pq.poll();

     if(visited[vertex.getVertex()])
       continue;
     if(visitedCnt == n+1)
       break;
     totalCost += vertex.getCost();
     visitedCnt ++;
     visited[vertex.getVertex()] = true;

     for(int i = 0; i<adjList[vertex.getVertex()].size();i++) {
       pq.add(adjList[vertex.getVertex()].get(i));
     }
   }
   return totalCost;
 }
 // 정점과 가중치를 포함한 클래스를 생성하고 
 // Comparable을 구현해서 compareTo함수로 가중치 비교를 한다.
static class AdjVertex implements Comparable<AdjVertex>{
  private int vertex;
  private int cost;

  public AdjVertex(int vertex, int cost) {
    this.vertex = vertex;
    this.cost = cost;
  }
  public int getVertex() {
    return vertex;
  }

  public int getCost() {
    return cost;
  }

  @Override
  public int compareTo(AdjVertex vertex) {
    if(this.cost > vertex.cost) return 1;
    else if(this.cost == vertex.cost) return 0;
    else return -1;
  }
} 
```
[관련문제](https://programmers.co.kr/learn/courses/30/lessons/42861)
