package br.com.vacinacao.bo.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.bo.vacina.IRegiaoVacinaViajanteBO;
import br.com.vacinacao.dao.vacina.impl.RegiaoVacinaViajanteDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.RegiaoVacinaViajanteVO;

public class RegiaoVacinaViajanteBO implements IRegiaoVacinaViajanteBO {

	RegiaoVacinaViajanteDAO regiaovacinaViajanteDAO = new RegiaoVacinaViajanteDAO();

	ArrayList<String> resultadoExecucaoProcedures= new ArrayList<String>();


	public ArrayList<RegiaoVacinaViajanteVO> listarTodasPorSequencialRegiao(RegiaoVacinaViajanteVO regiaoVacinaViajanteVO)
			throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return regiaovacinaViajanteDAO.listarTodasPorSequencialRegiao(regiaoVacinaViajanteVO);
		} catch (Exception e) {
			throw new BOException(e);
		}
	}

}
