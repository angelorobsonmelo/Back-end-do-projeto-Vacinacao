package br.com.vacinacao.dao.vacina;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.VacinaDoseIntervaloVO;

public interface IVacinaDoseIntervaloDAO {

	
	public String salvar(VacinaDoseIntervaloVO vacinaDoseVO) throws DAOException;
	
	public String remover(VacinaDoseIntervaloVO vacinaDoseVO) throws DAOException;
	
	public ArrayList<VacinaDoseIntervaloVO> listarTodasPorSequencialVacina(VacinaDoseIntervaloVO vacinaDoseVO) throws DAOException;
	
	public ArrayList<VacinaDoseIntervaloVO> listarTodas() throws DAOException;
	
	
	
}
