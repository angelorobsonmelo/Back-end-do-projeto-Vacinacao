package br.com.vacinacao.bo.vacina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.NotificacaoVacinaUsuarioDoseVO;

public interface INotificacaoVacinaUsuarioDoseBO {

	public String salvar(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDoseVO) throws BOException, SQLException;

	public String remover(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDoseVO) throws BOException, SQLException;

	public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodos() throws BOException, SQLException;

	public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodosPorSequencialUsuario(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDose) throws BOException, SQLException;



}
