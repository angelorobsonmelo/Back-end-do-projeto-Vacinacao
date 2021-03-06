package br.com.vacinacao.resource.usuario.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.vacinacao.bo.usuario.impl.UsuarioBO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.usuario.UsuarioVO;
import br.com.vacinacao.resource.usuario.IUsuarioResource;
import br.com.vacinacao.resource.util.ExecucaoResource;
import br.com.vacinacao.util.EnviarEmail;

@Path("usuario")
public class UsuarioResource implements IUsuarioResource {

	private EnviarEmail enviarEmail;
	private UsuarioBO usuarioBO;  
	private UsuarioVO usuarioVO;
	private ArrayList<ExecucaoResource> listaExecucaoResource;
	private ExecucaoResource execucaoResource;

	public UsuarioResource() {
		usuarioBO = new UsuarioBO();
		listaExecucaoResource = new ArrayList<ExecucaoResource>();
		execucaoResource = new ExecucaoResource();
		usuarioVO = new UsuarioVO();
		enviarEmail = new EnviarEmail();
	}


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("inserir")
	public ArrayList<ExecucaoResource> inserir(UsuarioVO usuarioVO)
			throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();

			System.out.println(usuarioVO.getSequencial());

			usuarioVO.getTipoUsuario().setSequencial(2);

			execucaoResource.setResultado(usuarioBO.salvar(usuarioVO));

			listaExecucaoResource.add(execucaoResource);

			System.out.println("chegou");

			return listaExecucaoResource;

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			usuarioBO = null;
		}
	}


	@GET
	@Produces("application/json")
	@Path("login/{email}/{senha}")
	public UsuarioVO login(@PathParam("email") String email, @PathParam("senha") String senha) throws BOException,
	SQLException {
		try {

			System.out.println("Chegou");

			usuarioVO.setEmail(email);
			usuarioVO.setSenha(senha);
			return usuarioBO.login(usuarioVO);



		} catch (Exception ex) {
			throw new BOException(ex);
		}finally {

			usuarioVO = null;
			usuarioBO = null;

		}
	}

	@GET
	@Produces("application/json")
	@Path("pesquisarPorEmail/{email}")
	public UsuarioVO pesquisarPorEmail(@PathParam("email") String email) throws BOException, SQLException {

		try {

			UsuarioVO usuarioVORetorno = new UsuarioVO();

			usuarioVO.setEmail(email);

			usuarioVORetorno = usuarioBO.pesquisarPorEmail(usuarioVO);

			if(usuarioVORetorno != null){

				Boolean confirmacaoEnvioDeEmail = enviarEmail.enviarEmailParaRecuperacaoDeSenha(usuarioVO);

				if (confirmacaoEnvioDeEmail) {

					return usuarioVORetorno;

				}else {

					usuarioVORetorno = null;

					return usuarioVORetorno;

				}


			}else {

				return usuarioVORetorno;
			}

		} catch (Exception ex) {
			throw new BOException(ex);
		}finally {

			usuarioVO = null;
			usuarioBO = null;

		}
	}

	@GET
	@Produces("application/json")
	@Path("pesquisarPorEmailPosLogin/{email}")
	public UsuarioVO pesquisarPorEmailPosLogin(@PathParam("email") String email) throws BOException, SQLException {

		try {


			usuarioVO.setEmail(email);

			return  usuarioBO.pesquisarPorEmail(usuarioVO);



		} catch (Exception ex) {
			throw new BOException(ex);
		}finally {

			usuarioVO = null;
			usuarioBO = null;

		}
	}


	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("redefinirSenha")
	public String redefinirSenha(UsuarioVO usuarioVO) throws BOException, SQLException {
		try {

			listaExecucaoResource.clear();


			return usuarioBO.redefinirSenha(usuarioVO);

		} catch (Exception ex) {
			throw new BOException(ex);
		}
		finally {

			execucaoResource = null;
			usuarioBO = null;
		}
	}

}
