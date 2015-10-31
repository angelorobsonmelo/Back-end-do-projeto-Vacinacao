package br.com.vacinacao.bo.usuario;

import java.sql.SQLException;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.usuario.UsuarioVO;

public interface IUsuarioBO {

	public String salvar(UsuarioVO usuarioVO) throws BOException, SQLException;

	public UsuarioVO login(UsuarioVO usuarioVO) throws BOException, SQLException;

	public UsuarioVO pesquisarPorEmail(UsuarioVO usuarioVO) throws  BOException, SQLException;

	public String redefinirSenha(UsuarioVO usuarioVO) throws  BOException, SQLException;

}
