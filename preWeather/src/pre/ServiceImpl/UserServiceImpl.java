package pre.ServiceImpl;

import java.sql.Connection;

import pre.DB.DBConection;
import pre.Factory.DAOFactory;
import pre.Service.UserService;

public class UserServiceImpl implements UserService{
	private DBConection dbc=  new DBConection();
	@Override
	public boolean resigter(String userName, String password, String sex) throws Exception {
		if(DAOFactory.getUserDaoInstance((Connection)
				this.dbc.getConn()).resigter(userName, password, sex)){
			System.out.println("注册业务逻辑成功");
			return true;
		}else {
			System.out.println("注册业务逻辑失败");
			return false;
		}
		
	}

	@Override
	public boolean login(String userName, String password) throws Exception {
		if(DAOFactory.getUserDaoInstance((Connection)
				this.dbc.getConn()).login(userName, password)){
			System.out.println("登陆业务逻辑成功");
			return true;
		}else {
			System.out.println("登陆业务逻辑失败");
			return false;
		}
	}

}
