## 9. 시간 관련 함수

이번건 알고리즘은 아니지만 코테에서 시간 관련한 문제가 나올때 사용하기 좋은 함수이다. 

String을 Date로 바꾼 후, 시간 계산하기 좋게 만들 수 있다. 

코드로 확인해보자

```java
String date1 = "2020/08/23 3:54:30";
SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd H:MM:ss");
Date changeDate = format.parse(date1);
```

위 처럼 DateFormat을 바꾸고 싶은 형식으로 바꿔주고 format.parse에 String을 넣게 되면 Date로 받을 수 있다. 

date의 getTime 메소드를 이용하면 밀리 세컨드 단위로 가져올수 시간을 가져올 수 있고 

**기준시점은 1970년 1월 1일 이다.**



그래서 이 함수는 두 시간이 주어졌을 때 차이를 구할 때 많이 사용할 수 있다. 

```java
String date1 = "2020/08/23 3:54:30";
String date2 = "2020/08/24 3:54:30";
SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd H:MM:ss");
Date changeDate = format.parse(date1);
Date changeDate2 = format.parse(date2);
long timeInterval = changeDate2.getTime() - changeDate.getTime();
System.out.println(timeInterval/(1000*60*60));		// 24
System.out.println(timeInterval/(1000*60*60*24));	// 1
```

마지막에 timeInterval이 밀리세컨드로 주어지기 때문에 세컨으로 바꾸고, 분으로 바꾸고, 시간으로 바꾸기 위해서 

1000, 60, 60을 각각 곱해줬다. 여기에 24를 곱해주면 일단위로 다시 바꿀 수 있다. 

