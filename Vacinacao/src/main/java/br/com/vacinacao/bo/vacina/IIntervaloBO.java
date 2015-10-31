package br.com.vacinacao.bo.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.IntervaloVO;

public interface IIntervaloBO {

	public ArrayList<IntervaloVO> listarTodas() throws BOException, SQLException;
	
	public String salvar(IntervaloVO intervaloVO) throws BOException, SQLException;
	
	public String remover(IntervaloVO intervalo) throws BOException, SQLException;
	
}
