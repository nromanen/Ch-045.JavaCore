package inheritance.homework.bird;


import static util.Print.print;

/*
 * Abstract class for describe Birds
 */


public abstract class Bird {
    private String area;
    private boolean feathers;
    private boolean layEggs;

    // abstract  method than show possibility of flying this bird
    public abstract void fly();

    // Method show information about this bird
    public void info(){
        print("I'm a ", this.getClass().getSimpleName(), ". I live in ", this.getArea(), ". I " , (this.isFeathers() ? "have " : "have not "), "feathers and I ", (this.isLayEggs() ? "lay eggs. ": "don't lay eggs. "));
        this.fly();

    }

    public boolean isFeathers() {
        return feathers;
    }

    public void setFeathers(boolean feathers) {
        this.feathers = feathers;
    }

    public boolean isLayEggs() {
        return layEggs;
    }

    public void setLayEggs(boolean layEggs) {
        this.layEggs = layEggs;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
