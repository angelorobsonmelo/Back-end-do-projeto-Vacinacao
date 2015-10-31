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

import br.com.vacinacao.bo.vacina.impl.VacinaUsuarioBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaUsuarioVO;
import br.com.vacinacao.resource.util.ExecucaoResource;
import br.com.vacinacao.resource.vacina.IVacinaUsuarioResource;


@Path("vacina_usuario")
public class VacinaUsuarioResource implements IVacinaUsuarioResource {

	private VacinaUsuarioBO vacinaUsuarioBO;  
	private VacinaUsuarioVO vacinaUsuarioVO;
	private ArrayList<ExecucaoResource> listaExecucaoResource;
	private ExecucaoResource execucaoResource;

	public VacinaUsuarioResource() {
		vacinaUsuarioBO = new VacinaUsuarioBO();
		listaExecucaoResource = new ArrayList<ExecucaoResource>();
		execucaoResource = new ExecucaoResource();
		vacinaUsuarioVO = new VacinaUsuarioVO();
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("salvar")
	public ArrayList<ExecucaoResource> salvar(VacinaUsuarioVO vacinaUsuarioVO) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			execucaoResource.setResultado(vacinaUsuarioBO.salvar(vacinaUsuarioVO));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaUsuarioBO = null;
		}
	}


	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("remover/{sequencial}")
	public ArrayList<ExecucaoResource> remover(@PathParam("sequencial") Integer sequencial) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			vacinaUsuarioVO.setSequencial(sequencial);

			execucaoResource.setResultado(vacinaUsuarioBO.remover(vacinaUsuarioVO));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaUsuarioBO = null;
		}
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarTodasPorSequencialUsuario/{sequencialUsuario}")
	public ArrayList<VacinaUsuarioVO> listarTodasPorSequencialUsuario(@PathParam("sequencialUsuario") Integer sequencialUsuario)
			throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			vacinaUsuarioVO.getUsuarioVO().setSequencial(sequencialUsuario);

			return vacinaUsuarioBO.listarTodasPorSequencialUsuario(vacinaUsuarioVO);

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaUsuarioBO = null;
		}
	}

}
