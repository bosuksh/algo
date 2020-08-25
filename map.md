## 10. Map

Map의 종류는 많다. HashMap, TreeMap, LinkedHashMap등



#### 1. TreeMap

TreeMap은 맵이 트리구조로 저장된다. 그래서 애초에 Map을 초기화 할때 Comparator을 설정해둔대로 key가 정렬된다. 

만약 comparator을 따로 설정안하면 오름차순으로  정렬된다. 

```java
Map<String, String> map = new TreeMap<>();
map.put("e","5");
map.put("d","4");
map.put("c","3");
map.put("b","2");
map.put("a","1");

for(String key: map.keySet()) {
  System.out.println(key+ ": "+ map.get(key));
}
//a: 1
//b: 2
//c: 3
//d: 4
//e: 5
```



#### 2. HashMap

HashMap이나 LinkedHashMap을 이용하면 value를 가지고 정렬을 할 수 있는데 코드는 아래와 같다. 

```java
List<Map.Entry<Integer, Double>> entries = failRate.entrySet().stream().
              sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
```

List에 Map의 key,value쌍인 entry로 지정해두고 stream을 통해서 comparingByValue를 통해서 오름차순이든, 내림차순이든 정렬한 후 

collect로 다시 리스트로 바꿀 수 있다.



#### 3. Linked HashMap

LinkedHashMap은 입력한 순서대로 저장되는 특성을 가졌다. 이것도 위와 같이 리스트로 만든후 다시 LinkedHashMap에 저장하는 형태를 가지고 있지만 굳이 그렇게 해야할 필요는 없느것 같다. 





#### 특히 2번 방법이 자주 사용될테니 숙지하자.

[관련문제]: https://programmers.co.kr/learn/courses/30/lessons/42889	""카카오2019코테2번""



