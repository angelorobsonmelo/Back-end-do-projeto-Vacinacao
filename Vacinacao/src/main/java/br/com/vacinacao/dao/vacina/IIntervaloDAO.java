package br.com.vacinacao.dao.vacina;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.IntervaloVO;

public interface IIntervaloDAO {

	public ArrayList<IntervaloVO> listarTodas() throws DAOException;
	
	public String salvar(IntervaloVO intervaloVO) throws DAOException;
	
	public String remover(IntervaloVO intervalo) throws DAOException;
	
}
