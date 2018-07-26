import java.util.HashMap;
import java.util.Set;
import java.util.map;
import java.util.Iterator;

public class HashTest{
	public static void main(String[] args){
		HashMap<String, Integer> ourMap = new HashMap<String, Integer>();
		ourMap.put("Kareem", 10);
		ourMap.put("Ron", 11);
		ourMap.put("Jill", 12);

		System.out.println(ourMap.get("Kareem"));
		System.out.println(ourMap.get("Jill"));

		if(ourMap.containsKey("Ron")){
			System.out.println("Ron's student ID is " + ourMap.get("Ron"));
		} else {
			System.out.println("Ron is not a student.");
		}

		if (ourMap.containsKey("Peter")){
			System.out.println("Peter's student ID is " + ourMap.get("Peter"))
		} else {
			System.out.println("Peter is not a student.");
		}

		if (ourMap.containsValue(10)){
			System.out.println("There exists a student with ID 10."
		} else {
			System.out.println("There does not exita a student with ID 10.");
		}

		Set set = ourMap.entrySet();

		Iterator i = set.iterator();

		while(i.hasNext()){
			Map.Entry curr = (Map.Entry)i.next();
			System.out.println(curr.getKey() + ": ");
			System.out.println(curr.getValue() + ": ");
		}
	}
	public toString(){
		//capture index and read contents of table(key + value)
		//chaining - list iterator trecerse at table element and append to a string
	}
}