import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Play;


public class MakeMusic {
	public static void Mus(Phrase a, Phrase b){
		//assume both phrases are of the same length
		
		Note [] phaN = a.getNoteArray();
		Note [] phbN = b.getNoteArray();
		
		for (int x = 0; x < phaN.length; x++){
			Play.midi(phaN[x]);
			Play.midi(phbN[x]);
		}
		
		
	}
}
