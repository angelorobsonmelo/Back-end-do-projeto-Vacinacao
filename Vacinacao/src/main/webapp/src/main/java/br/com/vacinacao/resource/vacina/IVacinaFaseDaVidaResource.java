package br.com.vacinacao.resource.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaFaseDaVidaVO;
import br.com.vacinacao.resource.util.ExecucaoResource;

public interface IVacinaFaseDaVidaResource {

	public ArrayList<ExecucaoResource> salvar(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws BOException, SQLException;
	
	public ArrayList<ExecucaoResource> remover(Integer sequencial) throws BOException, SQLException;
	
	public ArrayList<VacinaFaseDaVidaVO> listarTodas(Integer sequencialFaseDaVida) throws BOException, SQLException;
	
}
