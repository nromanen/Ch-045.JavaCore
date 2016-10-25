package net.gavrilyuk.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * Created by Igor Gavryliuk on 24.10.2016.
 */


        /*Create a class Plants, which includes fields int size,
         Color color and Type type, and constructor where
        these fields are initialized. Color and type are Enum.
        Override the method toString( ).
        Create classes ColorException and TypeException and describe there
        all possible colors and types of plants.
        In the method main create an array of five plants.
        Check to work your exceptions.*/

public class PlantsApp {

    public static void main(String[] args) {
        List<Plants> plants = new ArrayList<>();
        Random r = new Random();
            try {
                for (int i = 0; i < 5; i++) {
                plants.add(new Plants(
                        r.nextInt(5)+1,//random size
                        Color.values()[r.nextInt(Color.values().length)],//random plant color
                        Type.values()[r.nextInt(Type.values().length)]));//random plant type
                }
                // check exception
               /* Plants plant = new Plants();
                plant.setSize(-100);
                Color customBlack = Color.CUSTOM;
                customBlack.setBlue(0);
                customBlack.setGreen(-125);
                customBlack.setGreen(500);
                plant.setColor(customBlack);
                Type type = Type.ALGAE;
                type.setName(null);
                plant.setType(type);
                plants.add(plant);*/
            } catch (ColorException | TypeException e) {
                System.out.println(e.getMessage());
            }

        System.out.println(plants);
    }
}
