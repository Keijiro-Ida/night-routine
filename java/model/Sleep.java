package model;

import java.io.Serializable;
import java.time.LocalTime;

public class Sleep implements Serializable{
	private int usrId;
	private int sleepId;
	private LocalTime sleepTime;
	private boolean remindSetting;
	
	public Sleep() {}
	public Sleep(int usrId, int sleepId, LocalTime sleepTime, boolean remindSetting) {
		this.usrId = usrId;
		this.sleepId = sleepId;
		this.sleepTime = sleepTime;
		this.remindSetting = remindSetting;
	}
	
	public int getUsrId() {
		return usrId;
	}
	public int getSleepId() {
		return sleepId;
	}
	public LocalTime getSleepTime() {
		return sleepTime;
	}
	public boolean getRemindSetting() {
		return remindSetting;
	}

}
