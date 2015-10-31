package br.com.vacinacao.dao.vacina;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.CampanhaVO;

public interface ICampanhaDAO {

	public String inserir(CampanhaVO campanha) throws DAOException;
	
	public String remover(CampanhaVO campanha) throws DAOException;
	
	public CampanhaVO consultar(CampanhaVO campanha) throws DAOException;
	
	public ArrayList<CampanhaVO>consultarTodos() throws DAOException;
	
	public String atualizar(CampanhaVO campanha) throws DAOException;
	
	public String salvar(CampanhaVO campanha) throws DAOException;
	
}
