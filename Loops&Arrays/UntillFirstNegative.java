package java04.loops_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UntillFirstNegative {
	static int sum = 0;
	public static void main(String[] args) throws NumberFormatException, IOException{
		
		System.out.println("Input, please, some integers:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(Integer.parseInt(reader.readLine())>0){
			if((Integer.parseInt(reader.readLine()) % 2) == 0){
				sum += Integer.parseInt(reader.readLine());
			}
		}if(Integer.parseInt(reader.readLine())<0){
		
			System.out.println(sum);
			reader.close();
		}
	}
}
