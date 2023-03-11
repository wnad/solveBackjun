package dataStructure;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    // 배열이 생성 될 때의 최초 할당 크기(용적)이자 최소 할당 용적 변수로 기본값은 10으로 설정해두었다.

    private static final Object[] EMPTY_ARRAY = {};
    // 아무 것도 없는 빈 배열 (용적이 0인 배열)

    private int size;	// 요소 개수

    Object[] array;	// 요소를 담을 배열

    // 생성자1 (초기 공간 할당 X)
    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;

    }

    // 생성자2 (초기 공간 할당 O)
    public ArrayList(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize() {
        int array_capacity = array.length;

        // if array's capacity is 0
        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        // 용량이 꽉 찰 경우
        if (size == array_capacity) {
            int new_capacity = array_capacity * 2;

            // copy
            array = Arrays.copyOf(array, new_capacity);
            return;
        }
        // 용적의 절반 미만으로 요소가 차지하고 있을 경우
        if (size < (array_capacity / 2)) {
            int new_capacity = array_capacity / 2;

            // copy
            array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
            return;
        }
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value) {

        // 꽉차있는 상태라면 용적 재할당
        if (size == array.length) {
            resize();
        }

        array[size] = value;	// 마지막 위치에 요소 추가
        size++;	// 사이즈 1 증가
    }

    @Override
    public void add(int index, E value) {

        // index 오류 예외처리
        if (index>size || index<0) {
            throw new IndexOutOfBoundsException();
        }

        // index와 요소 개수와 같다면 마지막 자리에 추가
        if (index==size) {
            addLast(value);
        }

        // 그외 경우 마지막 부터 index 까지 한칸씩 뒤로 미루기
        if (index!=size) {
            if (size == array.length) {
                resize();
            }

            for (int i=size; i>index; i--) {
                array[i] = array[i-1];
            }

            array[index] = value;
            size++;

        }
    }

    public void addFirst(E value) {
        add(0, value);
    }

    // 해당 index 의 값을 반환
    @Override
    public E get(int index) {

        // index 오류 예외처리
        if (index>size || index<0) {
            throw new IndexOutOfBoundsException();
        }

        // (Object) -> (E) 캐스팅 후 index 요소 반환
        return (E) array[index];

    }

    // 해당 index 의 값을 value 로 교환
    @Override
    public void set(int index, E value) {

        // index 오류 예외처리
        if (index>size || index<0) {
            throw new IndexOutOfBoundsException();
        } else {
            array[index] = value;
        }

    }

    // 찾고 싶은 value 의 index 를 반환
    @Override
    public int indexOf(Object value) {
        int i = 0;

        for (i=0; i<size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }

        // 일치하는 요소가 없는 경우 -1 를 반환
        return -1;
    }

    public int lastIndexOf(Object value) {

        for (int i=size-1; i>=0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    // 해당 value 가 있는지 검사
    @Override
    public boolean contains(Object value) {

        if (indexOf(value)>=0) {
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);

        if (index == -1) {
            return false;
        }

        remove(index);
        return true;
    }

    @Override
    public E remove(int index) {
        // index 오류 예외처리
        if (index>size || index<0) {
            throw new IndexOutOfBoundsException();
        }

        E element = (E) array[index];
        array[index] = null;

        for (int i=index; i<size-1; i++) {
            array[i] = array[i+1];
            array[i+1] = null;
        }

        size--;
        resize();

        return element;

    }

    @Override
    public int size() {
        return size;	// 요소 개수 반환
    }

    @Override
    public boolean isEmpty() {
        return size == 0;	// 요소가 0개일 경우 비어있다는 의미이므로 true반환
    }

    @Override
    public void clear() {
        // 모든 공간을 null 처리 해준다.
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        resize();
    }


}
