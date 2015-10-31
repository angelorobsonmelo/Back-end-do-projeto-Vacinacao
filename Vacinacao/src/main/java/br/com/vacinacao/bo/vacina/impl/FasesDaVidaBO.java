package br.com.vacinacao.bo.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.bo.vacina.IFasesDaVida;
import br.com.vacinacao.dao.vacina.impl.FasesDaVidaDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.FasesDaVidaVO;

public class FasesDaVidaBO implements IFasesDaVida {

	FasesDaVidaDAO fasesDaVidaDAO = new FasesDaVidaDAO();  
	
	public ArrayList<FasesDaVidaVO> listarTodas() throws BOException, SQLException {
		try {

			/*Setar o AutoCommit para False, validar toda a transação antes do Commit*/
			Conexao.setarAutoCommitParaFalse();

			return fasesDaVidaDAO.listarTodas();
		} catch (Exception e) {
			throw new BOException(e);
		}
	}

}
