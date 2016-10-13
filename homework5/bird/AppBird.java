package hohework5.bird;


import java.util.ArrayList;
import java.util.List;

public class AppBird {
    public static void main(String [] args){

        List<Bird> bird = new ArrayList<Bird>();

        Bird bird1 = new Eagle("eagles", true, true,true);
        Bird bird2 = new Swallow("swallow", true, true, true);
        Bird bird3 = new Chicken("chicken", true, true, true);
        Bird bird4 = new Penguin("penguin", false, true, true);

        bird.add(bird1);
        bird.add(bird2);
        bird.add(bird3);
        bird.add(bird4);

        for (Bird birds: bird){
            System.out.println(birds);
        }
    }
}