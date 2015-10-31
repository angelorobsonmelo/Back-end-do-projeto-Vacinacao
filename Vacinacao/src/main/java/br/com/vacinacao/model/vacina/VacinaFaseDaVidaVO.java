package br.com.vacinacao.model.vacina;

public class VacinaFaseDaVidaVO {

	private Integer sequencial;
	private VacinaVO vacinaVO;
	private FasesDaVidaVO fasesDaVidaVO;
	
	public VacinaFaseDaVidaVO() {
 
		vacinaVO = new VacinaVO();
		fasesDaVidaVO = new FasesDaVidaVO();
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

	public FasesDaVidaVO getFasesDaVidaVO() {
		return fasesDaVidaVO;
	}

	public void setFasesDaVidaVO(FasesDaVidaVO fasesDaVida) {
		this.fasesDaVidaVO = fasesDaVida;
	}
	
}
