package br.com.vacinacao.dao.usuario;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.usuario.UsuarioVO;

public interface IUsuarioDAO {

	public String inserir(UsuarioVO usuarioVO) throws DAOException;
	
	public UsuarioVO login(UsuarioVO usuarioVO) throws DAOException;
	
	
	
}
