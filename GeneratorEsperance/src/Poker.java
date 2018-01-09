import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Poker {

	public static void main(String[] args) {
		int nbCards = 3;
		int nbS = (int)Math.pow(nbCards,2);
		int B = 1; // Blind
		int R = 1; // Raise
		
		Strategie p1 = new Strategie(nbCards);
		Strategie p2 = new Strategie(nbCards);
		
		double matEspecance[][] = new double[nbS][nbS];
		for(int k=1;k<nbS;k++){
			for(int l=1;l<nbS;l++){
				matEspecance[k][l]=0;
			}
		}
		for(int k=1;k<nbS;k++){
			for(int l=1;l<nbS;l++){
				int matResult[][] = new int[nbCards][nbCards];
				int sumCard[] = new int[nbCards];
				for(int i=0;i<nbCards;i++){
					sumCard[i] = 0;
				}
				for(int i=0;i<nbCards;i++){
					for(int j=0;j<nbCards;j++){
						if(p1.getStrat(k).charAt(i)=='F'){
							if(i==j){
								matResult[i][j] = 0;
							}else if(i<j){
								matResult[i][j] = -B;
							}else{
								matResult[i][j] = B;
							}
						}else if(p1.getStrat(k).charAt(i)=='C' && p2.getStrat(l).charAt(j)=='F'){
							matResult[i][j] = B;
						}else{
							if(i==j){
								matResult[i][j] = 0;
							}else if(i<j){
								matResult[i][j] = -B-R;
							}else{
								matResult[i][j] = B+R;
							}
						}
					}
					for(int j=0;j<nbCards;j++){
						sumCard[i] += matResult[i][j];
					}
				}
				for(int i=0;i<nbCards;i++){
					matEspecance[k][l] += sumCard[i];
					
				}
				matEspecance[k][l] = matEspecance[k][l]/Math.pow(nbCards, 2);
				int p1Strat = 8;
				int p2Strat = 7;
				
				if(k==p1Strat && l==p2Strat){
					System.out.println("Strategie 1 : " +p1.getStrat(p1Strat));
					System.out.println("Strategie 2 : " +p2.getStrat(p2Strat));
					for(int i=0;i<nbCards;i++){
						for(int j=0;j<nbCards;j++){
							System.out.print(matResult[i][j] + " ");
						}
						System.out.println();
					}
					System.out.println();
				}
			}
		}
		DecimalFormat df = new DecimalFormat("#0.00");
		df.setRoundingMode(RoundingMode.DOWN);
		for(int i=1;i<nbS;i++){
			for(int j=1;j<nbS;j++){
				System.out.print((df.format(matEspecance[i][j])) + " ");
			}
			System.out.println();
		}
	}

}
