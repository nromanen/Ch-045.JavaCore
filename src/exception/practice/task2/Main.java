package exception.practice.task2;

import util.Scan;

import static exception.practice.task2.PlantService.PrintPlantsByColor;
import static exception.practice.task2.PlantService.PrintPlantsByType;
import static util.Print.print;

/* Create a class Plants, which includes fields int size, Color color and Type type,
 * and constructor where these fields are initialized. Color and type are Enum.
 * Override the method toString( ). Create classes ColorException and TypeException
 * and describe there all possible colors and types of plants.
 * In the method main create an array of five plants. Check to work your exceptions.
 *
 */

public class Main {

    public static void main(String[] args) {

        Plant[] plants = {
                new Plant(10, Color.GREEN, Type.TREES),
                new Plant(1, Color.GREY, Type.GRASS),
                new Plant(2, Color.RED, Type.SEAWEED),
                new Plant(4, Color.BROWN, Type.MOSS),
                new Plant(5, Color.GREEN, Type.SHRUBS),
                new Plant(3, Color.YELLOW, Type.FLOWERS)
        };

        print("Enter the type of the plants: ");
        String type = Scan.getString();

        try {
            PrintPlantsByType(type, plants);
        } catch (TypeException e) {
            e.printStackTrace();
        }

        print("Enter the color of the plants: ");
        String color = Scan.getString();

        try {
            PrintPlantsByColor(color, plants);
        } catch (ColorException e) {
            e.printStackTrace();
        }
    }
}
