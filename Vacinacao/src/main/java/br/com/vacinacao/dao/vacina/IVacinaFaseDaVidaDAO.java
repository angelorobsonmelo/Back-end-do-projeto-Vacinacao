package br.com.vacinacao.dao.vacina;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.VacinaFaseDaVidaVO;

public interface IVacinaFaseDaVidaDAO {

	public String salvar(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws DAOException;

	public String remover(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws DAOException;

	public ArrayList<VacinaFaseDaVidaVO>  listarTodas(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws DAOException; 
	
	
	

}
