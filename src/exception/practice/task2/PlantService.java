package exception.practice.task2;

import static util.Print.println;


public class PlantService {

    public static void PrintPlantsByType(String type, Plant... plants) throws TypeException {
        type = type.toUpperCase();

        try{
            Type t = Type.valueOf(type);
        } catch (IllegalArgumentException e){
            throw new TypeException("No such type of plants");
        }

        Type t = Type.valueOf(type);

        for (Plant plant : plants) {
            if(plant.getType().equals(t)){
                println(plant);
            }
        }
    }

    public static void PrintPlantsByColor(String color, Plant... plants) throws ColorException {
        color = color.toUpperCase();

        try{
            Color c = Color.valueOf(color);
        } catch (IllegalArgumentException e){
            throw new ColorException("No such color of plants");
        }

        Color c = Color.valueOf(color);

        for (Plant plant : plants) {
            if(plant.getColor().equals(c)){
                println(plant);
            }
        }
    }
}
