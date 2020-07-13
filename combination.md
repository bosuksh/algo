## 1. 조합(Combination)

고등학교때 확률과 통계 이런데서 배웠을 순열과 조합중 조합이다. 

예를 들어, 5C3 5개중 3개를 순서와 상관없이 선택하는 것인데 프로그래밍에서는 주로 직접 일일이 세는식으로 구현된다. 



알고리즘을 간단히 설명하면, dfs로 구현되는데 나는 보통 파라미터로 몇개를 선택할 것인지 **target_count**를 두고 **current_count**로 현재 몇 개까지 선택되었는지를 체크한다. 
그리고 선택할 것들이 배열이나 리스트에 담겨있기 때문에 그 위치를 나타내주는 **current_position**도 체크를 한다. 
**check**라는 배열은 통해 선택된 인덱스를 가진 애들에게 1이라는 flag를 설정해주고 
**current_count ==  target_count를 만족**하면 그 때 check 배열을 통해 어떤 것들이 선택되었는지 확인한다. 

또한, current_position이 리스트를 벗어났는지 체크를 해준다.

```java
 public static void combination(int current_count, int target_count, int current_position, List<Integer> check, List<Integer> clothesCount) {
        if(current_count == target_count) {					// 선택할 개수와 선택한 개수가 같은지 확인
            int temp_answer = 1;
            for(int i = 0; i< check.size(); i++) {	// check된 애들을 찾아서 연산 해준다. 
                if(check.get(i) == 1) {
                    temp_answer  *= clothesCount.get(i);
                }
            }
            answer += temp_answer;
            return;
        }

        if(current_position >= check.size()) {		// 리스트의 현재 인덱스가 배열을 넘어갈 때 return
            return ;
        }

        check.set(current_position,1);						// 현재 위치 체크 
        combination(current_count+1,target_count, current_position+1,check, clothesCount);
        check.set(current_position,0);						// 현재 위치 체크x
        combination(current_count,target_count, current_position+1,check, clothesCount);
    }
```





------------------

+추가적으로

### 모든 조합의 경우의 수를 구하는 방법 

A, B, C 카테고리에서  A, B, C의 모든 조합의 경우의 수를 구하는 방법은 

**(A의 개수+1)x(B의 개수+1)x(C의 개수 +1)** 이다.

그 이유는 A를 0개부터 A의 개수까지 선택하는 경우를 B,C에도 적용해준다. 

예를 들면, 상의 하의 신발이 각각 5,4,3개가 있다고 했을 때

모든 조합의 수는  (5+1) x (4+1) x(3+1) 인 120가지이다.

[관련문제](https://programmers.co.kr/learn/courses/30/lessons/42578)
