package com.deterministic.algo;
/*  A2_S11123197_S11086287_S11145995
    This is Dynamic Programming approach for the 0-1 Knapsack problem 
    Got helpful pseudocode from the Textbook, and "Week 10\Lecture\" Moodle resources
    Source: "Dynamic Programming for Knapsack Problem.pdf" , page 14.
*/
import java.util.*;

public class DynamicProgramming { 
    public int optimalProfit=0;
    public int nfcc=0;
    public int itemCount = 0;
    public String word = "";
    public String optimalSelectionOfWeights;
    public int solution;
    public int best_again;
    
    public TreeSet<Integer> race_ProfitList = new TreeSet<>();
    public TreeSet<Long> race_NfcList = new TreeSet<>();
    public boolean is_in_a_race=false;
    public long racing_nfc=0;
    
    public ArrayList<Integer> empirTest_ProfitList = new ArrayList<>();
    public boolean is_empirTest=false;
    public int empirTest_nfc=0;
    
    public int max(int a, int b){ 
         ++nfcc; //NFC - number of function calls, for Dynamic Programming
         if (is_in_a_race==true){
            racing_nfc++;
            int temp = ((a > b) ? a : b);
            if(temp==solution){
                race_NfcList.add(racing_nfc);
                best_again++;
            }   
         }
         if (is_empirTest==true){
             empirTest_ProfitList.add((a > b) ? a : b);
         }
         return (a > b) ? a : b; 
    }
    
    public void start(int v[], int w[], int n, int W){
        begin_DP(v,w,n,W);
    }
    
    public void start(int v[], int w[], int n, int W, int sols){
        solution=sols;          
        is_in_a_race=true;      
        begin_DP(v,w,n,W);      
    }
    
    public void start(int v[], int w[], int n, int W, String mode){
        if (mode.toLowerCase().equals("etest")){
            is_empirTest=true;
        }
        begin_DP(v,w,n,W);
    }
    
    public int begin_DP(int v[], int w[], int n, int W){ //The actual DP algorithm
        //This is the main Algorithm (Dynamic Programming) for solvng 0-1 Knapsack problem
        nfc=0; nfcc=0;
        int i, ww; itemCount = n; //itemCount is the number of items in profit and weight arrays
        int V[][] = new int[n + 1][W + 1];
        for(ww=0; ww<=W;ww++){
            V[0][ww]=0;
        }
        for (i = 1; i<= n; i++) {
            for (ww = 0; ww<= W; ww++) {
                if (w[i - 1]<= ww){
                    V[i][ww] = max(v[i - 1] + V[i - 1][ww - w[i - 1]], V[i - 1][ww]);
                }
                else{
                    V[i][ww] = V[i - 1][ww];
                }
            }
        }
        int nn=n; int K=W; String concat="";
        while(nn != 0){
		if (V[nn][K] != V[nn - 1][K]){
			concat+=1;
                        if (nn-1!=0){
                            concat+=" ";
                        }
			K = K - w[nn-1];
		}
                else{
                    concat+=0;
                    if (nn-1!=0){
                            concat+=" ";
                    }
                }
		nn--;
	}
        String reverse_str = StringBuffer1.reverseString(concat);
        word=reverse_str;
        optimalProfit=V[n][W];
        
        optimalWeight(w); //and the Optimal selection of weights
        return V[n][W];
    }
    
    public void optimalWeight(int[] w){
        String[] splat = word.split(" ");
        String concat="";
        optimalWeight=0;
        for (int i = 0; i < itemCount;i++){
            optimalWeight+=(Integer.parseInt(splat[i]))*w[i];
            concat+=splat[i];
        }
        optimalSelectionOfWeights=concat;
        nfc=nfcc;
    }
    
    public int optimalWeight;
    public int nfc;
    
    public int getOptimalProfit(){
            return optimalProfit;
        }
        
        public int getOptimalWeight(){
            return optimalWeight;
        }
        
        public String getOptimalSelectionOfWeights(){
            return optimalSelectionOfWeights;
        }
        
        public int getNfc (){
            return nfc;
        }
}

class StringBuffer1 { //This is a string reverser
    public static String reverseString(String str){ //It is useful to reversing the solution produced by DP
        StringBuffer sb=new StringBuffer(str); //      so that it matches the solution in "name"_s.txt
        sb.reverse();
        return sb.toString();
    }
}
