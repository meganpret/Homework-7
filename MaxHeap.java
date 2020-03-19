public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
      for (int i = 0; i < data.length; i++) {
        this.data.add(data[i]);
      }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
      int n = data.length;
      
      for (int i = (n/2); i < 0; i++) {
        Heapify(data, i, n);
      }
    }

    public int Heapify(Integer[] data, int i, int n) {
      int l = 2 * i + 1; 
      int r = (2 * i) + 2;
      int largest = i;
      
      if (l <= n && data[l] > data [largest]) {
        largest = l;
      }
      if (r < n && data[r] > data[largest]) {
        largest = r;
      }
      if (largest != i) {
        int swap = data[i];
        data[i] = data[largest];
        data[largest] = swap;
        Heapify(data, largest, n);
      }
    }
    // add an item to the heap
    public boolean add(Integer item) {
        int current = size; 
        while (data[current] > data[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
            return true;
        } 
        return false;
    }

    public int parent (int place) {
       return place / 2;
    }
    
    public void swap(int place1, int place2) {
      int temp;
      temp = data[place1];
      data[place1] = data[place2];
      data[place2] = temp;
    }
    // return the max item in the heap
    public Integer get() {
        // homework
        return null;
    }

    private boolean isLeaf(int pos) { 
      if (pos >= (size / 2) && pos <= size) { 
       return true; 
      } 
      return false; 
    } 
  
    public int leftChild(int pos) { 
        return (2 * pos); 
    } 
    
    public int rightChild(int pos) { 
        return (2 * pos) + 1; 
    } 
    
    public void maxHeapify(int pos) { 
      if (isLeaf(pos)) {
        return; 
      }
      if (data[pos] < data[leftChild(pos)] ||  
            data[pos] < data[rightChild(pos)]) { 
  
        if (data[leftChild(pos)] > data[rightChild(pos)]) { 
          swap(pos, leftChild(pos)); 
          maxHeapify(leftChild(pos)); 
        } 
        else { 
          swap(pos, rightChild(pos)); 
          maxHeapify(rightChild(pos)); 
        } 
      } 
    } 
    // remove the root item
    public Integer pop() {
        int pop = data[1];
        data[1] = data[size--];
        maxHeapify(1);
        return null;
    }
}