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

import br.com.vacinacao.bo.vacina.impl.VacinaFaseDaVidaBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaFaseDaVidaVO;
import br.com.vacinacao.resource.util.ExecucaoResource;
import br.com.vacinacao.resource.vacina.IVacinaFaseDaVidaResource;


@Path("vacina_fase_da_vida")
public class VacinaFaseDaVidaResource implements IVacinaFaseDaVidaResource{


	private VacinaFaseDaVidaBO vacinaFaseDaVidaBO;  
	private VacinaFaseDaVidaVO vacinaFaseDaVidaVO;
	private ArrayList<ExecucaoResource> listaExecucaoResource;
	private ExecucaoResource execucaoResource;

	public VacinaFaseDaVidaResource() {
		vacinaFaseDaVidaBO = new VacinaFaseDaVidaBO();
		listaExecucaoResource = new ArrayList<ExecucaoResource>();
		execucaoResource = new ExecucaoResource();
		vacinaFaseDaVidaVO = new VacinaFaseDaVidaVO();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("salvar")
	public ArrayList<ExecucaoResource> salvar(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			execucaoResource.setResultado(vacinaFaseDaVidaBO.salvar(vacinaFaseDaVidaVO));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaFaseDaVidaBO = null;
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("remover/{sequencial}")
	public ArrayList<ExecucaoResource> remover(@PathParam("sequencial") Integer sequencial) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			vacinaFaseDaVidaVO.setSequencial(sequencial);

			execucaoResource.setResultado(vacinaFaseDaVidaBO.remover(vacinaFaseDaVidaVO));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaFaseDaVidaBO = null;
		}
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarTodas/{sequencialFaseDaVida}")
	public ArrayList<VacinaFaseDaVidaVO> listarTodas(@PathParam("sequencialFaseDaVida") Integer sequencialFaseDaVida) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			vacinaFaseDaVidaVO.getFasesDaVidaVO().setSequencial(sequencialFaseDaVida);

			return vacinaFaseDaVidaBO.listarTodas(vacinaFaseDaVidaVO);

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaFaseDaVidaBO = null;
		}
	}


}
