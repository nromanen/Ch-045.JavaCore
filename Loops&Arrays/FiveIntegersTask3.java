package java04.loops_array;

import java.util.Scanner;

public class FiveIntegersTask3 {
	static int indexPositive = 0;
	public static void main(String[] args){
		System.out.println("Enter 5 integers");
		Scanner scn = new Scanner(System.in);
		int[] array = new int[5];
		int count = 0;
		int minimum = 0;
		int secpositive;
		for(int i=0;i<5;i++){
			array[i] = scn.nextInt();
			minimum = array[0];
	        if (minimum > array[i]){
	        	minimum = array[i];
		}
		for (int ii =0;ii<5;ii++) {
			if (array[ii] > 0) {
				count++;
				if (count == 2)
					indexPositive = ii;
					break;
			}
			}
		
   } System.out.println("Position of 2nd positive integer is " + indexPositive + " and minimum is " + minimum);	 
    }// Position of 2nd positive integer is 0!!!???
   
	}
		
		
