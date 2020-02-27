import java.util.*;
import java.io.*;
public class Data {
    private String stage_time;
    private String areas;
    private String content;
    public Data(){
        stage_time = "";
        areas = "";
    }

    public String getTime(String data) {
        stage_time=(data.split(" ",2))[0];
        return stage_time;
    }

    public String getAreas(String data){
        areas = (data.split(" ",2))[1];
        return areas;
    }

    public static void main(String[] args){
        String test1="8_4_12 7, 15, 3, 11, 8, 16, 4, 12";
        Data test = new Data();
        System.out.println(test.getTime(test1));
        System.out.println(test.getAreas(test1));
    }
}