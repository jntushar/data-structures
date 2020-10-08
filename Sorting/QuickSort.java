public class QuickSort {
	
	public static void main (String[] args) {
		int[] arr = {15,11,40,4,4,5,4};
		quickSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if(low>high) {
			return;
		}
		int pivotIdx = partition(arr, arr[high], low, high);
		quickSort(arr, low, pivotIdx-1);
		quickSort(arr, pivotIdx+1, high);
	}
	
	
	public static int partition(int[] arr, int pivot, int low, int high) {
		int j=low;
		for(int i=low; i<=high; i++) {
			if(arr[i]<=pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;	
			}
		}
		return (j-1);
	}
	
	
}

