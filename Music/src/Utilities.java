import java.util.Random;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;

public class Utilities implements JMC {

	public static int calcDistance(int pitch1, int pitch2){
		int distance = Math.abs(pitch1 - pitch2);
		return distance;
		
	}
	
	public static double genFloat(){
		
	double r = Math.random();
	double result = ((long)(r * (529520586993098L - (-15549001010L) + 1)) -15549001010L) / 10000.0;
	return result;
	}

	public static double getMedian(double[] numArray) {
	    
		double median;
		if (numArray.length % 2 == 0){
		    median = ((double)numArray[numArray.length/2] + (double)numArray[numArray.length/2 - 1])/2;
	
		}else{
		    median = (double) numArray[numArray.length/2];
		}
		return median;
	}
	public static void playPhrase(Phrase [] ph, int count){
		for (int x = 0; x < count && x < ph.length; x ++)
		Play.midi(ph[x]);
	}
	
	/*
	public static void printPhrase (Phrase ph){
		Score s = new Score();
	}
	*/
	
	//reverse sorts a Phrase in sorted order
	
		public static void reverseOrder(double [] data) {
		    int left = 0;
		    int right = data.length - 1;

		    while( left < right ) {
		        // swap the values at the left and right indices
		        double temp = data[left];
		        data[left] = data[right];
		        data[right] = temp;

		        // move the left and right index pointers in toward the center
		        left++;
		        right--;
		    }
		}

		public static void spSort(scoredPhrase[] sp) {
			
			
		}
		
			
			
		}
	


