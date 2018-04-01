import java.util.ArrayList;

public class Lapin {
	/*Attributs*/
	private char genre;
	private Age age;
	private Rnd rnd;
	private boolean enVie;
	private int maturity;
	private boolean portee;
	private int nbrPortee;
	
	/*Constructeur*/
	public Lapin(){
		this.enVie = true;
		this.rnd = new Rnd();
		float i = rnd.get();
		if(i <= 0.5){
			this.genre = 'f';
		}else{
			this.genre = 'm';
		}
		
		this.age = new Age();
		this.maturity = rnd.get(5,8);
		this.portee = false;
		this.nbrPortee = 0;
	}
	
	/**Méthode**/	
	public void survie(){
		float i = rnd.get();
		if(age.an() <= 1 || age.mois() <= 12){
			if(i > 0.2){
				enVie = false;
			}
		}else if(age.an() < 11){
			if(i > 0.5){
				enVie = false;
			}
		}else if(age.an() < 12){
			if(i > 0.4){
				enVie = false;
			}
		}else if(age.an() < 13){
			if(i > 0.3){
				enVie = false;
			}
		}else if(age.an() < 14){
			if(i > 0.2){
				enVie = false;
			}
		}else if(age.an() < 15){
			if(i > 0.1){
				enVie = false;
			}
		}else{
			enVie = false;
		}
	}
		
	public void portee(ArrayList<Lapin> laps){
		int port = rnd.get(0,1);
		if (port == 1){
			nbrPortee++;
			portee = true;
			int i = rnd.get(3,6);
			
			for(int j = 0; j < i; j++){
				laps.add(new Lapin());
			}
		}
	}
	
	/*Affichage*/
	public void affichage(){
		System.out.println(this.genre + " " + this.age.toString() + " Maturité : " + maturity+ " En vie : " + enVie);
	}
	
	/*Accesseur*/
	public char genre(){
		return genre;
	}

	public boolean enVie(){
		return enVie;
	}

	public int maturity(){
		return maturity;
	}

	public Age age(){
		return age;
	}
	
	public boolean portee(){
		return portee;
	}
	
	public void newPorte(){
		this.portee=false;
	}
	
	public int nbrPorte(){
		return nbrPortee;
	}
	
	public void newNbrPortee(){
		this.nbrPortee=0;
	}
}
