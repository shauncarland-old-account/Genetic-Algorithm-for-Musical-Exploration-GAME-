import jm.JMC;
import jm.util.*;
import jm.music.data.*;
import jm.midi.*;

	public final class Chaos implements JMC{
		public static int song_length;

		public Score chaosInitialize(){
			
			Score s = new Score ("Initial Population");
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
				 Note n = new Note((int)(x*36)+song_length, Q);
				 phr.addNote(n);
					xold = x;
					yold = y;
				 
			 }

			
			return s;
			
			
		}
		
	
	}
	

