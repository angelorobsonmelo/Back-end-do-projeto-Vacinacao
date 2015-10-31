package br.com.vacinacao.model.usuario;

import java.util.Date;

import br.com.vacinacao.util.DataUtil;

public class UsuarioVO {

	private Integer sequencial;
	private String regId;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String genero;
	private TipoUsuario tipoUsuario;
	private Date dataNascimento;
	private String dataNascimentoFormatada;
	private String dataNascimentoFormatadaBasica;

	public UsuarioVO() {
		tipoUsuario = new TipoUsuario();
	}

	public Integer getSequencial() {
		return sequencial;
	}
	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getDataNascimentoFormatadaBasica() {
		return dataNascimentoFormatadaBasica;
	}

	public void setDataNascimentoFormatadaBasica(
			String dataNascimentoFormatadaBasica) {
		this.dataNascimentoFormatadaBasica = dataNascimentoFormatadaBasica;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
		this.dataNascimentoFormatada = DataUtil.formatarDataComHoraRetornandoString(dataNascimento);
		this.dataNascimentoFormatadaBasica = DataUtil.formatarDataRetornandoString(dataNascimento);

	}

	public String getDataNascimentoFormatada() {
		return dataNascimentoFormatada;
	}

	public void setDataNascimentoFormatada(String dataNascimentoFormatada) {
		this.dataNascimentoFormatada = dataNascimentoFormatada;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

}
