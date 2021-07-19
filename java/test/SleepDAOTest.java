package test;

import java.time.LocalTime;

import DAO.SleepDAO;
import model.PostSleep;
import model.Sleep;

public class SleepDAOTest {
	public static void main(String[] args) {
		testExecute1();
	}
	public static void testExecute1() {
		LocalTime time = LocalTime.now();
		boolean setting = true;
		PostSleep postSleep = new PostSleep(1, time, setting);
		SleepDAO dao = new SleepDAO();
		Sleep sleep = dao.createSleep(postSleep);
		if(sleep.getUsrId() == 1 && sleep.getSleepTime().equals(time) && sleep.getRemindSetting()) {
			System.out.println("test1成功");
			System.out.println("sleepId=" + sleep.getSleepId());
		} else {
			System.out.println("失敗");
		}
	}
}
