package br.com.vacinacao.bo.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.bo.vacina.INotificacaoVacinaUsuarioDoseBO;
import br.com.vacinacao.dao.vacina.impl.NotificacaoVacinaUsuarioDoseDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.NotificacaoVacinaUsuarioDoseVO;

public class NotificacaoVacinaUsuarioDoseBO implements INotificacaoVacinaUsuarioDoseBO {

	NotificacaoVacinaUsuarioDoseDAO notificacaoVacinaUsuarioDoseDAO = new NotificacaoVacinaUsuarioDoseDAO();

	ArrayList<String> resultadoExecucaoProcedures= new ArrayList<String>();


	public String salvar(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDoseVO) throws BOException, SQLException {
		String resultadoExecucaoInserirOuAtualizarVacina = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirOuAtualizarVacina =  notificacaoVacinaUsuarioDoseDAO.salvar(notificacaoVacinaUsuarioDoseVO);
			resultadoExecucaoProcedures.add(resultadoExecucaoInserirOuAtualizarVacina);

			if (!resultadoExecucaoInserirOuAtualizarVacina.equals("OK")){
				throw new BOException("Erro ao inserir unidade de saúde. "+resultadoExecucaoInserirOuAtualizarVacina);
			}

			return Conexao.verificarResultadosDaExecucaoDeProceduresValidandoCommit(resultadoExecucaoProcedures);

		}catch (Exception ex) { 
			/*Preferivel que seja dado um Rollback neste caso*/

			throw new BOException(ex);
		}
		finally{
			resultadoExecucaoInserirOuAtualizarVacina = null;
			resultadoExecucaoProcedures.clear();

		}
	}


	public String remover(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDoseVO)
			throws BOException, SQLException {
		String resultadoExecucaoInserirOuAtualizarVacina = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirOuAtualizarVacina =  notificacaoVacinaUsuarioDoseDAO.remover(notificacaoVacinaUsuarioDoseVO);
			resultadoExecucaoProcedures.add(resultadoExecucaoInserirOuAtualizarVacina);

			if (!resultadoExecucaoInserirOuAtualizarVacina.equals("OK")){
				throw new BOException("Erro ao inserir unidade de saúde. "+resultadoExecucaoInserirOuAtualizarVacina);
			}

			return Conexao.verificarResultadosDaExecucaoDeProceduresValidandoCommit(resultadoExecucaoProcedures);

		}catch (Exception ex) { 
			/*Preferivel que seja dado um Rollback neste caso*/

			throw new BOException(ex);
		}
		finally{
			resultadoExecucaoInserirOuAtualizarVacina = null;
			resultadoExecucaoProcedures.clear();

		}
	}


	public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodos() throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return notificacaoVacinaUsuarioDoseDAO.buscarTodos();
		} catch (Exception e) {
			throw new BOException(e);
		}
	}


	public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodosPorSequencialUsuario(
			NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDose) throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return notificacaoVacinaUsuarioDoseDAO.buscarTodosPorSequencialUsuario(notificacaoVacinaUsuarioDose);
		} catch (Exception e) {
			throw new BOException(e);
		}
	}



}
