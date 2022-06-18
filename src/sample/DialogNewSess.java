package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DialogNewSess {

    public static Stage window=null;
    public static Scene scene;

    public static void display() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("fxml/info.fxml"));
        window = new Stage();
        window.initModality(Modality.NONE);
        window.setTitle("Додати сеанс");

        scene = new Scene(root, 350, 250);
        window.setScene(scene);

        try{
            window.showAndWait();
        }catch (Exception e){

        }


    }

}

