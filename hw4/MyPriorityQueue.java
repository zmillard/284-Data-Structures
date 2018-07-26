/*"I pledge my honor that I have abided by the Steven's Honor System"
 *
 *Zoe Millard(c) 2014
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class MyPriorityQueue
{
	private MyMaxHeap theQueue;

	/*
     *Constructer class for the MyPriorityQueue method
     *requires - monthlyExpenses input
     *ensures - an empty array is defined and sent to a second constructor
     *@param  monthlyExpenses  the value of the monthly expenses
     */
	public MyPriorityQueue(double monthlyExpenses)
	{
		new MyPriorityQueue(null, monthlyExpenses);
	}
	/*
     *Constructer class for the MyPriorityQueue method
     *requires - an array of creditOffers, monthlyExpenses input, theQueue is defined
     *ensures - an empty array is defined and sent to a second constructor
     *@param  monthlyExpenses  the value of the monthly expenses
     *@param  arr  an array of creditOffers
     */
	public MyPriorityQueue(creditOffer[] arr, double monthlyExpenses)
	{
		theQueue = new MyMaxHeap(arr, arr.length, monthlyExpenses);
	}
	/*
     *removes a credit offer
     *requires - size is greater than 0
     *ensures - a credit offer is removed
     *@return  creditOffer removed from the array
     */
	public creditOffer remove()
	{
		if(theQueue.size() == 0){
			return null;
		}else{
			return theQueue.removeMax();
		}
	}
	/*
     *adds a credit offer
     *requires - a credit offer
     *ensures - a credit offer is added to the array
     *@param  co  credit offer to be added to the array
     *@return boolean  returns true if the credit offer is added successfully
     */
	public boolean offer(creditOffer co)
	{
		return theQueue.add(co);
	}
	/*
     *lets you see the top element in the array
     *requires - array not empty
     *ensures - the top element is returned
     *@return  creditOffer at the top of the array
     */
	public creditOffer peek() //pretty sure you cant do this w/o another method in there somewhere
	{
		if (theQueue.size() == 0){
	    	return null;
		}
		return null; //theQueue.theHeap[0];
	}
	/*
     *lets the user know if the array is empty
     *ensures - the user knows the contents of the array
     *@peturn  boolean  true if its empty
     */
	public boolean isEmpty()
	{
		if(theQueue.size() == 0){
			return true;
		}
		return false;
	}
	/*
     *prints the list
     */
	public void showList()
	{
		theQueue.showList();
	}
	public static void main(String[] args){
		/*creditOffer[] credits = new creditOffer[3];
		creditOffer a = new creditOffer(5.0, 5.0, 5.0);
		creditOffer b = new creditOffer(1.0, 10.0, 3.0);
		creditOffer c = new creditOffer(1.0, 1.0, 5.0);
		credits[0] = a;
		credits[1] = b;
		//credits = {a,b,c};

		MyPriorityQueue q = new MyPriorityQueue(credits, 100);
		q.showList();*/

		double number;

		try{

			BufferedReader in = new BufferedReader (new FileReader(new File("offers.txt")));
			for(String inputLine = in.readLine(); inputLine != null; inputLine = in.readLine())
			{
				System.out.println("flag");
				String[]splits = inputLine.split(" ");
				System.out.println("Read: " + inputLine);
				if(splits[0].length() != 0)
				{
					for(int j = 0; j < splits.length; j++)
					{
						number = Double.parseDouble(splits[j]);
						System.out.println("Next int: " + number);
					}
				}				
			}
			in.close();
		}
		catch (IOException e){
			System.out.println("File I/O Exception");
			System.exit(1);
		}
	}
}