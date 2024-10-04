package edu.wit.cs.comp1000;

import java.util.Arrays;
import java.util.Scanner;

/***
 * Solution to programming assignment 2b, solves a quadratic
 * @author Oliver Stevens
 */
public class PA2b {

	/***
	 * Solves the quadratic
	 */
	public static void main(String[] args) {
		//VARIABLE DECLARATIONS
		Scanner scan = new Scanner(System.in); //Create scanner
		double a, b, c, d;
		double[] roots = new double[2]; //For multiple roots
		
		//Inputs
		System.out.printf("Enter a b c: ");
		a = scan.nextDouble();
		b = scan.nextDouble();
		c = scan.nextDouble();
		
		//Calculate d
		d = Math.pow(b, 2.0) - (4 * a * c);
		
		//Handle imaginary
		if(d < 0) {
			System.out.printf("Roots: imaginary\n");
		}
		
		//Handle 0
		else if(d == 0) {
			System.out.printf("Root: %.2f\n", -b/(2*a));
		}
		
		//Handle two roots
		else {
			roots[0] = (-b + Math.sqrt(d))/(2.0*a);
			roots[1] = (-b - Math.sqrt(d))/(2.0*a);
			Arrays.sort(roots);
			System.out.printf("Roots: %.2f, %.2f\n", roots[0], roots[1]);
		}
		
		//Exit
		scan.close();
		return;
	}

}
