import java.util.Random;

import jm.music.data.*;
import jm.music.tools.Mod;


public class correctPitch {

	public static void correctPitch(Phrase phr){
		Random r = new Random();
		
		Note [] noteArray = phr.getNoteArray();
		Note n1 = new Note();
		for (int x = 0; x < noteArray.length; x++){
			
			n1 =  noteArray[x];
			//System.out.println(n1.getPitch());
			if (n1.getPitch() > 80){
				while(true){
					int dice = r.nextInt(12-1);
				Mod.transpose(n1, -(dice));
				
				if (n1.getPitch() <80){
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
		
		
	}
}}}
