package test;

import java.time.LocalTime;
import java.util.ArrayList;

import DAO.RemindDAO;
import model.PostRemind;
import model.Remind;
import model.users.Users;

public class RemindDAOTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		testExecute1();
		testExecute2();
	}
	public static void testExecute1() {
		LocalTime time = LocalTime.now();
		PostRemind postRemind = new PostRemind(1, 1, 1, time);
		RemindDAO dao = new RemindDAO();
		Remind remind = dao.createRemind(postRemind);
		if(remind.getUsrId() == 1 && remind.getSleepId() ==1 && remind.getTaskId() == 1 && remind.getRemindTime().equals(time)) {
			System.out.println("test1成功");
			System.out.println(remind.getRemindId());
		} else {
			System.out.println("test1失敗");
		}
	}
	public static void testExecute2() {
		RemindDAO dao = new RemindDAO();
		Users users = new Users(1, "idatt1122@icloud.com", "11223344");
		ArrayList<Remind> list = dao.findByUsers(users);
		if(list != null) {
			list.stream().forEach( remind -> System.out.println(remind.getRemindId()));
			System.out.println("test2成功");
		} else {
			System.out.println("test2失敗");
		}
	}

}
