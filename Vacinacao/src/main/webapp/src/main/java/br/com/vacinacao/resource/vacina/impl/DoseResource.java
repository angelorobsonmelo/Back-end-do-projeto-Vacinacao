package br.com.vacinacao.resource.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.vacinacao.bo.vacina.impl.DoseBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.DoseVO;
import br.com.vacinacao.resource.vacina.IDoseResource;

@Path("dose")
public class DoseResource implements IDoseResource {

	
	private DoseBO doseBO;  
	
	public DoseResource() {
		doseBO = new DoseBO();
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

}
