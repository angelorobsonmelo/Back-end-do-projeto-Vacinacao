package br.com.vacinacao.dao.unidadeDeSaude.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.unidadeDeSaude.IUnidadeDeSaudeDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.unidadeDeSaude.UnidadeDeSaudeVO;
import br.com.vacinacao.util.VerificadorValorObjeto;

public class UnidadeDeSaudeDAO implements IUnidadeDeSaudeDAO {

	private CallableStatement cstmt;
	private String resultado;
	private String procedure;

	public String inserir(UnidadeDeSaudeVO unidadeDeSaudeVO) throws DAOException {
		procedure = "{ ? = CALL SP_UNIDADE_DE_SAUDE_INSERIR(?,?,?,?,?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setString(2, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getLongitude()));
			cstmt.setString(3, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getLatitude()));
			cstmt.setString(4, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getNome()));
			cstmt.setString(5, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getLogradouro()));
			cstmt.setString(6, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getCidade()));
			cstmt.setString(7, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getBairro()));
			cstmt.setString(8, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getEstado()));
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

	public ArrayList<UnidadeDeSaudeVO> consultarTodasAsUnidadesDeSaude()
			throws DAOException {
		procedure = "{? = CALL SP_UNIDADE_DE_SAUDE_CONSULTAR_TODOS()}";
		cstmt = null;
		ArrayList<UnidadeDeSaudeVO> lista = new ArrayList<UnidadeDeSaudeVO>();

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

	public UnidadeDeSaudeVO consultarUnidadeDeSaudePorParametros(UnidadeDeSaudeVO unidadeDeSaudeVO)
			throws DAOException {
		procedure = "{? = CALL SP_UNIDADE_DE_SAUDE_CONSULTAR_POR_PARAMETROS(?)}";
		cstmt = null;
		UnidadeDeSaudeVO unidadeDeSaudeRetornoVO = null;

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(unidadeDeSaudeVO.getSequencial()));

			cstmt.execute();

			unidadeDeSaudeRetornoVO = mapearResultComParametros((ResultSet) cstmt.getObject(1));

			cstmt.close();		

			return unidadeDeSaudeRetornoVO;
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

	public ArrayList<UnidadeDeSaudeVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<UnidadeDeSaudeVO> lista = new ArrayList<UnidadeDeSaudeVO>();


		while(rs.next()){

			UnidadeDeSaudeVO unidadeDeSaudeVO = new UnidadeDeSaudeVO();

			unidadeDeSaudeVO.setSequencial(rs.getInt("seq_unidade_de_saude"));
			unidadeDeSaudeVO.setLongitude(rs.getString("longitude"));
			unidadeDeSaudeVO.setLatitude(rs.getString("latitude"));
			unidadeDeSaudeVO.setNome(rs.getString("nom_unidade_de_saude"));
			unidadeDeSaudeVO.setLogradouro(rs.getString("nom_logradouro_unidade_de_saude"));
			unidadeDeSaudeVO.setCidade(rs.getString("nom_cidade_unidade_de_saude"));
			unidadeDeSaudeVO.setBairro(rs.getString("nom_bairro_unidade_de_saude"));
			unidadeDeSaudeVO.setEstado(rs.getString("nom_estado_unidade_de_saude"));

			lista.add(unidadeDeSaudeVO);
		}
		return lista;
	}


	public UnidadeDeSaudeVO mapearResultComParametros(ResultSet rs) throws SQLException{

		UnidadeDeSaudeVO unidadeDeSaudeVO = null;

		if(rs.next()){

			unidadeDeSaudeVO = new UnidadeDeSaudeVO();	

			unidadeDeSaudeVO.setSequencial(rs.getInt("seq_unidade_de_saude"));
			unidadeDeSaudeVO.setLongitude(rs.getString("longitude"));
			unidadeDeSaudeVO.setLatitude(rs.getString("latitude"));
			unidadeDeSaudeVO.setNome(rs.getString("nom_unidade_de_saude"));
			unidadeDeSaudeVO.setLogradouro(rs.getString("nom_logradouro_unidade_de_saude"));
			unidadeDeSaudeVO.setCidade(rs.getString("nom_cidade_unidade_de_saude"));
			unidadeDeSaudeVO.setBairro(rs.getString("nom_bairro_unidade_de_saude"));
			unidadeDeSaudeVO.setEstado(rs.getString("nom_estado_unidade_de_saude"));


		}
		return unidadeDeSaudeVO;
	}

	public String remover(UnidadeDeSaudeVO unidadeDeSaudeVO)
			throws DAOException {
		procedure = "{ ? = CALL SP_UNIDADE_DE_SAUDE_REMOVER(?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(unidadeDeSaudeVO.getSequencial()));

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

	public String update(UnidadeDeSaudeVO unidadeDeSaudeVO) throws DAOException {
		procedure = "{ ? = CALL SP_UNIDADE_DE_SAUDE_ATUALIZAR(?,?,?,?,?,?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(unidadeDeSaudeVO.getSequencial()));
			cstmt.setString(3, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getLongitude()));
			cstmt.setString(4, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getLatitude()));
			cstmt.setString(5, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getNome()));
			cstmt.setString(6, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getLogradouro()));
			cstmt.setString(7, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getCidade()));
			cstmt.setString(8, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getBairro()));
			cstmt.setString(9, VerificadorValorObjeto.retornaStringValorObjetoOuNull(unidadeDeSaudeVO.getEstado()));
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

	public String salvar(UnidadeDeSaudeVO unidadeDeSaudeVO) throws DAOException{

		resultado = null;

		if (unidadeDeSaudeVO.getSequencial() != null) {

			resultado = update(unidadeDeSaudeVO);

			return resultado;

		} else {
			resultado = inserir(unidadeDeSaudeVO);

			return resultado;

		}

	}

}
