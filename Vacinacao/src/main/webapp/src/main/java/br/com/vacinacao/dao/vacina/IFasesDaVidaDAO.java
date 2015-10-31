package br.com.vacinacao.dao.vacina;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.FasesDaVidaVO;

public interface IFasesDaVidaDAO {

	public ArrayList<FasesDaVidaVO> listarTodas() throws DAOException;
	
	
	
}
