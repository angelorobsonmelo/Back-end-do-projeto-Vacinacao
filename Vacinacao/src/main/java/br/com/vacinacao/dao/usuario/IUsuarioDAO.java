package br.com.vacinacao.dao.usuario;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.usuario.UsuarioVO;

public interface IUsuarioDAO {

	public String salvar(UsuarioVO usuarioVO) throws DAOException;
	
	public UsuarioVO login(UsuarioVO usuarioVO) throws DAOException;
	
	public UsuarioVO pesquisarPorEmail(UsuarioVO usuarioVO) throws DAOException;
	
	public String redefinirSenha(UsuarioVO usuarioVO) throws DAOException;
	
	public ArrayList<UsuarioVO> buscarTodos() throws DAOException;
	
}
