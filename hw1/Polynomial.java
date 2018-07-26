/**
*Polynomial.java
*
*"I pledge my honor that I have abided by the Stevens Honor System"
*
*Zoe Millard (c)2015
*
*/
import java.util.Scanner;

public class Polynomial{
	Scanner s = new Scanner(System.in);

	/*
	*Constructor for no input
	*
	*requires - no input
	*ensures - an error message is printed asking the user to input a value
	*/
	public Polynomial(){
		System.out.println("Please enter a valid value.");
		System.exit(1);
	}


	/*
	*Constructor for input int x
	*
	*requires - int x is input
	*ensures - if x is positive, find polynomial value, else print error message
	*
	*@param   x  the integer value of the degree function
	*@param   a  array of coeficients
	*@param   b  array of coeficients
	*/
	public Polynomial(double a[], double b[], int x){
		int al = a.length - 1;
		int bl = b.length - 1;
		int csize;

		if (al > bl){
			csize = a.length;
		}else{
			csize = b.length;
		}

		double[] c = new double[csize];

		if(x >= 0){

			printEquation(a, a.length);
			System.out.println(" = " + degree(a, al, (double)x));

			printEquation(b, b.length);
			System.out.println(" = " + degree(b, bl, (double)x));

			for (int i = 0; i < csize; i++){
				if(al >= i){
					c[i] += a[i];
				}
				if(bl >= i){
					c[i] += b[i];
				}
			}

			printEquation(c, csize);
			System.out.println(" = " + (degree(a, al, (double)x) + degree(b, bl, (double)x)));

		}
		System.out.println("Please enter a valid value."); 
		System.exit(1);
		
	}

	/*
	*Constructor for input int x
	*
	*requires - double x is input
	*ensures - if x is positive, find polynomial value, else print error message
	*
	*@param   x  the double value of the degree function
	*@param   a  array of coeficients
	*@param   b  array of coeficients
	*/
	public Polynomial(double a[], double b[], double x){ //round int to double?
		int al = a.length - 1;
		int bl = b.length - 1;
		int csize;

		if (al > bl){
			csize = a.length;
		}else{
			csize = b.length;
		}

		double[] c = new double[csize];

		if(x >= 0){

			printEquation(a, a.length);
			System.out.println(" = " + degree(a, al, x));

			printEquation(b, b.length);
			System.out.println(" = " + degree(b, bl, x));

			for (int i = 0; i < csize; i++){
				if(al >= i){
					c[i] += a[i];
				}
				if(bl >= i){
					c[i] += b[i];
				}
			}

			printEquation(c, csize);
			System.out.println(" = " + (degree(a, al, x) + degree(b, bl, x)));

		}
		System.out.println("Please enter a valid value."); 
		System.exit(1);
		
	}

	/*
	*Prints the polynomial
	*
	*requires - double x is input, there is an array of coeficients
	*ensures - if x is positive, find polynomial value, else return 
	*
	*@param   nums  array of  coeffiecients
	*@param   size  size of nums
	*/
	public void printEquation(double nums[], int size){
		for (int i = 0; i < size; i++){
				System.out.print(nums[i] + "x^" + i);
				if(i < size - 1){
					System.out.print(" + ");
				}
			}
	}

	/*
	*Finds the value of the polynomial using recursion
	*
	*requires - double x is input
	*ensures - if x is positive, find polynomial value, else return 
	*
	*@param   x  the integer value of the degree function
	*@param   c  arrat of coeffiecients
	*@param   n  size of array
	*/
	public double degree(double c[], int n, double x){
		if(n == 0){
			return c[n];
		}else{
			return (c[n]*Math.pow(x, n) + degree(c,--n, x));
		}
	}

	public static void main(String[]arg){
		System.out.println("Testing for x = 4.0");
		double[] nums1 = {1.0, 1.0};
		double[] nums2 = {1.0, 1.0};

		Polynomial p = new Polynomial(nums1, nums2, 4.0);

		System.out.println("Testing for no input for x:");
		Polynomial t = new Polynomial();
	}
}
