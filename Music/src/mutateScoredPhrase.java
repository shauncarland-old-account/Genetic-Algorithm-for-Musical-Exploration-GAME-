import java.util.*;

import jm.JMC;
import jm.music.data.*;
import jm.music.tools.Mod;


public class mutateScoredPhrase implements JMC{
	
	public static void MuxxNotes(scoredPhrase sP,  double[] noteParam){
		Random r = new Random();
		//manipulate the scoredPhrased note by note
		Phrase phr = sP.phrase;
		Note [] noteArray = phr.getNoteArray();
		double roll = 0;
		for (int x = 0; x < noteArray.length;x++){
			Note curNote = noteArray[x];
			
			//transpose up one octave? 
			roll = r.nextDouble();

			if (noteParam[0] > roll){
				Mod.transpose(curNote, 12);
			}
			//transpose down one octave? 

			roll = r.nextDouble();
			
			if (noteParam[1] > roll){
				Mod.transpose(curNote, -12);
			}
			//transpose up one perfect fifth? 

			roll = r.nextDouble();

			if (noteParam[2] > roll){
				Mod.transpose(curNote, 7);
			}
			//transpose down one perfect fifth? 

			roll = r.nextDouble();

			if (noteParam[3] > roll){
				Mod.transpose(curNote, -7);

		}
			//transpose up one random interval? 

			roll = r.nextDouble();
			if (noteParam[4] > roll){
				int increase = r.nextInt(12-1);
				Mod.transpose(curNote,increase);
			}
			//transpose down one random interval? 

			roll = r.nextDouble();
			if (noteParam[4] > roll){
				int decrease = r.nextInt(12-1);
				Mod.transpose(curNote,decrease);
			}

			//crossover?
			
			//roll = r.nextDouble();
			//if (roll  < 0.3 && x > 0){
				//Note temp = new Note();
				//Note temp2 = new Note();
				//temp = curNote;
				//temp2 = noteArray[x -1];
				
				//curNote = temp2;
				//noteArray[x-1] = temp;
		
				//switch
				
			}
		 
		
	}
	}

