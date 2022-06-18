package sample.items;

import sample.Main;

import java.sql.Time;

public class Movie {
    Time time_start, time_end;
    public Hall hall_set = new Hall(Main.PLACE_NUMB);
    public int hour, min;
    public String mv_name; // інформація
    public Movie next_movie; // посилання на наступний елемент списку

    public Movie(int hour, int min, int mov_min, String mv_name) {
        this.hour = hour;
        this.min = min;
        time_start = new Time((hour-3)*3600000L + min*60000L);
        time_end = new Time((hour-3)*3600000L + min*60000L + mov_min*60000L);
        this.mv_name = mv_name;
    }

    public Time getTime_start() {
        return time_start;
    }

    public String toView(){
       return this.mv_name + " (" + this.time_start + "-" + this.time_end + ")";
    }

    @Override
    public String toString() {
        return "Movie{" +
                "time=" + time_start +
                " - " + time_end +
                ", mv_name='" + mv_name + '\'' +
//                ", next_movie=" + ((next_movie == null)?"null":"'" + next_movie.mv_name + "'") +
                '}';
    }
}
