/*
*Zoe Millard
*"I pledge my honor that I have abided by the Stevens Honor System" -ZM
*
*This method establishs the values for the PassengerQueue, and sets up ways to deal with the line
*/

import javax.swing.*;
import java.util.Scanner;
import java.util.Random;
public class AirlineCheckinSim{
	private PassengerQueue frequentFlyerQueue = new PassengerQueue("Frequent Flyer");
	private PassengerQueue regularPassengerQueue = new PassengerQueue("Regular Passenger");

	private float frequentFlyerMax;
	private float maxServ;
	private float totalTime;
	Server Serv = new Server();
	double lamda;
	int seq = 0;
	float clock = 0;
	double averageWaitingTime;
	Scanner input = new Scanner(System.in);
	private float timeDone;
	int sort;
	private boolean showAll;

	/*
	*Calculate poisson formula
	*/
	public AirlineCheckinSim(){}
	private static float getPoissonRandom(double mean){ //check this formula
		Random r = new Random();
		float l = (float) Math.exp(-mean);
		int i = 0;
		float p = (float)1.0;
		do {
			p = p* r.nextFloat();
			i++;
		} while (p > l);
		
		return (float)(i - 1);
	}
	/*
	*enter data feilds
	*/
	public void enterData(){
		System.out.println("Give a value for lamda: ");
		lamda = input.nextDouble();
		System.out.println("Give a total time: ");
		totalTime = input.nextFloat();
		System.out.println("Pick a way to sort through the lines: ");
		System.out.println("(1) Round Robin ");
		System.out.println("(2) Longest Wait ");
		System.out.println("(3) VIP Treatment ");
		sort = input.nextInt();
		System.out.println("Give a maximum serving volume: ");
		maxServ = input.nextFloat();
		System.out.println("Give a maximum number of frequent flyers: ");
		frequentFlyerMax = input.nextFloat();
	}
	/*
	*Runs the simulation and manages the classes
	*/
	public void runSimulation(){
		for(clock = 0; clock < totalTime; clock++){
			frequentFlyerQueue.checkNewArrival(clock, showAll, getPoissonRandom(lamda));
			regularPassengerQueue.checkNewArrival(clock, showAll, getPoissonRandom(lamda));
			if(clock <= frequentFlyerQueue.getTotalWait() || clock <= regularPassengerQueue.getTotalWait()){ 
				if (sort == 1){
					roundRobin();
				} else if (sort == 2){
					longestWait();
				} else if (sort == 3){
					VIPTreatment();
				}
				
			}
		}
	}
	/*
	*take turns serving from both lines
	*returns   float   time taken to process
	*/
	public float roundRobin(){  //find the average wait time using poisson formula
		if(!frequentFlyerQueue.isEmpty() && !regularPassengerQueue.isEmpty()){
			timeDone = frequentFlyerQueue.update(clock, showAll) + regularPassengerQueue.update(clock, showAll);
		}else if(!regularPassengerQueue.isEmpty()) {
			timeDone = regularPassengerQueue.update(clock, showAll);
		}else if (!frequentFlyerQueue.isEmpty()){
			timeDone = frequentFlyerQueue.update(clock, showAll);
		}else if (showAll){
			System.out.print("Time is " + clock + " server is idle");
		}
		return timeDone;
	}
	/*
	*serve the passenger with the longest wait time
	*returns   float   time taken to process
	*/
	public float longestWait(){ 
		if(!frequentFlyerQueue.isEmpty() && !regularPassengerQueue.isEmpty() && (frequentFlyerQueue.getTotalWait() > regularPassengerQueue.getTotalWait())){ //check to see if this is the right output, it might be the line as a whole
			timeDone = frequentFlyerQueue.update(clock, showAll);
		} else if(!regularPassengerQueue.isEmpty() && !frequentFlyerQueue.isEmpty() && (frequentFlyerQueue.getTotalWait() < regularPassengerQueue.getTotalWait())){
			timeDone = regularPassengerQueue.update(clock, showAll);
		} else if (!frequentFlyerQueue.isEmpty() && !regularPassengerQueue.isEmpty() && (frequentFlyerQueue.getTotalWait() == regularPassengerQueue.getTotalWait())){
			timeDone = frequentFlyerQueue.update(clock, showAll);
		} else if (showAll){
			System.out.print("Time is " + clock + " server is idle");
		}
		return timeDone;

	}
	/*
	*serve all frequent flyers before the regular customers
	*returns   float   time taken to process
	*/
	public float VIPTreatment(){ 
		if(!frequentFlyerQueue.isEmpty()){
			timeDone = frequentFlyerQueue.update(clock, showAll);
		} else if(!regularPassengerQueue.isEmpty()){
			timeDone = regularPassengerQueue.update(clock, showAll);
		} else if (showAll){
			System.out.print("Time is " + clock + " server is idle");
		}
		return timeDone;
	}
	/*
	*prints the stats
	*need the throughput - number of pa
	*/
	public void showStats(){
		System.out.println("\nThe number of regular passengers served was " + regularPassengerQueue.getNumServed());
		averageWaitingTime = (double) regularPassengerQueue.getTotalWait() / (double) regularPassengerQueue.getNumServed();
		System.out.println(" with an average waiting time of " + averageWaitingTime);
		System.out.println("The number of frequent flyers served was " + frequentFlyerQueue.getNumServed());
		averageWaitingTime = (double) frequentFlyerQueue.getTotalWait() / (double) frequentFlyerQueue.getNumServed();
		System.out.println(" with an average waiting time of " + averageWaitingTime);
		System.out.println("Passengers in frequent flyer queue: " + frequentFlyerQueue.getSize()); 
		System.out.println("Passengers in regular passenger queue: " + regularPassengerQueue.getSize());
	}
	public static void main(String args[]){
		AirlineCheckinSim sim = new AirlineCheckinSim();
		sim.enterData(); //need to prevent errors when its not a number

		sim.runSimulation();
		sim.showStats();
		System.exit(0);
	}
}