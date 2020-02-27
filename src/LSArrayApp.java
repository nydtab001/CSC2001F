import java.util.*;
import java.io.*;
public class LSArrayApp extends Data{
    private String all = "";
    private String list = "";
    private String[] data = new String[2976];

    public LSArrayApp()throws Exception{
        File file = new File("C:\\Users\\Taboka\\Desktop\\Course\\CSC2001F\\Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int i=0;
        while ((st = br.readLine()) != null){
            data[i]=st;
            i=i+1;
        }
    }

    public String printAreas(String stage,String day,String startTime){
        return "VOILA!!!";
    }

    public String[] printAllAreas(){
        return data;
    }

    public static void main(String[] args){
        try{
            LSArrayApp test;
            if (args.length==0){
                test = new LSArrayApp();
                String[] x = test.printAllAreas();
                for (String value : x) {
                    System.out.println(value);
                }
            }
            else if (args.length==3) {
                test = new LSArrayApp();
                System.out.println(test.printAreas(args[0],args[1],args[2]));
            }
        }catch (Exception e){
            System.out.println("File not found");
        }
    }
}
