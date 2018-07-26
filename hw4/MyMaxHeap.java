public class MyMaxHeap{
	private creditOffer[] theHeap;
	private int size = 0;
	private int capacity;
	private double expenses;

	/*
     *Constructer class for the MyMaxHeap method
     *requires - monthlyExpenses input
     *ensures - an empty array is defined and sent to a second constructor
     *@param  monthlyExpenses  the value of the monthly expenses
     */
	public MyMaxHeap(double monthlyExpenses)
	{
	    new MyMaxHeap(null, 0, monthlyExpenses);
	}
	/*
     *Constructer class for the MyMaxHeap method
     *requires - an array of creditOffers, monthlyExpenses input, theQueue is defined
     *ensures - an empty array is defined and sent to a second constructor
     *@param  monthlyExpenses  the value of the monthly expenses
     *@param  arr  an array of creditOffers
     *@param  n  the size of the array
     */
	public MyMaxHeap(creditOffer arr[], int n, double monthlyExpenses)
	{
		theHeap = arr;
		capacity = n;
		size = arr.length;
		expenses = monthlyExpenses;

		if (size < capacity)
		{
	    	for(int m = 0; m < size; m++){
	    		for(int k = m + 1; k < size; k++){
	    			if(compare(m, k) == m){
	    				swap(m, k);
	    			} else {
	    				swap(k,m);
	    				m=0; 
	    				k=1;
	    			}
	    		}
	    	}
		}

	}
	/*
     *returns the size of the array
     *ensures - the size of the array
     *@return  int  size of the array
     */
	public int size()
	{
		return size;
	}
	/*
     *adds a credit offer
     *requires - a credit offer
     *ensures - a credit offer is added to the array
     *@param  co  credit offer to be added to the array
     *@return boolean  returns true if the credit offer is added successfully
     */
	public boolean add(creditOffer job)
	{
		if (size == capacity)
		{
	    	return false;
		}
		if (size < capacity)
		{
	    	theHeap[size++] = job;
	    	int m = size - 1;
	    	for(int k = size - 2; k > 0; k--){
	    		if(compare(m, k) == m){
	    			swap(m, k);
	    			m = k;

	    		}
	    	}
		}
		return true;
	}
	/*
     *removes a credit offer
     *requires - size is greater than 0
     *ensures - a credit offer is removed
     *@return  creditOffer removed from the array
     */
	public creditOffer removeMax() //remove the highest score
	{
		if(size == 0){
			return null;
		} else {
			creditOffer c = theHeap[size];
			theHeap[size] = null;
			size--;
			return c;
		}
	}
	/*
     *prints the list
     */
	public void showList()
	{
		for (int i = 0; i < size; i++)
		{
	    	System.out.print(theHeap[i].getScore(expenses));
		}
	}
	/*
     *swaps two vals after comparing them
     *requires - array is not empty
     *ensures -values are swapped if need be
     *@param  i,j  integer vals of the locations
     */
	private void swap(int i, int j) //swaps the credit scores
	{
		creditOffer c;
		c = theHeap[i];
		theHeap[i] = theHeap[j];
		theHeap[j] = c;
	}
	/*
     *compares two values
     *requires - array is not empty
     *ensures - larger val is returned
     *@param  i,j  integer vals of the locations
     *@return  int  larger of the two is returned
     */
	private int compare(int i, int j) //compares the credit scores
	{
		double firstScore = theHeap[i].getScore(expenses); //(theHeap[i].CBR - theHeap[i].membershipFee - theHeap[i].APR);
		double secondScore = theHeap[j].getScore(expenses); //(theHeap[i].CBR - theHeap[i].membershipFee - theHeap[i].APR);

		if(firstScore > secondScore){
			return i;
		}
		return j;
	}
	/*
     *returns the element of the top of the array
     *ensures - the size of the array
     *@return  creditOffer  
     */
	public creditOffer peek()
	{
		return theHeap[0];
	}
	
}