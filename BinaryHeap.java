
public class BinaryHeap {

/////////////////////////////////////////////////////////////////////

	private int size;
	private int[] arr;

/////////////////////////////////////////////////////////////////////

	//Constructor
	public BinaryHeap() {
		size = 0;
		arr = new int[5];
	}

/////////////////////////////////////////////////////////////////////

	//parent
	int parent(int index) {
		return ((index-1)/2);
	}

	//leftChild
	int leftChild(int index) {
		return ((index*2) + 1);
	}

	//rightChild
	int rightChild(int index) {
		return ((index*2) + 2);
	}

/////////////////////////////////////////////////////////////////////

	//Add to the heap
	public void add(int priority) {

		//If the heap is full
		if(arr.length == size) {
			growHeap();
		}

		//Add to end of array
		int index = size;
		arr[size++] = priority;

		//Reorder Heap
		while(index >= 0 && arr[index] < arr[parent(index)]) {
			swap(arr, index, parent(index));
			index = parent(index);
		}
	}

/////////////////////////////////////////////////////////////////////

	//Grow the heap
	private void growHeap() {
		int[] newArr = new int[(arr.length) * 2];		
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}

/////////////////////////////////////////////////////////////////////

	//Swap two elements
	private	void swap(int[]a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

/////////////////////////////////////////////////////////////////////
	
	//remove - throws exception when heap is empty
	public int remove() throws NullPointerException{

		//If the heap is empty already
		if(size == 0) {
			throw new NullPointerException();
		}

		//Remove from the root
		int removed = arr[0];
		arr[0] = arr[--size];
		
		//Reorder Heap
		heapify(0);
		
		return removed;
	}

/////////////////////////////////////////////////////////////////////
	
	public void heapify(int index){
		
		//Left and right child of the index
		int left = leftChild(index); 
		int right = rightChild(index); 
		int min;			

		//If the left child is smaller
		if(left < size && arr[left] < arr[index]) {		
			min = left;             	
		}else {
			min = index;
		}

		//If the right child is smaller
		if(right < size && arr[right] < arr[min]) {
			min = right;    
		}

		//Swap
		if(min != index){	 		
			swap(arr, index, min);
			heapify(min); 
		}
	}

/////////////////////////////////////////////////////////////////////	
	
}


