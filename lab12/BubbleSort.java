import java.util.Arrays;

public class BubbleSort{
	public static int[] sortByCounting(int[] arr){
		int[] counts = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length; ++j){
				if(arr[i] > arr[j]){
					counts[i]++;
				}else{
					counts[j]++;
				}
			}
		}
		int[] fin = new int[arr.length];
		for(int i = 0; i < arr.length; ++i){
			fin[counts[i]] = arr[i];
		}
		return fin;
	}
	public static <T> implements Comparabe<T> void bubbleSort(T[] arr){
		boolean swapped = true;

		while(swapped){
			swapped = false;
			for(int i = 0; i < arr.length - 1; ++i){
				if(arr[i].compareTo(arr[i+1]) > 0){
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;

					swapped = true;
				}
			}
		}
	}
	public static void main(String[] args){
		Integer[] arr3 = {10,9,8,7,6,5,4,3,2,1};
		System.out.println(Arrays.toString(arr3));
		bubbleSort(arr3);
		System.out.println(Arrays.toString(arr3));

		System.out.println();

		Integer[] arr4 = {12,3,3,12,454,1,1,55};
		System.out.println(Arrays.toString(arr4));
		bubbleSort(arr4);
		System.out.println(Arrays.toString(arr4));

		Integer[] arr5 = {"hi", "hello", "abcd", "bat"};
		System.out.println(Arrays.toString(arr5));
		bubbleSort(arr5);
		System.out.println(Arrays.toString(arr5));


	}
}