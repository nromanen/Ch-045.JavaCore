package FXApp;/**
 * Created by evil on 10.10.16.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FXApp extends Application {
    private final TableView<Student> table = new javafx.scene.control.TableView<>();
    private final ObservableList<Student> data = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);

        final Label label = new Label("Person Table");
        //construct table
        table.setEditable(true);
        TableColumn firstColName = new TableColumn("Name");
        firstColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        firstColName.setPrefWidth(100);
        TableColumn secondColName = new TableColumn("Rate");
        secondColName.setCellValueFactory(new PropertyValueFactory<>("rating"));
        secondColName.setPrefWidth(50);

        table.setItems(data);
        table.setPrefWidth(350);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(firstColName, secondColName);
        //dialog window for adding new student
        Button addNewStudent = new Button("Add");
        addNewStudent.setOnAction((ActionEvent e) -> {
            Stage dialog = new Stage();
            Group secondary = new Group();
            Scene newScene = new Scene(secondary, 350, 350);

            GridPane addStudentGrid = new GridPane();
            addStudentGrid.setPadding(new Insets(10, 10, 10, 10));
            addStudentGrid.setVgap(5);
            addStudentGrid.setHgap(5);

            final TextField name = new TextField();
            name.setPromptText("Input name");
            GridPane.setConstraints(name, 0, 0);
            addStudentGrid.getChildren().add(name);

            final TextField rating = new TextField();
            rating.setPromptText("Input rating");
            GridPane.setConstraints(rating, 0, 1);
            addStudentGrid.getChildren().add(rating);

            Button submit = new Button("Submit");
            GridPane.setConstraints(submit, 1, 0);
            addStudentGrid.getChildren().add(submit);

            submit.setOnAction((ActionEvent t) -> {
                double r = Double.parseDouble(rating.getText());
                data.add(new Student(name.getText(), r));
            });

            secondary.getChildren().addAll(addStudentGrid);
            dialog.setTitle("Add Student");
            dialog.setScene(newScene);
            dialog.show();
        });
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(20, 0, 0, 50));
        vbox.getChildren().addAll(label, table, addNewStudent);

        root.getChildren().addAll(vbox);

        primaryStage.setTitle("Person table");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void stop(){}
}
