## 2. 배열과 리스트 (Array and List)

자바를 사용할 때, List나 Arrays 클래스를 사용하면 유용한 점이 많이 있다.

예를 들어, 정렬을 하거나 부분 리스트를 구하는 등의 여러 유용한 면이 많다. 그런 함수들에 대해서 알아볼 것이다.  

**그 전에 한가지 주의 할 것은 자바는 메모리 값을 참조하는 것이 기본이기 때문에 값을 정렬을 할때는 copy를 해서 하는 것을 추천 한다.** 



### 1. List

List에 들어있는 함수는 대부분 **Collections** 클래스를 통해서 다양하게 사용할 수 있다.


1. 그 중 가장 알고리즘에서 많이 사용하는 것은 sort이다.

```java
Collections.sort(List, Comparator<T> comparator);

```

이런 형태로 사용하게 되면 리스트가 정렬된다. 또한 Comparator로 정렬을 어떻게 할지도 정할 수 있다. 
생략하면 그냥 오름차순 정렬이 된다. 




2. 또, 자주 사용하는 것 중 하나는 reverse이다. 

reverse는 현재 있는 리스트를 뒤집어준다. 즉, 맨 앞 원소가 맨 뒤로가고 맨 뒤 원소가 맨 앞으로 오게된다.

```java
Collections.reverse(List)
```

예를 들어, 정렬을 오름차순이 아닌 내림차순을 하고 싶을 때, Collections.sort() 후 Collections.reverse()를 사용하면 뒤집으면 내림차순 정렬을 할 수 있게 된다. 




3. subList를 이용하면 List의 일부를 사용할 수 있다.

이 메소드는 Collections에 들어가 있는게 아닌 List인스턴스의 메소드이다. fromIndex부터 toIndex 전 원소까지 갖게 되는 subList가 된다. 

```
List.subList(fromIndex, toIndex)
```

**그러나 위에서 말했다시피 subList역시 메모리 참조로 이뤄지게 때문에 이 subList를 변형하게 되면 실제 List에도 영향이 가게된다.**



### 2. Arrays

자바에서는 array보다는 List를 더 많이 사용하지만, array가 더 좋은 경우도 있다. 그렇기 때문에 **Arrays** 클래스를 잘 알아두면 좋다. 


1. 여기도 마찬가지로 sort를 사용할 수 있다.

사용법은 List와 마찬가지로  Arrays.sort()를 사용하면 인자로 들어가는 array가 정렬된다. 

```java
Arrays.sort(array, Comparator<T> comparator)
```

comparator를 이용하면 Comparator에 맞는 조건으로 정렬을 할 수 있다. 




2. Arrays.asList를 이용하면 array를 List로 바꿀 수 있다. 

```java
List<T> tList = Arrays.asList(array);
```

자바는 아무래도 List를 더 많이 사용하다 보니 List로 할 수 있는 게 많다. 이 메소드를 이용하면 array를 리스트로 한 번에 바꿀 수 있다. 

*반대로 List를 array로 바꾸기 위해서는 List인스턴스의 toArray라는 메소드를 사용하면 된다.* 




3. copyOfRange를 이용하면 array를 원하는 범위에 맞춰 복사할 수 있다. 

```java
T[] copyArray = Arrays.copyOfRange(array,fromIndex, toIndex);
```

메모리 참조로 인해 값이 변하는 것을 막기 위해서 복사를 할 때는 반복문이 아닌 copyOfRange 메소드를 이용해서 하면 원하는 위치의 array를 카피해서 사용할 수 있다. 



[관련문제](https://programmers.co.kr/learn/courses/30/lessons/42748)

알고리즘 문제를 풀 때 주어진 것들을 잘 이용해서 노가다로 시간낭비 하지 말자.
