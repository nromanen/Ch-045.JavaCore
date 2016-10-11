package java04.loops_array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class TenIntegersTask2 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input 10 default integers");
		int sum =0;
		int [] array = new int[10];
		for(int i=0;i<10;i++){
			array[i] = Integer.parseInt(reader.readLine());
		}
		for(int b=0;b<5;b++)
		{
			if(array[b]>0){
				sum +=array[b];
			}else{
				sum =sum*array[5+b];
			}
				}System.out.println(sum);
	}
	
}



