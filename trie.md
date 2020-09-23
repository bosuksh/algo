## 12. 트라이(Trie)

트라이 자료구조는 탐색을 빠르게 하기 위해서 만들어진 자료구조다. 

![Trie - Wikipedia](https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Trie_example.svg/1200px-Trie_example.svg.png)



모든 단어를 각각 저장하는 것이 아니라 문자 하나하나로 트리를 형성하여 

현재 몇 개의 단어가 밑에 존재하는지 체크를 할 수 있다. 

그래서 Prefix로 현재 몇개의 단어가 이 밑으로 존재하는 지 알 수 있다. 

알고리즘은 다음과 같다. 

```java
public static class Trie {
  private int count;			   // 밑으로 이어지는 자식의 개수 
  private Trie[] children;	 // 밑으로 이어지는 자식의 형태 보통 알파벳의 개수이다. 
  private boolean isTerminal;// 현재 단어가 끝나는지 체크하는 boolean 필드

  public Trie() {
    this.count = 0;					// 초기화 0개
    this.children = new Trie[26];	// 알파벳 26개
    this.isTerminal = false;			// 현재 단어가 종료되었는지 시작이므로 false다.
  }

  public void insert(char[] word) {		// 트리에 삽입하는 함수
    if(search(word) != 0) return;			// 존재하면 삽입 X
    Trie current = this;							// root부터 시작 
    for(char unit: word) {						
      current.count++;								 
      if(current.children[unit - 'a'] == null) {
        current.children[unit - 'a'] = new Trie();// 자식이 존재하지 않으면 초기화
      }
      current = current.children[unit - 'a'];			// 단어 하나하나마다 자식을 타고 내려감
    }
    current.isTerminal = true;										// 단어 종료후 terminal true
  }

  public int search(char[] word) {
    Trie current = this;												// root부터 찾는다.
    for(char unit: word) {
      if(current.children[unit - 'a'] == null) {// 단어가 끝나지 않았는데 자식이 없으면 단어 존재 X 
        return 0;
      }
      current = current.children[unit - 'a'];
    }
    return current.count;											// 현재 노드 밑으로 존재하는 단어의 개수 리턴
  }
}
```

위의 코드로 삽입하고 search하면 최대 단어의 길이의 시간 복잡도를 갖는다. 

다시 말해 단어의 길이가 L이면 최악의 경우 O(L)의 시간복잡도를 갖는다.



[관련 문제](https://programmers.co.kr/learn/courses/30/lessons/60060)(프로그래머스 가사검색)

[솔루션](https://github.com/bosuksh/algo/blob/master/problems/SearchLyrics.java)



