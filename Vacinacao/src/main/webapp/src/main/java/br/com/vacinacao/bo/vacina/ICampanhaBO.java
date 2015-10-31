package br.com.vacinacao.bo.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.CampanhaVO;

public interface ICampanhaBO {

public String inserir(CampanhaVO campanha) throws BOException, SQLException;
	
	public String remover(CampanhaVO campanha) throws BOException, SQLException;
	
	public CampanhaVO consultar(CampanhaVO campanha) throws BOException, SQLException;
	
	public ArrayList<CampanhaVO>consultarTodos() throws BOException, SQLException;
	
	public String atualizar(CampanhaVO campanha) throws BOException, SQLException;
	
	public String salvar(CampanhaVO campanha) throws BOException, SQLException;
	
	
}
