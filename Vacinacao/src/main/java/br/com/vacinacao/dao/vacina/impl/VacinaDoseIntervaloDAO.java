package br.com.vacinacao.dao.vacina.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.vacina.IVacinaDoseIntervaloDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.VacinaDoseIntervaloVO;
import br.com.vacinacao.util.VerificadorValorObjeto;

public class VacinaDoseIntervaloDAO implements IVacinaDoseIntervaloDAO {

	private CallableStatement cstmt;
	private String resultado;
	private String procedure;

	public String inserir(VacinaDoseIntervaloVO vacinaDoseVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_DOSE_INTERVALO_INSERIR(?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaDoseVO.getVacinaVO().getSequencial()));
			cstmt.setInt(3, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaDoseVO.getDoseVO().getSequencial()));
			cstmt.setInt(4, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaDoseVO.getIntervaloVO().getSequencial()));
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

	public String remover(VacinaDoseIntervaloVO vacinaDoseVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_DOSE_INTERVALO_REMOVER(?)}";
		cstmt = null;
		resultado = null;

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);

			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaDoseVO.getSequencial()));

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

	public String atualiar(VacinaDoseIntervaloVO vacinaDoseVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_DOSE_INTERVALO_ATUALIZAR(?,?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);

			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaDoseVO.getSequencial()));
			cstmt.setInt(3, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaDoseVO.getVacinaVO().getSequencial()));
			cstmt.setInt(4, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaDoseVO.getDoseVO().getSequencial()));
			cstmt.setInt(5, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaDoseVO.getIntervaloVO().getSequencial()));
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

	public ArrayList<VacinaDoseIntervaloVO> listarTodasPorSequencialVacina(VacinaDoseIntervaloVO vacinaDoseVO) throws DAOException {
		procedure = "{? = CALL SP_VACINA_DOSE_INTERVALO_LISTAR_TODAS_POR_SEQ_VACINA(?)}";
		cstmt = null;
		ArrayList<VacinaDoseIntervaloVO> lista = new ArrayList<VacinaDoseIntervaloVO>();

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaDoseVO.getVacinaVO().getSequencial()));


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

	public ArrayList<VacinaDoseIntervaloVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<VacinaDoseIntervaloVO> lista = new ArrayList<VacinaDoseIntervaloVO>();

		while(rs.next()){

			VacinaDoseIntervaloVO vacinaDoseVO = new VacinaDoseIntervaloVO();

			vacinaDoseVO.setSequencial(rs.getInt("seq_vacina_dose_intervalo"));
			
			vacinaDoseVO.getDoseVO().setSequencial(rs.getInt("seq_dose"));
			vacinaDoseVO.getDoseVO().setDescricao(rs.getString("dsc_dose"));
			
			vacinaDoseVO.getVacinaVO().setSequencial(rs.getInt("seq_vacina"));
			vacinaDoseVO.getVacinaVO().setNome(rs.getString("nom_vacina"));
			vacinaDoseVO.getVacinaVO().setDescricao(rs.getString("dsc_vacina"));
			
			vacinaDoseVO.getIntervaloVO().setSequencial(rs.getInt("seq_intervalo"));
			vacinaDoseVO.getIntervaloVO().setTempoIntervalo(rs.getString("tempo_intervalo"));
			vacinaDoseVO.getIntervaloVO().setDias(rs.getInt("intervalo_dias"));

			lista.add(vacinaDoseVO);
		}
		return lista;
	}

	public String salvar(VacinaDoseIntervaloVO vacinaVO) throws DAOException{

		if(vacinaVO.getSequencial() != null){

			return atualiar(vacinaVO);

		}else{

			return inserir(vacinaVO);
		}

	}

	public ArrayList<VacinaDoseIntervaloVO> listarTodas() throws DAOException {
		procedure = "{? = CALL SP_VACINA_DOSE_INTERVALO_LISTAR_TODAS()}";
		cstmt = null;
		ArrayList<VacinaDoseIntervaloVO> lista = new ArrayList<VacinaDoseIntervaloVO>();

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



}
