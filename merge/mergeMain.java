public class mergeMain {
	static void mergeSort(int[] arr,int l,int r){ //main sorting method
		int m = l + (r-l)/2;
		if(r-l!=0){ //throws all kinds of weird errors without this line
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			merge(arr,l,r);
		}
	}
	static void merge(int[]arr,int l,int r){
		int m = l + (r-l)/2;
		int i=l;
		while(i<=m){
			if(arr[i]>arr[m+1]){
				swap(arr,i,m+1);
				twos(arr,m+1,r);
			}			
			i++;
		}		
	}
	static void swap(int[] arr,int j,int k){
		int temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
	}	
	static void twos(int[] arr,int l,int r){
		for(int i=l;i<r;i++){
			if(arr[i]>arr[i+1]){
				swap(arr,i,i+1);
			}
		}
	}
	public static void main(String[] args) {
		int[] test3 = new int[14];

		test3[0]=5;//TEST CASE 3
		test3[1]=4;
		test3[2]=3;
		test3[3]=12;
		test3[4]=13;
		test3[5]=2;
		test3[6]=11;
		test3[7]=8;
		test3[8]=14;
		test3[9]=1;
		test3[10]=7;
		test3[11]=10;
		test3[12]=9;
		test3[13]=6;
	
		System.out.println("MERGE SORT: ");
		System.out.print("original: ");
	
		for(int i = 0; i < 14; i++){
			System.out.print(test3[i] + " ");
		}	
		System.out.println("");
		System.out.print("sorted: ");
		mergeSort(test3, 0, 13);
		for(int i = 0; i < 14; i++){
			System.out.print(test3[i] + " ");
		}	
	}
}