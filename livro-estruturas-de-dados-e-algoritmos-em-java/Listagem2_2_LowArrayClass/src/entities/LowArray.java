package entities;

public class LowArray {
	private long[] arr;

	public LowArray(int size) {
		arr = new long[size];
	}
	
	public void setElem(int index, long value) {
		arr[index] = value;
	}
	
	public long getElem(int index) {
		return arr[index];
	}
	
}
