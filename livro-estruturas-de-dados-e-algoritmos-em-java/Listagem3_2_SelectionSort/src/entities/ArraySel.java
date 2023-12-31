package entities;

public class ArraySel {
	
	private long[] arr;
	private Integer nElems;
	
	public ArraySel() {
		
	}

	public ArraySel(long[] arr, Integer nElems) {
		this.arr = arr;
		this.nElems = nElems;
	}
	
	public ArraySel(int max) {
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
	
	public void SelectionSort() {
		int out, in, min;
		
		for(out = 0; out<nElems-1; out++) {
			min = out;
			for(in=out+1; in<nElems; in++) {
				if(arr[in] < arr[min]) {
					 min = in;
				}
			}
			swap(out, min);
		}
	}
	
	public void swap(int one, int two) {
		long temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
	}
}
