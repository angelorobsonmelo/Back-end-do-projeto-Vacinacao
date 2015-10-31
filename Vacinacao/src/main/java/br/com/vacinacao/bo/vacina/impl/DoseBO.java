package br.com.vacinacao.bo.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.bo.vacina.IDoseBO;
import br.com.vacinacao.dao.vacina.impl.DoseDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.DoseVO;

public class DoseBO implements IDoseBO {

	DoseDAO doseDAO = new DoseDAO();
	ArrayList<String> resultadoExecucaoProcedures= new ArrayList<String>();

	public ArrayList<DoseVO> listarTodas() throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return doseDAO.listarTodas();
		} catch (Exception e) {
			throw new BOException(e);
		}
	}


	public String salvar(DoseVO doseVO) throws BOException, SQLException {
		String resultadoExecucaoInserirOuAtualizarVacina = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirOuAtualizarVacina =  doseDAO.salvar(doseVO);
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


	public String remover(DoseVO doseVO) throws BOException, SQLException {
		String resultadoExecucaoInserirOuAtualizarVacina = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirOuAtualizarVacina =  doseDAO.remover(doseVO);
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


