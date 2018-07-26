/*
*Zoe Millard
*This method establishs the PassengerQueue object
*/

import java.util.*;
import java.util.Random;
public class PassengerQueue{
	private Queue<Passenger> theQueue;
	private int numServed;
	private float totalWait;
	private String queueName;
	private double arrivalRate;
	int seq = 0;
	/*
	*PassengerQueue constructor
	*@param  String queueName  labels the queue
	*/
	public PassengerQueue(String queueName){
		numServed = 0;
		totalWait = 0;
		this.queueName = queueName;
		theQueue = new LinkedList<Passenger>();
	}
	/*
	*update the passenger and remove it from the queue as it is served
	*@param  float   clock - acts as a time keeper 
	*@param  boolean showAll - decides whether or not to print the information
	*@param  float   process - the time it takes to process the new arrival
	*/
	public void checkNewArrival(float clock, boolean showAll, float process){ //needs to be poisson
		totalWait = process + clock; //this might be clock, check the text, process might be arrival rate
		arrivalRate = totalWait/numServed;
		if(Math.random() < arrivalRate){
			seq++;
			theQueue.add(new Passenger(seq, clock, false));
			if(showAll){
				System.out.print("Time is " + clock + ": " + queueName + " arrival, new queue size is " + theQueue.size());
			}
		}
	}
	/*
	*update the passenger and remove it from the queue as it is served
	*@param  float   clock - acts as a time keeper 
	*@param  boolean showAll - decides whether or not to print the information
	*@return float - returns the total processing time 
	*/
	public float update(float clock, boolean showAll){
		Passenger nextPassenger = theQueue.remove();
		float timeStamp = nextPassenger.getArrivalTime();
		float wait = clock - timeStamp; //maximum serving time comes from here?
		totalWait += wait;
		numServed++;
		if(showAll){
			System.out.println("Time is " + clock + ": Serving" + queueName + " with time stamp " + timeStamp);
		}
		return clock + nextPassenger.getProcessingTime();
	}
	/*
	*@return int - returns the number of people served
	*/
	public int getNumServed(){
		return numServed;
	}
	/*
	*@return int - returns the total wait time
	*/
	public float getTotalWait(){
		return totalWait;
	}
	/*
	*@return int - returns the number of people served
	*/
	public String queueName(){
		return queueName;
	}
	/*
	*@return int - returns the number of people served
	*/
	public boolean isEmpty(){
		if (theQueue.size() == 0){
			return true;
		}
		return false;
	}
	/*
	*@return int - returns the number of people served
	*/
	public int getSize(){
		return theQueue.size();
	}
}

/*
* generate passenger events at time clock - log(1-randArrival.nextFloat())/LAMDA
* if server is "idle" set it to busy and generate server event at time clock
*
*/
