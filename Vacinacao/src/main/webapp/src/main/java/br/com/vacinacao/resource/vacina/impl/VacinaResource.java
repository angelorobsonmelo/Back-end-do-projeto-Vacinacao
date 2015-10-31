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

import br.com.vacinacao.bo.vacina.impl.VacinaBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaVO;

import br.com.vacinacao.resource.util.ExecucaoResource;
import br.com.vacinacao.resource.vacina.IVacinaResource;


@Path("vacina")
public class VacinaResource implements IVacinaResource {



	private VacinaBO vacinaBO;  
	private VacinaVO vacinaVO;
	private ArrayList<ExecucaoResource> listaExecucaoResource;
	private ExecucaoResource execucaoResource;

	public VacinaResource() {
		vacinaBO = new VacinaBO();
		listaExecucaoResource = new ArrayList<ExecucaoResource>();
		execucaoResource = new ExecucaoResource();
		vacinaVO = new VacinaVO();
	}


	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("salvar")
	public ArrayList<ExecucaoResource> salvar(VacinaVO vacinaVO) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			execucaoResource.setResultado(vacinaBO.salvar(vacinaVO));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaBO = null;
		}
	}



	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("remover/{sequencial}")
	public ArrayList<ExecucaoResource> remover(@PathParam("sequencial") Integer sequencial) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			vacinaVO.setSequencial(sequencial);

			execucaoResource.setResultado(vacinaBO.remover(vacinaVO));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaBO = null;
		}
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarTodas")
	public ArrayList<VacinaVO> listarTodas() throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();



			return vacinaBO.listarTodas();

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaBO = null;
		}
	}


}
