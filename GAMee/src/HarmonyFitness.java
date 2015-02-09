import jm.music.data.Note;
import jm.music.data.Phrase;


public class HarmonyFitness {

	public static double rankHarmony(Phrase [] phr, Phrase Cantus){
		
		//ASSUME phr and cantus are the same size
		
		Note [] cantusArray = Cantus.getNoteArray();
		//we need to rank every member of phr against the Cantus
		for (int x = 0; x < phr.length; x++){
			//pull out note array
			Note [] phrArray = phr[x].getNoteArray();
			
			for (int y = 0; y < phrArray.length; y++){
				double dist =  cantusArray[y].getPitch() - phrArray[y].getPitch();
				System.out.println(dist);
				
			}
			
		}
 	return 0;
	}
	
}
