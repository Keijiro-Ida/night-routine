package test;

import DAO.UsersDAO;
import model.users.Login;
import model.users.SignUp;
import model.users.Users;

public class SignUpTest {

	public static void main(String[] args) {
		//testExecute1();
		testExecute2();
	}
	static void testExecute1() {
		SignUp signUp = new SignUp("idatt1122@icloud.com", "11223344");
		UsersDAO dao = new UsersDAO();
		int result = dao.createUsers(signUp);
		if(result == 1) {
			System.out.println("test1成功");
		} else {
			System.out.println("test1失敗");
		}
	}
	static void testExecute2() {
		Login login = new Login("idatt1122@icloud.com", "11223344");
		UsersDAO dao = new UsersDAO();
		Users users = dao.findByLogin(login);
		if(users.getUsrId() == 1 && users.getMail().equals("idatt1122@icloud.com")
								 && users.getPass().equals("11223344")) {
			System.out.println("test2成功");
		} else {
			System.out.println("test2失敗");
		}
	}

}
