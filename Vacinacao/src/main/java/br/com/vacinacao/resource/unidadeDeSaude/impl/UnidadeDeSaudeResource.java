package br.com.vacinacao.resource.unidadeDeSaude.impl;

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

import br.com.vacinacao.bo.unidadeDeSaude.impl.UnidadeDeSaudeBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.unidadeDeSaude.UnidadeDeSaudeVO;
import br.com.vacinacao.resource.unidadeDeSaude.IUnidadeDeSaudeResource;
import br.com.vacinacao.resource.util.ExecucaoResource;



@Path("unidadeDeSaude")
public class UnidadeDeSaudeResource implements IUnidadeDeSaudeResource{


	private UnidadeDeSaudeBO unidadeDeSaudeBO;  
	private UnidadeDeSaudeVO unidadeDeSaudeVO;
	private ArrayList<ExecucaoResource> listaExecucaoResource;
	private ExecucaoResource execucaoResource;

	public UnidadeDeSaudeResource() {
		unidadeDeSaudeBO = new UnidadeDeSaudeBO();
		listaExecucaoResource = new ArrayList<ExecucaoResource>();
		execucaoResource = new ExecucaoResource();
		unidadeDeSaudeVO = new UnidadeDeSaudeVO();
	}



	@GET
	@Path("consultarTodas")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<UnidadeDeSaudeVO> consultarTodasAsUnidadesDeSaude()
			throws BOException, SQLException {

		try {

			return unidadeDeSaudeBO.consultarTodasAsUnidadesDeSaude();


		} catch (Exception ex) {
			throw new BOException(ex);
		}finally {

			unidadeDeSaudeVO = null;
			unidadeDeSaudeBO = null;

		}
	}

	public UnidadeDeSaudeVO consultarUnidadeDeSaudePorParametros(
			UnidadeDeSaudeVO unidadeDeSaudeVO) throws BOException, SQLException {
		try {



			return unidadeDeSaudeBO.consultarUnidadeDeSaudePorParametros(unidadeDeSaudeVO);


		} catch (Exception ex) {
			throw new BOException(ex);
		}finally {

			unidadeDeSaudeVO = null;
			unidadeDeSaudeBO = null;

		}
	}


	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("remover/{sequencial}")
	public ArrayList<ExecucaoResource> remover(@PathParam("sequencial") Integer sequencial)
			throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			unidadeDeSaudeVO.setSequencial(sequencial);

			execucaoResource.setResultado(unidadeDeSaudeBO.remover(unidadeDeSaudeVO));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			unidadeDeSaudeBO = null;
		}
	}

	public ArrayList<ExecucaoResource> update(UnidadeDeSaudeVO unidadeDeSaudeVO)
			throws BOException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@POST
	@Path("salvar")
	@Consumes("application/json")
	@Produces("application/json")
	public ArrayList<ExecucaoResource> inserir(UnidadeDeSaudeVO unidadeDeSaudeVO)
			throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			execucaoResource.setResultado(unidadeDeSaudeBO.salvar(unidadeDeSaudeVO));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			unidadeDeSaudeBO = null;
		}
	}

}
