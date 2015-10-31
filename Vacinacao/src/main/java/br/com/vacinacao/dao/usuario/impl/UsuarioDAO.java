package br.com.vacinacao.dao.usuario.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.usuario.IUsuarioDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.usuario.UsuarioVO;
import br.com.vacinacao.util.VerificadorValorObjeto;

public class UsuarioDAO implements IUsuarioDAO {

	private CallableStatement cstmt;
	private String resultado;
	private String procedure;


	public String inserir(UsuarioVO usuarioVO) throws DAOException {
		procedure = "{ ? = CALL SP_USUARIO_INSERIR(?,?,?,?,?,?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setString(2, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getNome()));
			cstmt.setString(3, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getRegId()));
			cstmt.setString(4, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getSobrenome()));
			cstmt.setString(5, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getEmail()));
			cstmt.setString(6, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getSenha()));
			cstmt.setString(7, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getGenero()));
			cstmt.setDate(8, VerificadorValorObjeto.retornaSQLDateTratandoFusoHorarioBrasileiro(usuarioVO.getDataNascimento()));
			cstmt.setInt(9, VerificadorValorObjeto.retornaIntValorObjetoOuZero(usuarioVO.getTipoUsuario().getSequencial()));
			cstmt.execute();

			resultado = (String) cstmt.getString(1);
			cstmt.close();

			return resultado;
		}
		catch(Exception ex)
		{
			throw new DAOException(ex);
		}
		finally{

			procedure = null;
			cstmt = null;
		}
	}


	public String atualizar(UsuarioVO usuarioVO) throws DAOException {
		procedure = "{ ? = CALL SP_USUARIO_ATUALIZAR(?,?,?,?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(usuarioVO.getSequencial()));
			cstmt.setString(3, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getNome()));
			cstmt.setString(4, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getSobrenome()));
			cstmt.setString(5, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getSenha()));
			cstmt.setString(6, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getGenero()));
			cstmt.setDate(7, VerificadorValorObjeto.retornaSQLDateTratandoFusoHorarioBrasileiro(usuarioVO.getDataNascimento()));
			cstmt.execute();

			resultado = (String) cstmt.getString(1);
			cstmt.close();

			return resultado;
		}
		catch(Exception ex)
		{
			throw new DAOException(ex);
		}
		finally{

			procedure = null;
			cstmt = null;
		}
	}


	public UsuarioVO login(UsuarioVO usuarioVO) throws DAOException {
		procedure = "{? = CALL SP_USUARIO_LOGIN(?,?)}";
		cstmt = null;
		UsuarioVO usuarioRetorno = null;

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setString(2, usuarioVO.getEmail());
			cstmt.setString(3, usuarioVO.getSenha());

			cstmt.execute();

			usuarioRetorno = mapearResultSetUnicoResultado((ResultSet) cstmt.getObject(1));

			cstmt.close();		

			return usuarioRetorno;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new DAOException(ex);
		} finally{        	
			/*Indicar ao Garbage Collection do Java que as variáveis 
			 * podem ser esvaziadas do Coletor de Lixo
			 */        	
			procedure = null;
			cstmt = null;
		}
	}




	public UsuarioVO mapearResultSetUnicoResultado(ResultSet rs) throws SQLException, BOException, DAOException{

		UsuarioVO usuarioVO = null;

		if(rs.next()){

			usuarioVO = new UsuarioVO();

			usuarioVO.setSequencial(rs.getInt("seq_usuario"));
			usuarioVO.setNome(rs.getString("nom_usuario"));
			usuarioVO.setRegId(rs.getString("reg_id"));
			usuarioVO.setSobrenome(rs.getString("nom_sobrenome"));
			usuarioVO.setEmail(rs.getString("nom_email"));
			usuarioVO.setGenero(rs.getString("nom_genero"));
			usuarioVO.getTipoUsuario().setSequencial(rs.getInt("cod_tipo_usuario"));
			usuarioVO.setDataNascimento(rs.getDate("data_nascimento"));

		}
		return usuarioVO;


	}


	public String salvar(UsuarioVO usuarioVO) throws DAOException {

		if (usuarioVO.getSequencial() != null) {

			System.out.println("caiu aqui no atualizar");
			return atualizar(usuarioVO);



		} else {
			System.out.println("caiu aqui no salvar");
			return inserir(usuarioVO);

		}


	}


	public UsuarioVO pesquisarPorEmail(UsuarioVO usuarioVO) throws DAOException {
		procedure = "{? = CALL SP_USUARIO_PESQUISAR_POR_EMAIL(?)}";
		cstmt = null;
		UsuarioVO usuarioRetorno = null;

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setString(2, usuarioVO.getEmail());

			cstmt.execute();

			usuarioRetorno = mapearResultSetUnicoResultado((ResultSet) cstmt.getObject(1));

			cstmt.close();		

			return usuarioRetorno;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new DAOException(ex);
		} finally{        	
			/*Indicar ao Garbage Collection do Java que as variáveis 
			 * podem ser esvaziadas do Coletor de Lixo
			 */        	
			procedure = null;
			cstmt = null;
		}
	}


	public String redefinirSenha(UsuarioVO usuarioVO) throws DAOException {
		procedure = "{ ? = CALL SP_USUARIO_REDEFINIR_SENHA(?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);

			cstmt.setString(2, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getEmail()));
			cstmt.setString(3, VerificadorValorObjeto.retornaStringValorObjetoOuNull(usuarioVO.getSenha()));


			cstmt.execute();

			resultado = (String) cstmt.getString(1);
			cstmt.close();

			return resultado;
		}
		catch(Exception ex)
		{
			throw new DAOException(ex);
		}
		finally{

			procedure = null;
			cstmt = null;
		}
	}


	public ArrayList<UsuarioVO> buscarTodos() throws DAOException {
		procedure = "{? = CALL SP_USUARIO_BUSCAR_TODOS()}";
		cstmt = null;
		ArrayList<UsuarioVO> lista = new ArrayList<UsuarioVO>();

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.OTHER);


			cstmt.execute();

			lista = mapearResultSet((ResultSet) cstmt.getObject(1));

			cstmt.close();		

			return lista;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new DAOException(ex);
		} finally{        	
			/*Indicar ao Garbage Collection do Java que as variáveis 
			 * podem ser esvaziadas do Coletor de Lixo
			 */        	
			procedure = null;
			cstmt = null;
		}

	}

	public ArrayList<UsuarioVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<UsuarioVO> lista = new ArrayList<UsuarioVO>();

		while(rs.next()){

			UsuarioVO usuarioVO = new UsuarioVO();

			usuarioVO.setSequencial(rs.getInt("seq_usuario"));
			usuarioVO.setNome(rs.getString("nom_usuario"));
			usuarioVO.setRegId(rs.getString("reg_id"));
			usuarioVO.setSobrenome(rs.getString("nom_sobrenome"));
			usuarioVO.setEmail(rs.getString("nom_email"));
			usuarioVO.setGenero(rs.getString("nom_genero"));
			usuarioVO.getTipoUsuario().setSequencial(rs.getInt("cod_tipo_usuario"));
			usuarioVO.setDataNascimento(rs.getDate("data_nascimento"));


			lista.add(usuarioVO);
		}
		return lista;
	}

}
