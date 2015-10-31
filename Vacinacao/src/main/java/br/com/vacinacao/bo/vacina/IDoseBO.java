package br.com.vacinacao.bo.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.DoseVO;

public interface IDoseBO {

	public ArrayList<DoseVO> listarTodas() throws BOException, SQLException;

	public String salvar(DoseVO doseVO) throws BOException, SQLException;

	public String remover(DoseVO doseVO) throws BOException, SQLException;

}
