package br.com.vacinacao.util;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.mail.EmailException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.vacinacao.bo.vacina.impl.NotificacaoVacinaUsuarioDoseBO;
import br.com.vacinacao.dao.vacina.impl.NotificacaoVacinaUsuarioDoseDAO;
import br.com.vacinacao.excecao.BOException;
import br.com.vacinacao.model.vacina.NotificacaoVacinaUsuarioDoseVO;

public class JobSchulander implements Job {


	public void verificarDatasParaNotificacao() throws BOException, SQLException, MalformedURLException, EmailException{


		NotificacaoVacinaUsuarioDoseBO notificacaoVacinaUsuarioDoseBO = new NotificacaoVacinaUsuarioDoseBO();

		ArrayList<NotificacaoVacinaUsuarioDoseVO> listaDeDosesAgendadas = notificacaoVacinaUsuarioDoseBO.buscarTodos();


		for (NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDoseVO : listaDeDosesAgendadas) {

			Date data = new Date();  

			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  

			String dataFormatada = formatador.format(data);  

			//System.out.println(dataFormatada);  

			if (notificacaoVacinaUsuarioDoseVO.getDataNotificacaoFormatadaBasica().equals(dataFormatada)) {

				System.out.println("Pode notificar");
				System.out.println(notificacaoVacinaUsuarioDoseVO.getDataNotificacaoFormatadaBasica());
				System.out.println(notificacaoVacinaUsuarioDoseVO.getVacinaVO().getNome());
				System.out.println(notificacaoVacinaUsuarioDoseVO.getDoseVO().getDescricao());
				System.out.println(notificacaoVacinaUsuarioDoseVO.getUsuarioVO().getNome());
				System.out.println(notificacaoVacinaUsuarioDoseVO.getUsuarioVO().getRegId());
				System.out.println(notificacaoVacinaUsuarioDoseVO.getUsuarioVO().getEmail());

				EnviarNotificacao.enviarNotificacao(notificacaoVacinaUsuarioDoseVO.getUsuarioVO().getRegId(), notificacaoVacinaUsuarioDoseVO.getVacinaVO().getNome(), 

						"Hoje: " + notificacaoVacinaUsuarioDoseVO.getDataNotificacaoFormatadaBasica()  +" "+ notificacaoVacinaUsuarioDoseVO.getDoseVO().getDescricao() 
						+ " Lembre-se!");
				
				EnviarEmail.enviarEmailParaAlertarAoUsuarioDaDose(notificacaoVacinaUsuarioDoseVO);



			}


		}



		/*

		ArrayList<String> bandas = new ArrayList<String> ();
		bandas.add("11/11/2015");
		bandas.add("27/10/2015");
		 *
		for (String string : bandas) {

			Date data = new Date();  

			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  

			String dataFormatada = formatador.format(data);  

			//System.out.println(dataFormatada);  

			if (string.equals(dataFormatada)) {

				System.out.println("Pode notificar");
				System.out.println(string);

			} else {

				System.out.println("algumas não são iguais");
				System.out.println(string);

			}
		}

		 */
	}



	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		try {

			verificarDatasParaNotificacao();


		} catch (BOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
