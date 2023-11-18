public class MinHeap {
	public int[] heap = new int[10];
	public int size = 0;
	public MinHeap(){
		// default constructor

	}

	public void siftUp(int index){
		int parentIndex = (index - 1) / 2;
		while(index > 0 && heap[index] < heap[parentIndex]){
			int temp = heap[index];
			heap[index] = heap[parentIndex];
			heap[parentIndex] = temp;
			index = parentIndex;
			parentIndex = (index - 1) / 2;
		}
	}
	public void siftDown(int index){
		int leftChildIdx, rightChildIdx, minIndx;
		while((2 * index + 1) < size){
			leftChildIdx = 2 * index + 1;
			rightChildIdx = 2 * index + 2;
			minIndx = leftChildIdx;
			if(rightChildIdx < size && heap[leftChildIdx] > heap[rightChildIdx]){
				minIndx = rightChildIdx;
			}
			if(heap[index] > heap[minIndx]){
				int temp = heap[minIndx];
				heap[minIndx] = heap[index];
				heap[index] = temp;
				index = minIndx;
			}
			else{
				break;
			}
		}
	}
	public void insertion(int val){
		heap[size] = val;
		size++;
		siftUp(size - 1);
	}
	public int deletion(){
		if(size == 0){
			throw new IllegalArgumentException();
		}
		int max = heap[0];
		heap[0] = heap[size - 1];
		size--;
		siftDown(0);
		return max;
	}
}
