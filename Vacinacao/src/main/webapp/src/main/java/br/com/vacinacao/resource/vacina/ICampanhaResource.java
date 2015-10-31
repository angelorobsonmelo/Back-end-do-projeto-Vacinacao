package br.com.vacinacao.resource.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.CampanhaVO;
import br.com.vacinacao.resource.util.ExecucaoResource;

public interface ICampanhaResource {

	public ArrayList<ExecucaoResource> salvar(CampanhaVO campanha) throws BOException, SQLException;

	public ArrayList<ExecucaoResource> remover(Integer sequencial) throws BOException, SQLException;

	public CampanhaVO consultar(Integer sequencial) throws BOException, SQLException;

	public ArrayList<CampanhaVO>consultarTodos() throws BOException, SQLException;

}
