package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import model.PostRemind;
import model.Remind;
import model.users.Users;

public class RemindDAO {
	ResourceBundle bundle = ResourceBundle.getBundle("properties.database");

	public ArrayList<Remind> findByUsers(Users users) {
		ArrayList<Remind> list = new ArrayList<Remind>();
		try (Connection conn = DriverManager.getConnection(
				bundle.getString("JDBC_URL"),
				bundle.getString("DB_USER"),
				bundle.getString("DB_PASS"))) {

			String sql = "SELECT REMINDID, SLEEPID, TASKID, REMINDTIME FROM REMIND WHERE USRID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, users.getUsrId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int remindId = rs.getInt("REMINDID");
				int sleepId = rs.getInt("SLEEPID");
				int taskId = rs.getInt("TASKID");
				LocalTime remindTime = rs.getTime("REMINDTIME").toLocalTime();

				Remind remind = new Remind(users.getUsrId(), sleepId, remindId, taskId, remindTime);
				list.add(remind);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Remind> findAll() {
		ArrayList<Remind> list = new ArrayList<Remind>();
		try (Connection conn = DriverManager.getConnection(
				bundle.getString("JDBC_URL"),
				bundle.getString("DB_USER"),
				bundle.getString("DB_PASS"))) {

			String sql = "SELECT * FROM REMIND";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int usrId = rs.getInt("USRID");
				int remindId = rs.getInt("REMINDID");
				int sleepId = rs.getInt("SLEEPID");
				int taskId = rs.getInt("TASKID");
				LocalTime remindTime = rs.getTime("REMINDTIME").toLocalTime();

				Remind remind = new Remind(usrId, sleepId, remindId, taskId, remindTime);
				list.add(remind);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Remind createRemind(PostRemind postRemind) {

		Remind remind = null;

		try (Connection conn = DriverManager.getConnection(
				bundle.getString("JDBC_URL"),
				bundle.getString("DB_USER"),
				bundle.getString("DB_PASS"))) {

			String sql = "INSERT INTO REMIND(USRID,SLEEPID,TASKID,REMINDTIME) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, postRemind.getUsrId());
			pstmt.setInt(2, postRemind.getSleepId());
			pstmt.setInt(3, postRemind.getTaskId());
			pstmt.setTime(4, java.sql.Time.valueOf(postRemind.getRemindTime()));

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int remindId = rs.getInt(1);
				remind = new Remind(postRemind.getUsrId(), postRemind.getSleepId(), remindId, postRemind.getTaskId(),
						postRemind.getRemindTime());
			}

			return remind;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public int deleteRemind(Users users) {
		try (Connection conn = DriverManager.getConnection(bundle.getString("JDBC_URL"),
				bundle.getString("DB_USER"),
				bundle.getString("DB_PASS"))) {
			String sql = "DELETE FROM REMIND WHERE USRID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, users.getUsrId());
			int result = pstmt.executeUpdate();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
