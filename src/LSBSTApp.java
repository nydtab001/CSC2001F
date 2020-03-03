import java.util.*;
import java.io.*;
public class LSBSTApp {
    private BinarySearchTree<String> bst = new BinarySearchTree<>();
    private BinarySearchTree<String> bst2 = new BinarySearchTree<>();
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
            bst.insert(data.toString());
            bst2.insert(data.getTime());
            i=i+1;
        }
    }

    public void printAllAreas(){
        String[] arr = new String[2976];
        bst.inOrder();
    }

/*    public String printAreas(String stage,String day,String startTime){
        String x = (bst.find(stage+"_"+day+"_"+startTime)).data;
        if (x){

        }
        return "not found";
    }*/

    public static void main(String[] args){
        try{
            LSBSTApp test = new LSBSTApp();
            test.printAllAreas();
        }catch (Exception e){
            System.out.println("file not found");
        }
    }
}
