package pre.DAO;
/**
 * 用户底层数据
 * @author shineion
 *
 */
public interface UserDAO {
	/**
	 * 
	 * @param userName
	 * @param password
	 * @param Sex
	 * @return true/false
	 * @throws Exception
	 */
	public boolean resigter(String userName,String password,String sex) throws Exception;
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return true/false
	 * @throws Exception
	 */
	public boolean login(String userName,String password) throws Exception;
}
