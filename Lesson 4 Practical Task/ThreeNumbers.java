package oddnumber;
import java.io.*;
public class ThreeNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
	
	System.out.println("Input 3 float numbers");
		float[] array =null;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0;Float.parseFloat(reader.readLine())>-5&&Float.parseFloat(reader.readLine())<5;i++){
		 array[i] = (float)Float.parseFloat(reader.readLine());
			System.out.println(array[i]);}
		
		float maximum = 0;
		for(int i=0;i<array.length;i++){
			 maximum = array[0];
	            if (maximum < array[i]){
	                maximum = array[i];
	            }
		}System.out.println("Maximum is " + maximum);
		
			
			}
		
		
	}


