package hohework5.bird;

class Penguin extends NonFlyingBird {
    public boolean swim;

    public Penguin(){}

    public Penguin(String name, boolean feathers, boolean layEggs, boolean swim){
        super(name, feathers, layEggs);
        this.swim = swim;
    }
    @Override
    public String toString() {
        return String.format("Name: %-10s  feathers: %-6b lay eggs: %-6b fly: %-6b swim: %-6b",
                name,feathers,layEggs,this.fly(),swim);
    }
}