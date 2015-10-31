package br.com.vacinacao.util;

import br.com.vacinacao.metodos.push.POST2GCM;
import br.com.vacinacao.model.push.Content;

public class EnviarNotificacao {

	
	public static void enviarNotificacao(String regId, String titulo, String descricao){


		String apiKey = "AIzaSyBYxpEBG10XKLQ83h_iHcCVkkdvEy0fs_c";

		Content content = createContent(regId, titulo, descricao);

		POST2GCM.post(apiKey, content);

	}

	public static Content createContent(String regId, String titulo, String descricao){

		Content c = new Content();

		c.addRegId(regId);
		c.createData(titulo, descricao);

		return c;
	}
	
}
