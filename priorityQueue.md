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

[관련문제2](https://programmers.co.kr/learn/courses/30/lessons/42629)

[관련문제3](https://programmers.co.kr/learn/courses/30/lessons/42627)





