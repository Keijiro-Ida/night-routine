package model;

import DAO.SleepDAO;

public class PostSleepLogic {
	public Sleep execute(PostSleep postSleep) {
		SleepDAO dao = new SleepDAO();
		Sleep sleep = dao.createSleep(postSleep);
		return sleep;
	}
}
