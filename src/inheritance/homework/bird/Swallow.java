package inheritance.homework.bird;

public class Swallow extends FlyingBird{

    public Swallow(String area) {
        this.setFeathers(true);
        this.setLayEggs(true);
        this.setArea(area);
    }
}
