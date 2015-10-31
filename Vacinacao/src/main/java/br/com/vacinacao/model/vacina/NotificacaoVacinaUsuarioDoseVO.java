package br.com.vacinacao.model.vacina;

import java.util.Date;

import br.com.vacinacao.model.usuario.UsuarioVO;
import br.com.vacinacao.util.DataUtil;

public class NotificacaoVacinaUsuarioDoseVO {

	private Integer sequencial;
	private UsuarioVO usuarioVO;
	private VacinaVO vacinaVO;
	private DoseVO doseVO;

	private Date dataNotificacao;
	private String dataNotificacaoFormatada;
	private String dataNotificacaoFormatadaBasica;

	public NotificacaoVacinaUsuarioDoseVO() {
		usuarioVO = new UsuarioVO();
		vacinaVO = new VacinaVO();
		doseVO = new DoseVO();
	}

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public UsuarioVO getUsuarioVO() {
		return usuarioVO;
	}

	public void setUsuarioVO(UsuarioVO usuarioVO) {
		this.usuarioVO = usuarioVO;
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

	public Date getDataNotificacao() {
		return dataNotificacao;
	}

	public void setDataNotificacao(Date dataNotificacao) {
		this.dataNotificacao = dataNotificacao;
		this.dataNotificacaoFormatada = DataUtil.formatarDataComHoraRetornandoString(dataNotificacao);
		this.dataNotificacaoFormatadaBasica = DataUtil.formatarDataRetornandoString(dataNotificacao);
	}

	public String getDataNotificacaoFormatada() {
		return dataNotificacaoFormatada;
	}

	public void setDataNotificacaoFormatada(String dataNotificacaoFormatada) {
		this.dataNotificacaoFormatada = dataNotificacaoFormatada;
	}

	public String getDataNotificacaoFormatadaBasica() {
		return dataNotificacaoFormatadaBasica;
	}

	public void setDataNotificacaoFormatadaBasica(String dataNotificacaoFormatadaBasica) {
		this.dataNotificacaoFormatadaBasica = dataNotificacaoFormatadaBasica;
	}



}
