import java.util.Random;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;

import java.util.Arrays;


public final class Fitness implements JMC{
	
	public static double[] buildFitnessArray(Phrase [] phr){
		 
		double a, b;
		int c;
		Random rand = new Random();
		//double randomValue = 0 + (2 - 0) * rand.nextDouble();
		int size = phr.length;
		double [] fitArray = new double [size];
		
		for (int x = 0; x < size; x++){
			Phrase curPhr = phr[x];
			double curFit = 200;
			//deduct for notes outside of the scale
			curFit = curFit - 15.5*Fitness.NotesNotInScale(curPhr, JMC.MAJOR_SCALE);
			
			//deduct for notes outside of the range
			double notInRangePen = notInRangePen(curPhr.getNoteArray(), 40,80);
			curFit = curFit - notInRangePen;
			//System.out.println(curFit);
			
			//deduct notes for repeats
			double repeatPen = repeatPen(curPhr.getNoteArray()); 
		
			curFit = curFit - (int) 40*repeatPen;
			//System.out.println(repeatPen);
			 
			//deduct for large leaps
			double fifthsLeapPen = largeLeapsPen(curPhr.getNoteArray());
			curFit = curFit - (int) 2*fifthsLeapPen;
			
			//deduct for dissonant intervals
			double disPen = dissPen(curPhr.getNoteArray());
			curFit = curFit - 3*(int) disPen;
			
			//reward for unique notes
			double uniqueReward = uniqueReward(curPhr.getNoteArray());
			curFit = curFit + 15*uniqueReward;
			//System.out.println(curFit);
			fitArray[x] = curFit;
			//Play.midi(curPhr);;
			}
		return fitArray;
	}
	
	public static double NotesNotInScale(Phrase phr,int[] Scale){
		
		Note[] phrArray = phr.getNoteArray();
		
		//how many notes are not in the scale?
		double notInScaleCount = 0; 
		for (int x= 0; x < phrArray.length; x++){
			if (phrArray[x].isScale(Scale)== false){
				notInScaleCount++;
			}
		}
		return notInScaleCount;

	}

	public static double notInRangePen(Note [] noteArray, int lower, int upper){
		//Note[] phrArray = phr.getNoteArray(); 
		double penalty = 0;
		for (int x = 0; x < noteArray.length; x++){
			double curPen=0;
		
			Note cur = noteArray[x];
			int pitch = cur.getPitch();
			
			if (pitch > upper){
				curPen = pitch - upper;
			}
			else if (pitch < lower){
			curPen = 25;
				
			}
			penalty =+ curPen;
	

		}	
		return penalty;

	}
	
	public static double repeatPen(Note [] noteArray){
		double penalty = 0;
		double curRepeatCount=0;
		double mostRepeats=0;
		int prevPitch = 0; //initialized
		int curPitch;
		
		for (int x = 0; x < noteArray.length;x++){
			curPitch = noteArray[x].getPitch();
			if (curPitch == prevPitch){
				curRepeatCount++;
			}
			else if (curPitch != prevPitch){
				if(curRepeatCount > mostRepeats){
					mostRepeats = curRepeatCount;
					curRepeatCount = 0;
				}
			}
			prevPitch = curPitch;
			
			
		}
		penalty = mostRepeats;
		return penalty; 

	}
	
	public static double largeLeapsPen(Note [] noteArray){
		double penalty = 0;
		int prevPitch = 0; //initialized
		int curPitch;
		int curDistance; 
		
		for (int x = 0; x < noteArray.length;x++){
			curPitch = noteArray[x].getPitch();
			curDistance = Utilities.calcDistance(curPitch, prevPitch);
			//System.out.println(curDistance);
			//prevPitch = curPitch; 
			
			/*
			 * Note; we allow intervals of 12 (octave jumps) for this test
			 */
			
			penalty =+ Math.sqrt(Utilities.calcDistance(prevPitch,curPitch));
			
			prevPitch = curPitch;

		}
		return penalty;

		
	}
	public static double dissPen(Note [] noteArray){
	
	int penalty=0;
	int prevPitch = 0;
	int curPitch, curDistance;
	
	for(int x = 0; x < noteArray.length; x++){
		curPitch = noteArray[x].getPitch();
		int curDist = Utilities.calcDistance(curPitch, prevPitch);
		if (curDist == 1 || curDist == 2 || curDist == 3){
			penalty++;
		}
		prevPitch = curPitch;

	}
	
	
	return penalty;
	}
	
	
	/*TO DO:
	 * 
	 */
	
	public static double uniqueReward(Note [] noteArray){
		double reward = 0;
		int curPitch;
		//if boolArray[x] = null, we haven't seen this yet

		//Boolean[] boolArray = new Boolean [88];
		
		int [] seen = new int [88];
		Arrays.fill(seen,0);
		//if seen[x] = 0, we haven't seen this
		//int [] seen = new int [noteArray.length];
		int bonus = 0;
		int curSeen;
		//int seenAlready = 0;
		for (int x = 0; x <noteArray.length; x++){
			curPitch = noteArray[x].getPitch();
			
			if (curPitch < 0){
				curPitch = 1;
			}
			if (curPitch >= 87){
				curPitch = 86;
			}
			
			curSeen = seen[curPitch];
			//System.out.println(curPitch);
			//curSeen = seen[curPitch];
			
			if (curSeen==0){
				//System.out.println(curPitch);
				//we have not seen this pitch yet
				bonus++;
				seen[curPitch] = 1;
			}
			
			
	//	}
		//System.out.println("Bonus: " + bonus);
	
	}
		return reward;
	
	}
}
	