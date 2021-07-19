package model;

import DAO.RemindDAO;

public class PostRemindLogic {
	public Remind execute(PostRemind postRemind) {
		RemindDAO dao = new RemindDAO();
		Remind remind = dao.createRemind(postRemind);
		return remind;
	}
}
