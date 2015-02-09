import java.util.Arrays;

import jm.music.data.Note;
import jm.music.data.Phrase;

public class FitnessFunctions {
	
	/*Method: Note in Scale
	 * Input: A note and a Scale
	 * Output: A Boolean
	 * Description:  Tells you if this note is in the specified scale or not.
	 */
	public static boolean noteInScale(Note n1,int[] Scale){
		
	return n1.isScale(Scale);

	}

	/*Method: rangeOfPhase 
	 * Input: Phrase ph
	 * Output:An int (range)
	 * Description:  returns the difference between the highest and the lowest notes 
	 */
	public static double rangeOfPhrase(Phrase ph){
		int range=0;
		int highest = 0;
		int lowest = 0;
		Note n1 =  new Note();
		for (int x = 0; x < ph.getNoteArray().length; x++){
			n1 = ph.getNoteArray()[x];
			if (n1.getPitch() >highest){
				highest = n1.getPitch();
			}
			if (n1.getPitch() < lowest){
				lowest = n1.getPitch();
			}
		}
	range = Math.abs(highest - lowest);
	
	return range;
	}

	public static double unwantedIntervalPen(Note [] noteArray, double [] wantedIntervals){
		 
		double penalty = 0;
		double curUnwantedCount = 0;
		int prevPitch = 0; //to initialize
		int curPitch; //pitch we are on right now
		double dist = 0;
		for (int x = 0; x < noteArray.length;x++){
			curPitch = noteArray[x].getPitch();
			
			if (curPitch > prevPitch){
				//we went up in interval direction
				dist = curPitch - prevPitch;
				int wanted = 0;
				for (int y= 0; y <= wantedIntervals.length; x++){
					if (dist == wantedIntervals[y]){
						wanted = 1;
					}
				}
			if (wanted ==0){
				penalty++;
			} 
			
			prevPitch = curPitch;
			//return penalty;			
			}
	}
		return penalty;
}
	
	public static double unwantedIntervalPenCantus(Note [] noteArray){
		 
		double penalty = 0;
		double curUnwantedCount = 0;
		int prevPitch = 0; //to initialize
		int curPitch; //pitch we are on right now
		double dist = 0;
		for (int x = 0; x < noteArray.length;x++){
			curPitch = noteArray[x].getPitch();
			
			if (curPitch > prevPitch){
				//we went up in interval direction
				dist = curPitch - prevPitch;
				
			}
			else if (curPitch <= prevPitch){
				dist = prevPitch - curPitch;
			}
			//7 1 2 4 9 5
			if (dist != 7 && dist != 1 && dist != 2 && dist != 4 &&  dist != 9 && dist !=5 ){
			penalty++;	
			
			prevPitch = curPitch;
			//return penalty;			
			}
	}
		return penalty;
}
	
	public static double tooHigh(Note n1, int tolerance){
		double penalty = 0;
		 if (n1.getPitch() >= tolerance){
			 penalty = 1;
		 }
	return penalty;
	}
	
	public static double tooLow(Note n1, int tolerance){
		double penalty = 0;
		if (n1.getPitch() <= tolerance){
			penalty = 1;
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

	public static double repeatPen2(Note[] noteArray) {
		//eventually return this
		double penalty;
		
		//initialize
		double curPitch = 0;
		double prevPitch = 0;
		double dist;
		double longestSpan = 0; //longest notes are repeating
		double currentSpan=0; //current # of repeats we have seen
		for (int x = 0; x < noteArray.length; x++){
			curPitch = noteArray[x].getPitch();
			
			dist = curPitch - prevPitch;
			
			if (dist == 0){
				currentSpan++;
			}
			else{
				if (currentSpan > longestSpan){
					longestSpan = currentSpan;
				}
				currentSpan = 0;
			}

		}
		
		// TODO Auto-generated method stub
		return longestSpan;
	}

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


