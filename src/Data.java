import java.util.*;
import java.io.*;
public class Data implements Comparable<Data> {
    private String load_data;
    private String areas;
    private String content;

    /**
     * initializes the load_data instance variable and assigns it to the string of data read from the file
     *
     * @param data the line of data read from the file
     */
    public Data(String data){
        load_data = data;
    }

    /**
     * returns the stage, day of month and start time as a string separated underscore from the input string of data
     *
     * @return returns the information stated above
     */

    public String getTime() {
        return (load_data.split(" ",2))[0];
    }

    /**
     * returns the areas affected at a certain stage, day and start time
     *
     * @return returns areas affected based on the conditions stated above
     */

    public String getAreas(){
        return (load_data.split(" ",2))[1];
    }

    /**
     * returns the string representation of the data input
     *
     * @return returns the string representation of the data by combining the output of the getTime() function and getAreas()
     * function by a space.
     */

    public String toString(){
        return getTime()+" "+getAreas();
    }

    /**
     * Compares two data items of type "Data"
     * the function splits the output of the getTime() function from each data item into an array of integers and returns
     * the 0 if the arrays are identical and returns the difference of the first non-equal corresponding elements if arrays are not equal
     * @param o the input data to which the current data is compared
     * @return returns the results of the information mentioned above
     */

    @Override
    public int compareTo(Data o) {
        if (o.getTime().equals(this.getTime())){
            return 0;
        }
        int[] temp_o=new int[3];
        int[] temp_t=new int[3];
        temp_o[0]=Integer.parseInt((((o.getTime()).split("_",3))[0]));
        temp_o[1]=Integer.parseInt((((o.getTime()).split("_",3))[1]));
        temp_o[2]=Integer.parseInt((((o.getTime()).split("_",3))[2]));
        temp_t[0]=Integer.parseInt((((this.getTime()).split("_",3))[0]));
        temp_t[1]=Integer.parseInt((((this.getTime()).split("_",3))[1]));
        temp_t[2]=Integer.parseInt((((this.getTime()).split("_",3))[2]));
        if (temp_o[0]==temp_t[0]){
            if (temp_o[1]==temp_t[1]){
                return temp_t[2]-temp_o[2];
            }
            return temp_t[1]-temp_o[1];
        }
        return temp_t[0]-temp_o[0];
    }
}