package test;

import model.DeleteSleepLogic;
import model.users.Users;

public class DeleteSleepTest {
	public static void main(String[] args) {
		testExecute();
	}
	public static void testExecute() {
		DeleteSleepLogic bo = new DeleteSleepLogic();
		Users users = new Users(1, "idatt1122@icloud.com", "11223344");
		int result = bo.execute(users);
		if(result == 1) {
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}
		
	}
}
