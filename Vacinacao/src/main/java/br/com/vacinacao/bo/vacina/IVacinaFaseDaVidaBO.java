package br.com.vacinacao.bo.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaFaseDaVidaVO;

public interface IVacinaFaseDaVidaBO {

	public String salvar(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws BOException, SQLException;
	
	public String remover(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws BOException, SQLException;
	
	public ArrayList<VacinaFaseDaVidaVO> listarTodas(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws BOException, SQLException;
	
	
}
