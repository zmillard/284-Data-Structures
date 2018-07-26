/*
*Zoe Millard
*
*This method establishes the Passenger object
*/

import java.util.Random;

public class Passenger{
	private int passengerId;
	private float processingTime; //time passenger needs to be served
	private float arrivalTime;
	private static float maxProcessingTime; //this needs to be defined somewhere
	//private static float idNum = 0; //is this necessary?
	private boolean isFrequentFlyer;
	Random rand = new Random();

	/*
	*Passenger constructor
	*@param  int     IDnum - id of passenger 
	*@param  float   arrivalTime - when the passenger arrives rel to clock
	*@param  boolean frequentFlyer - control is false
	*
	*/
	public Passenger(int IDnum, float arrivalTime, boolean frequentFlyer){
		this.arrivalTime = arrivalTime;
		processingTime = (float) (rand.nextFloat() * (maxProcessingTime) + 1); //there's an issue with this random
		passengerId = IDnum;
		isFrequentFlyer = frequentFlyer;
		if (processingTime % 2 == 1){ //if the variable is odd, then it's not a FF
			isFrequentFlyer = true; 
		} else {
			isFrequentFlyer = frequentFlyer;
		}
	}
	public float getArrivalTime(){
		return arrivalTime;
	}
	public float getProcessingTime(){
		return processingTime;
	}
	public int getId(){
		return passengerId;
	}
	public static void setMaxProcessingTime(int maxProcessTime){
		maxProcessingTime = maxProcessTime;
	}
	public boolean frequentFlyer(){
		return isFrequentFlyer;
	}
}
//DO YOU NEED ISFREQUENTFLYER?