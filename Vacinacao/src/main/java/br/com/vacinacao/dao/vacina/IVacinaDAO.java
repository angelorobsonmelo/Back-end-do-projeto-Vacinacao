package br.com.vacinacao.dao.vacina;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.VacinaVO;

public interface IVacinaDAO {

	public String salvar(VacinaVO vacinaVO) throws DAOException;

	public String remover(VacinaVO vacinaVO) throws DAOException;

	public ArrayList<VacinaVO> listarTodas() throws DAOException;
	

}
