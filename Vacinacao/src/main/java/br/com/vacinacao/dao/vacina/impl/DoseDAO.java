package br.com.vacinacao.dao.vacina.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.vacina.IDoseDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.DoseVO;
import br.com.vacinacao.util.VerificadorValorObjeto;


public class DoseDAO implements IDoseDAO {


	private CallableStatement cstmt;
	private String resultado;
	private String procedure;


	public String inserir(DoseVO doseVO) throws DAOException {
		procedure = "{ ? = CALL SP_DOSE_INSERIR(?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setString(2, VerificadorValorObjeto.retornaStringValorObjetoOuNull(doseVO.getDescricao()));
		
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

	public String atualizar(DoseVO doseVO) throws DAOException {
		procedure = "{ ? = CALL SP_DOSE_ATUALIZAR(?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero((doseVO.getSequencial())));
			cstmt.setString(3, VerificadorValorObjeto.retornaStringValorObjetoOuNull(doseVO.getDescricao()));

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

	public String remover(DoseVO doseVO) throws DAOException {
		procedure = "{ ? = CALL SP_DOSE_REMOVER(?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero((doseVO.getSequencial())));

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


	public ArrayList<DoseVO> listarTodas() throws DAOException {
		procedure = "{? = CALL SP_DOSE_LISTAR_TODAS()}";
		cstmt = null;
		ArrayList<DoseVO> lista = new ArrayList<DoseVO>();

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



	public ArrayList<DoseVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<DoseVO> lista = new ArrayList<DoseVO>();

		while(rs.next()){

			DoseVO doseVO = new DoseVO();

			doseVO.setSequencial(rs.getInt("seq_dose"));
			doseVO.setDescricao(rs.getString("dsc_dose"));

			lista.add(doseVO);
		}
		return lista;
	}



	public String salvar(DoseVO doseVO) throws DAOException {
		if (doseVO.getSequencial() != null) {

			return atualizar(doseVO);

		} else {

			return inserir(doseVO);

		}

	}


}
