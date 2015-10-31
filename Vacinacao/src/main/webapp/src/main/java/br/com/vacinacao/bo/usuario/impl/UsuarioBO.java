package br.com.vacinacao.bo.usuario.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.bo.usuario.IUsuarioBO;
import br.com.vacinacao.dao.usuario.impl.UsuarioDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.usuario.UsuarioVO;

public class UsuarioBO implements IUsuarioBO {

	UsuarioDAO usuarioDAO = new UsuarioDAO();

	ArrayList<String> resultadoExecucaoProcedures= new ArrayList<String>();

	public String inserir(UsuarioVO usuarioVO) throws BOException, SQLException {
		String resultadoExecucaoInserirUsuario = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirUsuario =  usuarioDAO.inserir(usuarioVO);
			resultadoExecucaoProcedures.add(resultadoExecucaoInserirUsuario);

			if (!resultadoExecucaoInserirUsuario.equals("OK")){
				throw new BOException("Erro ao inserir unidade de saúde. "+resultadoExecucaoInserirUsuario);
			}

			return Conexao.verificarResultadosDaExecucaoDeProceduresValidandoCommit(resultadoExecucaoProcedures);

		}catch (Exception ex) { 
			/*Preferivel que seja dado um Rollback neste caso*/

			throw new BOException(ex);
		}
		finally{
			resultadoExecucaoInserirUsuario = null;
			resultadoExecucaoProcedures.clear();

		}
	}

	public UsuarioVO login(UsuarioVO usuarioVO) throws BOException,
	SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return usuarioDAO.login(usuarioVO);
		} catch (Exception e) {
			throw new BOException(e);
		}
	}

}
