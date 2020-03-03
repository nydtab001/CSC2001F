import java.util.*;
import java.io.*;
public class LSBSTApp {
    private BinarySearchTree<Data> bst = new BinarySearchTree<>();
    private Data data;
    private String[] arr_time = new String[2976];
    private String[] arr_areas = new String[2976];
    private int opCount = 0;

    public LSBSTApp()throws Exception{
        File file = new File("C:\\Users\\Taboka\\IdeaProjects\\untitled\\CSC2001F\\files\\Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int i=0;
        while ((st = br.readLine()) != null){
            data = new Data(st);
            bst.insert(data);
            i=i+1;
        }
    }

    public void printAllAreas(){
        String[] arr = new String[2976];
        bst.inOrder();
    }

    public String printAreas(String stage,String day,String startTime){
        Data temp = new Data(stage+"_"+day+"_"+startTime+" "+"null");
        if (bst.find(temp)==null){return "not found";}
        return ((bst.find(temp)).data).toString();
    }

    public static void main(String[] args){
        try{
            if (args.length==0) {
                LSBSTApp test = new LSBSTApp();
                test.printAllAreas();
            }
            else if (args.length==3){
                LSBSTApp test = new LSBSTApp();
                System.out.println("day: "+args[1]);
                System.out.println("time: "+args[2]+":00");
                System.out.println("Areas affected: "+test.printAreas(args[0],args[1],args[2]));
            }
        }catch (Exception e){
            System.out.println("file not found");
        }
    }
}
