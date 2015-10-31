package br.com.vacinacao.dao.vacina.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.vacina.IVacinaDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.VacinaVO;

import br.com.vacinacao.util.VerificadorValorObjeto;

public class VacinaDAO implements IVacinaDAO {



	private CallableStatement cstmt;
	private String resultado;
	private String procedure;

	public String inserir(VacinaVO vacinaVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_INSERIR(?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setString(2, VerificadorValorObjeto.retornaStringValorObjetoOuNull(vacinaVO.getNome()));
			cstmt.setString(3, VerificadorValorObjeto.retornaStringValorObjetoOuNull(vacinaVO.getDescricao()));

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

	public String remover(VacinaVO vacinaVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_REMOVER(?)}";
		cstmt = null;
		resultado = null;

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);

			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaVO.getSequencial()));

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

	public String atualiar(VacinaVO vacinaVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_ATUALIZAR(?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);

			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaVO.getSequencial()));
			cstmt.setString(3, VerificadorValorObjeto.retornaStringValorObjetoOuNull(vacinaVO.getNome()));
			cstmt.setString(4, VerificadorValorObjeto.retornaStringValorObjetoOuNull(vacinaVO.getDescricao()));
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

	public ArrayList<VacinaVO> listarTodas() throws DAOException {
		procedure = "{? = CALL SP_VACINA_LISTAR_TODAS()}";
		cstmt = null;
		ArrayList<VacinaVO> lista = new ArrayList<VacinaVO>();

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
	
	
	
	
	public ArrayList<VacinaVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<VacinaVO> lista = new ArrayList<VacinaVO>();

		while(rs.next()){

			VacinaVO vacinaVO = new VacinaVO();

			vacinaVO.setSequencial(rs.getInt("seq_vacina"));
			vacinaVO.setNome(rs.getString("nom_vacina"));
			vacinaVO.setDescricao(rs.getString("dsc_vacina"));

			lista.add(vacinaVO);
		}
		return lista;
	}
	
	public String salvar(VacinaVO vacinaVO) throws DAOException{
		
		if(vacinaVO.getSequencial() != null){
			
			return atualiar(vacinaVO);
			
		}else{
			
			return inserir(vacinaVO);
		}
		
	}

}
