package hohework5.bird;

class FlyingBird extends Bird {
    public FlyingBird(){};
    public FlyingBird(String name, boolean feathers, boolean layEggs){
        super(name, feathers, layEggs);
    }

    @Override
    boolean fly() {
        return true;
    }
}