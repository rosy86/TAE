/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.job;

import com.taurus.compratae.appservice.EnvioArchivoFTPService;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *
 * @author Desarrollador java
 */
public class ColocaArchivoFTP extends QuartzJobBean {

    //private RunMeTask runMeTask;
    @Autowired
    private EnvioArchivoFTPService envioArchivoFTPService;

    /*public void setRunMeTask(RunMeTask runMeTask) {
		this.runMeTask = runMeTask;
	}
     */
    public void setEnvioArchivoFTPService(EnvioArchivoFTPService envioArchivoFTPService){
        this.envioArchivoFTPService = envioArchivoFTPService;
    }
    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {

        //runMeTask.printMe();
        envioArchivoFTPService.enviarArchivoFTP();

    }
}
