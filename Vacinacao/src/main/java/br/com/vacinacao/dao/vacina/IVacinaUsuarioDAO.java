package br.com.vacinacao.dao.vacina;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.VacinaUsuarioVO;

public interface IVacinaUsuarioDAO {

	public String salvar(VacinaUsuarioVO vacinaUsuarioVO) throws DAOException;
	
	public String remover(VacinaUsuarioVO vacinaUsuarioVO) throws DAOException;
	
	public ArrayList<VacinaUsuarioVO> listarTodasPorSequencialUsuario(VacinaUsuarioVO vacinaUsuarioVO) throws DAOException;
	
}
