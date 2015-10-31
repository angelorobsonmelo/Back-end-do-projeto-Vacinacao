package br.com.vacinacao.resource.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.RegiaoVacinaViajanteVO;

public interface IRegiaoVacinaViajanteResource {

	public ArrayList<RegiaoVacinaViajanteVO> listarTodasPorSequencialRegiao(Integer sequencialRegiao)
			throws BOException, SQLException;
	
}
