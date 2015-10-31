package br.com.vacinacao.dao.vacina.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.vacina.IVacinaUsuarioDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.VacinaUsuarioVO;

import br.com.vacinacao.util.VerificadorValorObjeto;

public class VacinaUsuarioDAO implements IVacinaUsuarioDAO {

	private CallableStatement cstmt;
	private String resultado;
	private String procedure;


	public String inserir(VacinaUsuarioVO vacinaUsuarioVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_USUARIO_INSERIR(?,?,?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaUsuarioVO.getVacinaVO().getSequencial()));
			cstmt.setInt(3, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaUsuarioVO.getUsuarioVO().getSequencial()));
			cstmt.setDate(4, new java.sql.Date(VerificadorValorObjeto.retornaLongValorObjetoOuZero(vacinaUsuarioVO.getDataVacinacao().getTime())));
			cstmt.setString(5, VerificadorValorObjeto.retornaStringValorObjetoOuNull(vacinaUsuarioVO.getLote()));
			cstmt.setString(6, VerificadorValorObjeto.retornaStringValorObjetoOuNull(vacinaUsuarioVO.getLocal()));

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


	public String atualizar(VacinaUsuarioVO vacinaUsuarioVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_USUARIO_ATUALIZAR(?,?,?,?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaUsuarioVO.getSequencial()));
			cstmt.setInt(3, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaUsuarioVO.getVacinaVO().getSequencial()));
			cstmt.setInt(4, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaUsuarioVO.getUsuarioVO().getSequencial()));
			cstmt.setDate(5, new java.sql.Date(VerificadorValorObjeto.retornaLongValorObjetoOuZero(vacinaUsuarioVO.getDataVacinacao().getTime())));
			cstmt.setString(6, VerificadorValorObjeto.retornaStringValorObjetoOuNull(vacinaUsuarioVO.getLote()));
			cstmt.setString(7, VerificadorValorObjeto.retornaStringValorObjetoOuNull(vacinaUsuarioVO.getLocal()));

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

	public String remover(VacinaUsuarioVO vacinaUsuarioVO) throws DAOException {
		procedure = "{ ? = CALL SP_VACINA_USUARIO_REMOVER(?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(vacinaUsuarioVO.getSequencial()));

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

	public ArrayList<VacinaUsuarioVO> listarTodasPorSequencialUsuario(VacinaUsuarioVO vacinaUsuarioVO)
			throws DAOException {
		procedure = "{? = CALL SP_VACINA_USUARIO_LISTAR_TODAS_POR_SEQUENCIAL_USUARIO(?)}";
		cstmt = null;
		ArrayList<VacinaUsuarioVO> lista = new ArrayList<VacinaUsuarioVO>();

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setInt(2, vacinaUsuarioVO.getUsuarioVO().getSequencial());


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


	public ArrayList<VacinaUsuarioVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<VacinaUsuarioVO> lista = new ArrayList<VacinaUsuarioVO>();

		while(rs.next()){

			VacinaUsuarioVO vacinaUsuarioVO = new VacinaUsuarioVO();

			vacinaUsuarioVO.setSequencial(rs.getInt("seq_vacina_usuario"));
			vacinaUsuarioVO.setLocal(rs.getString("local_vacinacao"));
			vacinaUsuarioVO.setLote(rs.getString("lote_vacina_usuario"));
			vacinaUsuarioVO.setDataVacinacao(rs.getDate("data_vacinacao"));

			vacinaUsuarioVO.getVacinaVO().setSequencial(rs.getInt("seq_vacina"));
			vacinaUsuarioVO.getVacinaVO().setNome(rs.getString("nom_vacina"));
			vacinaUsuarioVO.getVacinaVO().setDescricao(rs.getString("dsc_vacina"));

			vacinaUsuarioVO.getUsuarioVO().setSequencial(rs.getInt("seq_usuario"));
			vacinaUsuarioVO.getUsuarioVO().setNome(rs.getString("nom_usuario"));
			vacinaUsuarioVO.getUsuarioVO().setSobrenome(rs.getString("nom_sobrenome"));
			vacinaUsuarioVO.getUsuarioVO().setEmail(rs.getString("nom_email"));
			vacinaUsuarioVO.getUsuarioVO().setSenha(rs.getString("nom_senha"));
			vacinaUsuarioVO.getUsuarioVO().setGenero(rs.getString("nom_genero"));
			vacinaUsuarioVO.getUsuarioVO().setDataNascimento(rs.getTimestamp("data_nascimento"));

			lista.add(vacinaUsuarioVO);
		}
		return lista;
	}

	public String salvar(VacinaUsuarioVO vacinaUsuarioVO) throws DAOException 
	{

		if (vacinaUsuarioVO.getSequencial() != null) {

			return atualizar(vacinaUsuarioVO);

		}else{

			return inserir(vacinaUsuarioVO);
		}

	}

}
