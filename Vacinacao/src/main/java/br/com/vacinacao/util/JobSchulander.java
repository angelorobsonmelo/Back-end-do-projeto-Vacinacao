package br.com.vacinacao.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobSchulander implements Job {

	
	public void usuario(){

		ArrayList<String> bandas = new ArrayList<String> ();
		bandas.add("11/11/2015");
		bandas.add("27/10/2015");
	
		
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
	}
	
	
	
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		usuario();

	}

}
