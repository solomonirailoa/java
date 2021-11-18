/**
 * @author: Solomoni Railoa
 * 
 * This Java program aims to solve the problem of reading commas 
 * inside an entry of double quotes
 * Take for example a comma next to John in:  A0B1, 1998, 33.5, "My name is John, I am 23", 247, Pacific, 0.314
 * will not be regarded as delimiter when performing a split string
 * or when identifying column entries, hence the entry "My name is John, I am 23" will be regarded 
 * as a single entry and not splitted.
 *
**/

import java.util.*;
import java.io.*;

public class MainClass
{
    public static void main(String[] args) { //Main Method
		ArrayList<Data> arrayList = new ArrayList<>();
        String columnHeading = "";
        int noOfRows = 0;
        int noOFcolumns = 0;
        try{
            String filename = "example.csv"; //Edit your filename here, to a .csv file of your choice
            File x = new File(filename);
            Scanner sc = new Scanner(x);
            System.out.println("Please wait while reading File: " + filename);
            columnHeading = sc.nextLine();
            String[]temp = columnHeading.split(",");
            noOFcolumns = temp.length;
            while(sc.hasNext()) {
                String str = sc.nextLine();
                String[] tokens = str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); //Shoutout and credits to a certain user at the Stackoverflow site, whom whose username I can't recall.
                String tmp = "";					//If you somehow come across Line33 in Stackoverflow, please tell me the username so I can add here
                for (int m=0;m<tokens.length;m++){
                    tmp = tmp + " || " + tokens[m]; // The || can act as a better delimeter for future String splits 
                }
                Data aLine = new Data(tmp); 
                arrayList.add(aLine);
                ++noOfRows;
            }
            System.out.println("\nFile reading COMPLETE.\n");
            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println("!!!!! File Open Error !!!!!");
        }
        for(int i=0;i<noOfRows;i++) {
            System.out.println(arrayList.get(i).getValue());
        }
	}
}

//The class below is optional
//The class below is an example of enabling Generics in Java
class Data<T extends Comparable<T>> { //Extends Comparable makes it easier for future comparison of data
    private T value;                 // Also useful for perforoming a Binary Search if needed
    public Data (T value){
        this.value = value;
    }
    public T getValue(){
        return this.value;
    }
}
