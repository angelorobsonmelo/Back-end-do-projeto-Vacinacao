package br.com.vacinacao.dao.vacina;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.DoseVO;

public interface IDoseDAO {

	public ArrayList<DoseVO> listarTodas() throws DAOException;
	
}
