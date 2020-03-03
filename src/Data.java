import java.util.*;
import java.io.*;
public class Data implements Comparable<Data> {
    private String load_data;
    private String areas;
    private String content;
    public Data(String data){
        load_data = data;
    }

    public String getTime() {
        return (load_data.split(" ",2))[0];
    }

    public String getAreas(){
        return (load_data.split(" ",2))[1];
    }

    public static void main(String[] args){
        String test1="8_4_12 7, 15, 3, 11, 8, 16, 4, 12";
        Data test = new Data(test1);
        System.out.println(test.getTime());
        System.out.println(test.getAreas());
    }

    public String toString(){
        return getTime()+" "+getAreas();
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        if (data.toString()==this.toString()){
            return true;
        }
        return false;
    }

/*    @Override
    public int hashCode() {
        return Objects.hash(load_data, areas, content);
    }*/

    @Override
    public int compareTo(Data o) {
        if (o.getTime().equals(this.getTime())){
            return 0;
        }
        return 1;
    }
}