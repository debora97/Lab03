package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String parolaInserita;
	private boolean giusto;
	public RichWord(String parolaInserita) {
		
		this.parolaInserita = parolaInserita;
		
	}
	public String getParolaInserita() {
		return parolaInserita;
	}
	public boolean isGiusto() {
		return giusto;
	}
	public void setParolaInserita(String parolaInserita) {
		this.parolaInserita = parolaInserita;
	}
	public void setGiusto(boolean giusto) {
		this.giusto = giusto;
	}
	
	

}
