package br.com.vacinacao.bo.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.FasesDaVidaVO;

public interface IFasesDaVida {

	public ArrayList<FasesDaVidaVO> listarTodas() throws BOException, SQLException;
	
}
