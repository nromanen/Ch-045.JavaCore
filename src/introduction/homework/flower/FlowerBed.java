package introduction.homework.flower;


public class FlowerBed {

    private double radius;

    FlowerBed(){
        radius = 1;
    }

    FlowerBed(double radius){
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1;
        }
    }

    // geters
    public double getRadius() {
        return radius;
    }

    // seters
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }

    // The method return perimeter of the flower bed
    public double perimeter(){
        return Math.round(100 * 2 * radius * Math.PI)/100.0;
    }

    // The method return area of the flower bed
    public double area (){
        return Math.round(100 * radius * radius * Math.PI)/ 100.0;
    }

}
