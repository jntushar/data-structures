public class MergeSort {
	
	public static void main (String[] args) {
		int[] arr = {15,11,40,4,4,5,4};
		arr = mergeSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static int[] mergeSort(int[] arr, int low, int high) {
		if(low==high) {
			int[] base = new int[1];
			base[0] = arr[low];
			return base;
		}
		
		int mid = (low+high)/2;
		int[] L = mergeSort(arr, low, mid);
		int[] R = mergeSort(arr, mid+1, high);
		int[] full = mergerTwoSortedArrays(L, R);
		return full;
	}
	
	
	public static int[] mergerTwoSortedArrays(int[] a, int[] b) {
		int[] res = new int[a.length + b.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<a.length && j<b.length) {
			if(a[i]<b[j]) {
				res[k] = a[i];
				i++;
			}else {
				res[k] = b[j];
				j++;
			}
			k++;
		}
		
		while(i<a.length) {
			res[k] = a[i];
			i++;
			k++;
		}
		while(j<b.length) {
			res[k] = b[j];
			j++;
			k++;
		}
		
		return res;
	}
	
}

