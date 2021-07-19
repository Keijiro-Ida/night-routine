package model;

public class Task {
	private int taskId;
	private String action ;
	private String mailText;
	
	public Task(int taskId, String action, String mailText) {
		this.taskId = taskId;
		this.action = action;
		this.mailText = mailText;
	}
	public int getTaskId() {
		return taskId;
	}
	public String getAction() {
		return action;
	}
	public String getMailText() {
		return mailText;
	}
}
