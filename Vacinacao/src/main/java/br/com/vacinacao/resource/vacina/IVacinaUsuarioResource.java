package br.com.vacinacao.resource.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaUsuarioVO;
import br.com.vacinacao.resource.util.ExecucaoResource;

public interface IVacinaUsuarioResource {

	public ArrayList<ExecucaoResource> salvar(VacinaUsuarioVO vacinaUsuarioVO) throws BOException, SQLException;

	public ArrayList<ExecucaoResource> remover(Integer sequencial) throws BOException, SQLException;

	public ArrayList<VacinaUsuarioVO> listarTodasPorSequencialUsuario(Integer sequencialUsuario) throws BOException, SQLException;

}
