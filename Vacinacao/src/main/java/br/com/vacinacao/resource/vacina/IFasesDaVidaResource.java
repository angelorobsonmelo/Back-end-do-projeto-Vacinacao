package br.com.vacinacao.resource.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.FasesDaVidaVO;

public interface IFasesDaVidaResource {

	
	public ArrayList<FasesDaVidaVO> listarTodas() throws BOException, SQLException;
	
}
