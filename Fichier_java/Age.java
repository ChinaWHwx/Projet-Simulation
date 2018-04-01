
public class Age {
	/*Attributs*/
	private int mois;
	private int an;
	
	/*Constructeur*/
	public Age(){
		this.mois=0;
		this.an=0;
	}

	/**Méthode**/
	public void viellir(){
		if(this.mois == 12){
			this.mois = 0;
			this.an++;
		}else{
			this.mois++;
		}
	}
	
	/*Pour affichage*/
	public String toString(){
		return ""+this.an+" an(s) "+this.mois+" mois";
	}
	
	/*Accesseur*/
	public int mois(){
		return mois;
	}

	public int an(){
		return an;
	}
}
