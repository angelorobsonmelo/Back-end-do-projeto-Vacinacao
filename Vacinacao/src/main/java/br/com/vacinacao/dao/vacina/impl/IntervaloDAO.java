package br.com.vacinacao.dao.vacina.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.vacina.IIntervaloDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.IntervaloVO;
import br.com.vacinacao.util.VerificadorValorObjeto;

public class IntervaloDAO implements IIntervaloDAO {

	private CallableStatement cstmt;
	private String resultado;
	private String procedure;


	public ArrayList<IntervaloVO> listarTodas() throws DAOException {
		procedure = "{? = CALL SP_INTERVALO_LISTAR_TODAS()}";
		cstmt = null;
		ArrayList<IntervaloVO> lista = new ArrayList<IntervaloVO>();

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

	public String inserir(IntervaloVO intervaloVO) throws DAOException {

		procedure = "{ ? = CALL SP_INTERVALO_INSERIR(?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setString(2, VerificadorValorObjeto.retornaStringValorObjetoOuNull(intervaloVO.getTempoIntervalo()));
			cstmt.setInt(3, VerificadorValorObjeto.retornaIntValorObjetoOuZero(intervaloVO.getDias()));

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

	public String atualizar(IntervaloVO intervaloVO) throws DAOException {

		procedure = "{ ? = CALL SP_INTERVALO_ATUALIZAR(?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(intervaloVO.getSequencial()));
			cstmt.setString(3, VerificadorValorObjeto.retornaStringValorObjetoOuNull(intervaloVO.getTempoIntervalo()));
			cstmt.setInt(4, VerificadorValorObjeto.retornaIntValorObjetoOuZero(intervaloVO.getDias()));

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

	public String salvar(IntervaloVO intervaloVO) throws DAOException {

		if (intervaloVO.getSequencial() != null) {

			return	atualizar(intervaloVO);

		} else {

			return inserir(intervaloVO);


		}

	}

	public String remover(IntervaloVO intervaloVO) throws DAOException {
		procedure = "{ ? = CALL SP_INTERVALO_REMOVER(?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(intervaloVO.getSequencial()));


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

	public ArrayList<IntervaloVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<IntervaloVO> lista = new ArrayList<IntervaloVO>();

		while(rs.next()){

			IntervaloVO doseVO = new IntervaloVO();

			doseVO.setSequencial(rs.getInt("seq_intervalo"));
			doseVO.setTempoIntervalo(rs.getString("tempo_intervalo"));
			doseVO.setDias(rs.getInt("intervalo_dias"));

			lista.add(doseVO);
		}
		return lista;
	}

}
