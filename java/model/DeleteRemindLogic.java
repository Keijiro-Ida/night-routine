package model;

import DAO.RemindDAO;
import model.users.Users;

public class DeleteRemindLogic {
	public int execute(Users users) {
		RemindDAO dao = new RemindDAO();
		int result = dao.deleteRemind(users);
		return result;
	}
}
