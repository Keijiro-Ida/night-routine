package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import model.Task;

public class TaskDAO {

	ResourceBundle bundle = ResourceBundle.getBundle("properties.database");
	public Task findByTaskId(int taskId) {
		Task task = null;
		try(Connection conn = DriverManager.getConnection(
											bundle.getString("JDBC_URL"),
											bundle.getString("DB_USER"),
											bundle.getString("DB_PASS"))){
			String sql = "SELECT ACTION , MAILTEXT FROM TASK WHERE TASKID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, taskId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String action = rs.getString("ACTION");
				String mailText = rs.getString("MAILTEXT");
				task = new Task(taskId, action, mailText);
			}
			return task;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
