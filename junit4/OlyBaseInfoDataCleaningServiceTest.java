/*package com.innshine.olyproductmanager.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.innshine.olyproductmanager.timetask.OlyBaseInfoDataCleaningService;
import com.innshine.olyproductmanager.timetask.OlySalesInfoDataCleaningService;
import com.utils.email.MailTimeTask;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml"})
@TestExecutionListeners({ TransactionalTestExecutionListener.class })
public class OlyBaseInfoDataCleaningServiceTest extends AbstractJUnit4SpringContextTests
{
	@Autowired(required=true)
	private  MailTimeTask mailTimeTask;
	
	
	
	@Test
	public void testDoTask()
	{
		// baseInfoDataCleaningService.doTask();
		mailTimeTask.doWork();
	}
 }
*/