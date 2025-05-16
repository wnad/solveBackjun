package dataStructure;


public interface QueueInterface<E> {

    // 큐 마지막에 요소 추가
    boolean add(E element);

    // 첫번째 큐 삭제하고 삭제한 요소 반환
    E poll();

    // 첫번째 큐 요소 반환
    E peek();

    // Queue 가 비어있는지 여부를 반환
    boolean isEmpty();

    // Queue 에 들어있는 요소의 개수를 반환
    int size();




}
