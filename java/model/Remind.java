package model;

import java.io.Serializable;
import java.time.LocalTime;

public class Remind implements Serializable{
	private int usrId;
	private int sleepId;
	private int remindId;
	private int taskId;
	private LocalTime remindTime;
	
	public Remind() {}
	public Remind(int usrId, int sleepId, int remindId, int taskId, LocalTime remindTime) {
		this.remindId = remindId;
		this.sleepId = sleepId;
		this.usrId = usrId;
		this.taskId = taskId;
		this.remindTime = remindTime;
	}
	public int getRemindId() {
		return remindId;
	}
	public int getSleepId() {
		return sleepId;
	}
	public int getUsrId() {
		return usrId;
	}
	public int getTaskId() {
		return taskId;
	}
	public LocalTime getRemindTime() {
		return remindTime;
	}
}
