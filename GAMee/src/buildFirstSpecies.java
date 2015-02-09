import java.util.Random;

import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.music.tools.Mod;


public class buildFirstSpecies {
 
	public static Phrase buildFirst(Phrase cantus){
		
		Phrase returnPhr = new Phrase();
		
		Note [] cantusNote = cantus.getNoteArray(); 
		Phrase firstSpec = new Phrase(); 
		
		Random r = new Random();
		for (int x = 0; x < cantusNote.length; x++){
			double dice = r.nextDouble();

			//dice = r.nextDouble();

			Note n1 = new Note();
			n1 = cantusNote[x];
			if (dice >= 0 && dice < 1/6){
				//major 3rd
				Mod.transpose(n1, 4);
			}
			if (dice >= 1/6 && dice < 2/6){
				//Minor Third
				Mod.transpose(n1,3);
			}
			
			if (dice >= 3/6 && dice < 4/6){
				//6th
				Mod.transpose(n1,9);
				
			}
			
			if (dice >= 4/6 && dice < 5/6){
				//10ths
				Mod.transpose(n1, 16);
			}
			
			if (dice >= 5/6 && dice < 5.5/6){
				Mod.transpose(n1, 12);
			}
			if (dice >=5.56 && dice < 1){
				Mod.transpose(n1,7);
			}
			
			returnPhr.add(n1);
			
		}
		 
		
		return returnPhr;
		
	}
	
}
