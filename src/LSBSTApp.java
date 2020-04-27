import java.util.*;
import java.io.*;
public class LSBSTApp {
    private BinarySearchTree<Data> bst = new BinarySearchTree<>();
    private Data data;
    private String[] arr_time = new String[2976];
    private String[] arr_areas = new String[2976];
    private int opCount = 0;

    /**
     * fetches file with load shedding data from a specific path and inserts the data read from each line into a binary tree
     * @throws Exception if the file is not found
     */

    public LSBSTApp()throws Exception{
        File file = new File("src\\Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int i=0;
        while ((st = br.readLine()) != null){
            data = new Data(st);
            bst.insert(data);
            i=i+1;
        }
    }

    /**
     * prints all data in the binary tree in numerical order of lowest to highest
     *
     */

    public void printAllAreas(){
        bst.inOrder();
    }

    /**
     * Gets the areas affected by load shedding matching the input stage, day and start time
     *
     * @param stage the load shedding stage
     * @param day the day of the month of load shedding
     * @param startTime the start time of load shedding
     * @return the areas affected based on the above parameters
     */

    public String printAreas(String stage,String day,String startTime)throws IOException{
        Data temp = new Data(stage+"_"+day+"_"+startTime+" "+"null");
        if (bst.find(temp)==null){return "not found";}
        BinaryTreeNode<Data> temp_node = bst.find(temp);
        FileWriter fw=new FileWriter("output1.txt");
        int opCount = bst.getOpCount1();
        fw.write(String.valueOf(opCount));
        fw.close();
        int x = bst.getOpCount1();
        return ((bst.find(temp)).data).getAreas();
    }

    /**
     * Prints out all the areas of load shedding for all stages, days and times if no parameters are given to the application.
     * If parameters are given, the details of the matching areas are printed out
     * @param args data input of the application
     */

    public static void main(String[] args){
        try{
            LSBSTApp test;
            if (args.length==0) {
                test = new LSBSTApp();
                test.printAllAreas();
            }
            else if (args.length==3){
                test = new LSBSTApp();
                System.out.println("day: "+args[1]);
                System.out.println("time: "+args[2]+":00");
                System.out.println("Areas affected: "+test.printAreas(args[0],args[1],args[2]));
            }
        }catch (Exception e){
            System.out.println("file not found");
        }
    }
}
