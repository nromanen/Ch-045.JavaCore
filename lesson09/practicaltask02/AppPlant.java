package lesson09.practicaltask02;

import java.util.ArrayList;
import java.util.List;

public class AppPlant {
public static void main(String[] args) throws ColorException, TypeException {

		Plant plant1=new Plant("rose", "red", 1);
		Plant plant2=new Plant("cornflower", "white", 3);
		Plant plant3=new Plant("chamomile", "blue", 2);
		List<Plant> list=new ArrayList<>();
		list.add(plant1);
		list.add(plant2);
		list.add(plant3);
		for(Plant in: list){
		System.out.println(in);
		}
	


}
}
