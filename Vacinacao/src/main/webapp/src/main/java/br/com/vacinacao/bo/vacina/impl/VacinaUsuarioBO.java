package br.com.vacinacao.bo.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.bo.vacina.IVacinaUsuarioBO;
import br.com.vacinacao.dao.vacina.impl.VacinaUsuarioDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaUsuarioVO;

public class VacinaUsuarioBO implements IVacinaUsuarioBO {


	VacinaUsuarioDAO vacinaUsuarioDAO = new VacinaUsuarioDAO();

	ArrayList<String> resultadoExecucaoProcedures= new ArrayList<String>();
	
	
	public String salvar(VacinaUsuarioVO vacinaUsuarioVO) throws BOException, SQLException {
		String resultadoExecucaoInserirOuAtualizarVacina = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirOuAtualizarVacina =  vacinaUsuarioDAO.salvar(vacinaUsuarioVO);
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

	public String remover(VacinaUsuarioVO vacinaUsuarioVO) throws BOException, SQLException {
		String resultadoExecucaoInserirOuAtualizarVacina = null;

		try{	
			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			resultadoExecucaoProcedures.clear();

			resultadoExecucaoInserirOuAtualizarVacina =  vacinaUsuarioDAO.remover(vacinaUsuarioVO);
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

	public ArrayList<VacinaUsuarioVO> listarTodasPorSequencialUsuario(VacinaUsuarioVO vacinaUsuarioVO)
			throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return vacinaUsuarioDAO.listarTodasPorSequencialUsuario(vacinaUsuarioVO);
		} catch (Exception e) {
			throw new BOException(e);
		}
	}



	

}
