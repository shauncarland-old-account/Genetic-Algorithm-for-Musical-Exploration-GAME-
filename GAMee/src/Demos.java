import java.io.Console;
import java.util.Random;
import java.util.Scanner;

import jm.music.data.*;
import jm.music.tools.Mod;
import jm.util.Play;
import jm.util.View;
import jm.util.Write;


/*
 * Oh hi there! :D  This is where we will be performing some demos
 * of the Software that I wrote! :D :D :D 
 * 
 */
public class Demos {

	public static void playDemos (Phrase [] Cantus){
		
		Scanner c = new Scanner(System.in);
		System.out.println("Welcome to the Demos!");
		System.out.println("Press any character and then Enter to go to the first demo");
        c.next();

		Random r = new Random();
		
		
		System.out.println("this plays the best motif found by the algorithm");
		Phrase px = Cantus[0];
		correctPitch.correctPitch(px);
		Play.midi(Cantus[0]);
		Play.midi(px);
		View.notate(px);
		System.out.println("Press any character and then Enter to go to the second demo");
        c.next();

		//View.sketch(px);
		
		
		System.out.println("this plays a few random Phrases the Algorithm generated");
		
		for (int x = 0; x < 4; x++){
			correctPitch.correctPitch(Cantus[(int) (GlobalParameters.popSize)/(3+x)]);
			Play.midi(Cantus[(int) (GlobalParameters.popSize)/(3+x)]);	
			View.notate(Cantus[(int) (GlobalParameters.popSize)/(3+x)]);
		}
		System.out.println();
		System.out.println("Press any character and then Enter to go to the third demo");
        c.next();
        
		
		//Play.midi(superPhrase);
		System.out.println();
		System.out.println("this plays two Phrases against each other (Chord Progressions)");	
		
		
		Phrase Pa = new Phrase();
		Phrase Pb = new Phrase ();
		
		
		Pa = Cantus[r.nextInt(GlobalParameters.popSize-4)];
		Pb = Cantus[r.nextInt(GlobalParameters.popSize-3)];
		
		correctPitch.correctPitch(Pa);
		
				
		correctPitch.correctPitch(Pb);
		Play.midi(Pa);
		Write.midi(Pa);
		
		Score sc = new Score();
		Part p = new Part(1);
		Part p2 = new Part(2);
		p.addPhrase(Pa);
		p2.addPhrase(Pb);
		sc.addPart(p);
		sc.addPart(p2);
		
		Play.midi(sc);
		
		View.notate(Pa);
		View.notate(Pb);
		
		System.out.println();
		System.out.println("Press any character and then Enter to go to the fourth demo");
        c.next();

		
		System.out.println("this plays two Phrases against each other in different rhythms(Polyphony)");	
		
		
		Phrase Pc = new Phrase();
		Phrase Pd = new Phrase ();
		
		Pc = Cantus[r.nextInt(GlobalParameters.popSize-4)];
		Pd = Cantus[r.nextInt(GlobalParameters.popSize-3)];
		
		correctPitch.correctPitch(Pc);
		correctPitch.correctPitch(Pd);
		
		
		
		//0.1 and 0.5: Galloping
		//1 and 1.3 chasing
		Pc.setStartTime(0.1);
		Pd.setStartTime(0.5);
		Score sc2 = new Score();

		Part p3 = new Part(1);
		Part p4 = new Part(2);
		p3.addPhrase(Pc);
		p4.addPhrase(Pd);
		sc2.addPart(p3);
		sc2.addPart(p4);
		
		//Score sc2 = new Score();
		Play.midi(sc2);
		View.notate(Pc);
		View.notate(Pd);
	
		}//end
		
	
		
	}
		
	
	

