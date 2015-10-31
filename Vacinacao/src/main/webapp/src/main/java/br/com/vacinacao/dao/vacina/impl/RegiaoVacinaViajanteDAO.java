package br.com.vacinacao.dao.vacina.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.vacina.IRegiaoVacinaViajanteDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.RegiaoVacinaViajanteVO;

public class RegiaoVacinaViajanteDAO implements IRegiaoVacinaViajanteDAO {

	private CallableStatement cstmt;
	private String resultado;
	private String procedure;



	public ArrayList<RegiaoVacinaViajanteVO> listarTodasPorSequencialRegiao(RegiaoVacinaViajanteVO regiaoVacinaViajanteVO) throws DAOException {
		procedure = "{? = CALL SP_VACINA_VIAJANTE_LISTAR_TODAS_POR_SEQ_REGIAO(?)}";
		cstmt = null;
		ArrayList<RegiaoVacinaViajanteVO> lista = new ArrayList<RegiaoVacinaViajanteVO>();

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setInt(2, regiaoVacinaViajanteVO.getRegiaoVO().getSequencial());

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




	public ArrayList<RegiaoVacinaViajanteVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<RegiaoVacinaViajanteVO> lista = new ArrayList<RegiaoVacinaViajanteVO>();

		while(rs.next()){

			RegiaoVacinaViajanteVO vacinaVO = new RegiaoVacinaViajanteVO();


			vacinaVO.getVacinaVO().setNome(rs.getString("nom_vacina_viajante"));
			vacinaVO.getVacinaVO().setDescricao(rs.getString("dsc_vacina_viajante"));

			vacinaVO.getRegiaoVO().setSequencial(rs.getInt("seq_regiao"));
			vacinaVO.getRegiaoVO().setNome(rs.getString("nom_regiao"));

			lista.add(vacinaVO);
		}
		return lista;
	}

}
