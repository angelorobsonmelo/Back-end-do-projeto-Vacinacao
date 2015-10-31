package br.com.vacinacao.resource.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.IntervaloVO;

public interface IIntervaloResource {


	public ArrayList<IntervaloVO> listarTodas() throws BOException, SQLException;

	public String salvar(IntervaloVO intervaloVO) throws BOException, SQLException;

	public String remover(Integer sequencialIntervalo) throws BOException, SQLException;


}
