
public class Champion {
	
	//=========================================== VARIABLES =====================================
	String name, onevsone, vsBurst, vsMSJG, boots, firstItem, optionalItem, sumSpell, difficulty;
	
	
	
	
	//=========================================== CONSTRUCTOR =====================================
	
	public Champion() {
		this.name = "";
		this.onevsone = "";
		this.vsBurst = "";
		this.vsMSJG = "";
		this.boots = "";
		this.firstItem = "";
		this.optionalItem = "";
		this.sumSpell = "";
		this.difficulty = "";
		
	}
	
	public Champion(String name, String onevsone, String vsBurst, String vsMSJG, String boots,String firstItem, String optionalItem, String sumSpell, String difficulty) {
		this.name = name;
		this.onevsone = onevsone;
		this.vsBurst = vsBurst;
		this.vsMSJG = vsMSJG;
		this.boots = boots;
		this.firstItem = firstItem;
		this.optionalItem = optionalItem;
		this.sumSpell = sumSpell;
		this.difficulty = difficulty;
		
	}

	
	//=========================================== METHODS =====================================
	
	
	@Override
	public String toString() {
		
		return "[Champion: " + name + "] \n - Boots: " + boots + " \n - Summoner: " + sumSpell + " \n - Difficulty: " + difficulty + "\n";
	}
	
	
	
	//=========================================== GETTERS AND SETTERS =====================================

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOnevsone() {
		return onevsone;
	}


	public void setOnevsone(String onevsone) {
		this.onevsone = onevsone;
	}


	public String getVsBurst() {
		return vsBurst;
	}


	public void setVsBurst(String vsBurst) {
		this.vsBurst = vsBurst;
	}


	public String getVsMSJG() {
		return vsMSJG;
	}


	public void setVsMSJG(String vsMSJG) {
		this.vsMSJG = vsMSJG;
	}


	public String getBoots() {
		return boots;
	}


	public void setBoots(String boots) {
		this.boots = boots;
	}


	public String getOptionalItem() {
		return optionalItem;
	}


	public void setOptionalItem(String optionalItem) {
		this.optionalItem = optionalItem;
	}


	public String getSumSpell() {
		return sumSpell;
	}


	public void setSumSpell(String sumSpell) {
		this.sumSpell = sumSpell;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getFirstItem() {
		return firstItem;
	}

	public void setFirstItem(String firstItem) {
		this.firstItem = firstItem;
	}

}
