package br.com.vacinacao.dao.unidadeDeSaude;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.unidadeDeSaude.UnidadeDeSaudeVO;

public interface IUnidadeDeSaudeDAO {

	public String inserir(UnidadeDeSaudeVO unidadeDeSaudeVO) throws DAOException;
	
	public ArrayList<UnidadeDeSaudeVO> consultarTodasAsUnidadesDeSaude() throws DAOException;
	
	public UnidadeDeSaudeVO consultarUnidadeDeSaudePorParametros(UnidadeDeSaudeVO unidadeDeSaudeVO)  throws DAOException;
	
	public String remover(UnidadeDeSaudeVO unidadeDeSaudeVO) throws DAOException;
	
	public String update(UnidadeDeSaudeVO unidadeDeSaudeVO) throws DAOException;
	
}
