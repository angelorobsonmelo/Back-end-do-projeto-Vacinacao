package br.com.vacinacao.dao.vacina.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import br.com.vacinacao.dao.vacina.INotificacaoVacinaUsuarioDoseDAO;
import br.com.vacinacao.database.Conexao;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.excecao.DAOException;
import br.com.vacinacao.model.vacina.NotificacaoVacinaUsuarioDoseVO;
import br.com.vacinacao.util.VerificadorValorObjeto;

public class NotificacaoVacinaUsuarioDoseDAO implements INotificacaoVacinaUsuarioDoseDAO {


	private CallableStatement cstmt;
	private String resultado;
	private String procedure;


	public String remover(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDose) throws DAOException {
		procedure = "{ ? = CALL SP_NOTIFICACAO_VACINA_USUARIO_DOSE_REMOVER(?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(notificacaoVacinaUsuarioDose.getSequencial()));

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

	public String inserir(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDose) throws DAOException {
		procedure = "{ ? = CALL SP_NOTIFICACAO_VACINA_USUARIO_DOSE_INSERIR(?,?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setDate(2, new java.sql.Date(VerificadorValorObjeto.retornaLongValorObjetoOuZero(notificacaoVacinaUsuarioDose.getDataNotificacao().getTime())));		
			cstmt.setInt(3, VerificadorValorObjeto.retornaIntValorObjetoOuZero(notificacaoVacinaUsuarioDose.getUsuarioVO().getSequencial()));
			cstmt.setInt(4, VerificadorValorObjeto.retornaIntValorObjetoOuZero(notificacaoVacinaUsuarioDose.getVacinaVO().getSequencial()));
			cstmt.setInt(5, VerificadorValorObjeto.retornaIntValorObjetoOuZero(notificacaoVacinaUsuarioDose.getDoseVO().getSequencial()));

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

	public String atualizar(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDose) throws DAOException {
		procedure = "{ ? = CALL SP_NOTIFICACAO_VACINA_USUARIO_DOSE_ATUALIZAR(?,?,?,?,?)}";
		cstmt = null;
		resultado = null;

		try
		{

			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(notificacaoVacinaUsuarioDose.getSequencial()));
			cstmt.setDate(3, new java.sql.Date(VerificadorValorObjeto.retornaLongValorObjetoOuZero(notificacaoVacinaUsuarioDose.getDataNotificacao().getTime())));		
			cstmt.setInt(4, VerificadorValorObjeto.retornaIntValorObjetoOuZero(notificacaoVacinaUsuarioDose.getUsuarioVO().getSequencial()));
			cstmt.setInt(5, VerificadorValorObjeto.retornaIntValorObjetoOuZero(notificacaoVacinaUsuarioDose.getVacinaVO().getSequencial()));
			cstmt.setInt(6, VerificadorValorObjeto.retornaIntValorObjetoOuZero(notificacaoVacinaUsuarioDose.getDoseVO().getSequencial()));

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

	public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodos() throws DAOException {
		procedure = "{? = CALL SP_NOTIFICACAO_VACINA_USUARIO_DOSE_BUSCAR_TODOS()}";
		cstmt = null;
		ArrayList<NotificacaoVacinaUsuarioDoseVO> lista = new ArrayList<NotificacaoVacinaUsuarioDoseVO>();

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

	public ArrayList<NotificacaoVacinaUsuarioDoseVO> buscarTodosPorSequencialUsuario(
			NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDose) throws DAOException {
		procedure = "{? = CALL SP_NOTIFICACAO_VACINA_USUARIO_DOSE_BUSCAR_TODOS_POR_SEQ_USU(?)}";
		cstmt = null;
		ArrayList<NotificacaoVacinaUsuarioDoseVO> lista = new ArrayList<NotificacaoVacinaUsuarioDoseVO>();

		try
		{
			cstmt = Conexao.getConexao().prepareCall(procedure);
			cstmt.registerOutParameter(1, Types.OTHER);
			cstmt.setInt(2, VerificadorValorObjeto.retornaIntValorObjetoOuZero(notificacaoVacinaUsuarioDose.getUsuarioVO().getSequencial()));

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

	public String salvar(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDose) throws DAOException {

		if (notificacaoVacinaUsuarioDose.getSequencial() != null) {

			return atualizar(notificacaoVacinaUsuarioDose);

		} else {

			return inserir(notificacaoVacinaUsuarioDose);

		}

	}

	public ArrayList<NotificacaoVacinaUsuarioDoseVO> mapearResultSet(ResultSet rs) throws SQLException, BOException, DAOException{

		ArrayList<NotificacaoVacinaUsuarioDoseVO> lista = new ArrayList<NotificacaoVacinaUsuarioDoseVO>();

		while(rs.next()){

			NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDoseVO = new NotificacaoVacinaUsuarioDoseVO();

			notificacaoVacinaUsuarioDoseVO.setSequencial(rs.getInt("seq_notificacao_vacina_usuario_dose"));
			notificacaoVacinaUsuarioDoseVO.setDataNotificacao(rs.getTimestamp("data_notificacao"));


			notificacaoVacinaUsuarioDoseVO.getVacinaVO().setSequencial(rs.getInt("seq_vacina"));
			notificacaoVacinaUsuarioDoseVO.getVacinaVO().setNome(rs.getString("nom_vacina"));
			notificacaoVacinaUsuarioDoseVO.getVacinaVO().setDescricao(rs.getString("dsc_vacina"));

			notificacaoVacinaUsuarioDoseVO.getUsuarioVO().setSequencial(rs.getInt("seq_usuario"));
			notificacaoVacinaUsuarioDoseVO.getUsuarioVO().setNome(rs.getString("nom_usuario"));
			notificacaoVacinaUsuarioDoseVO.getUsuarioVO().setSobrenome(rs.getString("nom_sobrenome"));
			notificacaoVacinaUsuarioDoseVO.getUsuarioVO().setEmail(rs.getString("nom_email"));
			notificacaoVacinaUsuarioDoseVO.getUsuarioVO().setSenha(rs.getString("nom_senha"));
			notificacaoVacinaUsuarioDoseVO.getUsuarioVO().setGenero(rs.getString("nom_genero"));
			notificacaoVacinaUsuarioDoseVO.getUsuarioVO().setDataNascimento(rs.getTimestamp("data_nascimento"));
			notificacaoVacinaUsuarioDoseVO.getUsuarioVO().setRegId(rs.getString("reg_id"));

			notificacaoVacinaUsuarioDoseVO.getDoseVO().setSequencial(rs.getInt("seq_dose"));
			notificacaoVacinaUsuarioDoseVO.getDoseVO().setDescricao(rs.getString("dsc_dose"));

			lista.add(notificacaoVacinaUsuarioDoseVO);
		}
		return lista;
	}


}
