package br.com.vacinacao.dao.vacina.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.vacina.IVacinaFaseDaVidaDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.VacinaFaseDaVidaVO;
import br.com.vacinacao.util.VerificadorValorObjeto;

public class VacinaFaseDaVidaDAO implements IVacinaFaseDaVidaDAO {



	private CallableStatement cstmt;
	private String resultado;
	private String procedure;

	public String inserir(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_FASE_DA_VIDA_INSERIR(?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaFaseDaVidaVO.getVacinaVO().getSequencial()));
			cstmt.setInt(3, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaFaseDaVidaVO.getFasesDaVidaVO().getSequencial()));

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

	public String remover(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_FASE_DA_VIDA_REMOVER(?)}";
		cstmt = null;
		resultado = null;

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);

			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaFaseDaVidaVO.getSequencial()));

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

	public String atualiar(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_FASE_DA_VIDA_ATUALIZAR(?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);

			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaFaseDaVidaVO.getSequencial()));
			cstmt.setInt(3, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaFaseDaVidaVO.getVacinaVO().getSequencial()));
			cstmt.setInt(4, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaFaseDaVidaVO.getFasesDaVidaVO().getSequencial()));

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

	public ArrayList<VacinaFaseDaVidaVO> listarTodas(VacinaFaseDaVidaVO vacinaFaseDaVida) throws DAOException {
		procedure = "{? = CALL SP_VACINA_FASE_DA_VIDA_LISTAR_TODAS(?)}";
		cstmt = null;
		ArrayList<VacinaFaseDaVidaVO> lista = new ArrayList<VacinaFaseDaVidaVO>();

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaFaseDaVida.getFasesDaVidaVO().getSequencial()));


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




	public ArrayList<VacinaFaseDaVidaVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<VacinaFaseDaVidaVO> lista = new ArrayList<VacinaFaseDaVidaVO>();

		while(rs.next()){

			VacinaFaseDaVidaVO vacinaFaseDaVidaVO = new VacinaFaseDaVidaVO();

			vacinaFaseDaVidaVO.setSequencial(rs.getInt("seq_vacina_fase_da_vida"));
			
			vacinaFaseDaVidaVO.getVacinaVO().setSequencial(rs.getInt("seq_vacina"));
			vacinaFaseDaVidaVO.getVacinaVO().setNome(rs.getString("nom_vacina"));
			vacinaFaseDaVidaVO.getVacinaVO().setDescricao(rs.getString("dsc_vacina"));
			
			vacinaFaseDaVidaVO.getFasesDaVidaVO().setSequencial(rs.getInt("seq_fase_da_vida"));
			vacinaFaseDaVidaVO.getFasesDaVidaVO().setNome(rs.getString("nom_fase"));

			lista.add(vacinaFaseDaVidaVO);
		}
		return lista;
	}

	public String salvar(VacinaFaseDaVidaVO vacinaFaseDaVidaVO) throws DAOException{

		if(vacinaFaseDaVidaVO.getSequencial() != null){

			return atualiar(vacinaFaseDaVidaVO);

		}else{

			return inserir(vacinaFaseDaVidaVO);
		}

	}

}
