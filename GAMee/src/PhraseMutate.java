import java.util.Random;

import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.music.tools.Mod;


public class PhraseMutate {
	
public static void PhraseMutate(Phrase phr, double [] phraseParam){
	
	double rand = Utilities.genFloat();

	if (phraseParam[0] > rand){
		mutTranspose(phr);
	}
	rand = Utilities.genFloat();
	
	if (phraseParam[1] > rand){
		mutTranspose(phr);
		
	}
	rand = Utilities.genFloat();

	if (phraseParam[2] > rand){
		mutTranspose(phr);
		
	}
	rand = Utilities.genFloat();
	
	if (phraseParam[3] > rand){
		mutTranspose(phr);
		
	}
	//rand = Utilities.genFloat();
}
	
	public static void mutTranspose (Phrase phr){
		Random r = new Random();
		int rand = (int) (Math.random() * (10 - 1));
		
		if (rand < 5){
	//transpose the phrase by a fifth
	Mod.transpose(phr, 7);	
	}
		else {
		//transpose phrase by an octave
			Mod.transpose(phr,12);
		}
	}
	
	public static void swapNotes(Note n1, Note n2){
		Note temp1 = new Note();
		Note temp2 = new Note();
		n1 = temp1;
		n2 = temp2;
		
		n1 = temp2;
		n2 = temp1;
		
	}
	
	public static void muInvert(Phrase ph){
		Mod.invert(ph);
	}

	public static void muShuffle(Phrase ph){
		Mod.shuffle(ph);
	
}
}