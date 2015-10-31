package br.com.vacinacao.model.vacina;

public class VacinaDoseIntervaloVO {

	private Integer sequencial;
	private VacinaVO vacinaVO;
	private DoseVO doseVO;
	private IntervaloVO intervaloVO;

	public VacinaDoseIntervaloVO() {

		vacinaVO = new VacinaVO();
		doseVO = new DoseVO();
		intervaloVO = new IntervaloVO();

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

	public DoseVO getDoseVO() {
		return doseVO;
	}

	public void setDoseVO(DoseVO doseVO) {
		this.doseVO = doseVO;
	}

	public IntervaloVO getIntervaloVO() {
		return intervaloVO;
	}

	public void setIntervaloVO(IntervaloVO intervaloVO) {
		this.intervaloVO = intervaloVO;
	}

}
