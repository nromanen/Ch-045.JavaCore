package practicaltasklesson8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rectangle {
	
	
	public static int squareRectangle (int a, int b)
	{
		
		try{
			if(a<0||b<0)
				throw new ArithmeticException();
		}
		catch(ArithmeticException e)
		{
			System.out.println("Input please positive numbers");
		}
		int s =(a*b)/2;
		return s;
	}
}
