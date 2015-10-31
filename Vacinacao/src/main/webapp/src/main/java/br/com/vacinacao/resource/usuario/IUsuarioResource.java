package br.com.vacinacao.resource.usuario;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.usuario.UsuarioVO;
import br.com.vacinacao.resource.util.ExecucaoResource;

public interface IUsuarioResource {

	public ArrayList<ExecucaoResource> inserir(UsuarioVO usuarioVO) throws BOException, SQLException;
	
	public UsuarioVO login(String email, String senha) throws BOException, SQLException;
	
}
