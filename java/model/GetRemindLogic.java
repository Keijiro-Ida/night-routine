package model;

import java.util.ArrayList;

import DAO.RemindDAO;
import model.users.Users;

public class GetRemindLogic {
	public ArrayList<Remind> execute(Users users) {
		RemindDAO dao = new RemindDAO();
		ArrayList<Remind> list = dao.findByUsers(users);
		return list;
	}
}
