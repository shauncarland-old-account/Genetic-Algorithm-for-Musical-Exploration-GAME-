import java.util.Random;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;


public final class Init implements JMC{
	
	 public static void randomInitialize(Phrase phr, int size){
			Part instr = new Part("Piano",0,PIANO);
			Random r = new Random();
		 for(int x = 0; x < size; x++){
			int pitch = r.nextInt(88-1);
			if (pitch <= 0){
				pitch++;
			}
			else if (pitch >= 88){
				pitch--;
			 Note n = new Note(pitch, Q);
			 phr.addNote(n);

		 }
	 }
	 }
	public static void chaosInitialize(Phrase phr,int song_length, int octaves, double a, double b, int c){
		//System.out.println("A = " + a + "B = " + b + "C = " + c);
		//System.out.println("hi");
		//s = new Score ("Initial Population");
		Part instr = new Part("Piano",0,PIANO);
		Random r = new Random();

		//Phrase phr = new Phrase(0.0);
		double xold = 0.0; // init x position
		double x, y; // temp var
		double yold = 0.0; // init  y position

		 //double a = 1.4;
		// double b = 0.3;
		
		 for (int i = 0; i < song_length - 1; i ++){
				x = 1 + yold - a * xold * xold;
				y = b * xold;
				
				int pitch = (int) ((x*c)+song_length);
				if (pitch <= 0){
					pitch = Math.abs(pitch);
				}
				
				//GO BACK HERE
				if (pitch >= 88){
					pitch = r.nextInt(87 -1);
					//pitch = 88;
				}
				
			 Note n = new Note(pitch, Q);
			 phr.addNote(n);
				xold = x;
				yold = y;
			 
		 }
		
		//instr.add(phr); 

		
	}

}
