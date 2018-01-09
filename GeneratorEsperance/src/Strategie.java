
public class Strategie {
	private String[] s;
	private int nbS;
	
	public Strategie(int nbCards){
		nbS = (int)Math.pow(nbCards,2);
		s = new String[nbS];
		for(int i=1;i<nbS;i++){
			if(i<=nbS/2){
				s[i]="F";
				if(i<=nbS/4){
					s[i]+='F';
				}else{
					s[i]+='C';
				}
			}else{
				s[i]="C";
				if(i<=3*nbS/4){
					s[i]+='F';
				}else{
					s[i]+='C';
				}
			}
			if(i%2==1){
				s[i]+='F';
			}else{
				s[i]+='C';
			}
		}
	}
	
	public void Affiche(){
		for(int i=1;i<nbS;i++)
			System.out.println(s[i]);
	}
	
	public String getStrat(int numStrat){
		return s[numStrat];
	}
}
