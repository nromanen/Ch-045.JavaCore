package hohework5.bird;

class Eagle extends FlyingBird {
    public boolean sharpClaws;

    public Eagle(){};

    public Eagle(String name, boolean feathers, boolean layEggs,boolean sharpClaws){
        super(name, feathers, layEggs);
        this.sharpClaws = sharpClaws;
    }
    @Override
    public String toString() {
        return String.format("Name: %-10s  feathers: %-6b lay eggs: %-6b fly: %-6b sharp glass: %-6b",
                name,feathers,layEggs,this.fly(),sharpClaws);
    }

}