import java.util.*;

public class Main {
	int size = 0;
	static int length = 10;
	int[] heap = new int[length];

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> sortedList = new ArrayList<>();

		Random rand = new Random();

		for(int i = 0; i < length; i++){
			list.add(rand.nextInt(10));
		}

		Main mxhp = new Main();
		MinHeap mnhp = new MinHeap();

		for(int i : list){
			mxhp.insertion(i);
			mnhp.insertion(i);
		}
		System.out.println("Original List: " + list);
		while(mxhp.size > 0){
			sortedList.add(mxhp.deletion());
		}
		System.out.println("Sorted List (MaxHeap): " + sortedList + "\n");

		System.out.println("Original list: " + list);
		sortedList.clear();

		while(mnhp.size > 0){
			sortedList.add(mnhp.deletion());
		}
		System.out.println("Sorted List (MinHeap): " + sortedList);
	}
	public void siftUp(int index){
		int parentIndex = (index - 1) / 2;
		while (index > 0 && heap[index] > heap[parentIndex]) {
			// Swap current element with its parent
			int temp = heap[index];
			heap[index] = heap[parentIndex];
			heap[parentIndex] = temp;
			index = parentIndex;
			parentIndex = (index - 1) / 2;
		}
	}
	public void siftDown(int index){
		int leftChildIndex, rightChildIndex, maxIndex;
		while (2 * index + 1 < size) {
			leftChildIndex = 2 * index + 1;
			rightChildIndex = 2 * index + 2;
			maxIndex = leftChildIndex;
			if (rightChildIndex < size && heap[rightChildIndex] > heap[leftChildIndex]) {
				maxIndex = rightChildIndex;
			}
			if (heap[index] < heap[maxIndex]) {
				int temp = heap[index];
				heap[index] = heap[maxIndex];
				heap[maxIndex] = temp;
				index = maxIndex;
			} else {
				break;
			}
		}
	}
	public void insertion(int value){
		heap[size] = value;
		size++;
		siftUp(size - 1);
	}

	public int deletion(){
		if (size == 0) {
			throw new IllegalStateException("Heap is empty");
		}
		int max = heap[0];
		heap[0] = heap[size - 1];
		size--;
		siftDown(0);
		return max;
	}
}