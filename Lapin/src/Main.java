import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Lapin> laps = new ArrayList<Lapin>();
		ArrayList<Lapin> lapsMatMal = new ArrayList<Lapin>();			
		ArrayList<Lapin> lapsMatFem = new ArrayList<Lapin>();
		
		int mois = 48;
		int h = 1;
		int total = 0;
		
		long tot[] = new long[mois+1];
		
		for(int i = 0; i < 20; i++){
			laps.add(new Lapin());
		}
		
		for(int i = 1; i <= mois; i++){			
			if(i == 12*h){
				survieList(laps);
				survieList(lapsMatMal);
				survieList(lapsMatFem);
				h++;
			}
			
			for(int j = 0; j < lapsMatFem.size(); j++){
				lapsMatFem.get(j).newPorte();
			}
			
			int l = 0;
			while(l < laps.size()) {				
				if(laps.get(l).age().mois() == laps.get(l).maturity()){
					if(laps.get(l).genre()=='f')
						lapsMatFem.add(laps.get(l));
					else{
						lapsMatMal.add(laps.get(l));
					}
					laps.remove(l);
				}else {
					l++;
				}
			}
			
			for(int j = 0; j < lapsMatFem.size(); j++){
				for(int k = 0; k < lapsMatMal.size(); k++){
					if(lapsMatFem.get(j).age().mois() == lapsMatFem.get(j).maturity()){
						lapsMatFem.get(j).newNbrPortee();
					}
					
					if(lapsMatFem.get(j).nbrPorte() < 8){
						lapsMatFem.get(j).portee(laps);
					}
					
					if(lapsMatFem.get(j).portee()) {
						k = lapsMatMal.size();
					}
				}
			}
			
			for(int j = 0; j < laps.size(); j++){
				laps.get(j).age().viellir();
			}
			for(int j = 0; j < lapsMatFem.size(); j++){
				lapsMatFem.get(j).age().viellir();
			}
			for(int j = 0; j < lapsMatMal.size(); j++){
				lapsMatMal.get(j).age().viellir();
			}
			
			total = laps.size() + lapsMatFem.size() + lapsMatMal.size();
			tot[i] = total;
			
			int a = h-1;
			int m = i-12*a+1;
			
			System.out.println("An " + h + " Mois " + m + " ::: Nombre de lapins total : " + total);
			/*System.out.println("Mois " + i + " : Nombre de petits lapins : " + laps.size()+"\n");
			System.out.println("Nombre de lapins male : " + lapsMatMal.size()+"\n");*/
		}
		Histogramme histo = new Histogramme(mois, tot);
		System.out.println("Fin de simulation");
		
	}
	
	public static void survieList(ArrayList<Lapin> laps){
		int j = 0;
		while(j < laps.size()) {
			laps.get(j).survie();
			if(!laps.get(j).enVie()){
				laps.remove(j);
			}else {
				j++;
			}
		}
	}

}
