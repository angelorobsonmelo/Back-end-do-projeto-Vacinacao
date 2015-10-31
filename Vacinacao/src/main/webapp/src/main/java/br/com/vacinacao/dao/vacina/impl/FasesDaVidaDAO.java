package br.com.vacinacao.dao.vacina.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.vacina.IFasesDaVidaDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.FasesDaVidaVO;


public class FasesDaVidaDAO implements IFasesDaVidaDAO{

	private CallableStatement cstmt;
	private String resultado;
	private String procedure;
	
	
	public ArrayList<FasesDaVidaVO> listarTodas() throws DAOException {
		procedure = "{? = CALL SP_FASES_DA_VIDA_LISTAR_TODAS()}";
		cstmt = null;
		ArrayList<FasesDaVidaVO> lista = new ArrayList<FasesDaVidaVO>();

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

	public ArrayList<FasesDaVidaVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<FasesDaVidaVO> lista = new ArrayList<FasesDaVidaVO>();

		while(rs.next()){

			FasesDaVidaVO fasesDaVidaVO = new FasesDaVidaVO();

			fasesDaVidaVO.setSequencial(rs.getInt("seq_fase_da_vida"));
			fasesDaVidaVO.setNome(rs.getString("nom_fase"));
		

			lista.add(fasesDaVidaVO);
		}
		return lista;
	}
	
	
	
}
