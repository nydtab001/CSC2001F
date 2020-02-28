import java.util.*;
import java.io.*;
public class LSArrayApp {
    private String[] arr_time = new String[2976];
    private String[] arr_areas = new String[2976];
    private String list = "";
    private Data[] data = new Data[2976];

    public LSArrayApp()throws Exception{
        File file = new File("C:\\Users\\Taboka\\Desktop\\Course\\CSC2001F\\Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int i=0;
        while ((st = br.readLine()) != null){
            data[i]=new Data(st);
            arr_time[i]=data[i].getTime();
            arr_areas[i]=data[i].getAreas();
            i=i+1;
        }
    }

    public String printAreas(String stage,String day,String startTime){
        String[] temp = {stage,day,startTime};
        for (int i = 0;i<data.length;i++){
            String[] temp2=arr_time[i].split("_",3);
            if (temp==temp2){
                return arr_areas[i];
            }
        }
        return "not found";
    }

    public String[] printAllAreas(){
        String[] arr = new String[2976];
        for (int i=0;i<arr_time.length;i++){
            arr[i]="|stage: "+(arr_time[i].split("_",3))[0]+"|day: "+(arr_time[i].split("_",3))[1]+"|areas: "+arr_areas[i]+"|time: "+(arr_time[i].split("_",3))[2]+"00hrs|";
        }
        return arr;
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
