package test;

import java.time.LocalTime;

import model.PostSleep;
import model.PostSleepLogic;
import model.Sleep;

public class PostSleepTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		LocalTime time = LocalTime.now();
		boolean setting = true;
		PostSleep postSleep = new PostSleep(1, time, setting);
		PostSleepLogic bo = new PostSleepLogic();
		Sleep sleep = bo.execute(postSleep);
		if(sleep.getUsrId() == 1 && sleep.getSleepTime().equals(time) && sleep.getRemindSetting()) {
			System.out.println("成功");
			System.out.println(sleep.getSleepId());
			
		}	else {
			System.out.println("失敗");
		}
	}

}
