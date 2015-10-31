package br.com.vacinacao.resource.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.DoseVO;

public interface IDoseResource {

	public ArrayList<DoseVO> listarTodas() throws BOException, SQLException;
	
}
