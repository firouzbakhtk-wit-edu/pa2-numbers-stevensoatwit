package edu.wit.cs.comp1000;
import java.util.Scanner;
import java.util.ArrayList;

/***
 * Solution to programming assignment 2a, gets numbers and prints stats
 * @author Oliver Stevens
 */
public class PA2a {

	/***
	 * Main function that does stuff.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[5]; //Create array to store numbers
		ArrayList<Integer> pos_nums = new ArrayList<Integer>(); //Positives
		ArrayList<Integer> neg_nums = new ArrayList<Integer>(); //Negatives
		int[] sums = new int[3]; //Store the 3 sums (pos, neg, all)
		float[] avgs = new float[3]; //Store the 3 averages
		int[] counts = new int[3]; //Store the counts (pos, neg, all) for displaying
		Scanner scan = new Scanner(System.in); //Create scanner
		String[] names = {" positive ", " non-positive ", " "}; //Names used to print more efficiently
		
		//Get input
		System.out.printf("Enter five whole numbers: ");
		for(int i = 0; i < 5; i++) { nums[i] = scan.nextInt(); } //Not confident why this works but I guess it does?
		
		//Sort
		for(int i = 0; i < 5; i++) {
			if(nums[i] > 0) { pos_nums.add(nums[i]); }
			else { neg_nums.add(nums[i]); }
		}
		
		//Count
		counts[0] = pos_nums.size(); counts[1] = neg_nums.size(); counts[2] = nums.length;
		
		//Calculate sums & averages
		for(int i = 0; i < counts[0]; i++) {
			sums[0] += pos_nums.get(i);
		}
		avgs[0] = ((float)sums[0])/((float)counts[0]);
		if(Float.isNaN(avgs[0])) { avgs[0] = 0; } //NaN fix
		
		for(int i = 0; i < counts[1]; i++) {
			sums[1] += neg_nums.get(i);
		}
		avgs[1] = ((float)sums[1])/((float)counts[1]);
		if(Float.isNaN(avgs[1])) { avgs[1] = 0; } //NaN fix
		
		for(int i = 0; i < counts[2]; i++) {
			sums[2] += nums[i];
		}
		avgs[2] = ((float)sums[2])/((float)counts[2]);
		if(Float.isNaN(avgs[2])) { avgs[2] = 0; } //NaN fix
		
		//Print stats
		for(int i = 0; i < 3; i++) {
			if(counts[i] == 1) {
				System.out.printf("The sum of the %d%snumber: %d\n", counts[i], names[i], sums[i]);
			}
			else {
				System.out.printf("The sum of the %d%snumbers: %d\n", counts[i], names[i], sums[i]);
			}
		}
		for(int i = 0; i < 3; i++) {
			if(counts[i] == 1) {
				System.out.printf("The average of the %d%snumber: %.2f\n", counts[i], names[i], avgs[i]);
			}
			else {
				System.out.printf("The average of the %d%snumbers: %.2f\n", counts[i], names[i], avgs[i]);
			}
		}
		
		scan.close();
	}

}
