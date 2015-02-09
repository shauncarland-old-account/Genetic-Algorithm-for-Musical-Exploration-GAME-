import java.util.*;

import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;



public class Mutate implements JMC {
	
	
	public static void MuX(scoredPhrase [] mutateThis,scoredPhrase[] tenthQuartile, 
			scoredPhrase [] fiftyQuartile,double[] phraseParam, double[] noteParam){
			 Random r = new Random();
			 
			 //individual note mutations
			for (int i = 0; i < (int) (GlobalParameters.popSize *0.5) ; i++){
				//select a phrase to be mutated
				scoredPhrase phr = new scoredPhrase();
				//scoredPhrase preMut = phr;
				//phr = tenthQuartile[r.nextInt(99-1)];
				int lol = tenthQuartile.length-2;
				phr = tenthQuartile[r.nextInt(lol)];
				
				mutateScoredPhrase.MuxxNotes(phr,noteParam);
				mutateThis[i] = phr;
			}
		
			//Phrase Mutations
			
			//System.out.println("made it this far!");
			
		//return null;
		
	}
	
	public static Phrase[] Mu(scoredPhrase [] mutate_this, scoredPhrase[] bestHalf, scoredPhrase [] bestTenth, double[] phraseParam, double[] noteParam){
		
		
		/*Goal: Create 400 new motifs from the top 100 motifs that we were able to find
		*/
		scoredPhrase curSP = new scoredPhrase();
		Random r = new Random();
		Phrase [] mutatedPhrase = new Phrase [400];
		for (int x = 0; x < 400; x ++){
			curSP = bestTenth[r.nextInt(99)]; 
			PhraseMutate.PhraseMutate(curSP.phrase, phraseParam);
			mutatedPhrase[x] = curSP.phrase;
		}
		return mutatedPhrase;
		//mutation function will eventually go here
	}

	public static void Mutate(Phrase [] topTenth, Phrase [] topHalf, Phrase [] fourHundMut, double [] phraseParam, double []noteParam){
		
		/*
		 * GOAL: Create 400 new motifs from the top 100 motifs that will
		 * be given in as inputs.
		 */
		
		Phrase curPhrase = new Phrase();
		Note curNote = new Note();
		
		//create 400 new motifs (phraseGen.length*4 = 400
		Random r = new Random();
		
		for (int x = 0; x < 400; x++){
			//grab a phrase from the top 10% at random 
			curPhrase = topTenth[r.nextInt(99)]; 
			PhraseMutate.PhraseMutate(curPhrase,phraseParam);
			fourHundMut[x] = curPhrase;
			 
			/*
			//phrase mutation
			//select a phrase from the top 10
			curPhrase = phraseGen[x];
			for (int j = 0; j < curPhrase.length(); j++){
 				r.nextInt(101);
				curNote = curPhrase.getNoteArray()[r];
				NoteMutate.NoteMutate(curNote, noteParam);
				
			}
			PhraseMutate.PhraseMutate(curPhrase, phraseParam);
			
			
			*/
			//note mutation
			
		
		}
	
		
	}
	
}
	
	

