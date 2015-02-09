/*Written by Shaun Carland
 * (C) 2015 All Rights Reserved
 */



import java.util.*;

import jm.music.data.*;
import jm.music.tools.*;
import jm.util.Play;
import jm.util.View;
import jm.util.Write;
import jm.JMC;
import jm.audio.*;
import jm.util.*;
import jm.audio.AudioObject;
import jm.audio.synth.*;
import jm.audio.io.*;




class Music {
	public static int song_length;
	public static int octaves;
	public static String tone;
	public Phrase [] Cantus = new Phrase [1000];

	
	public  Phrase [] getCantus(){
		return Cantus;
	}
	 
	public static void main(String[] args) {
	
	//Scanner sc = new Scanner(System.in);
	 
	//Generate the Cantus Firmus
	
		
	
	Phrase [] Cantus = new Phrase [1000];
	FitnessFCN cantus = new CantusFitness();
	
	Cantus = GAlgorithm.gAlg(cantus);
	
	/*
	for (int x = 0; x < 4; x++){
		correctPitch.correctPitch(Cantus[0]);
	}
	*/
	//correctPitch.correctPitch(Cantus[0]);
	System.out.println("<3333");
	//Play.midi(Cantus[0]);
	
	
	Phrase output = new Phrase();
	//Instrument sineWave = new SimpleSineInst(44100);

	for (int x = 0; x < 10; x++){
		correctPitch.correctPitch(Cantus[x]);
		Mod.append(output, Cantus[x]);
	}
	Instrument sineWave = new SimpleSineInst(44100);

	//Play.midi(output);
	Write.au(output,"GameWav",sineWave);
	System.out.println("gay");
	//Write.midi(Cantus[0],"GAME Run 2");
	
	//Play.midi(Cantus[0]);
    //Demos.playDemos(Cantus);
	
/*
	Phrase Pa = new Phrase();
	Phrase Pb = new Phrase ();
	
	Pa = Cantus[0];
	Pb = Cantus[1];
	
	
	for (int x = 0; x < 4; x++){
		correctPitch.correctPitch(Cantus[(int) (GlobalParameters.popSize)/(3+x)]);
		Play.midi(Cantus[(int) (GlobalParameters.popSize)/(3+x)]);	
	}
	

	
	//Pb = buildFirstSpecies.buildFirst(Pa);

	//correctPitch.correctPitch(Pb);
	//Pa.setStartTime(0.5);
	//Pb.setStartTime(1.5);
/*	 
	Score sc = new Score();
	Part p = new Part(1);
	//Part p2 = new Part(2);
	p.addPhrase(Pa);
	//p2.addPhrase(Pb);
	sc.addPart(p);
	//sc.addPart(p2);
	Play.midi(sc);
	
	//MakeMusic.Mus(Cantus[0], Cantus[1]);
	
	
	
	/*
	
	Phrase FirstSpec = buildFirstSpecies.buildFirst(Cantus[0]);
	Score sc = new Score();
	
	
	Cantus[1].setStartTime(1.0);
	Cantus[2].setStartTime(3.0);
	
	correctPitch.correctPitch(Cantus[0]);
	correctPitch.correctPitch(Cantus[1]);
	correctPitch.correctPitch(Cantus[2]);
	
	Play.midi(Cantus[0]);
	Play.midi(Cantus[1]);
	Play.midi(Cantus[2]);

	
	//Play.midi(FirstSpec);
	//Play.midi(Cantus[0]);
	
/*	
	Part p = new Part();
	Part p2 = new Part();
	p.addPhrase(Cantus[0]);
	p2.addPhrase(FirstSpec.setStartTime(1.0););
	sc.addPart(p);
	//sc.addPart(p2);
	Play.midi(sc);
*/
	//Play.midi(Cantus[1]);
	
	/*
	Score sc = new Score();
		Part p = new Part();
		correctPitch.correctPitch(Cantus[0]);
		correctPitch.correctPitch(Cantus[1]);
		
		Mod.transpose(Cantus[1], 4);
		
		//transcribe Cantus[1] by a fifth
		
		
		
		p.addPhrase(Cantus[0]);
		p.addPhrase(Cantus[1]);
		
		
		
		HarmonyFitness.rankHarmony(Cantus, Cantus[0]);
		
		
		sc.addPart(p);
		Play.midi(sc);
		//s.addPart(p);
		//Play.midi(s);
	
	for (int x = 0; x < 8; x++){
	correctPitch.correctPitch(Cantus[x]);
	Play.midi(Cantus[x]);;
	for (int y = 4; y < 8; y++){
		correctPitch.correctPitch(Cantus[y]);
		Play.midi(Cantus[y]);
	
	}
	//Play.midi(Cantus[x]);
	}
	//Play.midi(Cantus[0]);
	/*
	FitnessFCN f1 = new firstFitness();
	Phrase [] first = new Phrase[1000];
	
	first = GAlgorithm.gAlg(f1);
	*/ 
	
	//Score s = new Score();
	//Part p = new Part();
	//p.addPhrase(Cantus[0]);
	//p.addPhrase(Cantus[15]);
	
	//s.addPart(p);
	//Play.midi(s);
	//Utilities.playPhrase(Cantus, 5);
	
	
	
}

	
}
	

	


