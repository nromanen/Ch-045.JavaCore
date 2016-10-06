package FlowerBed;

/**
 * Created by evil on 03.10.16.
 */
class FlowerBed {
    private double radius;
    FlowerBed(double radius){
        this.radius = radius;
    }

    double circlePerimeter(){
        return (2*Math.PI)*radius;
    }
    double circleArea(){
        return Math.PI*(radius * radius);
    }

}
