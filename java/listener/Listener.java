package listener;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import DAO.RemindDAO;
import model.Remind;
import model.SendMailLogic;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements ServletContextListener {

	/**
	 * Default constructor. 
	 */
	public Listener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		RemindDAO dao = new RemindDAO();
		List<Remind> remindList = dao.findAll();
		for (Remind remind : remindList) {
			if (SendMailLogic.map_ScheduledFuture.get(remind.getRemindId()) != null) {
				SendMailLogic.map_ScheduledFuture.get(remind.getRemindId()).cancel(true);
				SendMailLogic.map_ScheduledExecutor.get(remind.getRemindId()).shutdown();
				System.out.println(remind.getRemindId() + "スレッド削除");
				SendMailLogic.map_ScheduledFuture.remove(remind.getRemindId());

				try {
					SendMailLogic.map_ScheduledExecutor.get(remind.getRemindId()).awaitTermination(1,
							TimeUnit.NANOSECONDS);
					SendMailLogic.map_ScheduledExecutor.remove(remind.getRemindId());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		RemindDAO dao = new RemindDAO();
		List<Remind> remindList = dao.findAll();
		for (Remind remind : remindList) {
			SendMailLogic bo = new SendMailLogic(remind);
			bo.execute();
			System.out.println(remind.getRemindId() + "スレッド再起");
		}
	}

}
