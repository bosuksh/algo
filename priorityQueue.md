## 5. 우선 순위 큐(Priority Queue)

우선 순위 큐는 일반 큐의 형태인데 우선순위에 따라 우선순위가 높은 원소가 앞에 들어가도록 되어있다. 

코드로 보게되면 

```java
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
```

기본 형태는 위와 같은 형태로 타입에 필요한 것을 넣어주면 된다. 

그리고 우선순위는 Integer의 경우 낮을수록 우선순위가 높다(기본 형태)

그러나 우선순위도 바꿔줄 수 있다. 

```java
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
```

이렇게 하게되면 우선순위가 뒤집히게 된다.

생성자에서 괄호안에 넣어주면 Comparator을 통해서 넣어줄 수 있다.

```java
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
  @Override
  public int compare(Integer o1, Integer o2) {
    return 0;
  }
});

PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
```

compare 메서드 안에서 비교를 통해서 우선순위를 정할 수 있다. 

o2 - o1을 하게되면 우선순위 기준이 숫자가 크게되고 o1-o2는 우선순위 기준이 숫자가 작을수록 되는 것이다. 

람다식으로 간단히 표현할 수도 있다. 



그리고 우선순위큐는 보통 MaxHeap과 Min Heap을 통해서 구현이 되는데

그렇기 때문에 iterator을 통해서 도는 것과 맨 앞에 값을 뽑아가는게 값이 다를 수 있다. 

```java
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

priorityQueue.add(5);
priorityQueue.add(1);
priorityQueue.add(2);
priorityQueue.add(3);
priorityQueue.add(4);
Iterator iterator = priorityQueue.iterator();

while(iterator.hasNext()) {						//iterator을 통한 값 가져오기
  System.out.print(iterator.next()+" ");
}
/*
*			1 3 2 5 4
*/
System.out.println();

while(!priorityQueue.isEmpty()) {			// 하나씩 맨 앞에 값을 가져오기 
  System.out.print(priorityQueue.poll()+" ");
}

/*
*			1 2 3 4 5
*/
```

각각 값이 다르게 나오는데 이건 구현이 힙으로 되어있기 때문이다. 그래서 우선순위 높은값을 꺼내기 위해서는 큐에서 하나씩 꺼내는게 좋다

[관련문제1](https://programmers.co.kr/learn/courses/30/lessons/42626)



### 우선순위 큐 문제 패턴

PriorityQueue의 문제는 주로 시계열의 문제가 많이 나온다. 

시간 순서에 따라서 Max든 Min이든 우선순위 큐에 넣어두고 해결하는 문제가 많이 나온다. 

이러한 문제는 for문 자체가 시간을 의미해서 for문을 돌면서 해당하는 시점에서 데이터를 큐에 넣어서 

조건에 도달했을때 큐에서 꺼내서 사용하게 되는 방법이다. 



*여기서 우선순위가 큰 값인 것을 최대 우선순위 큐라 하고 우선순위가 작은 값인 것을 최소 우선순위 큐라 하겠다.*



[라면공장](https://programmers.co.kr/learn/courses/30/lessons/42629) 문제 같은경우에는 for문을 통해서 하루하루를 count하고 밀가루 공급날짜에 도달하면

밀가루 공급량을 최대 우선순위 큐에 넣게 된다. 그래야 최대한 적게 밀가루를 공급받을 수 있기 때문이다. 

그리고 밀가루가 다 떨어졌을 때 최대 우선순위 큐에서 하나씩 꺼낸다.

여기서 놓친점은 밀가루를 꺼낸 날짜는 중요하지 않다. 어차피 최소로 꺼낸것이 중요하기 때문에 큐에 다 넣어놓고 필요할때 최대값을 뽑은 다음에 해당하는 날 밀가루를 공급받았다고 단정하면 되는 것이다.



```java
public int solution(int stock, int[] dates, int[] supplies, int k) {
    int answer = 0;
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());	//최대 우선순위 큐
    int idx = 0;
    for(int i = 0; i< k; i++) {													//하루하루를 for문을 통해 체크	
        stock--;
        if(idx < dates.length && i == dates[idx] ) {		//밀가루 공급시간이 i(현재)이면 최대 우선순위 큐에 넣는다.
          priorityQueue.add(supplies[idx++]);
        }
        if(stock == -1) {																//밀가루가 다 떨어지면 최대우선순위큐에서 공급해준다.
          stock += priorityQueue.poll();							//밀가루 공급날짜가 중요하지 않고 횟수가 중요하기 때문에 
          answer++;																		//큐에 넣어놓고 하나씩 꺼낸다고 생각해도 같다. 
        }
    }
    return answer;
}
```





[디스크 컨트롤러](https://programmers.co.kr/learn/courses/30/lessons/42627) 문제의 경우에도 위와 마찬가지로 매 초단위를 for문을 통해서 카운팅을 하고 요청 시점에 job을 최소 우선순위 큐에 넣어서 job이 끝난 후 job이 걸리는 시간이 짧은 순서대로 job을 처리하면 되는 문제이다.



```java
public int solution(int[][] jobs) {
  	PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(o -> o[1]));	//최소 우선순위 큐 
  	Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));	//Job을 시간 빠른 순서로 sorting
    int idx = 0;
    int time = 0;       // 현재 시간
    int endTime = 0;    // 현재 job이 끝나는 시간
    boolean isRunning = false;	//job이 도는지 체크
    int answer = 0;
    int requestTime = 0;//요청 시간
    while(isRunning || idx < jobs.length) {	// job이 모두 큐에 들어갔으면서 job이 돌지 않으면 끝난다.
      
        while(idx < jobs.length && jobs[idx][0] == time) {	//같은 요청시점에 job이 여러개 요청될 수 있다. 
          priorityQueue.add(new Integer[]{jobs[idx][0], jobs[idx++][1]});
        }
        if(endTime == time) {															//끝나는 시간에 도달했을 때
          isRunning = false;
          answer += endTime-requestTime;								//끝난시간 - 요청시간
        }
        if(!isRunning && !priorityQueue.isEmpty()) {        //job이 있고 queue가 비어있지 않을때
          Integer[] poll = priorityQueue.poll();
          endTime = time + poll[1];												//현재시간에서 소요시간을 더해 끝나는 시간 저장
          requestTime = poll[0];													//요청시간 저장	
          isRunning = true;
        }
        time++;
    }

    return answer/jobs.length;
}
```





