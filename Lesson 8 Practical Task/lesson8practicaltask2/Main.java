package lesson8practicaltask2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<Plants> plants = new ArrayList<>();
		Plants plant0 = new Plants(Type.BEAN, 1, Colour.BLACK);
		plants.add(plant0);
		Plants plant1 = new Plants(Type.BUSH, 15, Colour.GREEN);
		plants.add(plant1);
		Plants plant2 = new Plants(Type.CACTUS, 20, Colour.RED);
		plants.add(plant2);
		Plants plant3 = new Plants(Type.GRASS, 5, Colour.GREEN);
		plants.add(plant3);
		Plants plant4 = new Plants(Type.TREE, 50, Colour.YELLOW);
		plants.add(plant4);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input please type of plant:");

		String type = reader.readLine();
		/*try {
			System.out.println(getPlantByType(type, plants));
		} catch (TypeException e) {
			System.out.println("Check please type of plant");
			
		}*/
		
		try{
		getPlantBycolour(type,plants);
		}
		catch(ColourException e)
		{
			System.out.println("Where did u find this colour?");;
		}

	}

	public static Plants getPlantByType(String type, ArrayList<Plants> plants) throws TypeException {
		Type inputType;
		type = type.toUpperCase();
		try {
			inputType = Type.valueOf(type);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid type of plant");
			throw new TypeException();

		}
		for (Plants plant : plants) {
			if (plant.getType().equals(inputType)) {

				return plant;
			}

		}
		return null;
	}
	
	public static void getPlantBycolour(String colour, ArrayList<Plants> plants) throws ColourException
	{
		throw new ColourException();
	}

}