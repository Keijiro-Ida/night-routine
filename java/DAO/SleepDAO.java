package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ResourceBundle;

import model.PostSleep;
import model.Sleep;
import model.users.Users;

public class SleepDAO {
	ResourceBundle bundle = ResourceBundle.getBundle("properties.database");

	public Sleep createSleep(PostSleep postSleep) {
		Sleep sleep = null;
		try (Connection conn = DriverManager.getConnection(
				bundle.getString("JDBC_URL"),
				bundle.getString("DB_USER"),
				bundle.getString("DB_PASS"))) {
			String sql = "INSERT INTO SLEEP(USRID, SLEEPTIME, REMINDSETTING) VALUES(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, postSleep.getUsrId());
			pstmt.setTime(2, java.sql.Time.valueOf(postSleep.getSleepTime()));
			pstmt.setBoolean(3, postSleep.getRemindSetting());

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int sleepId = rs.getInt(1);
				sleep = new Sleep(postSleep.getUsrId(), sleepId, postSleep.getSleepTime(),
						postSleep.getRemindSetting());

			}

		} catch (SQLException e) {
			return null;
		}
		return sleep;
	}

	public Sleep findByUsers(Users users) {
		Sleep sleep = null;
		try (Connection conn = DriverManager.getConnection(
				bundle.getString("JDBC_URL"),
				bundle.getString("DB_USER"),
				bundle.getString("DB_PASS"))) {
			String sql = "SELECT SLEEPID, SLEEPTIME, REMINDSETTING FROM SLEEP WHERE USRID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, users.getUsrId());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int sleepId = rs.getInt("SLEEPID");
				LocalTime sleepTime = rs.getTime("SLEEPTIME").toLocalTime();
				boolean remindSetting = rs.getBoolean("REMINDSETTING");
				sleep = new Sleep(users.getUsrId(), sleepId, sleepTime, remindSetting);
			}
			return sleep;
		} catch (SQLException e) {
			return null;
		}
	}

	public int deleteByUsers(Users users) {
		try (Connection conn = DriverManager.getConnection(
				bundle.getString("JDBC_URL"),
				bundle.getString("DB_USER"),
				bundle.getString("DB_PASS"))) {
			String sql = "DELETE FROM SLEEP WHERE USRID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, users.getUsrId());

			int result = pstmt.executeUpdate();

			return result;
		} catch (SQLException e) {
			return -1;
		}
	}
}
