package model;

import DAO.UsersDAO;
import model.users.Users;

public class GetUsersLogic {
	public Users execute(int usrId) {
		UsersDAO dao = new UsersDAO();
		Users users = dao.findByUsrId(usrId);
		return users;
	}
}
