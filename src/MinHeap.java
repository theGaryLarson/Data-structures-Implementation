import java.util.Arrays;
//question let's say I did not want to enforce comparable but rather create a method that takes a comparable
// but if the client didn't set a comparable then it would need to be enforced. Is that doable?
// USE CASE: I have objects that i normally wouldn't need to compare but now i want to rank them by importance for
// a priority queue.
public class MinHeap<E extends Comparable<E>>{
    private static final int DEFAULT_CAPACITY = 17;
    private static final int ROOT = 0;
    private E[] heap;
    private int size;
    
    
    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }
    
    @SuppressWarnings("unchecked")
    public MinHeap(int initialCapacity) {
        heap = (E[]) new Comparable[initialCapacity];
        size = 0;
    }
    public E peek() {
        return heap[0];
    }
    
    public int size() {
        return size;
    }
    
    public void insert(E item) {
        ensureCapacity();
        heap[size++] = item;
         if (size() > 1 ) heapify(size - 1);
    }
    
    private void heapify(int idx) {
        // if not a leaf then it has children
        if(!isLeaf(idx)) {
            int swapIdx = idx;
            //if "node" has a right child need to compare left and right and prepare to swap minimum
            if (hasRightChild(idx)) {
                E leftChild = heap[leftChild(idx)];
                E rightChild = heap[rightChild(idx)];
                swapIdx = leftChild.compareTo(rightChild) < 0 ? leftChild(idx) : rightChild(idx);
            } else {
                swapIdx = leftChild(idx);
            }
            //check minimum against parent, if parent is larger swap
            E parent = heap[idx];
            E smallestChild = heap[swapIdx] != null ? heap[swapIdx]: heap[idx];
            if (parent.compareTo(smallestChild) < 0) {
                swap(idx, swapIdx);
                heapify(swapIdx);
            }
            
        }
    }
    
    private void swap(int firstIdx, int secondIdx) {
        E temp;
        temp = heap[firstIdx];
        heap[firstIdx] = heap[secondIdx];
        heap[secondIdx] = temp;
    }
    private void ensureCapacity() {
        if(!(size < heap.length)) {
            grow(heap.length * 2);
        }
    }
    private void grow(int capacity) {
        heap = Arrays.copyOf(heap,capacity);
    }
    
    private int parent(int idx) {
        //integer division drops the remainder. therefore, get the same index for both left and right child
        return (idx - 1) / 2;
    }
    
    private int leftChild(int idx) {
        return (2 * idx) + 1;
    }
    
    private int rightChild(int idx) {
        return (2 * idx) + 2;
    }
    
    private boolean hasParent(int idx) {
        return idx > 0;
    }
    
    private boolean hasLeftChild(int idx) {
        return leftChild(idx) <= size;
    }
    
    private boolean hasRightChild(int idx) {
        return rightChild(idx) <= size;
    }
    
    private boolean isLeaf(int idx) {
        return idx > (size / 2);
    }
    
}
