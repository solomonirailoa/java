/*  A2_S11123197_S11086287_S11145995
    This is a fully functional Genetic Algorithm code for
    solving the 0-1 Knapsack Problem

    This code was pulled from the site StackOverflow
    Code was originally published by: @Amro
    Source: https://stackoverflow.com/a/1575995/16874783
    Date of code publication: 16th October 2009

*/

package com.nondeterministic.algo;

import java.util.*;

public class GeneticAlgorithm
{
    final static int ELITISM_K = 5;
    public static int POP_SIZE = 500 + ELITISM_K;  // population size (in some cases, number of individuals) POPULATION   (No. of individuals)
    final static int MAX_ITER = 789;             // max number of iterations (number of generations) -- GENERATIONS
    final static double MUTATION_RATE = 0.05;     // probability of mutation
    final static double CROSSOVER_RATE = 0.8;     // probability of crossover
    
    public static int optimalProfit=0;
    public static int optimalWeight=0;
    public static String optimalSelectionOfWeights="";
    public static int nfc=0;
    public static int transit=0;
    
    private static Random m_rand = new Random();  // random-number generator
    private Individual[] m_population;
    private double totalFitness=0.0;

    public GeneticAlgorithm(int v[], int w[], int n, int W) {
        this.v=v; this.w=w; this.n=n; this.W=W;
        POP_SIZE=(n*20)+ELITISM_K;
        m_population = new Individual[POP_SIZE];
        // init population
        for (int i = 0; i < POP_SIZE; i++) {
            m_population[i] = new Individual();
            m_population[i].randGenes();
        }
        // evaluate current population
        this.evaluate();
    }

    public void setPopulation(Individual[] newPop) {
        // this.m_population = newPop;
        System.arraycopy(newPop, 0, this.m_population, 0, POP_SIZE);
    }

    public Individual[] getPopulation() {
        return this.m_population;
    }

    public double evaluate() {
        this.totalFitness = 0.0;
        for (int i = 0; i < POP_SIZE; i++) {
            this.totalFitness += m_population[i].evaluate();
        }
        return this.totalFitness;
    }

    public Individual rouletteWheelSelection() {
        double randNum = m_rand.nextDouble() * this.totalFitness;
        int idx;
        for (idx=0; idx<POP_SIZE && randNum>0; ++idx) {
            randNum -= m_population[idx].getFitnessValue();
        }
        return m_population[idx-1];
    }

    public Individual findBestIndividual() {
        int idxMax = 0, idxMin = 0;
        double currentMax = 0.0;
        double currentMin = 1.0;
        double currentVal;

        for (int idx=0; idx<POP_SIZE; ++idx) {
            currentVal = m_population[idx].getFitnessValue();
            if (currentMax < currentMin) {
                currentMax = currentMin = currentVal;
                idxMax = idxMin = idx;
            }
            if (currentVal > currentMax) {
                currentMax = currentVal;
                idxMax = idx;
            }
            if (currentVal < currentMin) {
                currentMin = currentVal;
                idxMin = idx;
            }
        }
        return m_population[idxMax];        // maximization
    }

    public static Individual[] crossover(Individual indiv1,Individual indiv2) {
        Individual[] newIndiv = new Individual[2];
        newIndiv[0] = new Individual();
        newIndiv[1] = new Individual();
        int randPoint = m_rand.nextInt(Individual.SIZE);
        int i;
        for (i=0; i<randPoint; ++i) {
            newIndiv[0].setGene(i, indiv1.getGene(i));
            newIndiv[1].setGene(i, indiv2.getGene(i));
        }
        for (; i<Individual.SIZE; ++i) {
            newIndiv[0].setGene(i, indiv2.getGene(i));
            newIndiv[1].setGene(i, indiv1.getGene(i));
        }
        return newIndiv;
    }
    
    public void start(int v[], int w[], int n, int W){
        begin_GA(v,w,n,W);
    }

    public void start(int v[], int w[], int n, int W, String mode){
        if (mode.toLowerCase().equals("race")){
            is_in_a_race=true;
        }
        else if (mode.toLowerCase().equals("etest")){
            is_empirTest=true;
        }
        begin_GA(v,w,n,W);
    }

    public int[] w = null; //Read from "name"_w.txt
    public int[] v=null; //Read from "name"_p.txt
    public int W = -1; //maximum capacity of Knapsack read from "name"_c.txt
    public int n=-1; //Number of items inside "name"_p.txt and "name"_w.txt 
    public int[] optimal_selection_of_weights=null; //This is read from "name"_s.txt
    
    public int best_again;
    public int solution;
    
    public static SortedSet<Integer> race_ProfitList = new TreeSet<Integer>();
    public static boolean is_in_a_race = false;
    public static long racing_nfc=0;

    public static TreeSet<Integer> empirTest_ProfitList = new TreeSet<>();
    public static boolean is_empirTest=false;
    public static TreeSet<Long> empirTest_NfcList = new TreeSet<>();
    public static long empirTest_nfc=0;
    
    public void begin_GA(int v[], int w[], int n, int W) {
        nfc=0; optimalProfit=0;optimalWeight=0; empirTest_nfc=0;
        this.v=v;
        this.w=w;
        this.n=n;
        this.W=W;
        Individual.SIZE=n;
        Individual.v=v;
        Individual.w=w;
        Individual.W=W;
                
        GeneticAlgorithm pop = new GeneticAlgorithm(v,w,n,W);
        Individual[] newPop = new Individual[POP_SIZE];
        Individual[] indiv = new Individual[2];
        // main loop
        int count;
        for (int iter = 0; iter < MAX_ITER; iter++) {
            count = 0;
            // Elitism
            for (int i=0; i<ELITISM_K; ++i) {
                newPop[count] = pop.findBestIndividual();
                count++;
            }

            // build new GeneticAlgorithm
            while (count < POP_SIZE) {
                // Selection
                indiv[0] = pop.rouletteWheelSelection();
                indiv[1] = pop.rouletteWheelSelection();

                // Crossover
                if ( m_rand.nextDouble() < CROSSOVER_RATE ) {
                    indiv = crossover(indiv[0], indiv[1]);
                }

                // Mutation
                if ( m_rand.nextDouble() < MUTATION_RATE ) {
                    indiv[0].mutate();
                }
                if ( m_rand.nextDouble() < MUTATION_RATE ) {
                    indiv[1].mutate();
                }

                // add to new population
                newPop[count] = indiv[0];
                newPop[count+1] = indiv[1];
                count += 2;
            }
            pop.setPopulation(newPop);

            // reevaluate current population
            pop.evaluate();
            if(pop.findBestIndividual().getFitnessValue()==solution){
                best_again++;
            }
        }

        // best indiv
        Individual bestIndiv = pop.findBestIndividual();
        optimalWeight=0;
        String concat = "";
        for (int i = 0; i < n; i++) {
            concat+=bestIndiv.getGene(i);
            if(concat.charAt(i)!=0){
                optimalWeight+= bestIndiv.getGene(i)*w[i];
            }
        }
        optimalSelectionOfWeights=concat;
        optimalProfit= pop.findBestIndividual().getFitnessValue(); 
    }
    
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


class Individual
{
    public static int SIZE;// = GeneticAlgorithm.n;
    private int[] genes = new int[SIZE];
    private int fitnessValue;

    public Individual() {}

    public int getFitnessValue() {
        return fitnessValue;
    }

    public void setFitnessValue(int fitnessValue) {
        this.fitnessValue = fitnessValue;
    }

    public int getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, int gene) {
        this.genes[index] = gene;
    }

    public void randGenes() {
        Random rand = new Random();
        for(int i=0; i<SIZE; ++i) {
            this.setGene(i, rand.nextInt(2));
        }
    }

    public void mutate() {
        Random rand = new Random();
        int index = rand.nextInt(SIZE);
        this.setGene(index, 1-this.getGene(index));    // flip
    }
    
    public static int v[];
    public static int w[];
    public static int W;
    public int evaluate() { //Fitness function
        ++GeneticAlgorithm.nfc; int wsum = 0;//Fitness function
        int fitness = 0;//Fitness function
        for(int i=0; i<SIZE; ++i) {//Fitness function
            wsum+=this.getGene(i)*w[i];
            fitness+=this.getGene(i)*v[i];
        }
        if(wsum>W){
            fitness=0;
        }
        if(GeneticAlgorithm.is_in_a_race==true){
            GeneticAlgorithm.race_ProfitList.add(fitness);
            GeneticAlgorithm.racing_nfc++;
        }
        if (GeneticAlgorithm.is_empirTest==true){
            GeneticAlgorithm.empirTest_nfc++;
            int temp= GeneticAlgorithm.empirTest_ProfitList.size();
            GeneticAlgorithm.empirTest_ProfitList.add(fitness);
            if(temp<GeneticAlgorithm.empirTest_ProfitList.size()){
                GeneticAlgorithm.empirTest_NfcList.add(GeneticAlgorithm.empirTest_nfc);
            }
        }
        this.setFitnessValue(fitness);
        return fitness;
    }
}
