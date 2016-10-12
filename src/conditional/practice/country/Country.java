package conditional.practice.country;


public class Country {
    private String name;
    private Continent contrinent;
    private double area;
    private int population;
    private Language language;

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, Continent contrinent) {
        this(name);
        this.contrinent = contrinent;
    }

    // seters and geters
    public Continent getContrinent() {
        return contrinent;
    }

    public void setContrinent(Continent contrinent) {
        this.contrinent = contrinent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
