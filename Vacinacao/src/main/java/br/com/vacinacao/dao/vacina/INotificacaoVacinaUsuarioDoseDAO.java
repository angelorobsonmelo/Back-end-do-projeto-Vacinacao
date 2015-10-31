package br.com.vacinacao.dao.vacina;

import java.util.ArrayList;

import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.NotificacaoVacinaUsuarioDoseVO;

public interface INotificacaoVacinaUsuarioDoseDAO {

	public String salvar(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDose) throws DAOException;
	
	public String remover(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDose) throws DAOException;
	
	public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodos() throws DAOException;
	
	public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodosPorSequencialUsuario(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDose) throws DAOException;
	
}
