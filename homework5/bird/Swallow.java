package hohework5.bird;

class  Swallow extends FlyingBird {
    public boolean maneuverable;

    public Swallow(){};

    public Swallow(String name, boolean feathers, boolean layEggs, boolean maneuverable){
        super(name, feathers, layEggs);
        this.maneuverable = maneuverable;
    }
    @Override
    public String toString() {
        return String.format("Name: %-10s  feathers: %-6b lay eggs: %-6b fly: %-6b maneuverable: %-6b",
                name,feathers,layEggs,this.fly(),maneuverable);

    }
}
