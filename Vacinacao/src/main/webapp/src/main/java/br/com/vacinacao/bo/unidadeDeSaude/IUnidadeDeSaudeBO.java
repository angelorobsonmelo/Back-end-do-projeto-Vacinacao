package br.com.vacinacao.bo.unidadeDeSaude;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.unidadeDeSaude.UnidadeDeSaudeVO;

public interface IUnidadeDeSaudeBO {

	
public String inserir(UnidadeDeSaudeVO unidadeDeSaudeVO) throws BOException, SQLException;
	
	public ArrayList<UnidadeDeSaudeVO> consultarTodasAsUnidadesDeSaude() throws BOException, SQLException;
	
	public UnidadeDeSaudeVO consultarUnidadeDeSaudePorParametros(UnidadeDeSaudeVO unidadeDeSaudeVO)  throws BOException, SQLException;
	
	public String remover(UnidadeDeSaudeVO unidadeDeSaudeVO) throws BOException, SQLException;
	
	public String update(UnidadeDeSaudeVO unidadeDeSaudeVO) throws BOException, SQLException;
	
	public String salvar(UnidadeDeSaudeVO unidadeDeSaudeVO) throws BOException, SQLException;
	
}
