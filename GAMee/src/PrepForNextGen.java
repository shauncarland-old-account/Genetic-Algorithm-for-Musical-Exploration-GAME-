import java.util.Arrays;

import jm.music.data.*;
import jm.util.Play;


public class PrepForNextGen {
	public static void Prep(double [] fitnessArray, Phrase [] phrArray, Phrase [] topHalf, Phrase [] topTenth){

		int size = phrArray.length;
		Arrays.sort(fitnessArray);
		double median = Utilities.getMedian(fitnessArray);
		double tenth  = fitnessArray[1000 - fitnessArray.length/10];

		int topHalfCount = 0;
		int topTenthCount = 0;

		
		
		for (int x = 0 ; x < size; x ++){
			if (fitnessArray[x] >= median && topHalfCount < topHalf.length){
				topHalf[topHalfCount] = phrArray[x];
				topHalfCount++;
			}


			if (fitnessArray[x] >=tenth && topTenthCount < topTenth.length){
				topTenth[topTenthCount] = phrArray[x];
				topTenthCount++; 
			}
		}
		
		
		/*
		for (int x = 0; x < topTen.length; x++){
			Play.midi(topTen[x]);
		}
		*/


		
		//sort the fitness array
}

}