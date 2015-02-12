import java.util.Comparator;


public class SPComparator implements  Comparator<scoredPhrase>  {

	@Override
	public int compare(scoredPhrase sp1, scoredPhrase sp2) {
		// TODO Auto-generated method stub
		
		if (sp1.fitness > sp2.fitness){
			return -1;
		}
		else if (sp1.fitness < sp2.fitness){
			return 1;
		}
		else{
		return 0;
	}
	}
}
