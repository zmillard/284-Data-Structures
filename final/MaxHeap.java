/*
*Zoe Millard
*
*Code for methods to find parent, lc, rc, ect was taken from an assignment I had for a prev class
*
*
*
*/
import java.util.ArrayList;

public class MaxHeap{
	private ArrayList<Message> theHeap;
	private int size = 0;
	private int capacity;

	/*
     *Constructer class for the MaxHeap obj
     *requires - 
     *ensures - an empty array is defined
     */
	public MaxHeap()
	{
		theHeap = new ArrayList<Message>();
		capacity = 100;
		size = 0;
	}
	/*
     *Constructer class for the MaxHeap obj
     *requires - Message array input
     *ensures - an empty array is defined
     *@param  arr  initial array
     */
	public MaxHeap(ArrayList<Message> arr)
	{
		theHeap = arr;
		capacity = 100;
		size = 0;
	}
	/*
     *requires - 
     *ensures - size is printed
     */
	public int size()
	{
		return size;
	}
	/*
     *requires - int position is greater than 0 and less than size of array
     *ensures - loc is returned
     */
	private int parent(int pos)
    {
        return pos / 2;
    }
 	/*
     *requires - int position is greater than 0 and less than size of array
     *ensures - loc is returned
     */
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
 	/*
     *requires - int position is greater than 0 and less than size of array
     *ensures - loc is returned
     */
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 	/*
     *requires - int position is greater than 0 and less than size of array
     *ensures - lets user know if it is a leaf
     */
    private boolean isLeaf(int pos)
    {
        if (pos >=  (size / 2)  &&  pos <= size)
        {
            return true;
        }
        return false;
    }
    /*Adds to the ArrayList
     *requires - message is input
     *ensures - the success of the operation is printed
     */
	public boolean add(Message m)
	{
		if(size < capacity){
        	int current = size;
        	theHeap.add(size, m);

        	while(theHeap.get(current).priority() > theHeap.get(parent(current)).priority())
        	{
            	swap(current,parent(current));
           	 	current = parent(current);
            	heapIt(current);
        	}	
        	size++;
        }
		return true;
	}
	/*
     *requires - int position is greater than 0 and less than size of array
     *ensures - loc is printed
     */
	public Message removeMax(){ //remove the highest score
		removeInstr();
		if(size == 0){
			return null;
		} else {
			Message m = theHeap.get(0);
			theHeap.set(0, null);
			nullMov(0);
			//heapIt(0);
			size--;
			return m;
		}
	} 
	/*
     *requires - 
     *ensures - list is printed
     */
	public void showList()
	{
		for (int i = 0; i < size; i++)
		{
	    	System.out.println(theHeap.get(i));
		}
		if(size == 0){
			System.out.println("No messages.");
		}
	}
	/*
     *requires - locations to be swapped are input
     *ensures - a swap is performed
     */
	private void swap(int i, int j) //swaps the credit scores
	{
		Message m;
		m = theHeap.get(i);
		theHeap.set(i, theHeap.get(j));
		theHeap.set(j, m);
	}
	/*
     *requires - locations to be compared are input
     *ensures - compares priority of locations
     */
	private int compare(int i, int j) //compares the credit scores
	{
		if(theHeap.get(i).priority() > theHeap.get(j).priority()){
			return i;
		}
		return j;
	}
	/*
     *requires - loc of null is input
     *ensures - moves values over
     */
	public void nullMov(int n){
		for(; n < size - 1; n++){
			theHeap.set(n, theHeap.get(n+1));
		}
		theHeap.set(size -1 , null);

	}
	/*
     *requires - 
     *ensures - Message at the top of the array is printed
     */
	public Message peek()
	{
		return theHeap.get(0);
	}
	public void removeInstr(){ 
		for(int i = 0;  i < size; i++){
        	for(int j = 0; j < size; j++){
        		if ((theHeap.get(i).getName()).equals(theHeap.get(j).getName()) /*&& i != j*/){
        			theHeap.set(j, null);
        			for(int k = j; k < size-1; k++){
        				int p = 3;//theHeap.get(j).priority();
        				//theHeap.get(i).setTotalLevel(3);
        				theHeap.set(k, theHeap.get(k+1));
        			}
        			size--;
        		}
        	}
        }
	} 
	/*
     *requires - position is input
     *ensures - values are arranged by size
     */
	public void heapIt(int pos){
		if (!isLeaf(pos))
        { 
            if(theHeap.get(pos).priority()<theHeap.get(leftChild(pos)).priority()||theHeap.get(pos).priority()<theHeap.get(rightChild(pos)).priority())
            {
                if (theHeap.get(leftChild(pos)).priority() > theHeap.get(rightChild(pos)).priority()){
                    swap(pos, leftChild(pos));
                    heapIt(leftChild(pos));
                }else{
                    swap(pos, rightChild(pos));
                    heapIt(rightChild(pos));
                }
            }
        }
	}
}