public class AsymptoticAnalysis{
	public static int y1(int n){
		return (100 * n + 10);
	}

	public static int y2(int n){
		return (5* n * n +2);
	}

	public static void main(String[]args){
		for (int i = 0; i <= 100; i += 10){
			System.out.println("y1(" + i + ") = " + y1(i) + ", y2(" + i + ") = " + y2(i));
			System.out.println()
		}
	}
}