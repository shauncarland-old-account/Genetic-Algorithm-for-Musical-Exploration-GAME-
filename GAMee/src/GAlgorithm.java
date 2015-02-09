import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

import jm.JMC;
import jm.music.data.*;
import jm.util.Play;

public class GAlgorithm implements JMC {

	public static Phrase [] firstSpecAlg(FitnessFCN fitfunc, Phrase [] Cantus){
		
	
		int l = 16;
		
		//int oct = 2;
		return Cantus;
		
	}
	
public static Phrase[] gAlg(FitnessFCN fitfunc){
	
	Phrase [] finalGen = new Phrase[1000];
		//Constants
	
		//eg a 16mer
		int l = GlobalParameters.motifLength;
		//int oct = 2;
		int populationSize = GlobalParameters.popSize;
		int size = GlobalParameters.popSize;
		int generations = GlobalParameters.generations;
		//parameters for note mutation
		double [] noteParam = new double [6];
		noteParam[0] = 0.4;
		noteParam[1] = 0.2;
		noteParam[2] = 0.3;
		noteParam[3] = 0.2;
		noteParam[4] = 0.2;
		noteParam[5] = 0.8;

		
		//parameters for phrase mutation
		double [] phraseParam = new double [4];
		phraseParam[0] = 0.12;
		phraseParam[1] = 0.5;
		phraseParam[2] = 0.5;
		phraseParam[3] = 0.25;
		
		
		
		
		//Score s = new Score();

		
		Part inst = new Part("Piano",0,JMC.PIANO);
		
		
		/*
		 * Initialize the Population
		 * In this stage, we will use a Chaos algorithm to create 1000 
		 */
		Phrase [] initialPop = new Phrase [size];
		double a, b;
		int c;
		Random rand = new Random();
		//double randomValue = 0 + (2 - 0) * rand.nextDouble();
		int[] fitArray = new int [size];
		int[] mode = {0,2,4,5,7,9,11,12}; //C major scale degrees
		
		
		 
		//Use CHAOS to Initialize the Population
		
		for(int x = 0; x < size; x ++){
			Phrase ph = new Phrase(0);
			for (int y = 0; y < l; y++)
			{
				//if (rand.nextDouble() > 0.5){
				Note n =new Note(rand.nextInt(88-22),Q);
				ph.add(n);
				//}
				
			}
			//a = 0 + (2 - 0) * rand.nextDouble();
			//b = 0 + (1 - 0) * rand.nextDouble();
			//c = rand.nextInt(85-1) + 1;
			
			//Init.randomInitialize(ph, l);
			//Init.chaosInitialize(ph,l,oct,a,b,c);
			initialPop[x] = ph;
		}


		
		/*
		 * Rank the initial population
		 */ 
		
		double [] initialFitness = Fitness.buildFitnessArray(initialPop);
		 
		
		
		/*
		 * Start Generation Loop
		 */
			double [] fitnessArray = new double[populationSize];
		Phrase [] currentPop = new Phrase[populationSize];
		Phrase [] nextPop = new Phrase [ (int) (populationSize * 0.4)];
		Phrase [] newGen = new Phrase [populationSize];
		double bestFitness = 0;

		//Generation Loop
		
		//initialize lists
		
		/*a scoredPhrase stores a fitness & a phrase 
		 * 
		 */
		scoredPhrase [] scored = new scoredPhrase[size];
		for (int i = 0; i < generations; i ++){
			
			
			
			//initialization
		  if (i == 0){ 
			  //we have not started the Generation Loop Yet
			  //Therefore, result to default values
		 fitnessArray = initialFitness;
		 currentPop = initialPop;
		  }
		 

			/*build up the scoredPhrase array.  it will hold 
			size (1000) scoredPhrase objects
			
			*/
			
			for(int j = 0; j < size; j++){
				
				
				//fitrank stores the current fitness
				double fitRank; 
				//create currentSP to store the information on currentPop[j]
				scoredPhrase currentSP = new scoredPhrase();
				
				//calculate fitness for currentPop[j]
				fitRank = fitfunc.rankPhrase(currentPop[j]);
				
				//store the variables
				currentSP.fitness = fitRank;
				currentSP.phrase = currentPop[j];
				
				//and finally, assign scored[j] to the currentSP! :D
				scored[j] = currentSP;
			}
			
			//we want to sort scored in order of fitness (descending)
			 List<scoredPhrase> scoredList = Arrays.asList(scored);
			  Collections.sort(scoredList,new SPComparator());
			  scoredPhrase [] scoredSorted = (scoredPhrase[]) scoredList.toArray();

			  //scoredSorted should be in Ascending to Descending Order
			  //System.out.println("Best fit: "+ bestFit + " Generation:" + i);
			  
			  //Partition scoredSorted into two Parts: the first 10%, the first 50%, an
			   
			  scoredPhrase[] tenthQuartile = new scoredPhrase [(int)(populationSize*0.1)];
			  scoredPhrase [] fiftyQuartile = new scoredPhrase [(int)(populationSize*0.5)];
			  int tenthQuartileCounter = 0;
			  //int fiftyQuartileCounter = 0;
			  for (int k = 0; k < (int)(populationSize*0.5); k++){
				  
				  if (k <(int)(populationSize*0.1)){
					  tenthQuartile[tenthQuartileCounter] = scoredSorted[k];
					  tenthQuartileCounter++;
				  }
			  
				  fiftyQuartile[k] = scoredSorted[k];
			  }
			   
			  scoredPhrase [] mutateThis = new scoredPhrase[(int)(populationSize*0.5)];
			  /*public static Phrase [] MuX(scoredPhrase mutateThis,scoredPhrase[] tenthQuartile, 
						scoredPhrase [] fiftyQuartile,double[] phraseParam, double[] noteParam){
						*/ 
			  Mutate.MuX(mutateThis, tenthQuartile, fiftyQuartile, phraseParam, noteParam);
			  
			  //we need to extract the phrase arrays from the system
			  
			  Phrase [] top50 = new Phrase [(int)(populationSize*0.5)];
			  Phrase [] mut = new Phrase [(int)(populationSize*0.5)];
			  for (int p = 0; p < (int)(populationSize*0.5); p++){
				  //System.out.println("p=" + p);
				  
				  Phrase mutx = new Phrase();
				  mutx = mutateThis[p].phrase;
				  mut[p] = mutx;
				  
				  
				  Phrase top50z = new Phrase();
				  top50z = fiftyQuartile[p].phrase;
				  top50[p] = top50z;
			  }
			  
			  Phrase [] newGeneration = new Phrase [populationSize];
			  System.arraycopy(mut,0,newGeneration,0,(int)(populationSize*0.5));
			  System.arraycopy(top50,0,newGeneration,(int)(populationSize*0.5),(int)(populationSize*0.5));
			   
			  currentPop = newGeneration;
			  //System.out.println(generations-2);
			  //this is our final result
			  if (i == generations - 2){
				  finalGen = currentPop;
			  }
			  
			  //Play.midi(newGeneration[1]);
			  
			  //System.out.println("Generation: " + i + " Best Fitness: " + tenthQuartile[0].fitness);
			  //Play.midi(tenthQuartile[0].phrase);
			  //System.out.println(newGeneration.length);
			 // currentPop = newGeneration;
			 
			  /*
			  for (int x = 0; x < 4; x++){
				  Play.midi(scoredSorted[x].phrase);
			  }
			  */
			  //
		/*	  
			double [] fitSort = fitnessArray;
		
		  Arrays.sort(fitSort);
		  Utilities.reverseOrder(fitSort);
//		double [] initalSort = initialFitness; 
		//Arrays.sort(fitSort,Collections.reverseOrder());
		  
		  
		//bestFitness = fitSort[0];
		double median = Utilities.getMedian(fitSort);
		double tenth  = fitSort[1000 - size/10];
		
		Phrase [] topHalf = new Phrase [size/2];
		Phrase [] topTenth = new Phrase [size/10];
		Phrase [] fourhund_mut = new Phrase[400];
	 
		PrepForNextGen.Prep(fitnessArray, currentPop, topHalf, topTenth);
		Mutate.Mutate(topTenth, topHalf, fourhund_mut, phraseParam, NoteParam);
		
		/*
		for (int j =0; j < 100; j++){
			Play.midi(topTenth[j]);
		}
		
		*/
		//next Gen  = topHalf + fourhund_mut + topTenth
		
			  /*
		System.arraycopy(topTenth,0,newGen , 0,  topTenth.length);
		System.arraycopy(topHalf, 0, newGen, topTenth.length, topHalf.length);
		System.arraycopy(fourhund_mut, 0, newGen, topTenth.length + topHalf.length, fourhund_mut.length);
		
		currentPop = newGen;
		
		System.out.println("Generation " + i + "Best Fitness " + bestFitness);
		bestFitness = 0;
		*/
		
		//View.sketch(currentPop[0]);
		
		//Utilities.playPhrase(newGen, 2);
		
		}
		return finalGen;
		
		

		
		
		
	}

		
	}

		


