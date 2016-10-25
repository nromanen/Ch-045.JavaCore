package net.gavrilyuk.task2;

/**
 * Plants Type
 * Created by Igor Gavryliuk on 24.10.2016.
 */
public enum  Type  {

    ALGAE("Algae"),
    LIVERWORTS("Liverworts"),
    MOSSES("Mosses"),
    FERNS_HORSETAILS("Ferns and horsetails"),
    CYCADS("Cycads"),
    GINKGO("Ginkgo"),
    CONIFERS("Conifers"),
    FLOWERING_PLANTS("Flowering plants");


    private String name;

    Type(String name) throws TypeException {
        if (name==null || name.isEmpty()) throw  new TypeException("empty type name");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name==null || name.isEmpty()) throw  new TypeException("empty type name!");
        this.name = name;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
