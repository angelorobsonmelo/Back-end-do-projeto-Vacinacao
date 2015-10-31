package br.com.vacinacao.bo.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.bo.vacina.IIntervaloBO;
import br.com.vacinacao.dao.vacina.impl.IntervaloDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.IntervaloVO;

public class IntervaloBO implements IIntervaloBO {

	IntervaloDAO intervaloDAO = new IntervaloDAO();
	ArrayList<String> resultadoExecucaoProcedures= new ArrayList<String>();
	
	public ArrayList<IntervaloVO> listarTodas() throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return intervaloDAO.listarTodas();
		} catch (Exception e) {
			throw new BOException(e);
		}
	}

	public String salvar(IntervaloVO intervaloVO) throws BOException, SQLException {
		String resultadoExecucaoInserirOuAtualizarVacina = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirOuAtualizarVacina =  intervaloDAO.salvar(intervaloVO);
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

	public String remover(IntervaloVO intervaloVO) throws BOException, SQLException {
		String resultadoExecucaoInserirOuAtualizarVacina = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirOuAtualizarVacina =  intervaloDAO.remover(intervaloVO);
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

}
