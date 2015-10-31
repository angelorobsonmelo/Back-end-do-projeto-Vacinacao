package br.com.vacinacao.bo.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.RegiaoVacinaViajanteVO;

public interface IRegiaoVacinaViajanteBO {

	public ArrayList<RegiaoVacinaViajanteVO> listarTodasPorSequencialRegiao(RegiaoVacinaViajanteVO regiaoVacinaViajante) throws BOException, SQLException;
	
	
}
