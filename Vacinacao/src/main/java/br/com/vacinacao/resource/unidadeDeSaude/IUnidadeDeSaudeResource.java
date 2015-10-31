package br.com.vacinacao.resource.unidadeDeSaude;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.unidadeDeSaude.UnidadeDeSaudeVO;
import br.com.vacinacao.resource.util.ExecucaoResource;

public interface IUnidadeDeSaudeResource {

	
public ArrayList<UnidadeDeSaudeVO> consultarTodasAsUnidadesDeSaude() throws BOException, SQLException;
	
	public UnidadeDeSaudeVO consultarUnidadeDeSaudePorParametros(UnidadeDeSaudeVO unidadeDeSaudeVO)  throws BOException, SQLException;
	
	public ArrayList<ExecucaoResource> remover(Integer sequencial) throws BOException, SQLException;
	
	public  ArrayList<ExecucaoResource> update(UnidadeDeSaudeVO unidadeDeSaudeVO) throws BOException, SQLException;
	
	public ArrayList<ExecucaoResource> inserir(UnidadeDeSaudeVO unidadeDeSaudeVO) throws BOException, SQLException;
	
}
