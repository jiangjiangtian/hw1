package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    int first;//store the first item in the queue
    int last;//store the index one beyond the most recently inserted item
    T[] items;

    public ArrayRingBuffer(int c) {
        capacity = c;
        first = capacity / 2;
        last = first + 1;
        items = (T[]) new Object[capacity];
        fillCount = 0;
    }

    @Override
    public T peek() {
        return items[first];
    }

    @Override
    public void enqueue(T x) {
        if(isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        if(fillCount == 0) {
            items[first] = x;
            fillCount++;
            if(first == last) {
                last++;
            }
            return;
        }
        if(last == capacity - 1) {
            items[last] = x;
            last = 0;
            fillCount++;
            return;
        }
        fillCount++;
        items[last++] = x;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T temp = items[first];
        items[first] = null;
        if(first == capacity - 1) {
            first = 0;
            fillCount--;
            if(isEmpty()) {
                last = first + 1;
            }
            return temp;
        }
        first++;
        fillCount--;
        if(isEmpty()) {
            last = first + 1;
        }
        return temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        int pos;
        int curnum;

        public MyIterator() {
            pos = first;
            curnum = 0;
        }

        @Override
        public boolean hasNext() {
            return curnum < fillCount;
        }

        @Override
        public T next() {
            T temp = items[pos];
            if(pos == capacity - 1) {
                pos = 0;
            } else {
                pos++;
            }
            curnum++;
            return temp;
        }
    }
}
