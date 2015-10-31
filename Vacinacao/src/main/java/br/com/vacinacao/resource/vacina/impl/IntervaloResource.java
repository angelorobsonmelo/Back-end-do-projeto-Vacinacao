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

import br.com.vacinacao.bo.vacina.impl.IntervaloBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.IntervaloVO;
import br.com.vacinacao.resource.vacina.IIntervaloResource;


@Path("intervalo")
public class IntervaloResource implements IIntervaloResource {

	private IntervaloBO intervaloBO;  
	private IntervaloVO intervaloVO;

	public IntervaloResource() {
		intervaloBO = new IntervaloBO();
		intervaloVO = new IntervaloVO();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarTodas")
	public ArrayList<IntervaloVO> listarTodas() throws BOException, SQLException {
		try {


			return intervaloBO.listarTodas();

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {


			intervaloBO = null;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("salvar")
	public String salvar(IntervaloVO intervaloVO) throws BOException, SQLException {
		try {


			return intervaloBO.salvar(intervaloVO);

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			intervaloBO = null;
		}
	}

	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("remover/{sequencialIntervalo}")
	public String remover(@PathParam("sequencialIntervalo") Integer sequencialIntervalo) throws BOException, SQLException {
		try {


			intervaloVO.setSequencial(sequencialIntervalo);

			return intervaloBO.remover(intervaloVO);

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {


			intervaloBO = null;
		}
	}

}
