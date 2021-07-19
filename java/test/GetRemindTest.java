package test;

import java.util.ArrayList;

import model.GetRemindLogic;
import model.Remind;
import model.users.Users;

public class GetRemindTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Users users = new Users(1, "idatt1122@icloud.com", "11223344");
		GetRemindLogic bo = new GetRemindLogic();
		ArrayList<Remind> list = bo.execute(users);
		list.forEach( (r) -> System.out.println(r.getRemindTime().toString()));
	}	

}
