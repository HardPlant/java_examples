# 분할정복

문제를 작은 부분 문제로 나누어 푸는 접근법

분할->정복->통합
하향식 접근 방법임 (Top-Down)


### 이분검색

정렬된 배열에서 검색함
배열을 부분배열로 분리

가장 간단한 부류의 분할정복 알고리즘임
사례가 더 작은 사례로만 갈라지기 때문임

##### 전략

x와 가운데 아이템이 같으면,

* 배열을 반 정도 크기의 2개 배열로 **분할**

* 선택한 부분배열에 x가 있는지 결정해 그 부분배열을 **정복**

* 부분배열로 얻은 해답으로 전체 배열에 대한 해답을 **구함**

##### 이분검색 코드

```java
int search(int[] array, int x){
    int low = 0;
    int high = array.length - 1;
    int mid = -1;
    for(; low <= high){
        mid = (low + high)/2
        if(array[mid] == x) break;
        else if(array[mid]<x) low = mid + 1;
        else high = mid - 1;
    }
    return mid;
}
```
### 합병정렬

### 퀵소트

### 쉬트라센 행렬곱셈 알고리즘

### Bigint 계산법

### 임계값 결정