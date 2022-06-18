package sample.items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Place {
    private int numb;
    private String name;
    boolean empty;
    ImageView img;
    Place(int numb){
        this.numb = numb;
        empty = true;
        name = null;

        img = new ImageView(new Image("sample/images/free.png"));
    }

    public ImageView getImg() {
        return img;
    }

    public int getNumb() {
        return numb;
    }

    public String getName() {
        return name;
    }

    public boolean getstat(){
        return empty;
    }

    public void add(String name){
        this.name = name;
        empty = false;
        Hall.pl_counter();
        img = new ImageView(new Image("sample/images/full.png"));
    }

    public void delete(){


        this.name = null;
        empty = true;
        Hall.m_counter();
    }



    @Override
    public String toString() {
        if(name!=null){
            return "{ place #" + numb +
                    ", full " +
                    ", '" + name + "' }";
        }else{
            return "{ place #" + numb +
                    ", empty }";
        }
    }
}
