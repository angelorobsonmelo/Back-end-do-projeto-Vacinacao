package br.com.vacinacao.resource.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.NotificacaoVacinaUsuarioDoseVO;

public interface INotificacaoVacinaUsuarioDoseResource {

	public String remover(Integer sequencialNotificacaoVacinaUsuarioDose) throws BOException, SQLException;

	public String salvar(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDoseVO) throws BOException, SQLException;

	public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodos() throws BOException, SQLException;

	public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodosPorSequencialUsuario(Integer sequencialUsuario) throws BOException, SQLException;

	public String removerPorSequencialVacinaEUsuario(Integer sequencialVacina, Integer sequencialUsuario) throws BOException, SQLException;
	

	
}
