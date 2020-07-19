## 5. 너비 우선 탐색 (Breadth First Search)

너비 우선 탐색 (BFS)는 깊이 우선 탐색(DFS)과 더불어 완전 탐색을 할 때 자주 사용하는 방법이다. 

DFS는 한 경로의 끝을 보는 반면 BFS는 너비로 찾기 때문에 최단 거리등의 문제에서 유용하다. 

코드는 다음과 같다. 

```java
 public int solution(String begin, String target, String[] words) {
        HashMap<String, Integer> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        visited.put(begin,0);
        while(!queue.isEmpty()) {
            String tempStr = queue.peek();
            queue.poll();
            if(tempStr.equals(target)) {
                return visited.get(tempStr);
            }
            for(int i = 0; i< words.length; i++) {
                if(!visited.containsKey(words[i]) && isOneCharDifferent(tempStr, words[i])) {
                    visited.put(words[i],visited.get(tempStr)+1);
                    queue.add(words[i]);
                }
            }
        }
        return 0;
    }
    public static boolean isOneCharDifferent(String s1, String s2) {
        int cnt = 0;
        for(int i = 0; i< s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i))
                cnt++;
        }
        if(cnt == 1)
            return true;
        return false;
        
    }
```

Queue를 만들어서 조건에 해당하는 값들을 queue에 넣어주고 하나씩 탐색을 해가면 되는 것이다. 

**방문 체크를 할 때는 HashMap을 이용해서 true/false를 할 수도 있고** 

**visited를 통해 depth를 기록할 수도 있다.** 



[관련문제](https://programmers.co.kr/learn/courses/30/lessons/43163)