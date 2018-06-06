package pre.DAOImpl;

import java.sql.Connection;
import java.sql.ResultSet;

import pre.DAO.UserDAO;

public class UserDAOImpl extends AbstractDAOImpl implements UserDAO{

	public UserDAOImpl(Connection conn) {
		super(conn);
		
	}

	@Override
	public boolean resigter(String userName, String password, String sex) throws Exception {
		String sql = "INSERT into user(userName,password,sex) value(?,?,?)";
		boolean flag =false;
		super.pstm = super.conn.prepareStatement(sql);
		super.pstm.setString(1, userName);
		super.pstm.setString(2, password);
		super.pstm.setString(3, sex);
		if (super.pstm.executeUpdate() > 0) {
			System.out.println("注册业务成功");
			flag = true;
			return flag;
		}else {
			System.out.println("注册业务失败");
			return flag;
		}
		
	}

	@Override
	public boolean login(String userName, String password) throws Exception {
		String sql="select * from user where userName=? and password=?";
		boolean flag = false;
		super.pstm = super.conn.prepareStatement(sql);
		super.pstm.setString(1, userName);
		super.pstm.setString(2, password);
		ResultSet rs=super.pstm.executeQuery();
		if(rs.next()){
			System.out.println("登陆验证成功");
			return true;
		}else {
			System.out.println("登陆验证失败");
			return false;
		}
	}

}
