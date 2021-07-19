package model;

import java.time.LocalTime;

public class PostSleep {
	private int usrId;
	private LocalTime sleepTime;
	private boolean remindSetting;
	
	public PostSleep(int usrId, LocalTime sleepTime, boolean remindSetting) {
		this.usrId = usrId;
		this.sleepTime = sleepTime;
		this.remindSetting = remindSetting;
	}
	public int getUsrId() {
		return usrId;
	}
	public LocalTime getSleepTime() {
		return sleepTime;
	}
	public boolean getRemindSetting() {
		return remindSetting;
	}

}
