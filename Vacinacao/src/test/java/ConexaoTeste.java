import java.sql.SQLException;

import br.com.vacinacao.database.Conexao;


public class ConexaoTeste {

	public static void main(String[] args) throws SQLException {

		Conexao.getConexao();

	}

}
