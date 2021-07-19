package test;

import model.GetSleepLogic;
import model.Sleep;
import model.users.Users;

public class GetSleepTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Users users = new Users(1, "idatt1122@icloud.com", "11223344");
		GetSleepLogic bo = new GetSleepLogic();
		Sleep sleep = bo.execute(users);
		if(sleep.getUsrId() == 1 && sleep.getSleepId() == 2 && sleep.getRemindSetting() == true) {
			System.out.println("成功");
			System.out.println(sleep.getSleepTime().toString());
		} else {
			System.out.println("失敗");
		}
	}

}
