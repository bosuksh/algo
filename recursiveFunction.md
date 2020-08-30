## 11. 재귀함수(Recursive Function) - 하노이의 탑

재귀함수 함수안에서 같은 함수를 계속해서 반복적으로 부르는 것이다.

DFS, 조합, 순열 등에서 사용되는데 재귀에 대표적인 것은 피보나치가 있다. 

그러나 그것보다 가끔 나오는 하노이의 탑 알고리즘에 대해서 작성하겠다. 



![하노이의 탑' 이해하기 - Parkito's on the way](https://shoark7.github.io/assets/img/algorithm/hanoi-tower-from-to.png)



그림을 보면 바로 이해가 될텐데, A 기둥에서 C기둥으로 옮기는 과정이다. 

제한 사항은 작은 블록은 무조건 큰 블록 위에 와야하는 것이다. 그렇기 때문에 B 기둥을 거쳐가야 한다. 

이걸 푸는 알고리즘은 간단하다. 재귀적으로 

1. n-1개의 블록을 A에서 B로 옮긴다. 
2. n번째 블록을 A에서 C로 옮긴다.
3. n-1번째 블록을 B에서 C로 옮긴다.

이 과정을 재귀적으로 하면 된다.

코드로 살펴보면

 

```java
private static void hanoiProcess(int n, int first_pillar, int third_pillar, int second_pillar) {
  if(n == 1) {
    answerList.add(new int[]{first_pillar,third_pillar});
    return;
  }

  // n-1개 링을 1번 기둥에서 2번 기둥으로 옮기기
  hanoiProcess(n-1,first_pillar,second_pillar,third_pillar);
  // n번째 링을 1번 기둥에서 3번 기둥으로 옮기기
  answerList.add(new int[]{first_pillar,third_pillar});
  // n-1개 링을 2번 기둥에서 3번 기둥으로 옮기기
  hanoiProcess(n-1,second_pillar,third_pillar,first_pillar);
}
```

이런식으로 answerList에 기둥으로 옮겨가는 순서가 차례대로 담기게 된다.