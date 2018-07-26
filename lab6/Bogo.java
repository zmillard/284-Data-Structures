import java.util.Random;
import java.util.Arrays;

public class Bogo{
	public static boolean isSorted(int[] array){
		if(array.length == 1){
			return true;
		}
		for (int i = 0; i < array.length; i++){
			if(array[i] > array[i + 1]){
				return false;
			}
		}
		return true;
	}
	public static void bogoSort(int[] array){
		Random randInts = new Random();

		while(!isSorted(array)){
			for(int i = 0; i < array.length; ++i){
				int swapIndex = randInts.nextInt(array.length);
				int tmp = array[swapIndex];
				array[swapIndex] = array[i];
				array[i] = tmp;

			}
			System.out.println(Arrays.toString(array));
		}
	}
	public static void main(String[] args){
		int[] array = {4,3,2,1};
		bogoSort(array);
	}
}
