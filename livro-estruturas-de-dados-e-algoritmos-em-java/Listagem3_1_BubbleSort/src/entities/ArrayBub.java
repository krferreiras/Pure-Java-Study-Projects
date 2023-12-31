package entities;

public class ArrayBub {
	
	private long[] arr;
	private Integer nElems;
	
	public ArrayBub() {
		
	}

	public ArrayBub(long[] arr, Integer nElems) {
		this.arr = arr;
		this.nElems = nElems;
	}
	
	public ArrayBub(int max) {
		arr = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		arr[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	
	public void bubbleSort() {
		int out, in;
		
		for(out = nElems-1; out>1; out--) {
			for(in=0; in<out; in++) {
				if(arr[in] > arr[in+1]) {
					 swap(in, in+1);
				}
			}
		}
	}
	
	public void swap(int one, int two) {
		long temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
	}
}
