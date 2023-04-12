package HeapsAndPriorityQueue;

public class MaxHeap {
    int[] arr;
    int capacity;
    int size;

    MaxHeap(int maxLimit) {
        capacity = maxLimit;
        size = 0;
        arr = new int[capacity + 1];
    }

    void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    void insert(int data) {
        size = size + 1;
        int idx = 0;
        // ensure size is less than capacity
        if (size < capacity) {
            idx = size;
            arr[idx] = data;
        }
        // fix the heap
        while (idx > 1 && arr[idx] > arr[idx / 2]) {
            swap(arr[idx], arr[idx / 2]);
        }
    }

}
