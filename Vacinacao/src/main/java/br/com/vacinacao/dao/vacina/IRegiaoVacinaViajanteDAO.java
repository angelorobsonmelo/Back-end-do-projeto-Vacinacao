package br.com.vacinacao.dao.vacina;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.RegiaoVacinaViajanteVO;

public interface IRegiaoVacinaViajanteDAO {

	public ArrayList<RegiaoVacinaViajanteVO> listarTodasPorSequencialRegiao(RegiaoVacinaViajanteVO regiaoVacinaViajante) throws DAOException;
	
}
