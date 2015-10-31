package br.com.vacinacao.bo.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaUsuarioVO;

public interface IVacinaUsuarioBO {


	public String salvar(VacinaUsuarioVO vacinaUsuarioVO) throws BOException, SQLException;

	public String remover(VacinaUsuarioVO vacinaUsuarioVO) throws BOException, SQLException;

	public ArrayList<VacinaUsuarioVO> listarTodasPorSequencialUsuario(VacinaUsuarioVO vacinaUsuarioVO) throws BOException, SQLException;


}
