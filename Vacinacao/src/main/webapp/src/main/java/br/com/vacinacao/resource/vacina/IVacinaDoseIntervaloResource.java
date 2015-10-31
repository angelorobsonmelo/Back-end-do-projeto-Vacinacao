package br.com.vacinacao.resource.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaDoseIntervaloVO;
import br.com.vacinacao.resource.util.ExecucaoResource;

public interface IVacinaDoseIntervaloResource {

	public ArrayList<ExecucaoResource> salvar(VacinaDoseIntervaloVO vacinaDoseVO) throws BOException, SQLException;

	public ArrayList<ExecucaoResource> remover(Integer sequencial) throws BOException, SQLException;

	public ArrayList<VacinaDoseIntervaloVO> listarTodas(Integer sequencialVacina) throws BOException, SQLException;
	
	
}
