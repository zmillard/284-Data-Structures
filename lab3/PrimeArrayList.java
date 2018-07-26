import java.util.ArrayList;
public class PrimeArrayList{
	public static boolean isPrime(int x){
		int k;
		double n;
		boolean prime = false;
		if(x > 1){
			prime = true;
			k = 2;
			n = Math.sqrt(x);
			while(k <= n && prime == true){
				if(x % k == 0){
					prime = false;
				}
				k++;
			}
		}
		return prime;
	}

	public static ArrayList<Integer> primeListGenerator(int n){
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		for(int i = 0; i<n; ++i){
			if(isPrime(i)){
				primeList.add(i);
			}
		}
		return primeList;
	}

	public static void main(String[]args){
		ArrayList<Integer> primes100 = primeListGenerator(100);
		System.out.println("There are " + primes100.size() + " primes under 100.");
		System.out.println("The 20th prime is " + primes100.get(19) + ".");

		if(primes100.contains(15)){
			System.out.println("15 is a prime number.");
		} else {
			System.out.println("15 is not a prime number.");
		}

		String listString = "";
		for (Integer i : primes100){
			listString += (i + " ");
		}

		System.out.println("the primes under 100 are : " + listString);
	}
}
