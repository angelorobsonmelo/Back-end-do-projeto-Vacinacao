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

import br.com.vacinacao.bo.vacina.impl.CampanhaBO;
import br.com.vacinacao.dao.usuario.impl.UsuarioDAO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.usuario.UsuarioVO;
import br.com.vacinacao.model.vacina.CampanhaVO;
import br.com.vacinacao.resource.util.ExecucaoResource;
import br.com.vacinacao.resource.vacina.ICampanhaResource;


@Path("campanha")
public class CampanhaResource implements ICampanhaResource {


	private CampanhaBO campanhaBO;  
	private CampanhaVO campanha;
	private ArrayList<ExecucaoResource> listaExecucaoResource;
	private ExecucaoResource execucaoResource;
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public CampanhaResource() {
		campanhaBO = new CampanhaBO();
		listaExecucaoResource = new ArrayList<ExecucaoResource>();
		execucaoResource = new ExecucaoResource();
		campanha = new CampanhaVO();
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("salvar")
	public ArrayList<ExecucaoResource> salvar(CampanhaVO campanha)
			throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			execucaoResource.setResultado(campanhaBO.salvar(campanha));

			listaExecucaoResource.add(execucaoResource);
			
			if (execucaoResource.getResultado().equals("OK")) {
				
				ArrayList<UsuarioVO> listaDeUsuarios = usuarioDAO.buscarTodos();
				
				for (UsuarioVO usuarioVO : listaDeUsuarios) {
					
					System.out.println(usuarioVO.getNome() + "\n" + campanha.getDescricao());
				}
				
				
			} else {

			}
			

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			campanhaBO = null;
		}
	}


	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("remover/{sequencial}")
	public ArrayList<ExecucaoResource> remover(@PathParam("sequencial") Integer sequencial) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			campanha.setSequencial(sequencial);

			execucaoResource.setResultado(campanhaBO.remover(campanha));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			campanhaBO = null;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("consultar/{sequencial}")
	public CampanhaVO consultar(@PathParam("sequencial") Integer sequencial) throws BOException,
	SQLException {
		try {

			listaExecucaoResource.clear();

			campanha.setSequencial(sequencial);

			return campanhaBO.consultar(campanha);

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			campanhaBO = null;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("consultarTodos")
	public ArrayList<CampanhaVO> consultarTodos() throws BOException,
	SQLException {
		try {

			listaExecucaoResource.clear();

			

			return campanhaBO.consultarTodos();

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			campanhaBO = null;
		}
	}

	public ArrayList<ExecucaoResource> atualizar(CampanhaVO campanha) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			execucaoResource.setResultado(campanhaBO.atualizar(campanha));

			listaExecucaoResource.add(execucaoResource);

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			campanhaBO = null;
		}
	}


}
