package br.com.vacinacao.resource.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.vacinacao.bo.vacina.impl.NotificacaoVacinaUsuarioDoseBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.NotificacaoVacinaUsuarioDoseVO;
import br.com.vacinacao.resource.vacina.INotificacaoVacinaUsuarioDoseResource;


@Path("notificacao_vacina_usuario_dose")
public class NotificacaoVacinaUsuarioDoseResource implements INotificacaoVacinaUsuarioDoseResource {

	private NotificacaoVacinaUsuarioDoseBO notificacaoVacinaUsuarioDoseBO;  
	private NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDoseVO;

	public NotificacaoVacinaUsuarioDoseResource() {
		notificacaoVacinaUsuarioDoseBO = new NotificacaoVacinaUsuarioDoseBO();
		notificacaoVacinaUsuarioDoseVO = new NotificacaoVacinaUsuarioDoseVO();
	}

	@Produces(MediaType.TEXT_PLAIN)
	@DELETE
	@Path("remover/{sequencialNotificacaoVacinaUsuarioDose}")
	public String remover(@PathParam("sequencialNotificacaoVacinaUsuarioDose") Integer sequencialNotificacaoVacinaUsuarioDose) throws BOException, SQLException {
		try {

			notificacaoVacinaUsuarioDoseVO.setSequencial(sequencialNotificacaoVacinaUsuarioDose);

			return notificacaoVacinaUsuarioDoseBO.remover(notificacaoVacinaUsuarioDoseVO);

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			notificacaoVacinaUsuarioDoseBO = null;
		}
	}



@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("listarTodas")
public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodos() throws BOException, SQLException {
	try {


		return notificacaoVacinaUsuarioDoseBO.buscarTodos();

	} catch (Exception ex) {
		throw new BOException(ex);
	}
	finally {

		notificacaoVacinaUsuarioDoseBO = null;
	}
}


@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("buscarTodosPorSequencialUsuario/{sequencialUsuario}")
public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodosPorSequencialUsuario(
		@PathParam("sequencialUsuario") Integer sequencialUsuario) throws BOException, SQLException {
	try {

		notificacaoVacinaUsuarioDoseVO.getUsuarioVO().setSequencial(sequencialUsuario);

		return notificacaoVacinaUsuarioDoseBO.buscarTodosPorSequencialUsuario(notificacaoVacinaUsuarioDoseVO);

	} catch (Exception ex) {
		throw new BOException(ex);
	}
	finally {

		notificacaoVacinaUsuarioDoseBO = null;
	}
}

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
@POST
@Path("salvar")
public String salvar(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDoseVO) throws BOException, SQLException {
	try {



		return notificacaoVacinaUsuarioDoseBO.salvar(notificacaoVacinaUsuarioDoseVO);

	} catch (Exception ex) {
		throw new BOException(ex);
	}
	finally {

		notificacaoVacinaUsuarioDoseBO = null;
	}
}

}
