package test;

import java.time.LocalTime;

import model.PostRemind;
import model.PostRemindLogic;
import model.Remind;
import model.SendMailLogic;

public class SendMailTest {
	public static void main(String[] args) {
		testExecute();
	}
	public static void testExecute() {
		LocalTime now = LocalTime.now().plusMinutes(1);
		PostRemind postRemind = new PostRemind(1, 2, 1, now);
		PostRemindLogic bo = new PostRemindLogic();
		Remind remind = bo.execute(postRemind);
		if(remind != null) {
			SendMailLogic bo2 = new SendMailLogic(remind);
			bo2.execute();
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}
		
	}
}

