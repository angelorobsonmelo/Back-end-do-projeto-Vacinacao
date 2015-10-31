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

import br.com.vacinacao.bo.vacina.impl.VacinaDoseIntervaloBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.VacinaDoseIntervaloVO;
import br.com.vacinacao.resource.util.ExecucaoResource;
import br.com.vacinacao.resource.vacina.IVacinaDoseIntervaloResource;


@Path("vacina_dose_intervalo")
public class VacinaDoseIntervaloResource implements IVacinaDoseIntervaloResource {



	private VacinaDoseIntervaloBO vacinaDoseBO;  
	private VacinaDoseIntervaloVO vacinaDoseVO;
	private ArrayList<ExecucaoResource> listaExecucaoResource;
	private ExecucaoResource execucaoResource;

	public VacinaDoseIntervaloResource() {
		vacinaDoseBO = new VacinaDoseIntervaloBO();
		listaExecucaoResource = new ArrayList<ExecucaoResource>();
		execucaoResource = new ExecucaoResource();
		vacinaDoseVO = new VacinaDoseIntervaloVO();
	}


	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("salvar")
	public ArrayList<ExecucaoResource> salvar(VacinaDoseIntervaloVO vacinaDoseVO) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			execucaoResource.setResultado(vacinaDoseBO.salvar(vacinaDoseVO));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaDoseBO = null;
		}
	}



	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	@Path("remover/{sequencial}")
	public ArrayList<ExecucaoResource> remover(@PathParam("sequencial") Integer sequencial) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			vacinaDoseVO.setSequencial(sequencial);

			execucaoResource.setResultado(vacinaDoseBO.remover(vacinaDoseVO));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaDoseBO = null;
		}
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarTodas/{sequencialVacina}")
	public ArrayList<VacinaDoseIntervaloVO> listarTodas(@PathParam("sequencialVacina") Integer sequencialVacina) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();


			vacinaDoseVO.getVacinaVO().setSequencial(sequencialVacina);

			return vacinaDoseBO.listarTodas(vacinaDoseVO);

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			vacinaDoseBO = null;
		}
	}

}
