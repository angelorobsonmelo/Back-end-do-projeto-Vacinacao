package br.com.vacinacao.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


@Path("agendamento_de_tarefa")
public class AgendamentoDeTarefaResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("executar_tarefa")
	public String executarTarefa(){

		try {

			// specify the job' s details..
			JobDetail job = JobBuilder.newJob(JobSchulander.class)
					.withIdentity("testJob")
					.build();

			// specify the running period of the job
			Trigger trigger = TriggerBuilder.newTrigger()
					.withSchedule(  
							SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInMinutes(1)
							.repeatForever())
					.build();  

			//schedule the job
			SchedulerFactory schFactory = new StdSchedulerFactory();
			Scheduler sch = schFactory.getScheduler();
			sch.start();	    	
			sch.scheduleJob(job, trigger);		

		} catch (SchedulerException e) {
			e.printStackTrace();
		}



		return "ok";

	}

}
