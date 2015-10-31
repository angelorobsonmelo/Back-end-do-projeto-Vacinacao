package br.com.vacinacao.bo.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaDoseIntervaloVO;

public interface IVacinaDoseIntervaloBO {


	public String salvar(VacinaDoseIntervaloVO vacinaDoseVO) throws BOException, SQLException;
	
	public String remover(VacinaDoseIntervaloVO vacinaDoseVO) throws BOException, SQLException;
	
	public ArrayList<VacinaDoseIntervaloVO> listarTodasPorSequencialVacina(VacinaDoseIntervaloVO vacinaDoseVO) throws BOException, SQLException;
	
	public ArrayList<VacinaDoseIntervaloVO> listarTodas() throws BOException, SQLException;
	
	
}
