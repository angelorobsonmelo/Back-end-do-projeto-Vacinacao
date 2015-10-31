package br.com.vacinacao.model.vacina;

public class IntervaloVO {

	private Integer sequencial;
	private String tempoIntervalo;
	private Integer dias;
	
	public Integer getSequencial() {
		return sequencial;
	}
	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}
	public String getTempoIntervalo() {
		return tempoIntervalo;
	}
	public void setTempoIntervalo(String tempoIntervalo) {
		this.tempoIntervalo = tempoIntervalo;
	}
	public Integer getDias() {
		return dias;
	}
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	
}
