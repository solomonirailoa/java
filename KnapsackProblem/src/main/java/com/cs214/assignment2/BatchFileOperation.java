/*
A2_S11123197_S11086287_S11145995
This is a useful utility for the Question 3 solution of Empirical Testing
What it does is that it allows the user to make multiple selection of datasets and TXT files
After the correct opening of files, the user can now perform empirical testing on GA and DP

The DP needs to load at least once. After that it won't run 31 times again
Now the GA only will then run 31 times on demand. 

The calculations of Success Rates (SR), Best NFC, Mean NFC, and Max NFC is done here too. 

*/

package com.cs214.assignment2;

import com.deterministic.algo.DynamicProgramming;
import com.nondeterministic.algo.GeneticAlgorithm;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javax.swing.JFileChooser;

public class BatchFileOperation extends javax.swing.JFrame {
    public static String path_ds1=""; 
    public static boolean batchOpenTXTagain_ds1=false;
    public static String datasetName_ds1="";
    public static String dir_ds1="";
    public static int v_ds1[];
    public static int w_ds1[];
    public static int W_ds1;
    public static int n_ds1;
    public static int opt_pr_ds1;
    public static String readMode_ds1="";
    public static String fl1_ds1="";
    public static String fl2_ds1="";
    public static String fl3_ds1="";
    public static boolean oneTime_ds1 = false;
    public static boolean canSTART_ds1 = false;
    
    public static String path_ds2=""; 
    public static boolean batchOpenTXTagain_ds2=false;
    public static String datasetName_ds2;
    public static String dir_ds2;
    public static int v_ds2[];
    public static int w_ds2[];
    public static int W_ds2;
    public static int n_ds2;
    public static int opt_pr_ds2;
    public static String readMode_ds2;
    public static String fl1_ds2="";
    public static String fl2_ds2="";
    public static String fl3_ds2="";
    public static boolean oneTime_ds2 = false;
    public static boolean canSTART_ds2 = false;
    
    public static String path_ds3; 
    public static boolean batchOpenTXTagain_ds3;
    public static String datasetName_ds3;
    public static String dir_ds3;
    public static int v_ds3[];
    public static int w_ds3[];
    public static int W_ds3;
    public static int n_ds3;
    public static int opt_pr_ds3;
    public static String readMode_ds3;
    public static String fl1_ds3="";
    public static String fl2_ds3="";
    public static String fl3_ds3="";
    public static boolean oneTime_ds3 = false;
    public static boolean canSTART_ds3 = false;
    
    public static String path_ds4; 
    public static boolean batchOpenTXTagain_ds4;
    public static String datasetName_ds4;
    public static String dir_ds4;
    public static int v_ds4[];
    public static int w_ds4[];
    public static int W_ds4;
    public static int n_ds4;
    public static int opt_pr_ds4;
    public static String readMode_ds4;
    public static String fl1_ds4="";
    public static String fl2_ds4="";
    public static String fl3_ds4="";
    public static boolean oneTime_ds4 = false;
    public static boolean canSTART_ds4 = false;
    
    public static String path_ds5; 
    public static boolean batchOpenTXTagain_ds5;
    public static String datasetName_ds5;
    public static String dir_ds5;
    public static int v_ds5[];
    public static int w_ds5[];
    public static int W_ds5;
    public static int n_ds5;
    public static int opt_pr_ds5;
    public static String readMode_ds5;
    public static String fl1_ds5="";
    public static String fl2_ds5="";
    public static String fl3_ds5="";
    public static boolean oneTime_ds5 = false;
    public static boolean canSTART_ds5 = false;
    
    public static String path_ds6; 
    public static boolean batchOpenTXTagain_ds6;
    public static String datasetName_ds6;
    public static String dir_ds6;
    public static int v_ds6[];
    public static int w_ds6[];
    public static int W_ds6;
    public static int n_ds6;
    public static int opt_pr_ds6;
    public static String readMode_ds6;
    public static String fl1_ds6="";
    public static String fl2_ds6="";
    public static String fl3_ds6="";
    public static boolean oneTime_ds6 = false;
    public static boolean canSTART_ds6 = false;
    
    public static String path_ds7; 
    public static boolean batchOpenTXTagain_ds7;
    public static String datasetName_ds7;
    public static String dir_ds7;
    public static int v_ds7[];
    public static int w_ds7[];
    public static int W_ds7;
    public static int n_ds7;
    public static int opt_pr_ds7;
    public static String readMode_ds7;
    public static String fl1_ds7="";
    public static String fl2_ds7="";
    public static String fl3_ds7="";
    public static boolean oneTime_ds7 = false;
    public static boolean canSTART_ds7 = false;
    
    public static String path_ds8=""; 
    public static boolean batchOpenTXTagain_ds8=false;
    public static String datasetName_ds8="";
    public static String dir_ds8="";
    public static int v_ds8[];
    public static int w_ds8[];
    public static int W_ds8;
    public static int n_ds8;
    public static int opt_pr_ds8;
    public static String readMode_ds8="";
    public static String fl1_ds8="";
    public static String fl2_ds8="";
    public static String fl3_ds8="";
    public static boolean oneTime_ds8 = false;
    public static boolean canSTART_ds8 = false;
    
    public static String the_dataset_is = ""; //Which dataset to select   -name of dataset   -dataset selection
    public static boolean startAll_eight;
    
    public static boolean isCleared=false;
    public BatchOpenTXT taskBatchOpenTXT;
    class BatchOpenTXT extends SwingWorker<Void,Void>{
        public String types_ds1="";
        public boolean only_c_data_ds1=false;
        
        public String types_ds2="";
        public boolean only_c_data_ds2=false;
        
        public String types_ds3="";
        public boolean only_c_data_ds3=false;
        
        public String types_ds4="";
        public boolean only_c_data_ds4=false;
        
        public String types_ds5="";
        public boolean only_c_data_ds5=false;
        
        public String types_ds6="";
        public boolean only_c_data_ds6=false;
        
        public String types_ds7="";
        public boolean only_c_data_ds7=false;
        
        public String types_ds8="";
        public boolean only_c_data_ds8=false;
        
        public Void doInBackground(){
            if (isCleared==true){
                fl1_ds1="";fl2_ds1="";fl3_ds1="";
                fl1_ds2="";fl2_ds2="";fl3_ds2="";
                fl1_ds3="";fl2_ds3="";fl3_ds3="";
                fl1_ds4="";fl2_ds4="";fl3_ds4="";
                fl1_ds5="";fl2_ds5="";fl3_ds5="";
                fl1_ds6="";fl2_ds6="";fl3_ds6="";
                fl1_ds7="";fl2_ds7="";fl3_ds7="";
                fl1_ds8="";fl2_ds8="";fl3_ds8="";
                isCleared=false;
            }
            if(the_dataset_is.equals("p01")){
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files only","txt");
                JFileChooser filechooser = new JFileChooser();
                filechooser.setAcceptAllFileFilterUsed(false);
                if(readMode_ds1.equals("p")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p01_p Profit (p) (*.TXT)",
                            "01_p", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                if(readMode_ds1.equals("w")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p01_w Weight (w) (*.TXT)",
                            "01_w", 31 * Customs.ExtensionFileFilter.MB)
                    ); 
                }
                if(readMode_ds1.equals("c")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p01_c Capacity (c) (*.TXT)",
                            "01_c", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                filechooser.addChoosableFileFilter(filter);
                int i = filechooser.showOpenDialog(null);
                if (i == JFileChooser.APPROVE_OPTION) {
                    if (v_ds1!=null || w_ds1!=null){
                        String next_pFile=dir_ds1+datasetName_ds1+"_p.txt";
                        String next_wFile=dir_ds1+datasetName_ds1+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){
                            n_ds1=0;
                        }
                    }
                    File f = filechooser.getSelectedFile();
                    String filepath = f.getPath();
                    path_ds1 = filepath; batchOpenTXTagain_ds1=false;
                    if (readMode_ds1.equals("p")){ //Read _p txt file
                        types_ds1="p";
                        if (v_ds1!=null || w_ds1!=null){

                        }
                        ArrayList<Integer> pList = new ArrayList<>();
                        String fileName_p = filepath;
                        try {
                            File x_p = new File(fileName_p);
                            Scanner sp = new Scanner(x_p);
                            while(sp.hasNextLine()) {
                                pList.add(Integer.parseInt((sp.nextLine().trim())));
                            }sp.close();
                            v_ds1 = pList.stream().mapToInt(ii -> ii).toArray(); //all the profit values
                            if(n_ds1!=0){
                                if (n_ds1<pList.size()){
                                    
                                }
                            }
                            else{
                                n_ds1=pList.size();
                            }
                            p01_p.setText(filepath);

                            String[] splat = path_ds1.split("\\\\");
                            datasetName_ds1= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds1=""; fl1_ds1=datasetName_ds1;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds1+=splat[s]+"\\";
                            }
                            String next_wFile=dir_ds1+datasetName_ds1+"_w.txt";
                            String next_cFile=dir_ds1+datasetName_ds1+"_c.txt";
                            if(new File(next_wFile).exists() && new File(next_cFile).exists()){

                            }
                            if(new File(next_wFile).exists()){
                                ArrayList<Integer> wList = new ArrayList<>(); 
                                String fileName_w = next_wFile;
                                try {
                                    File x_w = new File(fileName_w);
                                    Scanner sw = new Scanner(x_w);
                                    while(sw.hasNextLine()) {
                                        wList.add(Integer.parseInt((sw.nextLine().trim())));
                                    }sw.close();
                                    w_ds1 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds1!=0){
                                        if (n_ds1<wList.size()){
                                            
                                        }
                                    }
                                    else{
                                        n_ds1=wList.size();
                                    }
                                    readMode_ds1="w";
                                    fl2_ds1=datasetName_ds1;
                                    p01_w.setText(next_wFile);
                                    String[] splatt = path_ds1.split("\\\\");
                                    datasetName_ds1= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds1 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    fl3_ds1=datasetName_ds1;
                                    p01_c.setText(next_cFile);
                                    String[] splatt = path_ds1.split("\\\\");
                                    datasetName_ds1= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }


                        }
                        catch (FileNotFoundException e) {

                        }
                    }
                    else if (readMode_ds1.equals("w")){ //Read _w txt file
                        if (v_ds1!=null || w_ds1!=null){
                        }
                        types_ds1="w"; fl2_ds1=datasetName_ds1;
                        ArrayList<Integer> wList = new ArrayList<>(); 
                        String fileName_w = filepath;
                        try {
                            File x_w = new File(fileName_w);
                            Scanner sw = new Scanner(x_w);
                            while(sw.hasNextLine()) {
                                wList.add(Integer.parseInt((sw.nextLine().trim())));
                            }sw.close();
                            w_ds1 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                            if(n_ds1!=0){
                                if (n_ds1<wList.size()){
                                    
                                }
                                else{
                                    n_ds1=wList.size();
                                }
                            }
                            else{
                                n_ds1=wList.size();
                            }

                            p01_w.setText(filepath);
                            String[] splat = path_ds1.split("\\\\");
                            datasetName_ds1= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds1="";fl2_ds1=datasetName_ds1;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds1+=splat[s]+"\\";
                            }
                            String next_pFile=dir_ds1+datasetName_ds1+"_p.txt";
                            String next_cFile=dir_ds1+datasetName_ds1+"_c.txt";
                            if(new File(next_pFile).exists() && new File(next_cFile).exists()){

                            }
                            if(new File(next_pFile).exists()){
                                ArrayList<Integer> pList = new ArrayList<>(); 
                                String fileName_p = next_pFile; fl1_ds1=datasetName_ds1;
                                try {
                                    File x_p = new File(fileName_p);
                                    Scanner sp = new Scanner(x_p);
                                    while(sp.hasNextLine()) {
                                        pList.add(Integer.parseInt((sp.nextLine().trim())));
                                    }sp.close();
                                    v_ds1 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds1!=0){
                                        if (n_ds1<pList.size()){
                                            
                                        }
                                        else{
                                            n_ds1=pList.size();
                                        }
                                    }
                                    else{
                                        n_ds1=pList.size();
                                    }
                                    readMode_ds1="p";
                                    p01_p.setText(next_pFile);
                                    String[] splatt = path_ds1.split("\\\\");
                                    datasetName_ds1= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile; fl3_ds1=datasetName_ds1;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds1 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    p01_c.setText(next_cFile);
                                    String[] splatt = path_ds1.split("\\\\");
                                    datasetName_ds1= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }

                        }
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                }
                else if (readMode_ds1.equals("c")){    //Read _c txt file
                    types_ds1="c";
                    String fileName_c = filepath;
                    try {
                        File x_c = new File(fileName_c);
                        Scanner sc = new Scanner(x_c);
                        while(sc.hasNextLine()) {
                            W_ds1 = Integer.parseInt(sc.nextLine());
                        }sc.close();

                        p01_c.setText(filepath);
                        String[] splat = path_ds1.split("\\\\");
                        datasetName_ds1= ((splat[splat.length-1]).split("\\_"))[0];
                        dir_ds1=""; fl3_ds1=datasetName_ds1;
                        for (int s=0;s<splat.length-1;s++){
                            dir_ds1+=splat[s]+"\\";
                        }
                        String next_pFile=dir_ds1+datasetName_ds1+"_p.txt";
                        String next_wFile=dir_ds1+datasetName_ds1+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){

                        }
                        boolean checkType_p=false; 
                        boolean checkType_w=false;
                        if(new File(next_pFile).exists()){
                            checkType_p=true;
                            ArrayList<Integer> pList = new ArrayList<>(); 
                            String fileName_p = next_pFile;
                            try {
                                File x_p = new File(fileName_p);
                                Scanner sp = new Scanner(x_p);
                                while(sp.hasNextLine()) {
                                    pList.add(Integer.parseInt((sp.nextLine().trim())));
                                }sp.close();
                                v_ds1 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds1!=0){
                                    if (n_ds1<pList.size()){
                                        
                                    }
                                    else{
                                        n_ds1=pList.size();
                                    }
                                }
                                else{
                                    n_ds1=pList.size();
                                }
                                readMode_ds1="p";
                                fl1_ds1=datasetName_ds1;
                                p01_p.setText(next_pFile);
                                String[] splatt = path_ds1.split("\\\\");
                                datasetName_ds1= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(new File(next_wFile).exists()){
                            checkType_w=true;
                            ArrayList<Integer> wList = new ArrayList<>(); 
                            String fileName_w = next_wFile;
                            try {
                                File x_w = new File(fileName_w);
                                Scanner sw = new Scanner(x_w);
                                while(sw.hasNextLine()) {
                                    wList.add(Integer.parseInt((sw.nextLine().trim())));
                                }sw.close();
                                w_ds1 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds1!=0){
                                    if (n_ds1<wList.size()){
                                        
                                    }
                                    else{
                                        n_ds1=wList.size();
                                    }
                                }
                                else{
                                    n_ds1=wList.size();
                                }
                                readMode_ds1="w";
                                fl2_ds1=datasetName_ds1;
                                p01_w.setText(next_wFile);
                                String[] splatt = path_ds1.split("\\\\");
                                datasetName_ds1= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(checkType_w==false && checkType_p==false && !fl3_ds1.equals(" ")){
                            only_c_data_ds1=true;
                        }
                        
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                    }
                    batchOpenTXTagain_ds1=true;
                    if (!(fl1_ds1.equals(fl2_ds1) && fl2_ds1.equals(fl3_ds1) && fl3_ds1.equals(fl1_ds1))){
                        canSTART_ds1=false;

                    }
                    else{
                        batchOpenTXTagain_ds1=false;
                    }
                }
                
                if((fl1_ds1.equals(fl2_ds1) && fl2_ds1.equals(fl3_ds1) && fl3_ds1.equals(fl1_ds1))){
                    canSTART_ds1=true;
                }
                
            }
            
            else if(the_dataset_is.equals("p02")){
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files only","txt");
                JFileChooser filechooser = new JFileChooser();
                filechooser.setAcceptAllFileFilterUsed(false);
                if(readMode_ds2.equals("p")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p02_p Profit (p) (*.TXT)",
                            "02_p", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                if(readMode_ds2.equals("w")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p02_w Weight (w) (*.TXT)",
                            "02_w", 31 * Customs.ExtensionFileFilter.MB)
                    ); 
                }
                if(readMode_ds2.equals("c")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p02_c Capacity (c) (*.TXT)",
                            "02_c", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                filechooser.addChoosableFileFilter(filter);
                int i = filechooser.showOpenDialog(null);
                if (i == JFileChooser.APPROVE_OPTION) {
                    if (v_ds2!=null || w_ds2!=null){
                        String next_pFile=dir_ds2+datasetName_ds2+"_p.txt";
                        String next_wFile=dir_ds2+datasetName_ds2+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){
                            n_ds2=0;
                        }
                    }
                    File f = filechooser.getSelectedFile();
                    String filepath = f.getPath();
                    path_ds2 = filepath; batchOpenTXTagain_ds2=false;
                    if (readMode_ds2.equals("p")){ //Read _p txt file
                        types_ds2="p";
                        if (v_ds2!=null || w_ds2!=null){
                            
                        }
                        ArrayList<Integer> pList = new ArrayList<>();
                        String fileName_p = filepath;
                        try {
                            File x_p = new File(fileName_p);
                            Scanner sp = new Scanner(x_p);
                            while(sp.hasNextLine()) {
                                pList.add(Integer.parseInt((sp.nextLine().trim())));
                            }sp.close();
                            v_ds2 = pList.stream().mapToInt(ii -> ii).toArray(); //all the profit values
                            if(n_ds2!=0){
                                if (n_ds2<pList.size()){
                                    
                                }
                            }
                            else{
                                n_ds2=pList.size();
                            }
                            p02_p.setText(filepath);

                            String[] splat = path_ds2.split("\\\\");
                            datasetName_ds2= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds2=""; fl1_ds2=datasetName_ds2;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds2+=splat[s]+"\\";
                            }
                            String next_wFile=dir_ds2+datasetName_ds2+"_w.txt";
                            String next_cFile=dir_ds2+datasetName_ds2+"_c.txt";
                            if(new File(next_wFile).exists() && new File(next_cFile).exists()){

                            }
                            if(new File(next_wFile).exists()){
                                ArrayList<Integer> wList = new ArrayList<>(); 
                                String fileName_w = next_wFile;
                                try {
                                    File x_w = new File(fileName_w);
                                    Scanner sw = new Scanner(x_w);
                                    while(sw.hasNextLine()) {
                                        wList.add(Integer.parseInt((sw.nextLine().trim())));
                                    }sw.close();
                                    w_ds2 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds2!=0){
                                        if (n_ds2<wList.size()){
                                            
                                        }
                                    }
                                    else{
                                        n_ds2=wList.size();
                                    }
                                    readMode_ds2="w";
                                    fl2_ds2=datasetName_ds2;
                                    p02_w.setText(next_wFile);
                                    String[] splatt = path_ds2.split("\\\\");
                                    datasetName_ds2= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds2 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    fl3_ds2=datasetName_ds2;
                                    p02_c.setText(next_cFile);
                                    String[] splatt = path_ds2.split("\\\\");
                                    datasetName_ds2= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }


                        }
                        catch (FileNotFoundException e) {

                        }
                    }
                    else if (readMode_ds2.equals("w")){ //Read _w txt file
                        if (v_ds2!=null || w_ds2!=null){
                            
                        }
                        types_ds2="w"; fl2_ds2=datasetName_ds2;
                        ArrayList<Integer> wList = new ArrayList<>(); 
                        String fileName_w = filepath;
                        try {
                            File x_w = new File(fileName_w);
                            Scanner sw = new Scanner(x_w);
                            while(sw.hasNextLine()) {
                                wList.add(Integer.parseInt((sw.nextLine().trim())));
                            }sw.close();
                            w_ds2 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                            if(n_ds2!=0){
                                if (n_ds2<wList.size()){
                                    
                                }
                                else{
                                    n_ds2=wList.size();
                                }
                            }
                            else{
                                n_ds2=wList.size();
                            }

                            p02_w.setText(filepath);
                            String[] splat = path_ds2.split("\\\\");
                            datasetName_ds2= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds2="";fl2_ds2=datasetName_ds2;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds2+=splat[s]+"\\";
                            }
                            String next_pFile=dir_ds2+datasetName_ds2+"_p.txt";
                            String next_cFile=dir_ds2+datasetName_ds2+"_c.txt";
                            if(new File(next_pFile).exists() && new File(next_cFile).exists()){

                            }
                            if(new File(next_pFile).exists()){
                                ArrayList<Integer> pList = new ArrayList<>(); 
                                String fileName_p = next_pFile; fl1_ds2=datasetName_ds2;
                                try {
                                    File x_p = new File(fileName_p);
                                    Scanner sp = new Scanner(x_p);
                                    while(sp.hasNextLine()) {
                                        pList.add(Integer.parseInt((sp.nextLine().trim())));
                                    }sp.close();
                                    v_ds2 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds2!=0){
                                        if (n_ds2<pList.size()){
                                            
                                        }
                                        else{
                                            n_ds2=pList.size();
                                        }
                                    }
                                    else{
                                        n_ds2=pList.size();
                                    }
                                    readMode_ds2="p";
                                    p02_p.setText(next_pFile);
                                    String[] splatt = path_ds2.split("\\\\");
                                    datasetName_ds2= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile; fl3_ds2=datasetName_ds2;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds2 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    p02_c.setText(next_cFile);
                                    String[] splatt = path_ds2.split("\\\\");
                                    datasetName_ds2= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }

                        }
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                }
                else if (readMode_ds2.equals("c")){    //Read _c txt file
                    types_ds2="c";
                    String fileName_c = filepath;
                    try {
                        File x_c = new File(fileName_c);
                        Scanner sc = new Scanner(x_c);
                        while(sc.hasNextLine()) {
                            W_ds2 = Integer.parseInt(sc.nextLine());
                        }sc.close();

                        p02_c.setText(filepath);
                        String[] splat = path_ds2.split("\\\\");
                        datasetName_ds2= ((splat[splat.length-1]).split("\\_"))[0];
                        dir_ds2=""; fl3_ds2=datasetName_ds2;
                        for (int s=0;s<splat.length-1;s++){
                            dir_ds2+=splat[s]+"\\";
                        }
                        String next_pFile=dir_ds2+datasetName_ds2+"_p.txt";
                        String next_wFile=dir_ds2+datasetName_ds2+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){

                        }
                        boolean checkType_p=false; 
                        boolean checkType_w=false;
                        if(new File(next_pFile).exists()){
                            checkType_p=true;
                            ArrayList<Integer> pList = new ArrayList<>(); 
                            String fileName_p = next_pFile;
                            try {
                                File x_p = new File(fileName_p);
                                Scanner sp = new Scanner(x_p);
                                while(sp.hasNextLine()) {
                                    pList.add(Integer.parseInt((sp.nextLine().trim())));
                                }sp.close();
                                v_ds2 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds2!=0){
                                    if (n_ds2<pList.size()){
                                        
                                    }
                                    else{
                                        n_ds2=pList.size();
                                    }
                                }
                                else{
                                    n_ds2=pList.size();
                                }
                                readMode_ds2="p";
                                fl1_ds2=datasetName_ds2;
                                p02_p.setText(next_pFile);
                                String[] splatt = path_ds2.split("\\\\");
                                datasetName_ds2= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(new File(next_wFile).exists()){
                            checkType_w=true;
                            ArrayList<Integer> wList = new ArrayList<>(); 
                            String fileName_w = next_wFile;
                            try {
                                File x_w = new File(fileName_w);
                                Scanner sw = new Scanner(x_w);
                                while(sw.hasNextLine()) {
                                    wList.add(Integer.parseInt((sw.nextLine().trim())));
                                }sw.close();
                                w_ds2 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds2!=0){
                                    if (n_ds2<wList.size()){
                                        
                                    }
                                    else{
                                        n_ds2=wList.size();
                                    }
                                }
                                else{
                                    n_ds2=wList.size();
                                }
                                readMode_ds2="w";
                                fl2_ds2=datasetName_ds2;
                                p02_w.setText(next_wFile);
                                String[] splatt = path_ds2.split("\\\\");
                                datasetName_ds2= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(checkType_w==false && checkType_p==false && !fl3_ds2.equals(" ")){
                            only_c_data_ds2=true;
                        }
                        
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                }
                batchOpenTXTagain_ds2=true;
                if (!(fl1_ds2.equals(fl2_ds2) && fl2_ds2.equals(fl3_ds2) && fl3_ds2.equals(fl1_ds2))){
                    canSTART_ds2=false;

                }
                else{
                    batchOpenTXTagain_ds2=false;
                }
                }
                if((fl1_ds2.equals(fl2_ds2) && fl2_ds2.equals(fl3_ds2) && fl3_ds2.equals(fl1_ds2))){
                    canSTART_ds2=true;
                }
            }
            else if(the_dataset_is.equals("p03")){
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files only","txt");
                JFileChooser filechooser = new JFileChooser();
                filechooser.setAcceptAllFileFilterUsed(false);
                if(readMode_ds3.equals("p")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p03_p Profit (p) (*.TXT)",
                            "03_p", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                if(readMode_ds3.equals("w")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p03_w Weight (w) (*.TXT)",
                            "03_w", 31 * Customs.ExtensionFileFilter.MB)
                    ); 
                }
                if(readMode_ds3.equals("c")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p03_c Capacity (c) (*.TXT)",
                            "03_c", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                filechooser.addChoosableFileFilter(filter);
                int i = filechooser.showOpenDialog(null);
                if (i == JFileChooser.APPROVE_OPTION) {
                    if (v_ds3!=null || w_ds3!=null){
                        String next_pFile=dir_ds3+datasetName_ds3+"_p.txt";
                        String next_wFile=dir_ds3+datasetName_ds3+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){
                            
                        }
                    }
                    File f = filechooser.getSelectedFile();
                    String filepath = f.getPath();
                    path_ds3 = filepath; batchOpenTXTagain_ds3=false;
                    if (readMode_ds3.equals("p")){ //Read _p txt file
                        types_ds3="p";
                        if (v_ds3!=null || w_ds3!=null){
                            
                        }
                        ArrayList<Integer> pList = new ArrayList<>();
                        String fileName_p = filepath;
                        try {
                            File x_p = new File(fileName_p);
                            Scanner sp = new Scanner(x_p);
                            while(sp.hasNextLine()) {
                                pList.add(Integer.parseInt((sp.nextLine().trim())));
                            }sp.close();
                            v_ds3 = pList.stream().mapToInt(ii -> ii).toArray(); //all the profit values
                            if(n_ds3!=0){
                                if (n_ds3<pList.size()){
                                    
                                }
                            }
                            else{
                                n_ds3=pList.size();
                            }
                            p03_p.setText(filepath);

                            String[] splat = path_ds3.split("\\\\");
                            datasetName_ds3= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds3=""; fl1_ds3=datasetName_ds3;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds3+=splat[s]+"\\";
                            }
                            String next_wFile=dir_ds3+datasetName_ds3+"_w.txt";
                            String next_cFile=dir_ds3+datasetName_ds3+"_c.txt";
                            if(new File(next_wFile).exists() && new File(next_cFile).exists()){
                                
                            }
                            if(new File(next_wFile).exists()){
                                ArrayList<Integer> wList = new ArrayList<>(); 
                                String fileName_w = next_wFile;
                                try {
                                    File x_w = new File(fileName_w);
                                    Scanner sw = new Scanner(x_w);
                                    while(sw.hasNextLine()) {
                                        wList.add(Integer.parseInt((sw.nextLine().trim())));
                                    }sw.close();
                                    w_ds3 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds3!=0){
                                        if (n_ds3<wList.size()){
                                            
                                        }
                                    }
                                    else{
                                        n_ds3=wList.size();
                                    }
                                    readMode_ds3="w";
                                    fl2_ds3=datasetName_ds3;
                                    p03_w.setText(next_wFile);
                                    String[] splatt = path_ds3.split("\\\\");
                                    datasetName_ds3= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds3 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    fl3_ds3=datasetName_ds3;
                                    p03_c.setText(next_cFile);
                                    String[] splatt = path_ds3.split("\\\\");
                                    datasetName_ds3= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }


                        }
                        catch (FileNotFoundException e) {

                        }
                    }
                    else if (readMode_ds3.equals("w")){ //Read _w txt file
                        if (v_ds3!=null || w_ds3!=null){
                        
                        }
                        types_ds3="w"; fl2_ds3=datasetName_ds3;
                        ArrayList<Integer> wList = new ArrayList<>(); 
                        String fileName_w = filepath;
                        try {
                            File x_w = new File(fileName_w);
                            Scanner sw = new Scanner(x_w);
                            while(sw.hasNextLine()) {
                                wList.add(Integer.parseInt((sw.nextLine().trim())));
                            }sw.close();
                            w_ds3 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                            if(n_ds3!=0){
                                if (n_ds3<wList.size()){
                                    
                                }
                                else{
                                    n_ds3=wList.size();
                                }
                            }
                            else{
                                n_ds3=wList.size();
                            }

                            p03_w.setText(filepath);
                            String[] splat = path_ds3.split("\\\\");
                            datasetName_ds3= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds3="";fl2_ds3=datasetName_ds3;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds3+=splat[s]+"\\";
                            }
                            String next_pFile=dir_ds3+datasetName_ds3+"_p.txt";
                            String next_cFile=dir_ds3+datasetName_ds3+"_c.txt";
                            if(new File(next_pFile).exists() && new File(next_cFile).exists()){

                            }
                            if(new File(next_pFile).exists()){
                                ArrayList<Integer> pList = new ArrayList<>(); 
                                String fileName_p = next_pFile; fl1_ds3=datasetName_ds3;
                                try {
                                    File x_p = new File(fileName_p);
                                    Scanner sp = new Scanner(x_p);
                                    while(sp.hasNextLine()) {
                                        pList.add(Integer.parseInt((sp.nextLine().trim())));
                                    }sp.close();
                                    v_ds3 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds3!=0){
                                        if (n_ds3<pList.size()){
                                            n_ds3=n_ds3; //No change to no. of items
                                        }
                                        else{
                                            n_ds3=pList.size();
                                        }
                                    }
                                    else{
                                        n_ds3=pList.size();
                                    }
                                    readMode_ds3="p";
                                    p03_p.setText(next_pFile);
                                    String[] splatt = path_ds3.split("\\\\");
                                    datasetName_ds3= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile; fl3_ds3=datasetName_ds3;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds3 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    p03_c.setText(next_cFile);
                                    String[] splatt = path_ds3.split("\\\\");
                                    datasetName_ds3= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }

                        }
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                }
                else if (readMode_ds3.equals("c")){    //Read _c txt file
                    types_ds3="c";
                    String fileName_c = filepath;
                    try {
                        File x_c = new File(fileName_c);
                        Scanner sc = new Scanner(x_c);
                        while(sc.hasNextLine()) {
                            W_ds3 = Integer.parseInt(sc.nextLine());
                        }sc.close();

                        p03_c.setText(filepath);
                        String[] splat = path_ds3.split("\\\\");
                        datasetName_ds3= ((splat[splat.length-1]).split("\\_"))[0];
                        dir_ds3=""; fl3_ds3=datasetName_ds3;
                        for (int s=0;s<splat.length-1;s++){
                            dir_ds3+=splat[s]+"\\";
                        }
                        String next_pFile=dir_ds3+datasetName_ds3+"_p.txt";
                        String next_wFile=dir_ds3+datasetName_ds3+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){

                        }
                        boolean checkType_p=false; 
                        boolean checkType_w=false;
                        if(new File(next_pFile).exists()){
                            checkType_p=true;
                            ArrayList<Integer> pList = new ArrayList<>(); 
                            String fileName_p = next_pFile;
                            try {
                                File x_p = new File(fileName_p);
                                Scanner sp = new Scanner(x_p);
                                while(sp.hasNextLine()) {
                                    pList.add(Integer.parseInt((sp.nextLine().trim())));
                                }sp.close();
                                v_ds3 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds3!=0){
                                    if (n_ds3<pList.size()){
                                        
                                    }
                                    else{
                                        n_ds3=pList.size();
                                    }
                                }
                                else{
                                    n_ds3=pList.size();
                                }
                                readMode_ds3="p";
                                fl1_ds3=datasetName_ds3;
                                p03_p.setText(next_pFile);
                                String[] splatt = path_ds3.split("\\\\");
                                datasetName_ds3= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(new File(next_wFile).exists()){
                            checkType_w=true;
                            ArrayList<Integer> wList = new ArrayList<>(); 
                            String fileName_w = next_wFile;
                            try {
                                File x_w = new File(fileName_w);
                                Scanner sw = new Scanner(x_w);
                                while(sw.hasNextLine()) {
                                    wList.add(Integer.parseInt((sw.nextLine().trim())));
                                }sw.close();
                                w_ds3 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds3!=0){
                                    if (n_ds3<wList.size()){
                                       
                                    }
                                    else{
                                        n_ds3=wList.size();
                                    }
                                }
                                else{
                                    n_ds3=wList.size();
                                }
                                readMode_ds3="w";
                                fl2_ds3=datasetName_ds3;
                                p03_w.setText(next_wFile);
                                String[] splatt = path_ds3.split("\\\\");
                                datasetName_ds3= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(checkType_w==false && checkType_p==false && !fl3_ds3.equals(" ")){
                            only_c_data_ds3=true;
                        }
                        
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                    }
                    batchOpenTXTagain_ds3=true;
                    if (!(fl1_ds3.equals(fl2_ds3) && fl2_ds3.equals(fl3_ds3) && fl3_ds3.equals(fl1_ds3))){
                        canSTART_ds3=false;

                    }
                    else{
                        batchOpenTXTagain_ds3=false;
                    }
                }
                if((fl1_ds3.equals(fl2_ds3) && fl2_ds3.equals(fl3_ds3) && fl3_ds3.equals(fl1_ds3))){
                    canSTART_ds3=true;
                }
            }
            else if(the_dataset_is.equals("p04")){
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files only","txt");
                JFileChooser filechooser = new JFileChooser();
                filechooser.setAcceptAllFileFilterUsed(false);
                if(readMode_ds4.equals("p")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p04_p Profit (p) (*.TXT)",
                            "04_p", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                if(readMode_ds4.equals("w")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p04_w Weight (w) (*.TXT)",
                            "04_w", 31 * Customs.ExtensionFileFilter.MB)
                    ); 
                }
                if(readMode_ds4.equals("c")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p04_c Capacity (c) (*.TXT)",
                            "04_c", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                filechooser.addChoosableFileFilter(filter);
                int i = filechooser.showOpenDialog(null);
                if (i == JFileChooser.APPROVE_OPTION) {
                    if (v_ds4!=null || w_ds4!=null){
                        String next_pFile=dir_ds4+datasetName_ds4+"_p.txt";
                        String next_wFile=dir_ds4+datasetName_ds4+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){
                            
                        }
                    }
                    File f = filechooser.getSelectedFile();
                    String filepath = f.getPath();
                    path_ds4 = filepath; batchOpenTXTagain_ds4=false;
                    if (readMode_ds4.equals("p")){ //Read _p txt file
                        types_ds4="p";
                        if (v_ds4!=null || w_ds4!=null){
                            
                        }
                        ArrayList<Integer> pList = new ArrayList<>();
                        String fileName_p = filepath;
                        try {
                            File x_p = new File(fileName_p);
                            Scanner sp = new Scanner(x_p);
                            while(sp.hasNextLine()) {
                                pList.add(Integer.parseInt((sp.nextLine().trim())));
                            }sp.close();
                            v_ds4 = pList.stream().mapToInt(ii -> ii).toArray(); //all the profit values
                            if(n_ds4!=0){
                                if (n_ds4<pList.size()){
                                    
                                }
                            }
                            else{
                                n_ds4=pList.size();
                            }
                            p04_p.setText(filepath);

                            String[] splat = path_ds4.split("\\\\");
                            datasetName_ds4= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds4=""; fl1_ds4=datasetName_ds4;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds4+=splat[s]+"\\";
                            }
                            String next_wFile=dir_ds4+datasetName_ds4+"_w.txt";
                            String next_cFile=dir_ds4+datasetName_ds4+"_c.txt";
                            if(new File(next_wFile).exists() && new File(next_cFile).exists()){
                                
                            }
                            if(new File(next_wFile).exists()){
                                ArrayList<Integer> wList = new ArrayList<>(); 
                                String fileName_w = next_wFile;
                                try {
                                    File x_w = new File(fileName_w);
                                    Scanner sw = new Scanner(x_w);
                                    while(sw.hasNextLine()) {
                                        wList.add(Integer.parseInt((sw.nextLine().trim())));
                                    }sw.close();
                                    w_ds4 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds4!=0){
                                        if (n_ds4<wList.size()){
                                            
                                        }
                                    }
                                    else{
                                        n_ds4=wList.size();
                                    }
                                    readMode_ds4="w";
                                    fl2_ds4=datasetName_ds4;
                                    p04_w.setText(next_wFile);
                                    String[] splatt = path_ds4.split("\\\\");
                                    datasetName_ds4= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds4 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    fl3_ds4=datasetName_ds4;
                                    p04_c.setText(next_cFile);
                                    String[] splatt = path_ds4.split("\\\\");
                                    datasetName_ds4= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }


                        }
                        catch (FileNotFoundException e) {

                        }
                    }
                    else if (readMode_ds4.equals("w")){ //Read _w txt file
                        if (v_ds4!=null || w_ds4!=null){
                        
                        }
                        types_ds4="w"; fl2_ds4=datasetName_ds4;
                        ArrayList<Integer> wList = new ArrayList<>(); 
                        String fileName_w = filepath;
                        try {
                            File x_w = new File(fileName_w);
                            Scanner sw = new Scanner(x_w);
                            while(sw.hasNextLine()) {
                                wList.add(Integer.parseInt((sw.nextLine().trim())));
                            }sw.close();
                            w_ds4 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                            if(n_ds4!=0){
                                if (n_ds4<wList.size()){
                                    
                                }
                                else{
                                    n_ds4=wList.size();
                                }
                            }
                            else{
                                n_ds4=wList.size();
                            }

                            p04_w.setText(filepath);
                            String[] splat = path_ds4.split("\\\\");
                            datasetName_ds4= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds4="";fl2_ds4=datasetName_ds4;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds4+=splat[s]+"\\";
                            }
                            String next_pFile=dir_ds4+datasetName_ds4+"_p.txt";
                            String next_cFile=dir_ds4+datasetName_ds4+"_c.txt";
                            if(new File(next_pFile).exists() && new File(next_cFile).exists()){

                            }
                            if(new File(next_pFile).exists()){
                                ArrayList<Integer> pList = new ArrayList<>(); 
                                String fileName_p = next_pFile; fl1_ds4=datasetName_ds4;
                                try {
                                    File x_p = new File(fileName_p);
                                    Scanner sp = new Scanner(x_p);
                                    while(sp.hasNextLine()) {
                                        pList.add(Integer.parseInt((sp.nextLine().trim())));
                                    }sp.close();
                                    v_ds4 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds4!=0){
                                        if (n_ds4<pList.size()){
                                            
                                        }
                                        else{
                                            n_ds4=pList.size();
                                        }
                                    }
                                    else{
                                        n_ds4=pList.size();
                                    }
                                    readMode_ds4="p";
                                    p04_p.setText(next_pFile);
                                    String[] splatt = path_ds4.split("\\\\");
                                    datasetName_ds4= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile; fl3_ds4=datasetName_ds4;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds4 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    p04_c.setText(next_cFile);
                                    String[] splatt = path_ds4.split("\\\\");
                                    datasetName_ds4= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }

                        }
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                }
                else if (readMode_ds4.equals("c")){    //Read _c txt file
                    types_ds4="c";
                    String fileName_c = filepath;
                    try {
                        File x_c = new File(fileName_c);
                        Scanner sc = new Scanner(x_c);
                        while(sc.hasNextLine()) {
                            W_ds4 = Integer.parseInt(sc.nextLine());
                        }sc.close();

                        p04_c.setText(filepath);
                        String[] splat = path_ds4.split("\\\\");
                        datasetName_ds4= ((splat[splat.length-1]).split("\\_"))[0];
                        dir_ds4=""; fl3_ds4=datasetName_ds4;
                        for (int s=0;s<splat.length-1;s++){
                            dir_ds4+=splat[s]+"\\";
                        }
                        String next_pFile=dir_ds4+datasetName_ds4+"_p.txt";
                        String next_wFile=dir_ds4+datasetName_ds4+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){

                        }
                        boolean checkType_p=false; 
                        boolean checkType_w=false;
                        if(new File(next_pFile).exists()){
                            checkType_p=true;
                            ArrayList<Integer> pList = new ArrayList<>(); 
                            String fileName_p = next_pFile;
                            try {
                                File x_p = new File(fileName_p);
                                Scanner sp = new Scanner(x_p);
                                while(sp.hasNextLine()) {
                                    pList.add(Integer.parseInt((sp.nextLine().trim())));
                                }sp.close();
                                v_ds4 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds4!=0){
                                    if (n_ds4<pList.size()){
                                        
                                    }
                                    else{
                                        n_ds4=pList.size();
                                    }
                                }
                                else{
                                    n_ds4=pList.size();
                                }
                                readMode_ds4="p";
                                fl1_ds4=datasetName_ds4;
                                p04_p.setText(next_pFile);
                                String[] splatt = path_ds4.split("\\\\");
                                datasetName_ds4= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(new File(next_wFile).exists()){
                            checkType_w=true;
                            ArrayList<Integer> wList = new ArrayList<>(); 
                            String fileName_w = next_wFile;
                            try {
                                File x_w = new File(fileName_w);
                                Scanner sw = new Scanner(x_w);
                                while(sw.hasNextLine()) {
                                    wList.add(Integer.parseInt((sw.nextLine().trim())));
                                }sw.close();
                                w_ds4 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds4!=0){
                                    if (n_ds4<wList.size()){
                                        
                                    }
                                    else{
                                        n_ds4=wList.size();
                                    }
                                }
                                else{
                                    n_ds4=wList.size();
                                }
                                readMode_ds4="w";
                                fl2_ds4=datasetName_ds4;
                                p04_w.setText(next_wFile);
                                String[] splatt = path_ds4.split("\\\\");
                                datasetName_ds4= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(checkType_w==false && checkType_p==false && !fl3_ds4.equals(" ")){
                            only_c_data_ds4=true;
                        }
                        
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                }
                batchOpenTXTagain_ds4=true;
                if (!(fl1_ds4.equals(fl2_ds4) && fl2_ds4.equals(fl3_ds4) && fl3_ds4.equals(fl1_ds4))){
                    canSTART_ds4=false;

                }
                else{
                    batchOpenTXTagain_ds4=false;
                }
                }
                if((fl1_ds4.equals(fl2_ds4) && fl2_ds4.equals(fl3_ds4) && fl3_ds4.equals(fl1_ds4))){
                    canSTART_ds4=true;
                }
            }
            else if(the_dataset_is.equals("p05")){
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files only","txt");
                JFileChooser filechooser = new JFileChooser();
                filechooser.setAcceptAllFileFilterUsed(false);
                if(readMode_ds5.equals("p")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p05_p Profit (p) (*.TXT)",
                            "05_p", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                if(readMode_ds5.equals("w")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p05_w Weight (w) (*.TXT)",
                            "05_w", 31 * Customs.ExtensionFileFilter.MB)
                    ); 
                }
                if(readMode_ds5.equals("c")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p05_c Capacity (c) (*.TXT)",
                            "05_c", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                filechooser.addChoosableFileFilter(filter);
                int i = filechooser.showOpenDialog(null);
                if (i == JFileChooser.APPROVE_OPTION) {
                    if (v_ds5!=null || w_ds5!=null){
                        String next_pFile=dir_ds5+datasetName_ds5+"_p.txt";
                        String next_wFile=dir_ds5+datasetName_ds5+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){
                            
                        }
                    }
                    File f = filechooser.getSelectedFile();
                    String filepath = f.getPath();
                    path_ds5 = filepath; batchOpenTXTagain_ds5=false;
                    if (readMode_ds5.equals("p")){ //Read _p txt file
                        types_ds5="p";
                        if (v_ds5!=null || w_ds5!=null){
                            
                        }
                        ArrayList<Integer> pList = new ArrayList<>();
                        String fileName_p = filepath;
                        try {
                            File x_p = new File(fileName_p);
                            Scanner sp = new Scanner(x_p);
                            while(sp.hasNextLine()) {
                                pList.add(Integer.parseInt((sp.nextLine().trim())));
                            }sp.close();
                            v_ds5 = pList.stream().mapToInt(ii -> ii).toArray(); //all the profit values
                            if(n_ds5!=0){
                                if (n_ds5<pList.size()){
                                    
                                }
                            }
                            else{
                                n_ds5=pList.size();
                            }
                            p05_p.setText(filepath);

                            String[] splat = path_ds5.split("\\\\");
                            datasetName_ds5= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds5=""; fl1_ds5=datasetName_ds5;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds5+=splat[s]+"\\";
                            }
                            String next_wFile=dir_ds5+datasetName_ds5+"_w.txt";
                            String next_cFile=dir_ds5+datasetName_ds5+"_c.txt";
                            if(new File(next_wFile).exists() && new File(next_cFile).exists()){
                                
                            }
                            if(new File(next_wFile).exists()){
                                ArrayList<Integer> wList = new ArrayList<>(); 
                                String fileName_w = next_wFile;
                                try {
                                    File x_w = new File(fileName_w);
                                    Scanner sw = new Scanner(x_w);
                                    while(sw.hasNextLine()) {
                                        wList.add(Integer.parseInt((sw.nextLine().trim())));
                                    }sw.close();
                                    w_ds5 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds5!=0){
                                        if (n_ds5<wList.size()){
                                            
                                        }
                                    }
                                    else{
                                        n_ds5=wList.size();
                                    }
                                    readMode_ds5="w";
                                    fl2_ds5=datasetName_ds5;
                                    p05_w.setText(next_wFile);
                                    String[] splatt = path_ds5.split("\\\\");
                                    datasetName_ds5= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds5 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    fl3_ds5=datasetName_ds5;
                                    p05_c.setText(next_cFile);
                                    String[] splatt = path_ds5.split("\\\\");
                                    datasetName_ds5= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }


                        }
                        catch (FileNotFoundException e) {

                        }
                    }
                    else if (readMode_ds5.equals("w")){ //Read _w txt file
                        if (v_ds5!=null || w_ds5!=null){
                        
                        }
                        types_ds5="w"; fl2_ds5=datasetName_ds5;
                        ArrayList<Integer> wList = new ArrayList<>(); 
                        String fileName_w = filepath;
                        try {
                            File x_w = new File(fileName_w);
                            Scanner sw = new Scanner(x_w);
                            while(sw.hasNextLine()) {
                                wList.add(Integer.parseInt((sw.nextLine().trim())));
                            }sw.close();
                            w_ds5 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                            if(n_ds5!=0){
                                if (n_ds5<wList.size()){
                                    
                                }
                                else{
                                    n_ds5=wList.size();
                                }
                            }
                            else{
                                n_ds5=wList.size();
                            }

                            p05_w.setText(filepath);
                            String[] splat = path_ds5.split("\\\\");
                            datasetName_ds5= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds5="";fl2_ds5=datasetName_ds5;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds5+=splat[s]+"\\";
                            }
                            String next_pFile=dir_ds5+datasetName_ds5+"_p.txt";
                            String next_cFile=dir_ds5+datasetName_ds5+"_c.txt";
                            if(new File(next_pFile).exists() && new File(next_cFile).exists()){

                            }
                            if(new File(next_pFile).exists()){
                                ArrayList<Integer> pList = new ArrayList<>(); 
                                String fileName_p = next_pFile; fl1_ds5=datasetName_ds5;
                                try {
                                    File x_p = new File(fileName_p);
                                    Scanner sp = new Scanner(x_p);
                                    while(sp.hasNextLine()) {
                                        pList.add(Integer.parseInt((sp.nextLine().trim())));
                                    }sp.close();
                                    v_ds5 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds5!=0){
                                        if (n_ds5<pList.size()){
                                            
                                        }
                                        else{
                                            n_ds5=pList.size();
                                        }
                                    }
                                    else{
                                        n_ds5=pList.size();
                                    }
                                    readMode_ds5="p";
                                    p05_p.setText(next_pFile);
                                    String[] splatt = path_ds5.split("\\\\");
                                    datasetName_ds5= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile; fl3_ds5=datasetName_ds5;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds5 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    p05_c.setText(next_cFile);
                                    String[] splatt = path_ds5.split("\\\\");
                                    datasetName_ds5= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }

                        }
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                }
                else if (readMode_ds5.equals("c")){    //Read _c txt file
                    types_ds5="c";
                    String fileName_c = filepath;
                    try {
                        File x_c = new File(fileName_c);
                        Scanner sc = new Scanner(x_c);
                        while(sc.hasNextLine()) {
                            W_ds5 = Integer.parseInt(sc.nextLine());
                        }sc.close();

                        p05_c.setText(filepath);
                        String[] splat = path_ds5.split("\\\\");
                        datasetName_ds5= ((splat[splat.length-1]).split("\\_"))[0];
                        dir_ds5=""; fl3_ds5=datasetName_ds5;
                        for (int s=0;s<splat.length-1;s++){
                            dir_ds5+=splat[s]+"\\";
                        }
                        String next_pFile=dir_ds5+datasetName_ds5+"_p.txt";
                        String next_wFile=dir_ds5+datasetName_ds5+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){

                        }
                        boolean checkType_p=false; 
                        boolean checkType_w=false;
                        if(new File(next_pFile).exists()){
                            checkType_p=true;
                            ArrayList<Integer> pList = new ArrayList<>(); 
                            String fileName_p = next_pFile;
                            try {
                                File x_p = new File(fileName_p);
                                Scanner sp = new Scanner(x_p);
                                while(sp.hasNextLine()) {
                                    pList.add(Integer.parseInt((sp.nextLine().trim())));
                                }sp.close();
                                v_ds5 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds5!=0){
                                    if (n_ds5<pList.size()){
                                        
                                    }
                                    else{
                                        n_ds5=pList.size();
                                    }
                                }
                                else{
                                    n_ds5=pList.size();
                                }
                                readMode_ds5="p";
                                fl1_ds5=datasetName_ds5;
                                p05_p.setText(next_pFile);
                                String[] splatt = path_ds5.split("\\\\");
                                datasetName_ds5= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(new File(next_wFile).exists()){
                            checkType_w=true;
                            ArrayList<Integer> wList = new ArrayList<>(); 
                            String fileName_w = next_wFile;
                            try {
                                File x_w = new File(fileName_w);
                                Scanner sw = new Scanner(x_w);
                                while(sw.hasNextLine()) {
                                    wList.add(Integer.parseInt((sw.nextLine().trim())));
                                }sw.close();
                                w_ds5 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds5!=0){
                                    if (n_ds5<wList.size()){
                                        
                                    }
                                    else{
                                        n_ds5=wList.size();
                                    }
                                }
                                else{
                                    n_ds5=wList.size();
                                }
                                readMode_ds5="w";
                                fl2_ds5=datasetName_ds5;
                                p05_w.setText(next_wFile);
                                String[] splatt = path_ds5.split("\\\\");
                                datasetName_ds5= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(checkType_w==false && checkType_p==false && !fl3_ds5.equals(" ")){
                            only_c_data_ds5=true;
                        }
                        
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                    }
                    batchOpenTXTagain_ds5=true;
                    if (!(fl1_ds5.equals(fl2_ds5) && fl2_ds5.equals(fl3_ds5) && fl3_ds5.equals(fl1_ds5))){
                        canSTART_ds5=false;

                    }
                    else{
                        batchOpenTXTagain_ds5=false;
                    }
                }//end of ds5
                if((fl1_ds5.equals(fl2_ds5) && fl2_ds5.equals(fl3_ds5) && fl3_ds5.equals(fl1_ds5))){
                    canSTART_ds5=true;
                }
            }
            else if(the_dataset_is.equals("p06")){
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files only","txt");
                JFileChooser filechooser = new JFileChooser();
                filechooser.setAcceptAllFileFilterUsed(false);
                if(readMode_ds6.equals("p")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p06_p Profit (p) (*.TXT)",
                            "06_p", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                if(readMode_ds6.equals("w")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p06_w Weight (w) (*.TXT)",
                            "06_w", 31 * Customs.ExtensionFileFilter.MB)
                    ); 
                }
                if(readMode_ds6.equals("c")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p06_c Capacity (c) (*.TXT)",
                            "06_c", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                filechooser.addChoosableFileFilter(filter);
                int i = filechooser.showOpenDialog(null);
                if (i == JFileChooser.APPROVE_OPTION) {
                    if (v_ds6!=null || w_ds6!=null){
                        String next_pFile=dir_ds6+datasetName_ds6+"_p.txt";
                        String next_wFile=dir_ds6+datasetName_ds6+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){
                            
                        }
                    }
                    File f = filechooser.getSelectedFile();
                    String filepath = f.getPath();
                    path_ds6 = filepath; batchOpenTXTagain_ds6=false;
                    if (readMode_ds6.equals("p")){ //Read _p txt file
                        types_ds6="p";
                        if (v_ds6!=null || w_ds6!=null){
                            
                        }
                        ArrayList<Integer> pList = new ArrayList<>();
                        String fileName_p = filepath;
                        try {
                            File x_p = new File(fileName_p);
                            Scanner sp = new Scanner(x_p);
                            while(sp.hasNextLine()) {
                                pList.add(Integer.parseInt((sp.nextLine().trim())));
                            }sp.close();
                            v_ds6 = pList.stream().mapToInt(ii -> ii).toArray(); //all the profit values
                            if(n_ds6!=0){
                                if (n_ds6<pList.size()){
                                    
                                }
                            }
                            else{
                                n_ds6=pList.size();
                            }
                            p06_p.setText(filepath);

                            String[] splat = path_ds6.split("\\\\");
                            datasetName_ds6= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds6=""; fl1_ds6=datasetName_ds6;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds6+=splat[s]+"\\";
                            }
                            String next_wFile=dir_ds6+datasetName_ds6+"_w.txt";
                            String next_cFile=dir_ds6+datasetName_ds6+"_c.txt";
                            if(new File(next_wFile).exists() && new File(next_cFile).exists()){
                                
                            }
                            if(new File(next_wFile).exists()){
                                ArrayList<Integer> wList = new ArrayList<>(); 
                                String fileName_w = next_wFile;
                                try {
                                    File x_w = new File(fileName_w);
                                    Scanner sw = new Scanner(x_w);
                                    while(sw.hasNextLine()) {
                                        wList.add(Integer.parseInt((sw.nextLine().trim())));
                                    }sw.close();
                                    w_ds6 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds6!=0){
                                        if (n_ds6<wList.size()){
                                            
                                        }
                                    }
                                    else{
                                        n_ds6=wList.size();
                                    }
                                    readMode_ds6="w";
                                    fl2_ds6=datasetName_ds6;
                                    p06_w.setText(next_wFile);
                                    String[] splatt = path_ds6.split("\\\\");
                                    datasetName_ds6= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds6 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    fl3_ds6=datasetName_ds6;
                                    p06_c.setText(next_cFile);
                                    String[] splatt = path_ds6.split("\\\\");
                                    datasetName_ds6= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }


                        }
                        catch (FileNotFoundException e) {

                        }
                    }
                    else if (readMode_ds6.equals("w")){ //Read _w txt file
                        if (v_ds6!=null || w_ds6!=null){
                        
                        }
                        types_ds6="w"; fl2_ds6=datasetName_ds6;
                        ArrayList<Integer> wList = new ArrayList<>(); 
                        String fileName_w = filepath;
                        try {
                            File x_w = new File(fileName_w);
                            Scanner sw = new Scanner(x_w);
                            while(sw.hasNextLine()) {
                                wList.add(Integer.parseInt((sw.nextLine().trim())));
                            }sw.close();
                            w_ds6 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                            if(n_ds6!=0){
                                if (n_ds6<wList.size()){
                                    
                                }
                                else{
                                    n_ds6=wList.size();
                                }
                            }
                            else{
                                n_ds6=wList.size();
                            }

                            p06_w.setText(filepath);
                            String[] splat = path_ds6.split("\\\\");
                            datasetName_ds6= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds6="";fl2_ds6=datasetName_ds6;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds6+=splat[s]+"\\";
                            }
                            String next_pFile=dir_ds6+datasetName_ds6+"_p.txt";
                            String next_cFile=dir_ds6+datasetName_ds6+"_c.txt";
                            if(new File(next_pFile).exists() && new File(next_cFile).exists()){

                            }
                            if(new File(next_pFile).exists()){
                                ArrayList<Integer> pList = new ArrayList<>(); 
                                String fileName_p = next_pFile; fl1_ds6=datasetName_ds6;
                                try {
                                    File x_p = new File(fileName_p);
                                    Scanner sp = new Scanner(x_p);
                                    while(sp.hasNextLine()) {
                                        pList.add(Integer.parseInt((sp.nextLine().trim())));
                                    }sp.close();
                                    v_ds6 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds6!=0){
                                        if (n_ds6<pList.size()){
                                            
                                        }
                                        else{
                                            n_ds6=pList.size();
                                        }
                                    }
                                    else{
                                        n_ds6=pList.size();
                                    }
                                    readMode_ds6="p";
                                    p06_p.setText(next_pFile);
                                    String[] splatt = path_ds6.split("\\\\");
                                    datasetName_ds6= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile; fl3_ds6=datasetName_ds6;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds6 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    p06_c.setText(next_cFile);
                                    String[] splatt = path_ds6.split("\\\\");
                                    datasetName_ds6= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }

                        }
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                }
                else if (readMode_ds6.equals("c")){    //Read _c txt file
                    types_ds6="c";
                    String fileName_c = filepath;
                    try {
                        File x_c = new File(fileName_c);
                        Scanner sc = new Scanner(x_c);
                        while(sc.hasNextLine()) {
                            W_ds6 = Integer.parseInt(sc.nextLine());
                        }sc.close();

                        p06_c.setText(filepath);
                        String[] splat = path_ds6.split("\\\\");
                        datasetName_ds6= ((splat[splat.length-1]).split("\\_"))[0];
                        dir_ds6=""; fl3_ds6=datasetName_ds6;
                        for (int s=0;s<splat.length-1;s++){
                            dir_ds6+=splat[s]+"\\";
                        }
                        String next_pFile=dir_ds6+datasetName_ds6+"_p.txt";
                        String next_wFile=dir_ds6+datasetName_ds6+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){

                        }
                        boolean checkType_p=false; 
                        boolean checkType_w=false;
                        if(new File(next_pFile).exists()){
                            checkType_p=true;
                            ArrayList<Integer> pList = new ArrayList<>(); 
                            String fileName_p = next_pFile;
                            try {
                                File x_p = new File(fileName_p);
                                Scanner sp = new Scanner(x_p);
                                while(sp.hasNextLine()) {
                                    pList.add(Integer.parseInt((sp.nextLine().trim())));
                                }sp.close();
                                v_ds6 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds6!=0){
                                    if (n_ds6<pList.size()){
                                        
                                    }
                                    else{
                                        n_ds6=pList.size();
                                    }
                                }
                                else{
                                    n_ds6=pList.size();
                                }
                                readMode_ds6="p";
                                fl1_ds6=datasetName_ds6;
                                p06_p.setText(next_pFile);
                                String[] splatt = path_ds6.split("\\\\");
                                datasetName_ds6= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(new File(next_wFile).exists()){
                            checkType_w=true;
                            ArrayList<Integer> wList = new ArrayList<>(); 
                            String fileName_w = next_wFile;
                            try {
                                File x_w = new File(fileName_w);
                                Scanner sw = new Scanner(x_w);
                                while(sw.hasNextLine()) {
                                    wList.add(Integer.parseInt((sw.nextLine().trim())));
                                }sw.close();
                                w_ds6 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds6!=0){
                                    if (n_ds6<wList.size()){
                                        
                                    }
                                    else{
                                        n_ds6=wList.size();
                                    }
                                }
                                else{
                                    n_ds6=wList.size();
                                }
                                readMode_ds6="w";
                                fl2_ds6=datasetName_ds6;
                                p06_w.setText(next_wFile);
                                String[] splatt = path_ds6.split("\\\\");
                                datasetName_ds6= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(checkType_w==false && checkType_p==false && !fl3_ds6.equals(" ")){
                            only_c_data_ds6=true;
                        }
                        
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                    }
                    batchOpenTXTagain_ds6=true;
                    if (!(fl1_ds6.equals(fl2_ds6) && fl2_ds6.equals(fl3_ds6) && fl3_ds6.equals(fl1_ds6))){
                        canSTART_ds6=false;

                    }
                    else{
                        batchOpenTXTagain_ds6=false;
                    }
                }//end of ds6
            if((fl1_ds6.equals(fl2_ds6) && fl2_ds6.equals(fl3_ds6) && fl3_ds6.equals(fl1_ds6))){
                    canSTART_ds6=true;
                }    
            //end of P06    end of ds6
            }
            else if(the_dataset_is.equals("p07")){
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files only","txt");
                JFileChooser filechooser = new JFileChooser();
                filechooser.setAcceptAllFileFilterUsed(false);
                if(readMode_ds7.equals("p")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p07_p Profit (p) (*.TXT)",
                            "07_p", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                if(readMode_ds7.equals("w")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p07_w Weight (w) (*.TXT)",
                            "07_w", 31 * Customs.ExtensionFileFilter.MB)
                    ); 
                }
                if(readMode_ds7.equals("c")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p07_c Capacity (c) (*.TXT)",
                            "07_c", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                filechooser.addChoosableFileFilter(filter);
                int i = filechooser.showOpenDialog(null);
                if (i == JFileChooser.APPROVE_OPTION) {
                    if (v_ds7!=null || w_ds7!=null){
                        String next_pFile=dir_ds7+datasetName_ds7+"_p.txt";
                        String next_wFile=dir_ds7+datasetName_ds7+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){
                            
                        }
                    }
                    File f = filechooser.getSelectedFile();
                    String filepath = f.getPath();
                    path_ds7 = filepath; batchOpenTXTagain_ds7=false;
                    if (readMode_ds7.equals("p")){ //Read _p txt file
                        types_ds7="p";
                        if (v_ds7!=null || w_ds7!=null){
                            
                        }
                        ArrayList<Integer> pList = new ArrayList<>();
                        String fileName_p = filepath;
                        try {
                            File x_p = new File(fileName_p);
                            Scanner sp = new Scanner(x_p);
                            while(sp.hasNextLine()) {
                                pList.add(Integer.parseInt((sp.nextLine().trim())));
                            }sp.close();
                            v_ds7 = pList.stream().mapToInt(ii -> ii).toArray(); //all the profit values
                            if(n_ds7!=0){
                                if (n_ds7<pList.size()){
                                    
                                }
                            }
                            else{
                                n_ds7=pList.size();
                            }
                            p07_p.setText(filepath);

                            String[] splat = path_ds7.split("\\\\");
                            datasetName_ds7= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds7=""; fl1_ds7=datasetName_ds7;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds7+=splat[s]+"\\";
                            }
                            String next_wFile=dir_ds7+datasetName_ds7+"_w.txt";
                            String next_cFile=dir_ds7+datasetName_ds7+"_c.txt";
                            if(new File(next_wFile).exists() && new File(next_cFile).exists()){
                                
                            }
                            if(new File(next_wFile).exists()){
                                ArrayList<Integer> wList = new ArrayList<>(); 
                                String fileName_w = next_wFile;
                                try {
                                    File x_w = new File(fileName_w);
                                    Scanner sw = new Scanner(x_w);
                                    while(sw.hasNextLine()) {
                                        wList.add(Integer.parseInt((sw.nextLine().trim())));
                                    }sw.close();
                                    w_ds7 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds7!=0){
                                        if (n_ds7<wList.size()){
                                            
                                        }
                                    }
                                    else{
                                        n_ds7=wList.size();
                                    }
                                    readMode_ds7="w";
                                    fl2_ds7=datasetName_ds7;
                                    p07_w.setText(next_wFile);
                                    String[] splatt = path_ds7.split("\\\\");
                                    datasetName_ds7= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds7 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    fl3_ds7=datasetName_ds7;
                                    p07_c.setText(next_cFile);
                                    String[] splatt = path_ds7.split("\\\\");
                                    datasetName_ds7= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }


                        }
                        catch (FileNotFoundException e) {

                        }
                    }
                    else if (readMode_ds7.equals("w")){ //Read _w txt file
                        if (v_ds7!=null || w_ds7!=null){
                        
                        }
                        types_ds7="w"; fl2_ds7=datasetName_ds7;
                        ArrayList<Integer> wList = new ArrayList<>(); 
                        String fileName_w = filepath;
                        try {
                            File x_w = new File(fileName_w);
                            Scanner sw = new Scanner(x_w);
                            while(sw.hasNextLine()) {
                                wList.add(Integer.parseInt((sw.nextLine().trim())));
                            }sw.close();
                            w_ds7 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                            if(n_ds7!=0){
                                if (n_ds7<wList.size()){
                                    
                                }
                                else{
                                    n_ds7=wList.size();
                                }
                            }
                            else{
                                n_ds7=wList.size();
                            }

                            p07_w.setText(filepath);
                            String[] splat = path_ds7.split("\\\\");
                            datasetName_ds7= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds7="";fl2_ds7=datasetName_ds7;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds7+=splat[s]+"\\";
                            }
                            String next_pFile=dir_ds7+datasetName_ds7+"_p.txt";
                            String next_cFile=dir_ds7+datasetName_ds7+"_c.txt";
                            if(new File(next_pFile).exists() && new File(next_cFile).exists()){

                            }
                            if(new File(next_pFile).exists()){
                                ArrayList<Integer> pList = new ArrayList<>(); 
                                String fileName_p = next_pFile; fl1_ds7=datasetName_ds7;
                                try {
                                    File x_p = new File(fileName_p);
                                    Scanner sp = new Scanner(x_p);
                                    while(sp.hasNextLine()) {
                                        pList.add(Integer.parseInt((sp.nextLine().trim())));
                                    }sp.close();
                                    v_ds7 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds7!=0){
                                        if (n_ds7<pList.size()){
                                            
                                        }
                                        else{
                                            n_ds7=pList.size();
                                        }
                                    }
                                    else{
                                        n_ds7=pList.size();
                                    }
                                    readMode_ds7="p";
                                    p07_p.setText(next_pFile);
                                    String[] splatt = path_ds7.split("\\\\");
                                    datasetName_ds7= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile; fl3_ds7=datasetName_ds7;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds7 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    p07_c.setText(next_cFile);
                                    String[] splatt = path_ds7.split("\\\\");
                                    datasetName_ds7= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }

                        }
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                }
                else if (readMode_ds7.equals("c")){    //Read _c txt file
                    types_ds7="c";
                    String fileName_c = filepath;
                    try {
                        File x_c = new File(fileName_c);
                        Scanner sc = new Scanner(x_c);
                        while(sc.hasNextLine()) {
                            W_ds7 = Integer.parseInt(sc.nextLine());
                        }sc.close();

                        p07_c.setText(filepath);
                        String[] splat = path_ds7.split("\\\\");
                        datasetName_ds7= ((splat[splat.length-1]).split("\\_"))[0];
                        dir_ds7=""; fl3_ds7=datasetName_ds7;
                        for (int s=0;s<splat.length-1;s++){
                            dir_ds7+=splat[s]+"\\";
                        }
                        String next_pFile=dir_ds7+datasetName_ds7+"_p.txt";
                        String next_wFile=dir_ds7+datasetName_ds7+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){

                        }
                        boolean checkType_p=false; 
                        boolean checkType_w=false;
                        if(new File(next_pFile).exists()){
                            checkType_p=true;
                            ArrayList<Integer> pList = new ArrayList<>(); 
                            String fileName_p = next_pFile;
                            try {
                                File x_p = new File(fileName_p);
                                Scanner sp = new Scanner(x_p);
                                while(sp.hasNextLine()) {
                                    pList.add(Integer.parseInt((sp.nextLine().trim())));
                                }sp.close();
                                v_ds7 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds7!=0){
                                    if (n_ds7<pList.size()){
                                        
                                    }
                                    else{
                                        n_ds7=pList.size();
                                    }
                                }
                                else{
                                    n_ds7=pList.size();
                                }
                                readMode_ds7="p";
                                fl1_ds7=datasetName_ds7;
                                p07_p.setText(next_pFile);
                                String[] splatt = path_ds7.split("\\\\");
                                datasetName_ds7= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(new File(next_wFile).exists()){
                            checkType_w=true;
                            ArrayList<Integer> wList = new ArrayList<>(); 
                            String fileName_w = next_wFile;
                            try {
                                File x_w = new File(fileName_w);
                                Scanner sw = new Scanner(x_w);
                                while(sw.hasNextLine()) {
                                    wList.add(Integer.parseInt((sw.nextLine().trim())));
                                }sw.close();
                                w_ds7 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds7!=0){
                                    if (n_ds7<wList.size()){
                                        
                                    }
                                    else{
                                        n_ds7=wList.size();
                                    }
                                }
                                else{
                                    n_ds7=wList.size();
                                }
                                readMode_ds7="w";
                                fl2_ds7=datasetName_ds7;
                                p07_w.setText(next_wFile);
                                String[] splatt = path_ds7.split("\\\\");
                                datasetName_ds7= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(checkType_w==false && checkType_p==false && !fl3_ds7.equals(" ")){
                            only_c_data_ds7=true;
                        }
                        
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                    }
                    batchOpenTXTagain_ds7=true;
                    if (!(fl1_ds7.equals(fl2_ds7) && fl2_ds7.equals(fl3_ds7) && fl3_ds7.equals(fl1_ds7))){
                        canSTART_ds7=false;

                    }
                    else{
                        batchOpenTXTagain_ds7=false;
                    }
                }
                if((fl1_ds7.equals(fl2_ds7) && fl2_ds7.equals(fl3_ds7) && fl3_ds7.equals(fl1_ds7))){
                    canSTART_ds7=true;
                }
                //end of P07    end of ds7
            }
            else if(the_dataset_is.equals("p08")){
                FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files only","txt");
                JFileChooser filechooser = new JFileChooser();
                filechooser.setAcceptAllFileFilterUsed(false);
                if(readMode_ds8.equals("p")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p08_p Profit (p) (*.TXT)",
                            "08_p", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                if(readMode_ds8.equals("w")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p08_w Weight (w) (*.TXT)",
                            "08_w", 31 * Customs.ExtensionFileFilter.MB)
                    ); 
                }
                if(readMode_ds8.equals("c")){
                    filechooser.addChoosableFileFilter(
                        new Customs.ExtensionFileFilter(
                            new String[] { ".TXT" }, 
                            "p08_c Capacity (c) (*.TXT)",
                            "08_c", 31 * Customs.ExtensionFileFilter.MB)
                    );
                }
                filechooser.addChoosableFileFilter(filter);
                int i = filechooser.showOpenDialog(null);
                if (i == JFileChooser.APPROVE_OPTION) {
                    if (v_ds8!=null || w_ds8!=null){
                        String next_pFile=dir_ds8+datasetName_ds8+"_p.txt";
                        String next_wFile=dir_ds8+datasetName_ds8+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){
                            
                        }
                    }
                    File f = filechooser.getSelectedFile();
                    String filepath = f.getPath();
                    path_ds8 = filepath; batchOpenTXTagain_ds8=false;
                    if (readMode_ds8.equals("p")){ //Read _p txt file
                        types_ds8="p";
                        if (v_ds8!=null || w_ds8!=null){
                            
                        }
                        ArrayList<Integer> pList = new ArrayList<>();
                        String fileName_p = filepath;
                        try {
                            File x_p = new File(fileName_p);
                            Scanner sp = new Scanner(x_p);
                            while(sp.hasNextLine()) {
                                pList.add(Integer.parseInt((sp.nextLine().trim())));
                            }sp.close();
                            v_ds8 = pList.stream().mapToInt(ii -> ii).toArray(); //all the profit values
                            if(n_ds8!=0){
                                if (n_ds8<pList.size()){
                                    
                                }
                            }
                            else{
                                n_ds8=pList.size();
                            }
                            p08_p.setText(filepath);

                            String[] splat = path_ds8.split("\\\\");
                            datasetName_ds8= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds8=""; fl1_ds8=datasetName_ds8;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds8+=splat[s]+"\\";
                            }
                            String next_wFile=dir_ds8+datasetName_ds8+"_w.txt";
                            String next_cFile=dir_ds8+datasetName_ds8+"_c.txt";
                            if(new File(next_wFile).exists() && new File(next_cFile).exists()){
                                
                            }
                            if(new File(next_wFile).exists()){
                                ArrayList<Integer> wList = new ArrayList<>(); 
                                String fileName_w = next_wFile;
                                try {
                                    File x_w = new File(fileName_w);
                                    Scanner sw = new Scanner(x_w);
                                    while(sw.hasNextLine()) {
                                        wList.add(Integer.parseInt((sw.nextLine().trim())));
                                    }sw.close();
                                    w_ds8 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds8!=0){
                                        if (n_ds8<wList.size()){
                                            
                                        }
                                    }
                                    else{
                                        n_ds8=wList.size();
                                    }
                                    readMode_ds8="w";
                                    fl2_ds8=datasetName_ds8;
                                    p08_w.setText(next_wFile);
                                    String[] splatt = path_ds8.split("\\\\");
                                    datasetName_ds8= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds8 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    fl3_ds8=datasetName_ds8;
                                    p08_c.setText(next_cFile);
                                    String[] splatt = path_ds8.split("\\\\");
                                    datasetName_ds8= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }


                        }
                        catch (FileNotFoundException e) {

                        }
                    }
                    else if (readMode_ds8.equals("w")){ //Read _w txt file
                        if (v_ds8!=null || w_ds8!=null){
                        
                        }
                        types_ds8="w"; fl2_ds8=datasetName_ds8;
                        ArrayList<Integer> wList = new ArrayList<>(); 
                        String fileName_w = filepath;
                        try {
                            File x_w = new File(fileName_w);
                            Scanner sw = new Scanner(x_w);
                            while(sw.hasNextLine()) {
                                wList.add(Integer.parseInt((sw.nextLine().trim())));
                            }sw.close();
                            w_ds8 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                            if(n_ds8!=0){
                                if (n_ds8<wList.size()){
                                    
                                }
                                else{
                                    n_ds8=wList.size();
                                }
                            }
                            else{
                                n_ds8=wList.size();
                            }

                            p08_w.setText(filepath);
                            String[] splat = path_ds8.split("\\\\");
                            datasetName_ds8= ((splat[splat.length-1]).split("\\_"))[0];
                            dir_ds8="";fl2_ds8=datasetName_ds8;
                            for (int s=0;s<splat.length-1;s++){
                                dir_ds8+=splat[s]+"\\";
                            }
                            String next_pFile=dir_ds8+datasetName_ds8+"_p.txt";
                            String next_cFile=dir_ds8+datasetName_ds8+"_c.txt";
                            if(new File(next_pFile).exists() && new File(next_cFile).exists()){

                            }
                            if(new File(next_pFile).exists()){
                                ArrayList<Integer> pList = new ArrayList<>(); 
                                String fileName_p = next_pFile; fl1_ds8=datasetName_ds8;
                                try {
                                    File x_p = new File(fileName_p);
                                    Scanner sp = new Scanner(x_p);
                                    while(sp.hasNextLine()) {
                                        pList.add(Integer.parseInt((sp.nextLine().trim())));
                                    }sp.close();
                                    v_ds8 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                    if(n_ds8!=0){
                                        if (n_ds8<pList.size()){
                                            
                                        }
                                        else{
                                            n_ds8=pList.size();
                                        }
                                    }
                                    else{
                                        n_ds8=pList.size();
                                    }
                                    readMode_ds8="p";
                                    p08_p.setText(next_pFile);
                                    String[] splatt = path_ds8.split("\\\\");
                                    datasetName_ds8= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }
                            }
                            if(new File(next_cFile).exists()){
                                String fileName_c = next_cFile; fl3_ds8=datasetName_ds8;
                                try {
                                    File x_c = new File(fileName_c);
                                    Scanner sc = new Scanner(x_c);
                                    while(sc.hasNextLine()) {
                                        W_ds8 = Integer.parseInt(sc.nextLine());
                                    }sc.close();
                                    p08_c.setText(next_cFile);
                                    String[] splatt = path_ds8.split("\\\\");
                                    datasetName_ds8= ((splatt[splatt.length-1]).split("\\_"))[0];
                                }
                                catch (FileNotFoundException e) {

                                }

                        }
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                }
                else if (readMode_ds8.equals("c")){    //Read _c txt file
                    types_ds8="c";
                    String fileName_c = filepath;
                    try {
                        File x_c = new File(fileName_c);
                        Scanner sc = new Scanner(x_c);
                        while(sc.hasNextLine()) {
                            W_ds8 = Integer.parseInt(sc.nextLine());
                        }sc.close();

                        p08_c.setText(filepath);
                        String[] splat = path_ds8.split("\\\\");
                        datasetName_ds8= ((splat[splat.length-1]).split("\\_"))[0];
                        dir_ds8=""; fl3_ds8=datasetName_ds8;
                        for (int s=0;s<splat.length-1;s++){
                            dir_ds8+=splat[s]+"\\";
                        }
                        String next_pFile=dir_ds8+datasetName_ds8+"_p.txt";
                        String next_wFile=dir_ds8+datasetName_ds8+"_w.txt";
                        if(new File(next_pFile).exists() && new File(next_wFile).exists()){

                        }
                        boolean checkType_p=false; 
                        boolean checkType_w=false;
                        if(new File(next_pFile).exists()){
                            checkType_p=true;
                            ArrayList<Integer> pList = new ArrayList<>(); 
                            String fileName_p = next_pFile;
                            try {
                                File x_p = new File(fileName_p);
                                Scanner sp = new Scanner(x_p);
                                while(sp.hasNextLine()) {
                                    pList.add(Integer.parseInt((sp.nextLine().trim())));
                                }sp.close();
                                v_ds8 = pList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds8!=0){
                                    if (n_ds8<pList.size()){
                                        
                                    }
                                    else{
                                        n_ds8=pList.size();
                                    }
                                }
                                else{
                                    n_ds8=pList.size();
                                }
                                readMode_ds8="p";
                                fl1_ds8=datasetName_ds8;
                                p08_p.setText(next_pFile);
                                String[] splatt = path_ds8.split("\\\\");
                                datasetName_ds8= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(new File(next_wFile).exists()){
                            checkType_w=true;
                            ArrayList<Integer> wList = new ArrayList<>(); 
                            String fileName_w = next_wFile;
                            try {
                                File x_w = new File(fileName_w);
                                Scanner sw = new Scanner(x_w);
                                while(sw.hasNextLine()) {
                                    wList.add(Integer.parseInt((sw.nextLine().trim())));
                                }sw.close();
                                w_ds8 = wList.stream().mapToInt(ii -> ii).toArray();   //all the weight values
                                if(n_ds8!=0){
                                    if (n_ds8<wList.size()){
                                        
                                    }
                                    else{
                                        n_ds8=wList.size();
                                    }
                                }
                                else{
                                    n_ds8=wList.size();
                                }
                                readMode_ds8="w";
                                fl2_ds8=datasetName_ds8;
                                p08_w.setText(next_wFile);
                                String[] splatt = path_ds8.split("\\\\");
                                datasetName_ds8= ((splatt[splatt.length-1]).split("\\_"))[0];
                            }
                            catch (FileNotFoundException e) {

                            }
                        }
                        if(checkType_w==false && checkType_p==false && !fl3_ds8.equals(" ")){
                            only_c_data_ds8=true;
                        }
                        
                    }
                    catch (FileNotFoundException e) {
                       
                    }
                    }
                    batchOpenTXTagain_ds8=true;
                    if (!(fl1_ds8.equals(fl2_ds8) && fl2_ds8.equals(fl3_ds8) && fl3_ds8.equals(fl1_ds8))){
                        canSTART_ds8=false;

                    }
                    else{
                        batchOpenTXTagain_ds8=false;
                    }
                }
                if((fl1_ds8.equals(fl2_ds8) && fl2_ds8.equals(fl3_ds8) && fl3_ds8.equals(fl1_ds8))){
                    canSTART_ds8=true;
                }
                //end of P08    end of ds8
            }
            
            if(canSTART_ds1==true && canSTART_ds2==true && canSTART_ds3==true && canSTART_ds4==true && canSTART_ds5==true && canSTART_ds6==true && canSTART_ds7 == true && canSTART_ds8==true)
            {
                startAll_eight=true;
                jPanel10.setVisible(true);
            }
            
            return null;
        }
        
        public void done(){
            if(the_dataset_is.equals("p01")){
                if (path_ds1!=null && batchOpenTXTagain_ds1==true){
                    JOptionPane.showMessageDialog(null, "Opened \"_"+the_dataset_is+"\" dataset, Completed");
                    if (fl1_ds1.equals(fl2_ds1) && fl2_ds1.equals(fl3_ds1) && fl3_ds1.equals(fl1_ds1)){
                        canSTART_ds1=true;
                        oneTime_ds1=false;
                        System.out.println("ds1 true");
                    }
                    else{
                        canSTART_ds1=false;
                    }
                }
                if(canSTART_ds1==true){
                    oneTime_ds1=false;
                    taskGetOptProf_ds1 = new ThreadOptProf_ds1();
                    taskGetOptProf_ds1.execute();
                }
            }
            else if(the_dataset_is.equals("p02")){
                if (path_ds2!=null && batchOpenTXTagain_ds2==true){
                    JOptionPane.showMessageDialog(null, "Opened \"_"+the_dataset_is+"\" dataset, Completed");
                    if (fl1_ds2.equals(fl2_ds2) && fl2_ds2.equals(fl3_ds2) && fl3_ds2.equals(fl1_ds2)){
                        canSTART_ds2=true;
                        oneTime_ds2=false;
                    }
                    else{
                        canSTART_ds2=false;
                    }
                }
                if(canSTART_ds2==true){
                    oneTime_ds2=false;
                    taskGetOptProf_ds2 = new ThreadOptProf_ds2();
                    taskGetOptProf_ds2.execute();
                }
            }
            else if(the_dataset_is.equals("p03")){
                if (path_ds3!=null && batchOpenTXTagain_ds3==true){
                    JOptionPane.showMessageDialog(null, "Opened \"_"+the_dataset_is+"\" dataset, Completed");
                    if (fl1_ds3.equals(fl2_ds3) && fl2_ds3.equals(fl3_ds3) && fl3_ds3.equals(fl1_ds3)){
                        canSTART_ds3=true;
                        oneTime_ds3=false;
                    }
                    else{
                        canSTART_ds3=false;
                    }
                }
                if(canSTART_ds3==true){
                    oneTime_ds3=false;
                    taskGetOptProf_ds3 = new ThreadOptProf_ds3();
                    taskGetOptProf_ds3.execute();
                }
            }
            else if(the_dataset_is.equals("p04")){
                if (path_ds4!=null && batchOpenTXTagain_ds4==true){
                    JOptionPane.showMessageDialog(null, "Opened \"_"+the_dataset_is+"\" dataset, Completed");
                    if (fl1_ds4.equals(fl2_ds4) && fl2_ds4.equals(fl3_ds4) && fl3_ds4.equals(fl1_ds4)){
                        canSTART_ds4=true;
                        oneTime_ds4=false;
                    }
                    else{
                        canSTART_ds4=false;
                    }
                }
                if(canSTART_ds4==true){
                    oneTime_ds4=false;
                    taskGetOptProf_ds4 = new ThreadOptProf_ds4();
                    taskGetOptProf_ds4.execute();
                }
            }
            else if(the_dataset_is.equals("p05")){
                if (path_ds5!=null && batchOpenTXTagain_ds5==true){
                    JOptionPane.showMessageDialog(null, "Opened \"_"+the_dataset_is+"\" dataset, Completed");
                    if (fl1_ds5.equals(fl2_ds5) && fl2_ds5.equals(fl3_ds5) && fl3_ds5.equals(fl1_ds5)){
                        canSTART_ds5=true;
                        oneTime_ds5=false;
                    }
                    else{
                        canSTART_ds5=false;
                    }
                }
                if(canSTART_ds5==true){
                    oneTime_ds5=false;
                    taskGetOptProf_ds5 = new ThreadOptProf_ds5();
                    taskGetOptProf_ds5.execute();
                }
            }
            else if(the_dataset_is.equals("p06")){
                if (path_ds6!=null && batchOpenTXTagain_ds6==true){
                    JOptionPane.showMessageDialog(null, "Opened \"_"+the_dataset_is+"\" dataset, Completed");
                    if (fl1_ds6.equals(fl2_ds6) && fl2_ds6.equals(fl3_ds6) && fl3_ds6.equals(fl1_ds6)){
                        canSTART_ds6=true;
                        oneTime_ds6=false;
                    }
                    else{
                        canSTART_ds6=false;
                    }
                }
                if(canSTART_ds6==true){
                    oneTime_ds6=false;
                    taskGetOptProf_ds6 = new ThreadOptProf_ds6();
                    taskGetOptProf_ds6.execute();
                }
            }
            else if(the_dataset_is.equals("p07")){
                if (path_ds7!=null && batchOpenTXTagain_ds7==true){
                    JOptionPane.showMessageDialog(null, "Opened \"_"+the_dataset_is+"\" dataset, Completed");
                    if (fl1_ds7.equals(fl2_ds7) && fl2_ds7.equals(fl3_ds7) && fl3_ds7.equals(fl1_ds7)){
                        canSTART_ds7=true;
                        oneTime_ds7=false;
                    }
                    else{
                        canSTART_ds7=false;
                    }
                }
                if(canSTART_ds7==true){
                    oneTime_ds7=false;
                    taskGetOptProf_ds7 = new ThreadOptProf_ds7();
                    taskGetOptProf_ds7.execute();
                }
            }
            else if(the_dataset_is.equals("p08")){
                if (path_ds8!=null && batchOpenTXTagain_ds8==true){
                    JOptionPane.showMessageDialog(null, "Opened \"_"+the_dataset_is+"\" dataset, Completed");
                    if (fl1_ds8.equals(fl2_ds8) && fl2_ds8.equals(fl3_ds8) && fl3_ds8.equals(fl1_ds8)){
                        canSTART_ds8=true;
                        oneTime_ds8=false;
                        System.out.println("ds8 true");
                    }
                    else{
                        canSTART_ds8=false;
                    }
                }
                if(canSTART_ds8==true){
                    oneTime_ds8=false;
                    taskGetOptProf_ds8 = new ThreadOptProf_ds8();
                    taskGetOptProf_ds8.execute();
                }
            }
            
            if(canSTART_ds1==true && canSTART_ds2==true && canSTART_ds3==true && canSTART_ds4==true && canSTART_ds5==true && canSTART_ds6==true && canSTART_ds7 == true && canSTART_ds8==true)
            {
                startAll_eight=true;
                jPanel10.setVisible(true);
            }
            
                
            isCleared=false;   
        }
    }
    
    private ThreadOptProf_ds1 taskGetOptProf_ds1;
    class ThreadOptProf_ds1 extends SwingWorker<Void,Void>{
        public Void doInBackground(){
            DynamicProgramming dynPro = new DynamicProgramming();
            dynPro.begin_DP(v_ds1, w_ds1, n_ds1, W_ds1);
            opt_pr_ds1= dynPro.getOptimalProfit();
            return null;
        }
        public void done(){
        }   
    }
    
    private ThreadOptProf_ds2 taskGetOptProf_ds2;
    class ThreadOptProf_ds2 extends SwingWorker<Void,Void>{
        public Void doInBackground(){
            DynamicProgramming dynPro = new DynamicProgramming();
            dynPro.begin_DP(v_ds2, w_ds2, n_ds2, W_ds2);
            opt_pr_ds2= dynPro.getOptimalProfit();
            return null;
        }
        public void done(){
        }   
    }
    
    private ThreadOptProf_ds3 taskGetOptProf_ds3;
    class ThreadOptProf_ds3 extends SwingWorker<Void,Void>{
        public Void doInBackground(){
            DynamicProgramming dynPro = new DynamicProgramming();
            dynPro.begin_DP(v_ds3, w_ds3, n_ds3, W_ds3);
            opt_pr_ds3= dynPro.getOptimalProfit();
            return null;
        }
        public void done(){
        }   
    }
    
    private ThreadOptProf_ds4 taskGetOptProf_ds4;
    class ThreadOptProf_ds4 extends SwingWorker<Void,Void>{
        public Void doInBackground(){
            DynamicProgramming dynPro = new DynamicProgramming();
            dynPro.begin_DP(v_ds4, w_ds4, n_ds4, W_ds4);
            opt_pr_ds4= dynPro.getOptimalProfit();
            return null;
        }
        public void done(){
        }   
    }
    
    private ThreadOptProf_ds5 taskGetOptProf_ds5;
    class ThreadOptProf_ds5 extends SwingWorker<Void,Void>{
        public Void doInBackground(){
            DynamicProgramming dynPro = new DynamicProgramming();
            dynPro.begin_DP(v_ds5, w_ds5, n_ds5, W_ds5);
            opt_pr_ds5= dynPro.getOptimalProfit();
            return null;
        }
        public void done(){
        }   
    }
    
    private ThreadOptProf_ds6 taskGetOptProf_ds6;
    class ThreadOptProf_ds6 extends SwingWorker<Void,Void>{
        public Void doInBackground(){
            DynamicProgramming dynPro = new DynamicProgramming();
            dynPro.begin_DP(v_ds6, w_ds6, n_ds6, W_ds6);
            opt_pr_ds6= dynPro.getOptimalProfit();
            return null;
        }
        public void done(){
        }   
    }
    
    private ThreadOptProf_ds7 taskGetOptProf_ds7;
    class ThreadOptProf_ds7 extends SwingWorker<Void,Void>{
        public Void doInBackground(){
            DynamicProgramming dynPro = new DynamicProgramming();
            dynPro.begin_DP(v_ds7, w_ds7, n_ds7, W_ds7);
            opt_pr_ds7= dynPro.getOptimalProfit();
            return null;
        }
        public void done(){
        }   
    }
    
    private ThreadOptProf_ds8 taskGetOptProf_ds8;
    class ThreadOptProf_ds8 extends SwingWorker<Void,Void>{
        public Void doInBackground(){
            DynamicProgramming dynPro = new DynamicProgramming();
            dynPro.begin_DP(v_ds8, w_ds8, n_ds8, W_ds8);
            opt_pr_ds8= dynPro.getOptimalProfit();
            return null;
        }
        public void done(){
        }   
    }
    
    
    
    
    
    
    
    /**
     * Creates new form BatchFileOperation
     */
    public BatchFileOperation() {
        initComponents();
        jPanel10.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        p01_p = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        p01_w = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        p01_c = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        p02_p = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        p02_w = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        p02_c = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        p03_p = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        p03_w = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        p03_c = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        p04_p = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        p04_w = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        p04_c = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        p05_p = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        p05_w = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        p05_c = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        p06_p = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        p06_w = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        p06_c = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        p07_p = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        p07_w = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        p07_c = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        p08_p = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        p08_w = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        p08_c = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jButton25 = new javax.swing.JButton();

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton10.setText("Open \"_p.txt\" file");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel18.setText("Profits (p), was read from: ");

        p01_p.setText(" ");
        p01_p.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton11.setText("Open \"_w.txt\" file");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel19.setText("Weights (w), was read from:  ");

        p01_w.setText("  ");
        p01_w.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton12.setText("Open \"_c.txt\" file");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel20.setText("Capacity (c), was read from:  ");

        p01_c.setText("  ");
        p01_c.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Dataset: P01");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(p01_w, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                            .addComponent(p01_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p01_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jButton10)
                            .addComponent(p01_p))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jButton11)
                            .addComponent(p01_w))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton12)
                        .addComponent(jLabel20)
                        .addComponent(p01_c)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton1.setText("Open \"_p.txt\" file");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Profits (p), was read from: ");

        p02_p.setText(" ");
        p02_p.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton4.setText("Open \"_w.txt\" file");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setText("Weights (w), was read from:  ");

        p02_w.setText("  ");
        p02_w.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton5.setText("Open \"_c.txt\" file");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel11.setText("Capacity (c), was read from:  ");

        p02_c.setText("  ");
        p02_c.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Dataset: P02");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(p02_w, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(p02_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p02_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jButton1)
                            .addComponent(p02_p))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jButton4)
                            .addComponent(p02_w))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jLabel11)
                        .addComponent(p02_c)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton2.setText("Open \"_p.txt\" file");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setText("Profits (p), was read from: ");

        p03_p.setText(" ");
        p03_p.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton6.setText("Open \"_w.txt\" file");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel13.setText("Weights (w), was read from:  ");

        p03_w.setText("  ");
        p03_w.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton7.setText("Open \"_c.txt\" file");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel14.setText("Capacity (c), was read from:  ");

        p03_c.setText("  ");
        p03_c.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Dataset: P03");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p03_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p03_w, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                            .addComponent(p03_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(106, 106, 106))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jButton2)
                            .addComponent(p03_p))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jButton6)
                            .addComponent(p03_w))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(jLabel14)
                        .addComponent(p03_c)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton16.setText("Open \"_p.txt\" file");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton16MouseClicked(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel24.setText("Profits (p), was read from: ");

        p04_p.setText(" ");
        p04_p.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton17.setText("Open \"_w.txt\" file");
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
        });
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel25.setText("Weights (w), was read from:  ");

        p04_w.setText("  ");
        p04_w.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton18.setText("Open \"_c.txt\" file");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton18MouseClicked(evt);
            }
        });
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel26.setText("Capacity (c), was read from:  ");

        p04_c.setText("  ");
        p04_c.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Dataset: P04");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p04_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p04_w, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p04_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(104, 104, 104))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jButton16)
                            .addComponent(p04_p))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jButton17)
                            .addComponent(p04_w))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton18)
                        .addComponent(jLabel26)
                        .addComponent(p04_c)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton3.setText("Open \"_p.txt\" file");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel15.setText("Profits (p), was read from: ");

        p05_p.setText(" ");
        p05_p.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton8.setText("Open \"_w.txt\" file");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel16.setText("Weights (w), was read from:  ");

        p05_w.setText("  ");
        p05_w.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton9.setText("Open \"_c.txt\" file");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel17.setText("Capacity (c), was read from:  ");

        p05_c.setText("  ");
        p05_c.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Dataset: P05");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p05_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p05_w, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p05_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(90, 90, 90))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jButton3)
                            .addComponent(p05_p))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jButton8)
                            .addComponent(p05_w))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9)
                        .addComponent(jLabel17)
                        .addComponent(p05_c)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton13.setText("Open \"_p.txt\" file");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel21.setText("Profits (p), was read from: ");

        p06_p.setText(" ");
        p06_p.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton14.setText("Open \"_w.txt\" file");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel22.setText("Weights (w), was read from:  ");

        p06_w.setText("  ");
        p06_w.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton15.setText("Open \"_c.txt\" file");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel23.setText("Capacity (c), was read from:  ");

        p06_c.setText("  ");
        p06_c.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Dataset: P06");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p06_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p06_w, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p06_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(83, 83, 83))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jButton13)
                            .addComponent(p06_p))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jButton14)
                            .addComponent(p06_w))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton15)
                        .addComponent(jLabel23)
                        .addComponent(p06_c)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton22.setText("Open \"_p.txt\" file");
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton22MouseClicked(evt);
            }
        });
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jLabel30.setText("Profits (p), was read from: ");

        p07_p.setText(" ");
        p07_p.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton23.setText("Open \"_w.txt\" file");
        jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton23MouseClicked(evt);
            }
        });
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jLabel31.setText("Weights (w), was read from:  ");

        p07_w.setText("  ");
        p07_w.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton24.setText("Open \"_c.txt\" file");
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton24MouseClicked(evt);
            }
        });
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jLabel32.setText("Capacity (c), was read from:  ");

        p07_c.setText("  ");
        p07_c.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Dataset: P07");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p07_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p07_w, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p07_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jButton22)
                            .addComponent(p07_p))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jButton23)
                            .addComponent(p07_w))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton24)
                        .addComponent(jLabel32)
                        .addComponent(p07_c)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton19.setText("Open \"_p.txt\" file");
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton19MouseClicked(evt);
            }
        });
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel27.setText("Profits (p), was read from: ");

        p08_p.setText(" ");
        p08_p.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton20.setText("Open \"_w.txt\" file");
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton20MouseClicked(evt);
            }
        });
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel28.setText("Weights (w), was read from:  ");

        p08_w.setText("  ");
        p08_w.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButton21.setText("Open \"_c.txt\" file");
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton21MouseClicked(evt);
            }
        });
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jLabel29.setText("Capacity (c), was read from:  ");

        p08_c.setText("  ");
        p08_c.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Dataset: P08");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p08_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p08_w, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p08_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(73, 73, 73))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jButton19)
                            .addComponent(p08_p))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jButton20)
                            .addComponent(p08_w))
                        .addGap(31, 31, 31))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton21)
                        .addComponent(jLabel29)
                        .addComponent(p08_c)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1525, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(103, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel9);

        jLabel1.setText("Use this window to open multiple datasets at once, to ensure a smooth operation in Q3. Empirical Testing.");

        jLabel34.setText("After all the datasets below are correctly opened, a button on the right will appear to \"COMPLETE BATCH OPEN\". ");

        jButton25.setText("COMPLETE BATCH OPEN");
        jButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton25MouseClicked(evt);
            }
        });
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jButton25)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel34))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        readMode_ds2="p";
        the_dataset_is="p02";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        readMode_ds2="w";
        the_dataset_is="p02";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
        
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        readMode_ds2="c";
        the_dataset_is="p02";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
        
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        readMode_ds3="p";
        the_dataset_is="p03";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        readMode_ds3="w";
        the_dataset_is="p03";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        readMode_ds3="c";
        the_dataset_is="p03";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        readMode_ds5="p";
        the_dataset_is="p05";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
        readMode_ds5="w";
        the_dataset_is="p05";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
        readMode_ds5="c";
        the_dataset_is="p05";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
        readMode_ds1="p";
        the_dataset_is="p01";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
        readMode_ds1="w";
        the_dataset_is="p01";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        // TODO add your handling code here:
        readMode_ds1="c";
        the_dataset_is="p01";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        // TODO add your handling code here:
        readMode_ds6="p";
        the_dataset_is="p06";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        // TODO add your handling code here:
        readMode_ds6="w";
        the_dataset_is="p06";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        // TODO add your handling code here:
        readMode_ds6="c";
        the_dataset_is="p06";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton15MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked
        // TODO add your handling code here:
        readMode_ds4="p";
        the_dataset_is="p04";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton16MouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        // TODO add your handling code here:
        readMode_ds4="w";
        the_dataset_is="p04";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked
        // TODO add your handling code here:
        readMode_ds4="c";
        the_dataset_is="p04";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton18MouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseClicked
        // TODO add your handling code here:
        readMode_ds8="p";
        the_dataset_is="p08";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton19MouseClicked

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseClicked
        // TODO add your handling code here:
        readMode_ds8="w";
        the_dataset_is="p08";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton20MouseClicked

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseClicked
        // TODO add your handling code here:
        readMode_ds8="c";
        the_dataset_is="p08";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton21MouseClicked

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseClicked
        // TODO add your handling code here:
        readMode_ds7="p";
        the_dataset_is="p07";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton22MouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseClicked
        // TODO add your handling code here:
        readMode_ds7="w";
        the_dataset_is="p07";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton23MouseClicked

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseClicked
        // TODO add your handling code here:
        readMode_ds7="c";
        the_dataset_is="p07";
        taskBatchOpenTXT = new BatchOpenTXT();
        taskBatchOpenTXT.execute();
    }//GEN-LAST:event_jButton24MouseClicked

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MouseClicked
        // TODO add your handling code here:
        
        this.setVisible(false);
        if(startAll_eight==true){
            MainClassGUI.jPanel13.setVisible(true);
        }
            
    }//GEN-LAST:event_jButton25MouseClicked

    /**
     * @param args the command line arguments
     */
    public void start() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BatchFileOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatchFileOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatchFileOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatchFileOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatchFileOperation().setVisible(true);
                BatchFileOperation window = new BatchFileOperation();
                window.setVisible(true);
                window.setTitle("Open Multiple Datasets");
            }
        });
    }

    public static BatchFileOperation _instance;
    public static BatchFileOperation GetInstance()
    {
      if(_instance == null) _instance = new BatchFileOperation();
      return _instance; 
    }
    
    public static EmpiricalTestNonDeterministicAlgo taskEmpiricalTestNonDeterministicAlgoThread;
    class EmpiricalTestNonDeterministicAlgo extends SwingWorker<Void,Void>{
        public long dur;
        public String the_dataset_iss;
        public int[]val;
        public int[]wei;
        public int num;
        public int WEI;
        public int opt_pr; 
        
        public EmpiricalTestNonDeterministicAlgo(String the_dataset_is, int[] v, int[]w, int n, int W, int opt_prr){
            the_dataset_iss=the_dataset_is;
            val=v;
            wei=w;
            num=n;
            WEI=W;
            opt_pr=opt_prr;
        }
        
        public Void doInBackground(){
            if (the_dataset_iss.equals("p01")){
                MainClassGUI.jProgressBar3.setIndeterminate(true);
                MainClassGUI.jLabel56.setText("Process time: ");
            }
            else if (the_dataset_iss.equals("p02")){
                MainClassGUI.jProgressBar6.setIndeterminate(true);
                MainClassGUI.jLabel88.setText("Process time: ");
            }
            else if (the_dataset_iss.equals("p03")){
                MainClassGUI.jProgressBar8.setIndeterminate(true);
                MainClassGUI.jLabel108.setText("Process time: ");
            }
            else if (the_dataset_iss.equals("p04")){
                MainClassGUI.jProgressBar10.setIndeterminate(true);
                MainClassGUI.jLabel130.setText("Process time: ");
            }
            else if (the_dataset_iss.equals("p05")){
                MainClassGUI.jProgressBar13.setIndeterminate(true);
                MainClassGUI.jLabel156.setText("Process time: ");
            }
            else if (the_dataset_iss.equals("p06")){
                MainClassGUI.jProgressBar15.setIndeterminate(true);
                MainClassGUI.jLabel177.setText("Process time: ");
            }
            else if (the_dataset_iss.equals("p07")){
                MainClassGUI.jProgressBar17.setIndeterminate(true);
                MainClassGUI.jLabel199.setText("Process time: ");
            }
            else if (the_dataset_iss.equals("p08")){
                MainClassGUI.jProgressBar19.setIndeterminate(true);
                MainClassGUI.jLabel217.setText("Process time: ");
            }
            GeneticAlgorithm ga = new GeneticAlgorithm(val,wei,num,WEI);
            ga.is_empirTest=true; ga.solution=opt_pr; 
            ArrayList<Integer> nfcList = new ArrayList<>();
            long startTime = System.nanoTime(); 
            int successrate=0;
            for (int i = 0; i < 31;i++){
                ga.start(val, wei, num, WEI,"etest");
                if (the_dataset_iss.equals("p01")){
                    MainClassGUI.jLabel42.setText(Integer.toString(i+1));
		}
		else if (the_dataset_iss.equals("p02")){
		    MainClassGUI.jLabel85.setText(Integer.toString(i+1));
		}
		else if (the_dataset_iss.equals("p03")){
		    MainClassGUI.jLabel105.setText(Integer.toString(i+1));
		}
		else if (the_dataset_iss.equals("p04")){
		    MainClassGUI.jLabel127.setText(Integer.toString(i+1));
		}
		else if (the_dataset_iss.equals("p05")){
		    MainClassGUI.jLabel153.setText(Integer.toString(i+1));
		}
		else if (the_dataset_iss.equals("p06")){
		    MainClassGUI.jLabel174.setText(Integer.toString(i+1));
		}
		else if (the_dataset_iss.equals("p07")){
		    MainClassGUI.jLabel196.setText(Integer.toString(i+1));
		}
		else if (the_dataset_iss.equals("p08")){
		    MainClassGUI.jLabel214.setText(Integer.toString(i+1));
		}
                if(i==30){    
                    if (the_dataset_iss.equals("p01")){
			MainClassGUI.jLabel42.setText(Integer.toString(i+1) + "         (Done!)");	
                    }
                    else if (the_dataset_iss.equals("p02")){
                        MainClassGUI.jLabel85.setText(Integer.toString(i+1) + "         (Done!)");
                    }
                    else if (the_dataset_iss.equals("p03")){
                        MainClassGUI.jLabel105.setText(Integer.toString(i+1) + "         (Done!)");
                    }
                    else if (the_dataset_iss.equals("p04")){
                        MainClassGUI.jLabel127.setText(Integer.toString(i+1) + "         (Done!)");
                    }
                    else if (the_dataset_iss.equals("p05")){
                        MainClassGUI.jLabel153.setText(Integer.toString(i+1) + "         (Done!)");
                    }
                    else if (the_dataset_iss.equals("p06")){
                        MainClassGUI.jLabel174.setText(Integer.toString(i+1) + "         (Done!)");
                    }
                    else if (the_dataset_iss.equals("p07")){
                        MainClassGUI.jLabel196.setText(Integer.toString(i+1) + "         (Done!)");
                    }
                    else if (the_dataset_iss.equals("p08")){
                        MainClassGUI.jLabel214.setText(Integer.toString(i+1) + "         (Done!)");
                    }
                }
                nfcList.add(ga.getNfc());
                if (ga.getOptimalProfit() == opt_pr){
                    successrate++;
                }
            }
            long endTime = System.nanoTime();  
            long duration = (endTime - startTime);  
            dur=duration;
            long sum=0;
            for(long value: ga.empirTest_NfcList){
                sum+=value;
            }
            
            
            
            //Q3 findings for GA
            long bestNFC = ga.empirTest_NfcList.last(); //Q3 findings for GA
            long maxNFC = nfcList.get(nfcList.size()-1); // GA Q3
            long meanNFC = (maxNFC+bestNFC)/2; // Q3 GA           GA Q3
            successrate= 100*successrate/nfcList.size();
            //Q3 findings for Genetic Algorithm
           
            
            
            if (the_dataset_iss.equals("p01")){
                MainClassGUI.jLabel47.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel38.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel37.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel36.setText("Max NFC: "+ maxNFC);
            }
            else if (the_dataset_iss.equals("p02")){
                MainClassGUI.jLabel87.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel83.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel82.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel81.setText("Max NFC: "+ maxNFC);
            }
            else if (the_dataset_iss.equals("p03")){
                MainClassGUI.jLabel107.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel103.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel102.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel101.setText("Max NFC: "+ maxNFC);
            }
            else if (the_dataset_iss.equals("p04")){
                MainClassGUI.jLabel129.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel125.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel124.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel123.setText("Max NFC: "+ maxNFC);
            }
            else if (the_dataset_iss.equals("p05")){
                MainClassGUI.jLabel155.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel151.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel150.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel149.setText("Max NFC: "+ maxNFC);
            }
            else if (the_dataset_iss.equals("p06")){
                MainClassGUI.jLabel176.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel172.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel171.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel170.setText("Max NFC: "+ maxNFC);
            }
            else if (the_dataset_iss.equals("p07")){
                MainClassGUI.jLabel198.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel194.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel193.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel192.setText("Max NFC: "+ maxNFC);
            }
            else if (the_dataset_iss.equals("p08")){
                MainClassGUI.jLabel216.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel212.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel211.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel210.setText("Max NFC: "+ maxNFC);
            }
            ga.empirTest_NfcList.clear();
            ga.empirTest_ProfitList.clear();
            ga.empirTest_nfc=0;
            ga.best_again=0;
            ga.is_empirTest=false;
            ga=null;
            return null;
        }
        public void done (){            
            if (the_dataset_iss.equals("p01")){
                MainClassGUI.jProgressBar3.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel56.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel56.setText(wrd);
            }
            else if (the_dataset_iss.equals("p02")){
                MainClassGUI.jProgressBar6.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel88.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel88.setText(wrd);
            }
            else if (the_dataset_iss.equals("p03")){
                MainClassGUI.jProgressBar8.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel108.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel108.setText(wrd);
            }
            else if (the_dataset_iss.equals("p04")){
                MainClassGUI.jProgressBar10.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel130.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel130.setText(wrd);
            }
            else if (the_dataset_iss.equals("p05")){
                MainClassGUI.jProgressBar13.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel156.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel156.setText(wrd);
            }
            else if (the_dataset_iss.equals("p06")){
                MainClassGUI.jProgressBar15.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel177.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel177.setText(wrd);
            }
            else if (the_dataset_iss.equals("p07")){
                MainClassGUI.jProgressBar17.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel199.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel199.setText(wrd);
            }
            else if (the_dataset_iss.equals("p08")){
                MainClassGUI.jProgressBar19.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel217.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel217.setText(wrd);
            }
        }
    }
    
    public static EmpiricalTestDeterministicAlgo taskEmpiricalTestDeterministicAlgoThread;
    class EmpiricalTestDeterministicAlgo extends SwingWorker<Void,Void>{
        public long dur;
        public String the_dataset_iss;
        public int[]val;
        public int[]wei;
        public int num;
        public int WEI;
        public int opt_pr;
        
        public EmpiricalTestDeterministicAlgo(String the_dataset_is, int[] v, int[]w, int n, int W, int opt_prr){
            the_dataset_iss=the_dataset_is;
            val=v;
            wei=w;
            num=n;
            WEI=W;
            opt_pr=opt_prr;
        }
        
        public Void doInBackground(){
            int successrate=0;   
            if (the_dataset_iss.equals("p01")){
                MainClassGUI.jLabel40.setText(" ");
                MainClassGUI.jProgressBar2.setIndeterminate(true);
                MainClassGUI.jLabel53.setText("Process time: ");
                MainClassGUI.jLabel46.setText("Success Rate (SR): ");
                MainClassGUI.jProgressBar2.setIndeterminate(true);
            }
            else if (the_dataset_iss.equals("p02")){
                MainClassGUI.jLabel74.setText(" ");
                MainClassGUI.jProgressBar5.setIndeterminate(true);
                MainClassGUI.jLabel77.setText("Process time : ");
                MainClassGUI.jLabel76.setText("Success Rate (SR): ");
                MainClassGUI.jProgressBar5.setIndeterminate(true);
            }
            else if (the_dataset_iss.equals("p03")){
                MainClassGUI.jLabel94.setText(" ");
                MainClassGUI.jProgressBar7.setIndeterminate(true);
                MainClassGUI.jLabel97.setText("Process time : ");
                MainClassGUI.jLabel96.setText("Success Rate (SR): ");
                MainClassGUI.jProgressBar7.setIndeterminate(true);
            }
            else if (the_dataset_iss.equals("p04")){
                MainClassGUI.jLabel116.setText(" ");
                MainClassGUI.jProgressBar9.setIndeterminate(true);
                MainClassGUI.jLabel119.setText("Process time : ");
                MainClassGUI.jLabel118.setText("Success Rate (SR): ");
                MainClassGUI.jProgressBar9.setIndeterminate(true);
            }
            else if (the_dataset_iss.equals("p05")){
                MainClassGUI.jLabel42.setText(" ");
                MainClassGUI.jProgressBar12.setIndeterminate(true);
                MainClassGUI.jLabel145.setText("Process time : ");
                MainClassGUI.jLabel144.setText("Success Rate (SR): ");
                MainClassGUI.jProgressBar12.setIndeterminate(true);
            }
            else if (the_dataset_iss.equals("p06")){
                MainClassGUI.jLabel163.setText(" ");
                MainClassGUI.jProgressBar14.setIndeterminate(true);
                MainClassGUI.jLabel166.setText("Process time : ");
                MainClassGUI.jLabel165.setText("Success Rate (SR): ");
                MainClassGUI.jProgressBar14.setIndeterminate(true);
            }
            else if (the_dataset_iss.equals("p07")){
                MainClassGUI.jLabel185.setText(" ");
                MainClassGUI.jProgressBar16.setIndeterminate(true);
                MainClassGUI.jLabel188.setText("Process time : ");
                MainClassGUI.jLabel187.setText("Success Rate (SR): ");
                MainClassGUI.jProgressBar16.setIndeterminate(true);
            }
            else if (the_dataset_iss.equals("p08")){
                MainClassGUI.jLabel205.setText(" ");
                MainClassGUI.jProgressBar18.setIndeterminate(true);
                MainClassGUI.jLabel208.setText("Process time : ");
                MainClassGUI.jLabel207.setText("Success Rate (SR): ");
                MainClassGUI.jProgressBar18.setIndeterminate(true);
            }
            ArrayList<Integer> nfcList = new ArrayList<>();
            long startTime = System.nanoTime();
            DynamicProgramming dpr = new DynamicProgramming();
            for (int i = 0; i < 31;i++){
                dpr.start(val, wei, num, WEI,opt_pr);
                nfcList.add(dpr.getNfc());
                if (the_dataset_iss.equals("p01")){
		    MainClassGUI.jLabel40.setText(""+(i+1));
		}
		else if (the_dataset_iss.equals("p02")){
		    MainClassGUI.jLabel74.setText(""+(i+1));
		}
		else if (the_dataset_iss.equals("p03")){
		    MainClassGUI.jLabel94.setText(""+(i+1));
		}
		else if (the_dataset_iss.equals("p04")){
		    MainClassGUI.jLabel116.setText(""+(i+1));
		}
		else if (the_dataset_iss.equals("p05")){
		    MainClassGUI.jLabel142.setText(""+(i+1));
		}
		else if (the_dataset_iss.equals("p06")){
		    MainClassGUI.jLabel163.setText(""+(i+1));
		}
		else if (the_dataset_iss.equals("p07")){
		    MainClassGUI.jLabel185.setText(""+(i+1));
		}
		else if (the_dataset_iss.equals("p08")){
		    MainClassGUI.jLabel205.setText(""+(i+1));
		}
                if(taskEmpiricalTestDeterministicAlgoThread.getState()==StateValue.DONE){
                    if (the_dataset_iss.equals("p01")){
			MainClassGUI.jLabel46.setText("Success Rate (SR): ");
                        MainClassGUI.jLabel26.setText("Best NFC: ");
                        MainClassGUI.jLabel27.setText("Mean NFC: ");
                        MainClassGUI.jLabel28.setText("Max NFC: ");
                        MainClassGUI.jLabel40.setText("0");
                    }
                    else if (the_dataset_iss.equals("p02")){
                        MainClassGUI.jLabel76.setText("Success Rate (SR): ");
                        MainClassGUI.jLabel70.setText("Best NFC: ");
                        MainClassGUI.jLabel71.setText("Mean NFC: ");
                        MainClassGUI.jLabel72.setText("Max NFC: ");
                        MainClassGUI.jLabel74.setText("0");
                    }
                    else if (the_dataset_iss.equals("p03")){
                        MainClassGUI.jLabel96.setText("Success Rate (SR): ");
                        MainClassGUI.jLabel90.setText("Best NFC: ");
                        MainClassGUI.jLabel91.setText("Mean NFC: ");
                        MainClassGUI.jLabel92.setText("Max NFC: ");
                        MainClassGUI.jLabel94.setText("0");
                    }
                    else if (the_dataset_iss.equals("p04")){
                        MainClassGUI.jLabel118.setText("Success Rate (SR): ");
                        MainClassGUI.jLabel112.setText("Best NFC: ");
                        MainClassGUI.jLabel113.setText("Mean NFC: ");
                        MainClassGUI.jLabel114.setText("Max NFC: ");
                        MainClassGUI.jLabel116.setText("0");
                    }
                    else if (the_dataset_iss.equals("p05")){
                        MainClassGUI.jLabel144.setText("Success Rate (SR): ");
                        MainClassGUI.jLabel38.setText("Best NFC: ");
                        MainClassGUI.jLabel139.setText("Mean NFC: ");
                        MainClassGUI.jLabel140.setText("Max NFC: ");
                        MainClassGUI.jLabel142.setText("0");
                    }
                    else if (the_dataset_iss.equals("p06")){
                        MainClassGUI.jLabel165.setText("Success Rate (SR): ");
                        MainClassGUI.jLabel159.setText("Best NFC: ");
                        MainClassGUI.jLabel160.setText("Mean NFC: ");
                        MainClassGUI.jLabel161.setText("Max NFC: ");
                        MainClassGUI.jLabel163.setText("0");
                    }
                    else if (the_dataset_iss.equals("p07")){
                        MainClassGUI.jLabel187.setText("Success Rate (SR): ");
                        MainClassGUI.jLabel181.setText("Best NFC: ");
                        MainClassGUI.jLabel182.setText("Mean NFC: ");
                        MainClassGUI.jLabel183.setText("Max NFC: ");
                        MainClassGUI.jLabel185.setText("0");
                    }
                    else if (the_dataset_iss.equals("p08")){
                        MainClassGUI.jLabel207.setText("Success Rate (SR): ");
                        MainClassGUI.jLabel190.setText("Best NFC: ");
                        MainClassGUI.jLabel202.setText("Mean NFC: ");
                        MainClassGUI.jLabel203.setText("Max NFC: ");
                        MainClassGUI.jLabel205.setText("0");
                    }
                    break;
                }
            }
            long endTime = System.nanoTime(); 
            long duration = (endTime - startTime);  
            dur=duration;
            long sum=0;
            for(long value: dpr.race_NfcList){
                sum+=value;
            }
            
            //Dynamic Program Q3 findings
            long bestNFC = dpr.race_NfcList.first();//Q3 DP
            long maxNFC = nfcList.get(nfcList.size()-1); //DP Q3
            long meanNFC = (maxNFC+bestNFC)/2; //Q3 findings for Dynamic Programming
            successrate=100;    //DP Q3 findings
            //SR, Best NFC, Max, Mean NFC
            
            if (the_dataset_iss.equals("p01")){
                MainClassGUI.jLabel46.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel26.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel27.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel28.setText("Max NFC: "+ maxNFC);
                MainClassGUI.jProgressBar2.setIndeterminate(false);
            }
            else if (the_dataset_iss.equals("p02")){
                MainClassGUI.jLabel76.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel70.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel71.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel72.setText("Max NFC: "+ maxNFC);
                MainClassGUI.jProgressBar5.setIndeterminate(false);
            }
            else if (the_dataset_iss.equals("p03")){
                MainClassGUI.jLabel96.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel90.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel91.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel92.setText("Max NFC: "+ maxNFC);
                MainClassGUI.jProgressBar7.setIndeterminate(false);
            }
            else if (the_dataset_iss.equals("p04")){
                MainClassGUI.jLabel118.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel112.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel113.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel114.setText("Max NFC: "+ maxNFC);
                MainClassGUI.jProgressBar9.setIndeterminate(false);
            }
            else if (the_dataset_iss.equals("p05")){
                MainClassGUI.jLabel144.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel138.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel139.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel140.setText("Max NFC: "+ maxNFC);
                MainClassGUI.jProgressBar12.setIndeterminate(false);
            }
            else if (the_dataset_iss.equals("p06")){
                MainClassGUI.jLabel165.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel159.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel160.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel161.setText("Max NFC: "+ maxNFC);
                MainClassGUI.jProgressBar14.setIndeterminate(false);
            }
            else if (the_dataset_iss.equals("p07")){
                MainClassGUI.jLabel187.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel181.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel182.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel183.setText("Max NFC: "+ maxNFC);
                MainClassGUI.jProgressBar16.setIndeterminate(false);
            }
            else if (the_dataset_iss.equals("p08")){
                MainClassGUI.jLabel207.setText("Success Rate (SR): " + successrate + "%");
                MainClassGUI.jLabel190.setText("Best NFC: "+ bestNFC);
                MainClassGUI.jLabel202.setText("Mean NFC: "+ meanNFC);
                MainClassGUI.jLabel203.setText("Max NFC: "+ maxNFC);
                MainClassGUI.jProgressBar18.setIndeterminate(false);
            }
            return null;
        }
        public void done (){
            if (the_dataset_iss.equals("p01")){
                MainClassGUI.jProgressBar2.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel53.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel53.setText(wrd);
            }
            else if (the_dataset_iss.equals("p02")){
                MainClassGUI.jProgressBar5.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel77.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel77.setText(wrd);
            }
            else if (the_dataset_iss.equals("p03")){
                MainClassGUI.jProgressBar7.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel97.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel97.setText(wrd);
            }
            else if (the_dataset_iss.equals("p04")){
                MainClassGUI.jProgressBar9.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel119.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel119.setText(wrd);
            }
            else if (the_dataset_iss.equals("p05")){
                MainClassGUI.jProgressBar12.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel145.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel145.setText(wrd);
            }
            else if (the_dataset_iss.equals("p06")){
                MainClassGUI.jProgressBar14.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel166.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel166.setText(wrd);
            }
            else if (the_dataset_iss.equals("p07")){
                MainClassGUI.jProgressBar16.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel188.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel188.setText(wrd);
            }
            else if (the_dataset_iss.equals("p08")){
                MainClassGUI.jProgressBar3.setIndeterminate(false);
                String wrd = MainClassGUI.jLabel208.getText()+" "+String.format("%.5f",dur/1000000000.0) + " seconds";
                MainClassGUI.jLabel208.setText(wrd);
            }
        }
    }
    
    public static boolean only_DP_once = false;
    
    public void goAllOut(){
        if (only_DP_once==false){
            task_Name_LHS8 = new Thread_LHS8();
            task_Name_LHS8.execute();
            only_DP_once=true;
        }
        task_Name_RHS8 = new Thread_RHS8();
        task_Name_RHS8.execute();   
    }
    
    private Thread_LHS8 task_Name_LHS8;
    class Thread_LHS8 extends SwingWorker<Void,Void>{
        public Void doInBackground(){
            for(int t=1;t<=8;t++){
                if(t==1){
                    taskEmpiricalTestDeterministicAlgoThread = new EmpiricalTestDeterministicAlgo("p01",v_ds1,w_ds1,n_ds1,W_ds1,opt_pr_ds1);
                }
                else if (t==2){
                    taskEmpiricalTestDeterministicAlgoThread = new EmpiricalTestDeterministicAlgo("p02",v_ds2,w_ds2,n_ds2,W_ds2,opt_pr_ds2);
                }
                else if(t==3){
                    taskEmpiricalTestDeterministicAlgoThread = new EmpiricalTestDeterministicAlgo("p03",v_ds3,w_ds3,n_ds3,W_ds3,opt_pr_ds3);
                }
                else if(t==4){
                    taskEmpiricalTestDeterministicAlgoThread = new EmpiricalTestDeterministicAlgo("p04",v_ds4,w_ds4,n_ds4,W_ds4,opt_pr_ds4);
                }
                else if (t==5){
                    taskEmpiricalTestDeterministicAlgoThread = new EmpiricalTestDeterministicAlgo("p05",v_ds5,w_ds5,n_ds5,W_ds5,opt_pr_ds5);
                }
                else if(t==6){
                    taskEmpiricalTestDeterministicAlgoThread = new EmpiricalTestDeterministicAlgo("p06",v_ds6,w_ds6,n_ds6,W_ds6,opt_pr_ds6);
                }
                else if (t==7){
                    taskEmpiricalTestDeterministicAlgoThread = new EmpiricalTestDeterministicAlgo("p07",v_ds7,w_ds7,n_ds7,W_ds7,opt_pr_ds7);
                }
                else if (t==8){
                    taskEmpiricalTestDeterministicAlgoThread = new EmpiricalTestDeterministicAlgo("p08",v_ds8,w_ds8,n_ds8,W_ds8,opt_pr_ds8);
                }
                taskEmpiricalTestDeterministicAlgoThread.execute(); 
                while(taskEmpiricalTestDeterministicAlgoThread.isDone()==false) {
                    //Wait for thread completion
                }
            }
            return null;
        }
        public void done(){
            MainClassGUI.jButton6.setText("Begin Empirical Test");
            MainClassGUI.jProgressBar11.setIndeterminate(false);
        }   
    }
    
    private Thread_RHS8 task_Name_RHS8;
    class Thread_RHS8 extends SwingWorker<Void,Void>{
        public Void doInBackground(){
            for(int t=1;t<=8;t++){
                if(t==1){
                    taskEmpiricalTestNonDeterministicAlgoThread = new EmpiricalTestNonDeterministicAlgo("p01",v_ds1,w_ds1,n_ds1,W_ds1,opt_pr_ds1);
                }
                else if (t==2){
                    taskEmpiricalTestNonDeterministicAlgoThread = new EmpiricalTestNonDeterministicAlgo("p02",v_ds2,w_ds2,n_ds2,W_ds2,opt_pr_ds2);
                }
                else if(t==3){
                    taskEmpiricalTestNonDeterministicAlgoThread = new EmpiricalTestNonDeterministicAlgo("p03",v_ds3,w_ds3,n_ds3,W_ds3,opt_pr_ds3);
                }
                else if(t==4){
                    taskEmpiricalTestNonDeterministicAlgoThread = new EmpiricalTestNonDeterministicAlgo("p04",v_ds4,w_ds4,n_ds4,W_ds4,opt_pr_ds4);
                }
                else if (t==5){
                    taskEmpiricalTestNonDeterministicAlgoThread = new EmpiricalTestNonDeterministicAlgo("p05",v_ds5,w_ds5,n_ds5,W_ds5,opt_pr_ds5);
                }
                else if(t==6){
                    taskEmpiricalTestNonDeterministicAlgoThread = new EmpiricalTestNonDeterministicAlgo("p06",v_ds6,w_ds6,n_ds6,W_ds6,opt_pr_ds6);
                }
                else if (t==7){
                    taskEmpiricalTestNonDeterministicAlgoThread = new EmpiricalTestNonDeterministicAlgo("p07",v_ds7,w_ds7,n_ds7,W_ds7,opt_pr_ds7);
                }
                else if (t==8){
                    taskEmpiricalTestNonDeterministicAlgoThread = new EmpiricalTestNonDeterministicAlgo("p08",v_ds8,w_ds8,n_ds8,W_ds8,opt_pr_ds8);
                }
                taskEmpiricalTestNonDeterministicAlgoThread.execute(); 
                while(taskEmpiricalTestNonDeterministicAlgoThread.isDone()==false) {
                    //Wait for thread completion
                }
            }    
            return null;
        }
        public void done(){
            if(only_DP_once==true){
                MainClassGUI.jButton6.setText("Begin Empirical Test");
                MainClassGUI.jProgressBar11.setIndeterminate(false);
            }
        }   
    }
    
    public static void wipeScreen (){ //This plays the role of clearData and RESET
        only_DP_once=false;
        MainClassGUI.jLabel56.setText("Process time: ");
        MainClassGUI.jLabel88.setText("Process time: ");
        MainClassGUI.jLabel108.setText("Process time: ");
        MainClassGUI.jLabel130.setText("Process time: ");
        MainClassGUI.jLabel156.setText("Process time: ");
        MainClassGUI.jLabel177.setText("Process time: ");
        MainClassGUI.jLabel199.setText("Process time: ");
        MainClassGUI.jLabel217.setText("Process time: ");

        MainClassGUI.jLabel38.setText("Best NFC: ");
        MainClassGUI.jLabel37.setText("Mean NFC: ");
        MainClassGUI.jLabel36.setText("Max NFC: ");
        MainClassGUI.jLabel87.setText("Success Rate (SR): ");
        MainClassGUI.jLabel83.setText("Best NFC: ");
        MainClassGUI.jLabel82.setText("Mean NFC: ");
        MainClassGUI.jLabel81.setText("Max NFC: ");
        MainClassGUI.jLabel107.setText("Success Rate (SR): ");
        MainClassGUI.jLabel103.setText("Best NFC: ");
        MainClassGUI.jLabel102.setText("Mean NFC: ");
        MainClassGUI.jLabel101.setText("Max NFC: ");
        MainClassGUI.jLabel129.setText("Success Rate (SR): ");
        MainClassGUI.jLabel125.setText("Best NFC: ");
        MainClassGUI.jLabel124.setText("Mean NFC: ");
        MainClassGUI.jLabel123.setText("Max NFC: ");
        MainClassGUI.jLabel155.setText("Success Rate (SR): ");
        MainClassGUI.jLabel151.setText("Best NFC: ");
        MainClassGUI.jLabel150.setText("Mean NFC: ");
        MainClassGUI.jLabel149.setText("Max NFC: ");
        MainClassGUI.jLabel176.setText("Success Rate (SR): ");
        MainClassGUI.jLabel172.setText("Best NFC: ");
        MainClassGUI.jLabel171.setText("Mean NFC: ");
        MainClassGUI.jLabel170.setText("Max NFC: ");
        MainClassGUI.jLabel198.setText("Success Rate (SR): ");
        MainClassGUI.jLabel194.setText("Best NFC: ");
        MainClassGUI.jLabel193.setText("Mean NFC: ");
        MainClassGUI.jLabel192.setText("Max NFC: ");
        MainClassGUI.jLabel216.setText("Success Rate (SR): ");
        MainClassGUI.jLabel212.setText("Best NFC: ");
        MainClassGUI.jLabel211.setText("Mean NFC: ");
        MainClassGUI.jLabel210.setText("Max NFC: ");

        MainClassGUI.jLabel40.setText(" ");
        MainClassGUI.jLabel53.setText("Process time: ");
        MainClassGUI.jLabel46.setText("Success Rate (SR): ");
        MainClassGUI.jLabel74.setText(" ");
        MainClassGUI.jLabel77.setText("Process time : ");
        MainClassGUI.jLabel76.setText("Success Rate (SR): ");
        MainClassGUI.jLabel94.setText(" ");
        MainClassGUI.jLabel97.setText("Process time : ");
        MainClassGUI.jLabel96.setText("Success Rate (SR): ");
        MainClassGUI.jLabel116.setText(" ");
        MainClassGUI.jLabel119.setText("Process time : ");
        MainClassGUI.jLabel118.setText("Success Rate (SR): ");
        MainClassGUI.jLabel42.setText(" ");
        MainClassGUI.jLabel145.setText("Process time : ");
        MainClassGUI.jLabel144.setText("Success Rate (SR): ");
        MainClassGUI.jLabel163.setText(" ");
        MainClassGUI.jLabel166.setText("Process time : ");
        MainClassGUI.jLabel165.setText("Success Rate (SR): ");
        MainClassGUI.jLabel185.setText(" ");
        MainClassGUI.jLabel188.setText("Process time : ");
        MainClassGUI.jLabel187.setText("Success Rate (SR): ");
        MainClassGUI.jLabel205.setText(" ");
        MainClassGUI.jLabel208.setText("Process time : ");
        MainClassGUI.jLabel207.setText("Success Rate (SR): ");

        MainClassGUI.jLabel46.setText("Success Rate (SR): ");
        MainClassGUI.jLabel26.setText("Best NFC: ");
        MainClassGUI.jLabel27.setText("Mean NFC: ");
        MainClassGUI.jLabel28.setText("Max NFC: ");
        MainClassGUI.jLabel40.setText(" ");
        MainClassGUI.jLabel76.setText("Success Rate (SR): ");
        MainClassGUI.jLabel70.setText("Best NFC: ");
        MainClassGUI.jLabel71.setText("Mean NFC: ");
        MainClassGUI.jLabel72.setText("Max NFC: ");
        MainClassGUI.jLabel74.setText(" ");
        MainClassGUI.jLabel96.setText("Success Rate (SR): ");
        MainClassGUI.jLabel90.setText("Best NFC: ");
        MainClassGUI.jLabel91.setText("Mean NFC: ");
        MainClassGUI.jLabel92.setText("Max NFC: ");
        MainClassGUI.jLabel94.setText(" ");
        MainClassGUI.jLabel118.setText("Success Rate (SR): ");
        MainClassGUI.jLabel112.setText("Best NFC: ");
        MainClassGUI.jLabel113.setText("Mean NFC: ");
        MainClassGUI.jLabel114.setText("Max NFC: ");
        MainClassGUI.jLabel116.setText(" ");
        MainClassGUI.jLabel114.setText("Success Rate (SR): ");
        MainClassGUI.jLabel38.setText("Best NFC: ");
        MainClassGUI.jLabel139.setText("Mean NFC: ");
        MainClassGUI.jLabel140.setText("Max NFC: ");
        MainClassGUI.jLabel142.setText(" ");
        MainClassGUI.jLabel165.setText("Success Rate (SR): ");
        MainClassGUI.jLabel159.setText("Best NFC: ");
        MainClassGUI.jLabel160.setText("Mean NFC: ");
        MainClassGUI.jLabel161.setText("Max NFC: ");
        MainClassGUI.jLabel163.setText(" ");
        MainClassGUI.jLabel187.setText("Success Rate (SR): ");
        MainClassGUI.jLabel181.setText("Best NFC: ");
        MainClassGUI.jLabel182.setText("Mean NFC: ");
        MainClassGUI.jLabel183.setText("Max NFC: ");
        MainClassGUI.jLabel185.setText(" ");
        MainClassGUI.jLabel207.setText("Success Rate (SR): ");
        MainClassGUI.jLabel190.setText("Best NFC: ");
        MainClassGUI.jLabel202.setText("Mean NFC: ");
        MainClassGUI.jLabel203.setText("Max NFC: ");
        MainClassGUI.jLabel205.setText(" ");

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel p01_c;
    public static javax.swing.JLabel p01_p;
    public static javax.swing.JLabel p01_w;
    public static javax.swing.JLabel p02_c;
    public static javax.swing.JLabel p02_p;
    public static javax.swing.JLabel p02_w;
    public static javax.swing.JLabel p03_c;
    public static javax.swing.JLabel p03_p;
    public static javax.swing.JLabel p03_w;
    public static javax.swing.JLabel p04_c;
    public static javax.swing.JLabel p04_p;
    public static javax.swing.JLabel p04_w;
    public static javax.swing.JLabel p05_c;
    public static javax.swing.JLabel p05_p;
    public static javax.swing.JLabel p05_w;
    public static javax.swing.JLabel p06_c;
    public static javax.swing.JLabel p06_p;
    public static javax.swing.JLabel p06_w;
    public static javax.swing.JLabel p07_c;
    public static javax.swing.JLabel p07_p;
    public static javax.swing.JLabel p07_w;
    public static javax.swing.JLabel p08_c;
    public static javax.swing.JLabel p08_p;
    public static javax.swing.JLabel p08_w;
    // End of variables declaration//GEN-END:variables
}