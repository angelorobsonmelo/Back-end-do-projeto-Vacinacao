package br.com.vacinacao.model.vacina;

import java.util.Date;

import br.com.vacinacao.model.usuario.UsuarioVO;
import br.com.vacinacao.util.DataUtil;

public class VacinaUsuarioVO {


	private Integer sequencial;
	private VacinaVO vacinaVO;
	private UsuarioVO usuarioVO;
	private String lote;
	private String local;
	private Date dataVacinacao;
	private String dataVacinacaoFormatada;
	private String dataVacinacaoFormatadaBasica;

	public VacinaUsuarioVO() {

     vacinaVO = new VacinaVO();
     usuarioVO = new UsuarioVO();

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

	public UsuarioVO getUsuarioVO() {
		return usuarioVO;
	}

	public void setUsuarioVO(UsuarioVO usuarioVO) {
		this.usuarioVO = usuarioVO;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(Date dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
		this.dataVacinacaoFormatada = DataUtil.formatarDataComHoraRetornandoString(dataVacinacao);
		this.dataVacinacaoFormatadaBasica = DataUtil.formatarDataRetornandoString(dataVacinacao);
		
	}

	public String getDataVacinacaoFormatada() {
		return dataVacinacaoFormatada;
	}

	public void setDataVacinacaoFormatada(String dataVacinacaoFormatada) {
		this.dataVacinacaoFormatada = dataVacinacaoFormatada;
	}

	public String getDataVacinacaoFormatadaBasica() {
		return dataVacinacaoFormatadaBasica;
	}

	public void setDataVacinacaoFormatadaBasica(String dataVacinacaoFormatadaBasica) {
		this.dataVacinacaoFormatadaBasica = dataVacinacaoFormatadaBasica;
	}

}
