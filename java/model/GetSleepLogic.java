package model;

import DAO.SleepDAO;
import model.users.Users;

public class GetSleepLogic {
	public Sleep execute(Users users) {
		SleepDAO dao = new SleepDAO();
		Sleep sleep = dao.findByUsers(users);
		return sleep;
	}
}
