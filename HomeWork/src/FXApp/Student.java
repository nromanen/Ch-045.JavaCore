package FXApp;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by evil on 10.10.16.
 */
public class Student {
    private final SimpleStringProperty name;
    private final SimpleDoubleProperty rating;

    public Student(String name, double rating){
        this.name = new SimpleStringProperty(name);
        this.rating = new SimpleDoubleProperty(rating);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getRating() {
        return rating.get();
    }

    public SimpleDoubleProperty ratingProperty() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating.set(rating);
    }
}
