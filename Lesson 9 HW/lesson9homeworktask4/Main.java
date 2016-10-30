package lesson9homeworktask4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		MainUtils MU = new MainUtils();
		File file0 = new File("d:/1.txt");
		ArrayList<String> list = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file0)));
		String s0 = reader.readLine();
		while(s0!=null)
		{
			list.add(s0);
			System.out.println(s0);
			s0=reader.readLine();
		}
		reader.close();
		System.out.println("Number of lines in file is - "+MU.listLength(list));
		
		
		String task1 = "Number of lines in file is - "+MU.listLength(list);
		String task2 = MU.longestString(list);
		String task3 = "My name is Maksym, I was born 18.02.1987.";
		File file2 = new File("d:/file2.txt");
		OutputStream stream = new FileOutputStream(file2);
		stream.write(task1.getBytes());
		stream.write(task2.getBytes());
		stream.write(task3.getBytes());
		stream.close();
	}
}
