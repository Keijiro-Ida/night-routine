package servlet;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DeleteRemindLogic;
import model.DeleteSleepLogic;
import model.GetRemindLogic;
import model.GetSleepLogic;
import model.PostRemind;
import model.PostRemindLogic;
import model.PostSleep;
import model.PostSleepLogic;
import model.Remind;
import model.SendMailLogic;
import model.Sleep;
import model.users.Users;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");

		GetSleepLogic bo = new GetSleepLogic();
		Sleep sleep = bo.execute(users);
		session.setAttribute("sleep", sleep);

		GetRemindLogic bo2 = new GetRemindLogic();
		ArrayList<Remind> remindList = bo2.execute(users);
		session.setAttribute("remindList", remindList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("users");
		ArrayList<Remind> remindList = (ArrayList<Remind>) session.getAttribute("remindList");

		for (Remind remind : remindList) {
			if (SendMailLogic.map_ScheduledFuture.get(remind.getRemindId()) != null) {
				SendMailLogic.map_ScheduledFuture.get(remind.getRemindId()).cancel(true);
				SendMailLogic.map_ScheduledExecutor.get(remind.getRemindId()).shutdown();

				try {
					SendMailLogic.map_ScheduledExecutor.get(remind.getRemindId()).awaitTermination(1,
							TimeUnit.NANOSECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		remindList.clear();
		SendMailLogic.map_ScheduledFuture.clear();
		SendMailLogic.map_ScheduledExecutor.clear();

		DeleteRemindLogic bo2 = new DeleteRemindLogic();
		bo2.execute(users);

		DeleteSleepLogic bo = new DeleteSleepLogic();
		bo.execute(users);

		String sleepTime_str = request.getParameter("sleepTime");
		String remindSetting_str = request.getParameter("remind_switch");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime sleepTime = LocalTime.parse(sleepTime_str, fmt);
		System.out.println(remindSetting_str);
		boolean remindSetting = Boolean.valueOf(remindSetting_str);
		System.out.println(remindSetting);
		PostSleep postSleep = new PostSleep(users.getUsrId(), sleepTime, remindSetting);
		PostSleepLogic bo3 = new PostSleepLogic();
		Sleep sleep = bo3.execute(postSleep);

		session.setAttribute("sleep", sleep);

		if (remindSetting == true) {
			PostRemind postRemind_dinner = new PostRemind(users.getUsrId(), sleep.getSleepId(), 1,
					sleepTime.minusMinutes(180));
			PostRemind postRemind_bath = new PostRemind(users.getUsrId(), sleep.getSleepId(), 2,
					sleepTime.minusMinutes(90));
			PostRemind postRemind_reading = new PostRemind(users.getUsrId(), sleep.getSleepId(), 3,
					sleepTime.minusHours(1));

			PostRemindLogic bo4 = new PostRemindLogic();
			Remind remind_dinner = bo4.execute(postRemind_dinner);
			Remind remind_bath = bo4.execute(postRemind_bath);
			Remind remind_reading = bo4.execute(postRemind_reading);

			SendMailLogic remindLogic_dinner = new SendMailLogic(remind_dinner);
			SendMailLogic remindLogic_bath = new SendMailLogic(remind_bath);
			SendMailLogic remindLogic_reading = new SendMailLogic(remind_reading);
			remindLogic_dinner.execute();
			remindLogic_bath.execute();
			remindLogic_reading.execute();

			remindList.add(remind_dinner);
			remindList.add(remind_bath);
			remindList.add(remind_reading);

		}
		session.setAttribute("remindList", remindList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
