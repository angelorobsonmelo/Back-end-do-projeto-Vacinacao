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


	public ArrayList<DoseVO> listarTodas() throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return doseDAO.listarTodas();
		} catch (Exception e) {
			throw new BOException(e);
		}
	}
}


