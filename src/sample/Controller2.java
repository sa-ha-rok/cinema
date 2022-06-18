package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {

    public TextField t_name;
    public TextField t_hour;
    public TextField t_min;
    public TextField t_time;
    public Button b_ok;
    public Button b_cancel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        b_ok.setOnMouseClicked(p -> {
            press_ok();
        });

        b_cancel.setOnMouseClicked( p -> pressCancel());
    }

    void press_ok(){
        if(t_hour.getText()!=null&&t_min.getText()!=null&&t_time.getText()!=null){
            int hour = Integer.parseInt(t_hour.getText());
            int min = Integer.parseInt(t_min.getText());
            int time = Integer.parseInt(t_time.getText());
            String name = t_name.getText();

            Main._29_11.insertEnd(hour, min, time, name);
            String databaseURL = "jdbc:ucanaccess://cinemagg.accdb";

            Connection connection = null;
            try {
                connection = DriverManager.getConnection(databaseURL);
                System.out.println("Connected succesfull");


                String sql = "INSERT INTO sessions (Name, hour, min, time) VALUES (?,?,?,?)";

                PreparedStatement statement = null;
                try {
                    statement = connection.prepareStatement(sql);
                    statement.setString(1, name);
                    statement.setInt(2 , hour);
                    statement.setInt(3 ,min);
                    statement.setInt(4 , time);


                    int rows = statement.executeUpdate();
                    if(rows > 0){
                        System.out.println("new");
                    }
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }





            DialogNewSess.window.close();
        }
    }

    public void pressCancel() {
        DialogNewSess.window.close();
    }
}
