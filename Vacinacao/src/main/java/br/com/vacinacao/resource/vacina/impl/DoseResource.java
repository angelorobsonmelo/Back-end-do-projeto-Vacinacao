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

import br.com.vacinacao.bo.vacina.impl.DoseBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.DoseVO;
import br.com.vacinacao.resource.vacina.IDoseResource;

@Path("dose")
public class DoseResource implements IDoseResource {


	private DoseBO doseBO;  
	private DoseVO doseVO;

	public DoseResource() {
		doseBO = new DoseBO();
		doseVO = new DoseVO();
	}


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarTodas")
	public ArrayList<DoseVO> listarTodas() throws BOException, SQLException {
		try {


			return doseBO.listarTodas();

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {


			doseBO = null;
		}
	}


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("salvar")
	public String salvar(DoseVO doseVO) throws BOException, SQLException {
		try {


			return doseBO.salvar(doseVO);

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {


			doseBO = null;
		}
	}


	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("remover/{sequencialDose}")
	public String remover(@PathParam("sequencialDose") Integer sequencialDose) throws BOException, SQLException {
		try {


			doseVO.setSequencial(sequencialDose);

			return doseBO.remover(doseVO);

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {


			doseBO = null;
		}
	}

}
