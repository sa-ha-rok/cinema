package sample.items;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.Arrays;

public class Hall {

    Place places[];
    public ObservableList<Place> plas;
    static private int counter = 0;

    public Hall(int numb){
        places = new Place[numb];
        for (int i = 0; i <= places.length-1; i++) {
            places[i] = new Place(i+1);
        }
    }

    public  Place getIt(int a) {
        return places[a];
    }

    public void add_in(int a, String name){
        if(places[a-1].empty) places[a-1].add(name);
    }

    public void gen_table(){
       plas = getList();

    }

    ObservableList<Place> getList(){
        ArrayList<Place> it = new ArrayList<>();

        for(var l : places){
            if(!l.getstat()){
                it.add(l);
            }
        }

        System.out.println(Arrays.toString(it.toArray()));
        return  FXCollections.observableArrayList(it);
    }

    public void dell_in(int a){
        if(!places[a-1].empty){
            places[a-1].delete();
        }
    }

    public static int getCounter() {
        return counter;
    }

    public static void pl_counter(){
        counter++;
    }

    public static void m_counter(){
        counter--;
    }

    public int fby_name(String name){
           for (int i = 0; i <= places.length-1; i++) {
            if(places[i].getName().equals(name)){
                return i;
            }
        }
           return -1;
    }

    public void display(){

        System.out.println("\nHall { ");
        for (var k : places){
            System.out.println(k.toString());
        }
        System.out.println(" }");
    }


}
