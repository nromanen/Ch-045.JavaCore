package java04.loops_array;
import java.io.*;

public class Array_1sttask {
	public static void main(String[] args) throws NumberFormatException, IOException{
		int[] daysinMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int month = Integer.parseInt(reader.readLine());
		System.out.println("Month number " + month + " has " + daysinMonth[month-1] + " days");
	}

}
