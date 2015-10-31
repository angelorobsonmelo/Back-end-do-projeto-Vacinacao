package br.com.vacinacao.model.vacina;

public class RegiaoVacinaViajanteVO {

	
	private Integer sequencial;
	private VacinaVO vacinaVO;
	private RegiaoVO regiaoVO;
	
	
	public RegiaoVacinaViajanteVO() {

		vacinaVO = new VacinaVO();
		regiaoVO = new RegiaoVO();
		
	}
	
	public Integer getSequencial() {
		return sequencial;
	}
	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}
	public VacinaVO getVacinaVO() {
		return vacinaVO;
	}
	public void setVacinaVO(VacinaVO vacinaVO) {
		this.vacinaVO = vacinaVO;
	}
	public RegiaoVO getRegiaoVO() {
		return regiaoVO;
	}
	public void setRegiaoVO(RegiaoVO regiaoVO) {
		this.regiaoVO = regiaoVO;
	}
	
	
}
