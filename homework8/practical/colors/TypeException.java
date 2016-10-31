package homework8.practical.colors;

/**
 * Created by roma on 28.10.2016.
 */
public class TypeException extends Exception {

    private String type;

    public TypeException() {
    }

    public TypeException(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return "Type Exception type = "+type
                +"\nChose [Type1,Type2,Type3]";
    }
}
