import jm.JMC;
import jm.music.data.*;
import jm.music.tools.*;


public class NoteMutate implements JMC{

	public static void NoteMutate(Note n,double[] noteParam){
		
		double rand = Utilities.genFloat();
		
		if (noteParam[0] > rand){
			mutTransOct(n);
		}
		 rand = Utilities.genFloat();
		 if (noteParam[1] > rand){
			 mutTransInRange(n,40);
			}
		
	}
	//swap two notes

	
	//transpose the note up an Octave
	public static void mutTransOct(Note n1){
		Mod.transpose(n1, 1);
	}
	
	
	//this transposes notes that are out of range back into range
		public static void mutTransInRange (Note n, int lower){
			int curPitch = 0;
			
				 curPitch = n.getPitch();
				 if (curPitch <= lower){
					 while (1==1){
						 Mod.transpose(n, 1);
						 if (curPitch <= lower){
							 break;
						 }
					 }
				 }
			}

		}
		
