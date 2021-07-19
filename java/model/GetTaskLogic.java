package model;

import DAO.TaskDAO;

public class GetTaskLogic {
	public Task execute(int taskId) {
		TaskDAO dao = new TaskDAO();
		Task task = dao.findByTaskId(taskId);
		return task;
	}
}
