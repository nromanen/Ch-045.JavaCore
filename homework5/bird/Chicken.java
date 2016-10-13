package hohework5.bird;

class Chicken extends NonFlyingBird {
    public boolean poultry;

    public Chicken(){};

    public Chicken(String name, boolean feathers, boolean layEggs, boolean poultry){
        super(name, feathers, layEggs);
        this.poultry = poultry;
    }
    @Override
    public String toString() {
        return String.format("Name: %-10s  feathers: %-6b lay eggs: %-6b fly: %-6b poultry: %-6b",
                name,feathers,layEggs,this.fly(),poultry);
    }
}