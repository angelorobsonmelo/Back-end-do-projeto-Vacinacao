package br.com.vacinacao.resource.vacina.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.vacinacao.bo.vacina.impl.RegiaoVacinaViajanteBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.RegiaoVacinaViajanteVO;
import br.com.vacinacao.resource.util.ExecucaoResource;
import br.com.vacinacao.resource.vacina.IRegiaoVacinaViajanteResource;


@Path("regiao_vacina_viajante")
public class RegiaoVacinaViajanteResource implements IRegiaoVacinaViajanteResource {


	private RegiaoVacinaViajanteBO regiaoVacinaViajanteBO;  
	private RegiaoVacinaViajanteVO regiaoVacinaViajanteVO;
	private ArrayList<ExecucaoResource> listaExecucaoResource;
	private ExecucaoResource execucaoResource;

	public RegiaoVacinaViajanteResource() {
		regiaoVacinaViajanteBO = new RegiaoVacinaViajanteBO();
		listaExecucaoResource = new ArrayList<ExecucaoResource>();
		execucaoResource = new ExecucaoResource();
		regiaoVacinaViajanteVO = new RegiaoVacinaViajanteVO();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarTodasPorSequencialRegiao/{sequencialRegiao}")
	public ArrayList<RegiaoVacinaViajanteVO> listarTodasPorSequencialRegiao(@PathParam("sequencialRegiao") Integer sequencialRegiao)
			throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();
			
			regiaoVacinaViajanteVO.getRegiaoVO().setSequencial(sequencialRegiao);


			return regiaoVacinaViajanteBO.listarTodasPorSequencialRegiao(regiaoVacinaViajanteVO);

					
		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			regiaoVacinaViajanteBO = null;
		}
	}

}
