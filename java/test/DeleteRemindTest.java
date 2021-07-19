package test;

import model.DeleteRemindLogic;
import model.users.Users;

public class DeleteRemindTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		DeleteRemindLogic bo = new DeleteRemindLogic();
		Users users = new Users(1, "idatt1122@icloud.com", "11223344");
		int result = bo.execute(users);
		if(result > 0) {
			System.out.println(result);
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}
	}

}
