package test;

import model.GetSleepLogic;
import model.PostRemind;
import model.PostRemindLogic;
import model.Remind;
import model.Sleep;
import model.users.Users;

public class CreateRemindTest {
	public static void main(String[] args) {
		Users users = new Users(1, "idatt1122@icloud.com", "11223344");
		GetSleepLogic bo = new GetSleepLogic();
		Sleep sleep = bo.execute(users);
		PostRemind postRemind = new PostRemind(1, 2, 1, sleep.getSleepTime());
		PostRemindLogic bo2 = new PostRemindLogic();
		Remind remind = bo2.execute(postRemind);
		if(remind.getUsrId() == 1 && remind.getSleepId() == 2 && remind.getRemindTime().equals(sleep.getSleepTime())) {
			System.out.println("成功");
			System.out.println(remind.getRemindId());
		} else {
			System.out.println("失敗");
		}
	}
}
