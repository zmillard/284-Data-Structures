/*
*Defines the message object
*
*
*
*/
public class Message{
	private String message;
	private String name;
	private String hostname;
	private String problem;
	private int level;
	private int totalLevels;
	/*
     *Constructer class for the Message
     *requires - intial string
     *ensures - 
     */
	public Message(String m){
		message = m;
		name = "";
		hostname = "";
		problem = "";
		level = 0;
		totalLevels = level;
		process();
	}
	/*
     *reads the string and asigns to vars
     *requires - 
     *ensures - diseects parts of string
     */
	public void process(){
		boolean first, second, third;
		first = true; 
		second = true;
		third = true;
		for(int i = 0; i < message.length(); i++){
			char c = message.charAt(i);
			String s = String.valueOf(c);
			if(s.compareTo("|") != 0 && s.compareTo(" ")!=0){
				if(first){
					name += c;
				}else if (second){
					hostname += c;
				}else if(third){
					problem += c;
				}else{
					level = Integer.parseInt(s);
					totalLevels = level;
					if(level > 5){
						level = 5;
						totalLevels = 5;
					}
					if(level < 0){
						level = 0;
						totalLevels = 0;
					}
				}
			}else{
				if(first){
					first = false;
				}else if(second){
					second = false;
				}else if(third){
					third = false;
				}
			}
		}
	}
	/*
     *requires - 
     *ensures - priority level is returned
     */
	public int priority(){
		return level - (int)(totalLevels/2);
	}
	/*
     *requires - a level is input
     *ensures - the total levels are returned
     */
	public int setTotalLevel(int l){
		totalLevels += l;
		return totalLevels;
	}
	/*
     *requires - 
     *ensures - message is printed
     */
	public void read(){
		System.out.println(message);
	}
	public String toString(){
		return (name + " | " +  hostname + " | " +  problem + " | " + level);
	}
	/*
     *requires 
     *ensures - hash key
     */
	public int getKey(int n){
		return  (int)(Math.pow(23, n) * priority());
	}
	/*gets the name of the Message submitter*/
	public String getName(){
		return name;
	}

}
//use stupid sum to implement hash