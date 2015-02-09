import jm.JMC;
import jm.music.data.*;
import jm.music.tools.Mod;



/*
 * Class: CantusFitness
 * This class contains the functions that will evaluate the fitness of a single Phrase.  
 * This fitness function is epsecially tailored to write a cantas firmus
 * The following rules will be enforced:
 * 
 * No Notes Outside of the Scale 
 * 
 * Total Range should not exceed an 11th
 * 
 * Acceptable Melodic Intervals: major and minor seconds, thirds, 
 * and sixths, and perfect fourths, fifths, and octaves
 * 
 * No More than Two Leaps should be in a Line
 * 
 * A note should not be repeated more than three times
 */


public class CantusFitness implements JMC, FitnessFCN{
	
	/*
	 * CantusFitness; The following rules will be enforced:
	 * No Notes Outside of the Scale: Strongly Enforced 
	 * Total Range should not exceed an 11th
	 * 
	 */

	
	
	public  double rankPhrase(Phrase phr){
		//double rank=0;
		double curFit = 100;
		//iterate through the notes in the Phrase
		Note n1 = new Note ();
	
		int notInScalePen = 0;
		//int rangePen = 0;
		//System.out.println("here");
		Note [] noteArray = phr.getNoteArray();
		double tooHighCnt= 0;
		double tooLowCnt = 0;
		for (int x = 0; x < noteArray.length; x++){
			
			n1 =  noteArray[x];
			//System.out.println(n1.getPitch());
			if (n1.getPitch() > 60){
				while(true){
				Mod.transpose(n1, -12);
				
				if (n1.getPitch() <60){
					break;
				}
			}
		}
			
		if (n1.getPitch() < 20){
			while(true){
				Mod.transpose(n1,12);
			
			if (n1.getPitch() > 20){
				break;
			}
			
		}
			
			
			tooLowCnt =+ FitnessFunctions.tooLow(n1, 20);
			tooHighCnt =+ FitnessFunctions.tooHigh(n1, 65);
			
			/*
			 * BEGIN RANKING THE NOTES
			 */
			
			
			/*<3 <3 <3 ~~~test to see if this note is out of the scale ~~~ <3 <3 <3 */
			
			if (FitnessFunctions.noteInScale(n1, MAJOR_SCALE) == false){
				notInScalePen++;
			}
		
		}
		/*Begin Ovearll Phrase Diagnostics */
		
		/*test the range of this motif*/
		double rangePen = FitnessFunctions.rangeOfPhrase(phr);
		//maxRange = rangePen;
		
		/*test for repeating notes */
		
		double repeatPen = FitnessFunctions.repeatPen(phr.getNoteArray());
		//double repeatPen2 = FitnessFunctions.repeatPen2(phr.getNoteArray());

		/*test for unwanted intervals */
		
		double unwantedIntervalPen = FitnessFunctions.unwantedIntervalPenCantus(phr.getNoteArray());

		//System.out.println("hi");

		/*Display the penaltys */

		/*
		System.out.println("Not in Scale Penalty: " +notInScalePen);
		System.out.println("Range Pen: " + rangePen);
		System.out.println("UnwantedIntervanPen:" + unwantedIntervalPen);
		System.out.println("repeatPen:" + repeatPen);
		*/
		
		
		
		//System.out.println(phr);
		
		/*Apply the Penalty*/
		
		
		 if (notInScalePen >0){
		curFit = curFit/notInScalePen;
		 }
		if (rangePen > 200){
			curFit = curFit/1000;
		}
		curFit= curFit - rangePen;
		if (tooHighCnt>0 ){
		curFit = curFit/ (tooHighCnt);
		}
		
		if (repeatPen >4){
			curFit = curFit /6;
		}
		
		double reward = FitnessFunctions.uniqueReward(phr.getNoteArray());
	
		curFit =+ 5*reward;
		//System.out.println(curFit);
		//return curFit;
		}
		return curFit;
	}
	
	
	
	public double rankPhrase(Phrase phrase, Phrase[] phr) {
		throw new RuntimeException("You shouldn't call this method on the Cantus Fitness");
	}
}
