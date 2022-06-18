package sample.items;

import sample.Main;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;

public class Sessions {
    private Movie first;
    public Sessions() {
        first = null;
    }

    public Movie getFirst() {
      return first;
    }

    public void insertFirst(int hour, int min, int mov_min, String mv_name) {
        Movie newLink = new Movie(hour, min, mov_min, mv_name);
        newLink.next_movie = first;
        first = newLink;
    }

    public void insertEnd(int hour, int min, int mov_min, String mv_name) {
        Movie current = first;
        if(current==null){
            first =  new Movie(hour, min, mov_min, mv_name);
        }else{
            while (current.next_movie != null) {
                current = current.next_movie;
            }
            current.next_movie =  new Movie(hour, min, mov_min, mv_name);
        }


    }

    public String[] get_String_Sess(){

        ArrayList<String> tmp = new ArrayList<>();
        ArrayList<Time> tmp2 = new ArrayList<>();


        Movie current = first;
        if(current==null){
           return null;
        } else{
            tmp.add(current.toView());
            tmp2.add(current.time_start);

            while(current.next_movie!=null){
                tmp.add(current.next_movie.toView());
                tmp2.add(current.next_movie.time_start);
                current = current.next_movie;
            }

        }

        String[] _one = tmp.toArray(new String[tmp.size()]);
        Time[] _two = tmp2.toArray(new Time[tmp2.size()]);

        Time tmps;
        String tmps_s;

        for (int d = (_two.length-1)/2; d >= 1; d /= 2)
            for (int i = d; i < _two.length; i++)
                for (int j = i; j >= d; j -= d) {
                    if(_two[j-d].getTime() > _two[j].getTime()){
                        tmps = _two[j];
                        _two[j] =  _two[j-d];
                        _two[j-d] =  tmps;

                        tmps_s = _one[j];
                        _one[j] =  _one[j-d];
                        _one[j-d] =  tmps_s;
                    }

                }

        return _one;

    }

    public void dis_info(){
        Movie current = first;
        if(current==null){
            System.out.println("Немає фільмів");
        } else{
            while(current.next_movie!=null){
                System.out.println(current);
                current = current.next_movie;
            }
            if(current.next_movie==null&&current.mv_name!=null){
                System.out.println(current);
            }
        }

    }

    public void disp_numb_of_mov(){
        Movie current = first;
        int counter;
        if(current==null){
            counter = 0;
        }else {
            counter = 1;
            while(current.next_movie!=null){
                counter++;
                current = current.next_movie;
            }
        }

        System.out.println("Всього фільмів: " + counter);
    }

    public Movie find(String mv_name) {
        Movie current = first;
        if(current==null) {
        } else{

            while (!mv_name.equals(current.mv_name)) {
                if (current.next_movie == null) {
                    return null;
                } else {
                    current = current.next_movie;
                }
            }
        }
        return current;

    }

    public Movie get(String mv_name) {
        Movie current = first;
        if(current==null) {
        } else{

            while (!mv_name.equals(current.toView())) {
                if (current.next_movie == null) {
                    return null;
                } else {
                    current = current.next_movie;
                }
            }
        }
        return current;

    }

    public void delete(String key) {
        Movie current = first;
        Movie previus = null;
        if (key.equals(current.toView())) {
            for(var k : current.hall_set.places){
                if(!k.empty){
                    Hall.m_counter();
                }
            }

            first = current.next_movie;

            System.out.println("Видалено1");
        } else {
            while(!key.equals(current.toView())){
                if(current.next_movie==null) break;
                previus = current;
                current = current.next_movie;
            }
            if(key.equals(current.toView())){
                for(var k : current.hall_set.places){
                    if(!k.empty){
                        Hall.m_counter();
                    }
                }

                previus.next_movie = current.next_movie;
                System.out.println("Видалено2");

            } else{
                System.out.println("Немає такого елементу");
            }

        }


    }


    public void displayList() {
        Movie current = first;
        System.out.print("List (first --> last): ");

        while(current != null) {
            System.out.print(current.mv_name + "(" + current.time_start + "-" + current.time_end + ") ->> ");
            current = current.next_movie;
        }
        System.out.println("");
    }


}


