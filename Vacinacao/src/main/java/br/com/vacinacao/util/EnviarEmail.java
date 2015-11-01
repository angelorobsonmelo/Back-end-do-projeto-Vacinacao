package br.com.vacinacao.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.vacinacao.model.usuario.UsuarioVO;
import br.com.vacinacao.model.vacina.CampanhaVO;
import br.com.vacinacao.model.vacina.NotificacaoVacinaUsuarioDoseVO;


public class EnviarEmail {

	
	 public Boolean enviarEmailParaRecuperacaoDeSenha(UsuarioVO usuarioVO) throws EmailException, MalformedURLException  {

		// Cria o e-mail
		HtmlEmail email = new HtmlEmail(); 
		email.setHostName("smtp.gmail.com"); 
		email.setSmtpPort(465);
		email.setSSL(true);
		email.setAuthentication("coachteste45@gmail.com", "coachteste");

		System.out.println("enviando... para " + usuarioVO.getEmail());

		email.addTo(usuarioVO.getEmail(), "Vacinação"); 
		email.setFrom("me@apache.org", "Vacinação"); 
		email.setSubject("Recuperação de Senha");   
		// adiciona uma imagem ao corpo da mensagem e retorna seu id
		URL url = new URL("https://www.casadevacinasgsk.com.br/visao/default/img/newstyle/link-gota.png");  
		String cid = email.embed(url, "Logo Vacinação"); 
	
		String sb = "<html><head><style> h1 { color:rgb(185, 41, 66); } button { " +
				"        margin: -8px;" +
				"        padding: 6px;" +
				"		 padding-left: 12%;" +
				"		 padding-right: 12%;" +
				"        font-family: verdana;" +
				"        font-weight: bold;" +
				"        font-size: 20px;" +
				"        background-repeat: no-repeat;" +
				"        background-position: -75% 0;" +
				"        background-color: rgb(185, 41, 66);" +
				"        border: 2px solid #e92a4e;" +
				"        color: #fff;" +
				"        cursor: pointer;" +
				"        -webkit-transition: .5s ease-out;" +
				"}"	+

" 		 .divbox,* [lang~='x-divbox']:hover {" +
"        margin: -8px;" +
"        padding: 6px;" +
"		 padding-left: 12%;" +
"		 padding-right: 12%;" +
"        font-family: verdana;" +
"        font-weight: bold;" +
"        font-size: 20px;" +
"        background-repeat: no-repeat;" +
"        background-position: -75% 0;" +
"        background-color: #fff;" +
"        border: 2px solid #e92a4e;" +
"        color: rgb(185, 41, 66);" +
"        cursor: pointer;" +
"        -webkit-transition: .5s ease-out;" +
"    }" +

"table { " +
"        border: 1px solid #dedede;" +


"    }" +  


 "</style> "
 + "<head>"
 + "<body>"
 
 + "<img src=\"cid:"+cid+"\" alt='Smiley face' height='35%' width='100%'>"

 + "<a href='http://192.168.0.10:63342/Vacinacao/www/index.html#/redefinir-senha/"+ usuarioVO.getEmail() + " '  ><button type='button'class='divbox' lang='x-divbox'>CLICK AQUI PARA REDEFINIR SUA SENHA</button></a>"

 + "</body>"
 + "</html>";


		// configura a mensagem para o formato HTML
		email.setHtmlMsg(sb);   
		// configure uma mensagem alternativa caso o servidor nÃ£o suporte HTML 
		email.setTextMsg("seu servidor nÃ£o suporta formato html"); 
		// envia o e-mail 
		email.send();

		System.out.println("Email enviado para " + usuarioVO.getEmail());

		return true;
	}
	 
	 
	 
	 public static Boolean enviarEmailParaAlertarAoUsuarioDaDose(NotificacaoVacinaUsuarioDoseVO notificacaoVacinaUsuarioDoseVO) throws EmailException, MalformedURLException  {

			// Cria o e-mail
			HtmlEmail email = new HtmlEmail(); 
			email.setHostName("smtp.gmail.com"); 
			email.setSmtpPort(465);
			email.setSSL(true);
			email.setAuthentication("coachteste45@gmail.com", "coachteste");

			System.out.println("enviando... para " + notificacaoVacinaUsuarioDoseVO.getUsuarioVO().getEmail());

			email.addTo(notificacaoVacinaUsuarioDoseVO.getUsuarioVO().getEmail(), "Vacinação"); 
			email.setFrom("me@apache.org", "Vacinação"); 
			email.setSubject("Alerta");   
			// adiciona uma imagem ao corpo da mensagem e retorna seu id
			URL url = new URL("https://www.casadevacinasgsk.com.br/visao/default/img/newstyle/link-gota.png");  
			String cid = email.embed(url, "Logo Vacinação"); 
		
			String sb = "<html><head><style> h1 { color:rgb(185, 41, 66); } button { " +
					"        margin: -8px;" +
					"        padding: 6px;" +
					"		 padding-left: 12%;" +
					"		 padding-right: 12%;" +
					"        font-family: verdana;" +
					"        font-weight: bold;" +
					"        font-size: 20px;" +
					"        background-repeat: no-repeat;" +
					"        background-position: -75% 0;" +
					"        background-color: rgb(185, 41, 66);" +
					"        border: 2px solid #e92a4e;" +
					"        color: #fff;" +
					"        cursor: pointer;" +
					"        -webkit-transition: .5s ease-out;" +
					"}"	+

	" 		 .divbox,* [lang~='x-divbox']:hover {" +
	"        margin: -8px;" +
	"        padding: 6px;" +
	"		 padding-left: 12%;" +
	"		 padding-right: 12%;" +
	"        font-family: verdana;" +
	"        font-weight: bold;" +
	"        font-size: 20px;" +
	"        background-repeat: no-repeat;" +
	"        background-position: -75% 0;" +
	"        background-color: #fff;" +
	"        border: 2px solid #e92a4e;" +
	"        color: rgb(185, 41, 66);" +
	"        cursor: pointer;" +
	"        -webkit-transition: .5s ease-out;" +
	"    }" +

	"table { " +
	"        border: 1px solid #dedede;" +


	"    }" +  


	 "</style> "
	 + "<head>"
	 + "<body>"
	 
	 + "<img src=\"cid:"+cid+"\" alt='Smiley face' height='35%' width='100%'>"

	 + "Hoje: " +  notificacaoVacinaUsuarioDoseVO.getDataNotificacaoFormatadaBasica() + " é dia da " + notificacaoVacinaUsuarioDoseVO.getDoseVO().getDescricao() 
	 + " da Vacina " + notificacaoVacinaUsuarioDoseVO.getVacinaVO().getNome() + " Lembre-se!"

	 + "</body>"
	 + "</html>";


			// configura a mensagem para o formato HTML
			email.setHtmlMsg(sb);   
			// configure uma mensagem alternativa caso o servidor nÃ£o suporte HTML 
			email.setTextMsg("seu servidor nÃ£o suporta formato html"); 
			// envia o e-mail 
			email.send();

			System.out.println("Email enviado para " + notificacaoVacinaUsuarioDoseVO.getUsuarioVO().getEmail());

			return true;
		}
	 
	 
	 public static Boolean enviarEmailParaAlertarAoUsuarioSobreCampanhas(UsuarioVO usuarioVO, CampanhaVO campanhaVO) throws EmailException, MalformedURLException  {

			// Cria o e-mail
			HtmlEmail email = new HtmlEmail(); 
			email.setHostName("smtp.gmail.com"); 
			email.setSmtpPort(465);
			email.setSSL(true);
			email.setAuthentication("coachteste45@gmail.com", "coachteste");

			System.out.println("enviando... para " + usuarioVO.getEmail());

			email.addTo(usuarioVO.getEmail(), "Vacinação"); 
			email.setFrom("me@apache.org", "Vacinação"); 
			email.setSubject(campanhaVO.getTitulo());   
			// adiciona uma imagem ao corpo da mensagem e retorna seu id
			URL url = new URL("https://www.casadevacinasgsk.com.br/visao/default/img/newstyle/link-gota.png");  
			String cid = email.embed(url, "Logo Vacinação"); 
		
			String sb = "<html><head><style> h1 { color:rgb(185, 41, 66); } button { " +
					"        margin: -8px;" +
					"        padding: 6px;" +
					"		 padding-left: 12%;" +
					"		 padding-right: 12%;" +
					"        font-family: verdana;" +
					"        font-weight: bold;" +
					"        font-size: 20px;" +
					"        background-repeat: no-repeat;" +
					"        background-position: -75% 0;" +
					"        background-color: rgb(185, 41, 66);" +
					"        border: 2px solid #e92a4e;" +
					"        color: #fff;" +
					"        cursor: pointer;" +
					"        -webkit-transition: .5s ease-out;" +
					"}"	+

	" 		 .divbox,* [lang~='x-divbox']:hover {" +
	"        margin: -8px;" +
	"        padding: 6px;" +
	"		 padding-left: 12%;" +
	"		 padding-right: 12%;" +
	"        font-family: verdana;" +
	"        font-weight: bold;" +
	"        font-size: 20px;" +
	"        background-repeat: no-repeat;" +
	"        background-position: -75% 0;" +
	"        background-color: #fff;" +
	"        border: 2px solid #e92a4e;" +
	"        color: rgb(185, 41, 66);" +
	"        cursor: pointer;" +
	"        -webkit-transition: .5s ease-out;" +
	"    }" +

	"table { " +
	"        border: 1px solid #dedede;" +


	"    }" +  


	 "</style> "
	 + "<head>"
	 + "<body>"
	 
	 + "<img src=\"cid:"+cid+"\" alt='Smiley face' height='35%' width='100%'>"

	 + campanhaVO.getDescricao()

	 + "</body>"
	 + "</html>";


			// configura a mensagem para o formato HTML
			email.setHtmlMsg(sb);   
			// configure uma mensagem alternativa caso o servidor nÃ£o suporte HTML 
			email.setTextMsg("seu servidor nÃ£o suporta formato html"); 
			// envia o e-mail 
			email.send();

			System.out.println("Email enviado para " + usuarioVO.getEmail());

			return true;
		}
	
}
