package model;

import java.time.LocalTime;

public class PostRemind {
	private int usrId;
	private int sleepId;
	private int taskId;
	private LocalTime remindTime;
	
	public PostRemind(int usrId, int sleepId, int taskId, LocalTime remindTime) {
		this.usrId = usrId;
		this.sleepId = sleepId;
		this.taskId = taskId;
		this.remindTime = remindTime;
	}
	public int getUsrId() {
		return usrId;
	}
	public int getSleepId() {
		return sleepId;
	}
	public int getTaskId() {
		return taskId;
	}
	public LocalTime getRemindTime() {
		return remindTime;
	}
}
