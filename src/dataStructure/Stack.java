package dataStructure;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E> {

    private static final int DEFAULT_CAPACITY = 10;    // 최소(기본) 용적 크기
    private static final Object[] EMPTY_ARRAY = {};    // 빈 배열

    private Object[] array;    // 요소를 담을 배열
    private int size;    // 요소 개수

    public Stack() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public Stack(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    public void resize() {

        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        // 현재 용적 크기
        int arrayCapacity = array.length;

        // 용적이 가득 찰 경우
        if (size == arrayCapacity) {
            int newSize = arrayCapacity * 2;

            array = Arrays.copyOf(array, newSize);
            return;
        }

        // 용적의 절반 미만으로 요소가 차지하고 있을 경우
        if (size < (arrayCapacity / 2)) {

            int newCapacity = (arrayCapacity / 2);

            // 배열 복사
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
            return;
        }
    }

    @Override
    public E push(E item) {

        if (size == array.length) {
            resize();
        }

        array[size] = item;
        size++;

        return item;
    }

    @Override
    public E pop() {

        // 스택이 비어있다면 예외 처리
        if (size == 0) {
            throw new EmptyStackException();
        }

        E obj = (E) array[size-1];

        array[size-1] = null;

        size--;
        resize();

        return obj;
    }

    @Override
    public E peek() {
        // 만약 삭제할 요소가 없다면 Stack이 비어있다는 의미이므로 예외 발생시키기
        if(size == 0) {
            throw new EmptyStackException();
        }

        return (E) array[size - 1];
    }

    @Override
    public int search(Object value) {
        // value가 null일 때는 eqauls(null)이되어 null pointer exception이 발생할 수 있으니,
        // == 로 null값을 비교해준다.
        if(value == null) {
            for(int idx = size - 1; idx >= 0; idx--) {
                if(array[idx] == null) {
                    return size - idx;
                }
            }
        } else {
            for(int idx = size - 1; idx >= 0; idx--) {

                // 같은 객체를 찾았을 경우 size - idx 값을 반환
                if(array[idx].equals(value)) {
                    return size - idx;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

        // 저장되어있던 모든 요소를 null 처리 해준다.
        for(int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        resize();
    }

    @Override
    public boolean empty() {
        return size == 0;
    }


}
