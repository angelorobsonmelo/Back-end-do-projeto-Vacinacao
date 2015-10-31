package br.com.vacinacao.dao.vacina.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.vacina.ICampanhaDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.CampanhaVO;
import br.com.vacinacao.util.VerificadorValorObjeto;

public class CampanhaDAO implements ICampanhaDAO {


	private CallableStatement cstmt;
	private String resultado;
	private String procedure;

	public String inserir(CampanhaVO campanha) throws DAOException {
		procedure = "{ ? = CALL SP_CAMPANHA_INSERIR(?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setString(2, VerificadorValorObjeto.retornaStringValorObjetoOuNull(campanha.getTitulo()));
			cstmt.setString(3, VerificadorValorObjeto.retornaStringValorObjetoOuNull(campanha.getDescricao()));

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

	public String remover(CampanhaVO campanha) throws DAOException {
		procedure = "{ ? = CALL SP_CAMPANHA_REMOVER(?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(campanha.getSequencial()));

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

	public CampanhaVO consultar(CampanhaVO campanha) throws DAOException {
		procedure = "{? = CALL SP_CAMPANHA_CONSULTAR(?)}";
		cstmt = null;
		CampanhaVO campanhaRetorno = null;

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setInt(2, campanha.getSequencial());


			cstmt.execute();

			campanhaRetorno = mapearResultSetUnicoResultado((ResultSet) cstmt.getObject(1));

			cstmt.close();		

			return campanhaRetorno;
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



	public ArrayList<CampanhaVO> consultarTodos() throws DAOException {
		procedure = "{? = CALL SP_CAMPANHA_CONSULTAR_TODOS()}";
		cstmt = null;
		ArrayList<CampanhaVO> lista = new ArrayList<CampanhaVO>();

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

	public String atualizar(CampanhaVO campanha) throws DAOException {
		procedure = "{ ? = CALL SP_CAMPANHA_ATUALIZAR(?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(campanha.getSequencial()));
			cstmt.setString(3, VerificadorValorObjeto.retornaStringValorObjetoOuNull(campanha.getTitulo()));
			cstmt.setString(4, VerificadorValorObjeto.retornaStringValorObjetoOuNull(campanha.getDescricao()));

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

	public CampanhaVO mapearResultSetUnicoResultado(ResultSet rs) throws SQLException, BOException, DAOException{

		CampanhaVO campanha = null;

		if(rs.next()){

			campanha = new CampanhaVO();

			campanha.setSequencial(rs.getInt("seq_campanha"));
			campanha.setTitulo(rs.getString("titulo_campanha"));
			campanha.setDescricao(rs.getString("dsc_campanha"));

		}
		return campanha;


	}

	public ArrayList<CampanhaVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<CampanhaVO> lista = new ArrayList<CampanhaVO>();

		while(rs.next()){

			CampanhaVO campanha = new CampanhaVO();

			campanha.setSequencial(rs.getInt("seq_campanha"));
			campanha.setTitulo(rs.getString("titulo_campanha"));
			campanha.setDescricao(rs.getString("dsc_campanha"));

			lista.add(campanha);
		}
		return lista;
	}

	public String salvar(CampanhaVO campanha) throws DAOException {

		if (campanha.getSequencial() != null) {

			return atualizar(campanha);

		} else {

			return inserir(campanha);
		}
	}


}
