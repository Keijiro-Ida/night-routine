package model;

import DAO.SleepDAO;
import model.users.Users;

public class DeleteSleepLogic {
	public int execute(Users users) {
		SleepDAO dao = new SleepDAO();
		int result = dao.deleteByUsers(users);
		return result;
	}
}
