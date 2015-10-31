package br.com.vacinacao.bo.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.bo.vacina.IVacinaDoseIntervaloBO;
import br.com.vacinacao.dao.vacina.impl.VacinaDoseIntervaloDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaDoseIntervaloVO;

public class VacinaDoseIntervaloBO implements IVacinaDoseIntervaloBO {

	VacinaDoseIntervaloDAO vacinaDoseDAO = new VacinaDoseIntervaloDAO();

	ArrayList<String> resultadoExecucaoProcedures= new ArrayList<String>();

	public String salvar(VacinaDoseIntervaloVO vacinaDoseVO) throws BOException, SQLException {
		String resultadoExecucaoInserirOuAtualizarVacina = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirOuAtualizarVacina =  vacinaDoseDAO.salvar(vacinaDoseVO);
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

	public String remover(VacinaDoseIntervaloVO vacinaDoseVO) throws BOException, SQLException {

		String resultadoExecucaoInserirOuAtualizarVacina = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirOuAtualizarVacina =  vacinaDoseDAO.remover(vacinaDoseVO);
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

	public ArrayList<VacinaDoseIntervaloVO> listarTodasPorSequencialVacina(VacinaDoseIntervaloVO vacinaDoseVO) throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return vacinaDoseDAO.listarTodasPorSequencialVacina(vacinaDoseVO);
		} catch (Exception e) {
			throw new BOException(e);
		}
	}

	public ArrayList<VacinaDoseIntervaloVO> listarTodas() throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return vacinaDoseDAO.listarTodas();
		} catch (Exception e) {
			throw new BOException(e);
		}
	}

}
