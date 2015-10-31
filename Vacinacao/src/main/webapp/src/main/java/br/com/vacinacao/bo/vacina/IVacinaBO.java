package br.com.vacinacao.bo.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaVO;

public interface IVacinaBO {

	public String salvar(VacinaVO vacinaVO) throws BOException, SQLException;

	public String remover(VacinaVO vacinaVO) throws BOException, SQLException;

	public ArrayList<VacinaVO> listarTodas() throws BOException, SQLException;
	
	
}
