package br.com.vacinacao.bo.unidadeDeSaude.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.bo.unidadeDeSaude.IUnidadeDeSaudeBO;
import br.com.vacinacao.dao.unidadeDeSaude.impl.UnidadeDeSaudeDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.unidadeDeSaude.UnidadeDeSaudeVO;

public class UnidadeDeSaudeBO implements IUnidadeDeSaudeBO {

	UnidadeDeSaudeDAO unidadeDeSaudeDAO = new UnidadeDeSaudeDAO();

	ArrayList<String> resultadoExecucaoProcedures= new ArrayList<String>();
	
	
	public String inserir(UnidadeDeSaudeVO unidadeDeSaudeVO)
			throws BOException, SQLException {
		String resultadoExecucaoInserirUnidadeDeSaude = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();
			
			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirUnidadeDeSaude =  unidadeDeSaudeDAO.inserir(unidadeDeSaudeVO);
			resultadoExecucaoProcedures.add(resultadoExecucaoInserirUnidadeDeSaude);

			if (!resultadoExecucaoInserirUnidadeDeSaude.equals("OK")){
				throw new BOException("Erro ao inserir unidade de saúde. "+resultadoExecucaoInserirUnidadeDeSaude);
			}

			return Conexao.verificarResultadosDaExecucaoDeProceduresValidandoCommit(resultadoExecucaoProcedures);

		}catch (Exception ex) { 
			/*Preferivel que seja dado um Rollback neste caso*/

			throw new BOException(ex);
		}
		finally{
			resultadoExecucaoInserirUnidadeDeSaude = null;
			resultadoExecucaoProcedures.clear();
			
		}
	}

	public ArrayList<UnidadeDeSaudeVO> consultarTodasAsUnidadesDeSaude()
			throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return unidadeDeSaudeDAO.consultarTodasAsUnidadesDeSaude();
		} catch (Exception e) {
			throw new BOException(e);
		}
	}

	public UnidadeDeSaudeVO consultarUnidadeDeSaudePorParametros(
			UnidadeDeSaudeVO unidadeDeSaudeVO) throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return unidadeDeSaudeDAO.consultarUnidadeDeSaudePorParametros(unidadeDeSaudeVO);
		} catch (Exception e) {
			throw new BOException(e);
		}
	}

	public String remover(UnidadeDeSaudeVO unidadeDeSaudeVO)
			throws BOException, SQLException {
		String resultadoExecucaoRemoverUnidadeDeSaude = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();
			
			resultadoExecucaoProcedures.clear();

			resultadoExecucaoRemoverUnidadeDeSaude =  unidadeDeSaudeDAO.remover(unidadeDeSaudeVO);
			resultadoExecucaoProcedures.add(resultadoExecucaoRemoverUnidadeDeSaude);

			if (!resultadoExecucaoRemoverUnidadeDeSaude.equals("OK")){
				throw new BOException("Erro ao inserir unidade de saúde. "+resultadoExecucaoRemoverUnidadeDeSaude);
			}

			return Conexao.verificarResultadosDaExecucaoDeProceduresValidandoCommit(resultadoExecucaoProcedures);

		}catch (Exception ex) { 
			/*Preferivel que seja dado um Rollback neste caso*/

			throw new BOException(ex);
		}
		finally{
			resultadoExecucaoRemoverUnidadeDeSaude = null;
			resultadoExecucaoProcedures.clear();
			
		}
	}

	public String update(UnidadeDeSaudeVO unidadeDeSaudeVO) throws BOException,
			SQLException {
		String resultadoExecucaoUpdateUnidadeDeSaude = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();
			
			resultadoExecucaoProcedures.clear();

			resultadoExecucaoUpdateUnidadeDeSaude =  unidadeDeSaudeDAO.update(unidadeDeSaudeVO);
			resultadoExecucaoProcedures.add(resultadoExecucaoUpdateUnidadeDeSaude);

			if (!resultadoExecucaoUpdateUnidadeDeSaude.equals("OK")){
				throw new BOException("Erro ao inserir unidade de saúde. "+resultadoExecucaoUpdateUnidadeDeSaude);
			}

			return Conexao.verificarResultadosDaExecucaoDeProceduresValidandoCommit(resultadoExecucaoProcedures);

		}catch (Exception ex) { 
			/*Preferivel que seja dado um Rollback neste caso*/

			throw new BOException(ex);
		}
		finally{
			resultadoExecucaoUpdateUnidadeDeSaude = null;
			resultadoExecucaoProcedures.clear();
			
		}
	}

	public String salvar(UnidadeDeSaudeVO unidadeDeSaudeVO) throws BOException,
			SQLException {
		String resultadoExecucaoInserirUnidadeDeSaude = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();
			
			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirUnidadeDeSaude =  unidadeDeSaudeDAO.salvar(unidadeDeSaudeVO);
			resultadoExecucaoProcedures.add(resultadoExecucaoInserirUnidadeDeSaude);

			if (!resultadoExecucaoInserirUnidadeDeSaude.equals("OK")){
				throw new BOException("Erro ao inserir unidade de saúde. "+resultadoExecucaoInserirUnidadeDeSaude);
			}

			return Conexao.verificarResultadosDaExecucaoDeProceduresValidandoCommit(resultadoExecucaoProcedures);

		}catch (Exception ex) { 
			/*Preferivel que seja dado um Rollback neste caso*/

			throw new BOException(ex);
		}
		finally{
			resultadoExecucaoInserirUnidadeDeSaude = null;
			resultadoExecucaoProcedures.clear();
			
		}
	}

}
