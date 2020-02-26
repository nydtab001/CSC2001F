import java.util.*;
import java.io.*;
public class LSArrayApp {
    public static void main(String[] args)throws Exception{
        File file = new File("C:\Users\Taboka\Desktop\Course\CSC2001F\Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            System.out.println(st);}
    }
}
