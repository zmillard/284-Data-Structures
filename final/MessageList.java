/*
*Used to implement the Hashtable
*
*
*/
public class MessageList{ 
	private int cap;
	private int start;
	private int size = 100;
	private Message[] listing = new Message[size];
	/*
     *Constructer class for the Hash
     *requires - 
     *ensures - cap and start are defined
     */
	public MessageList(int s){
		cap = 0;
		start = 0;
		for(int i = 0; i < size; i++){
			listing[i] = null;
		}
	}
	/*
     *adds to hashtable
     *requires - a message
     *ensures -it is added to the proper location
     */
	public void add(Message m){
		//listing[cap++] = m;
		
		if(m != null){
			cap++;

			int hash = (m.getKey(size) % size);
			while (listing[hash] != null && listing[hash].getKey(size) != m.getKey(size)){ 
          		hash = (hash + 1) % cap;
        	}
        	listing[hash] = m;
    	}
	}
	/*
     *requires - non empty array 
     *ensures - the first element is removed
     */
	public void remove(){
		listing[start] = null;
		cap--;
		reorder();
	}
	/*
     *reorganizes the array
     *requires - 
     *ensures - the array is clear of null elements
     */
	public void reorder(){
		for(int i = 0; i < cap; i++){
			if(listing[i] == null){
				specialSwap(listing, i, i+1);
			}
		}
	}
	/*
     *requires - 
     *ensures - inserts a null object
     */
	public static void specialSwap(Message[] arr, int j,int k){
		arr[j] = arr[k];
		arr[k] = null;
	}
	public void print(){
		System.out.println();
		System.out.println("Messages in hashtable thus far:\n");
		for(int i = start; i < size; i++){
			if(listing[i] != null){
				listing[i].read();
			}
		}
	}
	/*
     *retrieves an item
     *requires - there is a valid key
     *ensures - the proper item is returned
     */
	public Message getItem(int k) {
        int hash = k % cap;
        while (listing[hash] != null && listing[hash].getKey(size) != k){
            hash = (hash + 1) % cap;
            if (listing[hash] == null){
                return null;
            } else { 
                return listing[hash];
            }
        }
        return null;
    }      
}