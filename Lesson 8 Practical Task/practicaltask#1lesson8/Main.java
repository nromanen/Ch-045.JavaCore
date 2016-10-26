package practicaltasklesson8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)  {
		int a=0;
		int b =0;
		System.out.println("Input please rectangles 2 sides values:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try{
		a = Integer.parseInt(reader.readLine());
		 b = Integer.parseInt(reader.readLine());}
		catch(IOException e)
		{
			System.out.println("Wrong input");
		}
	System.out.println(Rectangle.squareRectangle(a,b));}
}
