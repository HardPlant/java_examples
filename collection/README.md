# 자바 컬렉션

Java에서 데이터를 저장하는 기본적인 자료구조들을 한 곳에 모아 관리하고 편하게 사용하기 위해서 제공하는 것을 의미한다.

사용 용도에 따라 List, Set, Map 3가지로 요약할 수 있다.

기본적인 구조는 다음과 같다.

#### Collection : 순서, 집합적인 저장공간

###### List : 순서가 있는 저장 공간

데이터 중복을 허용함

* ArrayList : 동기화 보장하지 않음
* LinkedList
* Vector : 동기화 보장
* Stack

###### Set : 집합적인 저장 공간

데이터의 중복을 허용하지 않음

* HashSet : Set 계열 대표클래스
* (SortedSet) -> TreeSet

#### Map : 키/값으로 데이터 처리

키/값 쌍으로 이루어짐, 순서는 유지되지 않음, 키의 중복을 허용하지 않음

* HashMap: 동기화가 보장되는 맵 클래스
* (SortedMap) -> TreeMap: 동기화가 보장되지 않는 맵 클래스
* HashTable: 정렬을 위한 맵 클래스

### Collection : interface

add(), contain(), isEmpty(), remove(), size(), iterator()

##### List

###### ArrayList

읽기 빠름, 동적 크기 결정 가능
단방향 포인터 구조임

###### Vector

ArrayList 구형버전임, 잘 쓰진 않음

###### LinkedList

양방향 포인터 구조임
삽입/삭제 빈번할 때 빠른 성능 보장
스택, 큐, 양방향 큐 만들기 가능

##### Set

###### HashSet

임의 접근 속도 가장 빠름
순서 예측 불가

###### LinkedHashSet

추가된 순서, 최근 접근한 순서대로 접근 가능

###### TreeSet

정렬된 순서대로 보관, 정렬 방법 지정 가능

##### Map