package oddnumber;

import java.io.*;

public class WeekDay {
	public static void main(String[] args) throws Exception {
		System.out.println("Input number of the day or the week and check respond in 3 languages");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(reader.readLine());
		switch (i) {
		case 1:
			System.out.println("Monday, Понедельник, Понедiлок");
			break;
		case 2:
			System.out.println("Tuesday, Вторник, Вiвторок");
			break;
		case 3:
			System.out.println("Wednesday, Среда, Середа");
			break;
		case 4:
			System.out.println("Thursday, Черверг, Четвер");
			break;
		case 5:
			System.out.println("Friday, everyone loves friday!)), Пятница развратница");
			break;
		case 6:
			System.out.println("Saturday, Суббота, Субота");
			break;
		case 7:
			System.out.println("Sunday, oops weekend finished");
			break;
		default:
			System.out.println("Wrong input");

		}

	}

}
