package test;

import DAO.TaskDAO;
import model.Task;

public class TaskTest {
	public static void main(String[] args) {
		TaskDAO dao = new TaskDAO();
		Task task = dao.findByTaskId(1);
		System.out.println(task.getAction());
		System.out.println(task.getMailText());
	}

}
