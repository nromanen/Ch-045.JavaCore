package inheritance.homework.bird;


public class Penguin extends NonFlyingBird {

    public Penguin(String area) {
        this.setFeathers(false);
        this.setLayEggs(true);
        this.setArea(area);
    }
}
