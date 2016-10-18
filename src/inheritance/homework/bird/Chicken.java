package inheritance.homework.bird;

public class Chicken extends NonFlyingBird{

    public Chicken(String area) {
        this.setFeathers(true);
        this.setLayEggs(true);
        this.setArea(area);
    }

}
