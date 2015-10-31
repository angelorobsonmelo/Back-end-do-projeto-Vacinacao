package br.com.vacinacao.resource.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.vacinacao.bo.vacina.impl.FasesDaVidaBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.FasesDaVidaVO;
import br.com.vacinacao.resource.util.ExecucaoResource;
import br.com.vacinacao.resource.vacina.IFasesDaVidaResource;


@Path("fases_da_vida")
public class FasesDaVidaResource implements IFasesDaVidaResource {



	private FasesDaVidaBO fasesDaVidaBO;  
	private FasesDaVidaVO fasesDaVidaVO;
	private ArrayList<ExecucaoResource> listaExecucaoResource;
	private ExecucaoResource execucaoResource;

	public FasesDaVidaResource() {
		fasesDaVidaBO = new FasesDaVidaBO();
		listaExecucaoResource = new ArrayList<ExecucaoResource>();
		execucaoResource = new ExecucaoResource();
		fasesDaVidaVO = new FasesDaVidaVO();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarTodas")
	public ArrayList<FasesDaVidaVO> listarTodas() throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();



			return fasesDaVidaBO.listarTodas();

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			fasesDaVidaBO = null;
		}
	}

}
