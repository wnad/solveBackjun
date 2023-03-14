package dataStructure;

public interface Queue<E> {

    // 큐 마지막에 요소 추가
    boolean offer(E e);

    // 첫번째 큐 삭제하고 삭제한 요소 반환
    E poll();

    // 첫번째 큐 요소 반환
    E peek();

}
