import jm.music.data.Phrase;


public interface FitnessFCN {
	
	double rankPhrase (Phrase phrase);
	
	double rankPhrase (Phrase phrase, Phrase [] phr);
	
}
