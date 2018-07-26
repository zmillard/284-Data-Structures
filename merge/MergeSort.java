public class MergeSort{
	public static void insert(int []arr, int size, int start, int incr)
	{
		int i, j;
		for (i = start + incr; i < size; i+=incr)
		{
	    	for(j = i; j > start && arr[j] < arr[j-incr]; j-= incr)
	    	{
				swap(arr, j, j-incr);
	    	}
		}
    }

	public static void mergeS(int [] arr, int l, int r){
		int m = l + (r-l)/2;
		//System.out.println("flag merge" + l + " " + r);
		if (r - l == 0){

		}
		else if (r-l != 0 && l < r)
		{
			
	    	if (r > arr.length)
	    	{
				r = arr.length;
	    	} else if (r - l == 1){
	    		if(arr[l] < arr[r]){
	    			swap(arr, l, r);
	    		}
	    	} else {	  
	    		System.out.println("flag mergeS");
	    		mergeS(arr, l, m);
	    		mergeS(arr, m + 1, r);
	    		merge(arr, l, r);
				//insert(arr, n, 0, 1);
				//int [] temp = new int [n];
				//merge (arr, 0, n-1, temp);
	    	}
		}
		System.out.println("doneeeee");
	}/*
    private static void merge(int [] arr, int l, int r, int [] temp){ //original array, new array
		int m, i, j, k;
		if (l < r)
		{
	   		m = l + (r-l)/2;
	    	merge(arr, l, m, temp);
	    	merge(arr, m + 1, r, temp);
	    	for(i = l; i <= m; i++)
	    	{
				temp[i] = arr[i];
	   		}
	    	for(j = r; i <= r; i++, j--)
	    	{
				temp[i] = arr[j];
	    	}
	    	for(i = l, j = r, k = l; k <= r; k++)
	    	{
				if(temp[i] < temp[j])
				{
		    		arr[k]=temp[i++];
				}else{
		    		arr[k] = temp[j--];
				}
	    	}
		}else{
	    	insert(arr, r-l, 0, 1);
		}
    }*/
     private static void merge(int [] arr, int l, int r){ //original array, new array
     	//int n = arr.size();
     	//int c = 0;
     	int memi;//memory holding space
     	int memj;
     	int m, i, j, k;
     	/*int a = aStart;
     	int b = bStart;
		while(a < n && b < n)
		{
			if(arr[a] < arr[b]){
				m = arr[a];
				arr[a] = 
			}
		}*/
		//System.out.println("flag merge");
		//NEW ATTEMPT
		i = l;
		if (l < r)
		{
	   		m = l + (r-l)/2;

	   		while(i <= m){
	   			if(arr[i] > arr[m + 1]){
	   				swap(arr,i, m+1);
	   				push(arr, m+1, r);
	   				System.out.println("flag merge");
	   			}
	   			i++;
	   		}
	   		System.out.println("flag merge complete");


/*
	    	//merge(arr, aStart, aFin, bStart, bFin);
			merge(arr, l, m, temp); //does there need to be an error check here to see if it 
	    	merge(arr, m + 1, r, temp);
	    	for(i = l, j = r, k = l; k <= r; k++)
	    	{
				if(arr[i] < arr[j])
				{
					memi = arr[i]; //this is where the issue is
					memj = arr[j];
		    		arr[j]=memi;
		    		arr[i]=memj;
		    		i++;
		    		k++;

				}else{
					memj = arr[j];
					memi = arr[k];
		    		arr[k] = memj;
		    		arr[j] = memi;
		    		j--;
				}
	    	}*/
		//}else{
	    	//insert(arr, r-l, 0, 1);
		}
    }
    public static void swap(int[] arr, int j, int k) //method is obvi
    {
		int temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
    }
    public static void push(int[] arr, int l, int r){
    	for (int i = l; i < r; i++){
    		if(arr[i] > arr[i+1]){
    			swap(arr,i,i+1);
    		}
    	}
    }
    public static void main(String[]args)
    {
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
		mergeS(test3, 1, 13);
		for(int i = 0; i < 14; i++){
			System.out.print(test3[i] + " ");
		}
    }
}