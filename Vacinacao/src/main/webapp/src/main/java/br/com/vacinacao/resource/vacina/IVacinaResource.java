package br.com.vacinacao.resource.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaVO;
import br.com.vacinacao.resource.util.ExecucaoResource;

public interface IVacinaResource {

	public ArrayList<ExecucaoResource> salvar(VacinaVO vacinaVO) throws BOException, SQLException;

	public ArrayList<ExecucaoResource> remover(Integer sequencial) throws BOException, SQLException;

	public ArrayList<VacinaVO> listarTodas() throws BOException, SQLException;


	
}
