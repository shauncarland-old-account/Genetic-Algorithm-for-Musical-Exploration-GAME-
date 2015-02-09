import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;


public final class chaosInitialize implements JMC{
	public static void chaosInitialize(Score s,int song_length, int octaves){
		
		s = new Score ("Initial Population");
		Part instr = new Part("Piano",0,PIANO);
		Phrase phr = new Phrase(0.0);
		double xold = 0.0; // init x position
		double x, y; // temp var
		double yold = 0.0; // init  y position

		 double a = 1.4;
		 double b = 0.3;
		 
		 for (int i = 0; i < song_length - 1; i ++){
				x = 1 + yold - a * xold * xold;
				y = b * xold;
			int pitch = (int)(x*36)+song_length;
			if (pitch >= 88){
				pitch = 88;
			}
			if (pitch <= 0){
				pitch =1;
			}
			 Note n = new Note(pitch, Q);
			 phr.addNote(n);
				xold = x;
				yold = y;
			 
		 }
		
		
	}

}
