package br.com.vacinacao.bo.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.bo.vacina.ICampanhaBO;
import br.com.vacinacao.dao.vacina.impl.CampanhaDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.CampanhaVO;

public class CampanhaBO implements ICampanhaBO {

	CampanhaDAO campanhaDAO = new CampanhaDAO();

	ArrayList<String> resultadoExecucaoProcedures= new ArrayList<String>();


	public String inserir(CampanhaVO campanha) throws BOException, SQLException {
		String resultadoExecucaoInserirCampanha = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirCampanha =  campanhaDAO.inserir(campanha);
			resultadoExecucaoProcedures.add(resultadoExecucaoInserirCampanha);

			if (!resultadoExecucaoInserirCampanha.equals("OK")){
				throw new BOException("Erro ao inserir unidade de saúde. "+resultadoExecucaoInserirCampanha);
			}

			return Conexao.verificarResultadosDaExecucaoDeProceduresValidandoCommit(resultadoExecucaoProcedures);

		}catch (Exception ex) { 
			/*Preferivel que seja dado um Rollback neste caso*/

			throw new BOException(ex);
		}
		finally{
			resultadoExecucaoInserirCampanha = null;
			resultadoExecucaoProcedures.clear();

		}
	}

	public String remover(CampanhaVO campanha) throws BOException, SQLException {
		String resultadoExecucaoRemoverCampanha = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoRemoverCampanha =  campanhaDAO.remover(campanha);
			resultadoExecucaoProcedures.add(resultadoExecucaoRemoverCampanha);

			if (!resultadoExecucaoRemoverCampanha.equals("OK")){
				throw new BOException("Erro ao inserir unidade de saúde. "+resultadoExecucaoRemoverCampanha);
			}

			return Conexao.verificarResultadosDaExecucaoDeProceduresValidandoCommit(resultadoExecucaoProcedures);

		}catch (Exception ex) { 
			/*Preferivel que seja dado um Rollback neste caso*/

			throw new BOException(ex);
		}
		finally{
			resultadoExecucaoRemoverCampanha = null;
			resultadoExecucaoProcedures.clear();

		}
	}

	public CampanhaVO consultar(CampanhaVO campanha) throws BOException,
	SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return campanhaDAO.consultar(campanha);
		} catch (Exception e) {
			throw new BOException(e);
		}
	}


	public ArrayList<CampanhaVO> consultarTodos() throws BOException,
	SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return campanhaDAO.consultarTodos();
		} catch (Exception e) {
			throw new BOException(e);
		}
	}

	public String atualizar(CampanhaVO campanha) throws BOException, SQLException {
		String resultadoExecucaoRemoverCampanha = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoRemoverCampanha =  campanhaDAO.atualizar(campanha);
			resultadoExecucaoProcedures.add(resultadoExecucaoRemoverCampanha);

			if (!resultadoExecucaoRemoverCampanha.equals("OK")){
				throw new BOException("Erro ao inserir unidade de saúde. "+resultadoExecucaoRemoverCampanha);
			}

			return Conexao.verificarResultadosDaExecucaoDeProceduresValidandoCommit(resultadoExecucaoProcedures);

		}catch (Exception ex) { 
			/*Preferivel que seja dado um Rollback neste caso*/

			throw new BOException(ex);
		}
		finally{
			resultadoExecucaoRemoverCampanha = null;
			resultadoExecucaoProcedures.clear();

		}
	}

	public String salvar(CampanhaVO campanha) throws BOException, SQLException {
		String resultadoExecucaoRemoverCampanha = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoRemoverCampanha =  campanhaDAO.salvar(campanha);
			resultadoExecucaoProcedures.add(resultadoExecucaoRemoverCampanha);

			if (!resultadoExecucaoRemoverCampanha.equals("OK")){
				throw new BOException("Erro ao inserir unidade de saúde. "+resultadoExecucaoRemoverCampanha);
			}

			return Conexao.verificarResultadosDaExecucaoDeProceduresValidandoCommit(resultadoExecucaoProcedures);

		}catch (Exception ex) { 
			/*Preferivel que seja dado um Rollback neste caso*/

			throw new BOException(ex);
		}
		finally{
			resultadoExecucaoRemoverCampanha = null;
			resultadoExecucaoProcedures.clear();

		}
	}




}
