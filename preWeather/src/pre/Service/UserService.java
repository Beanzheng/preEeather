package pre.Service;
/**
 * ÓÃ»§²Ù×÷Âß¼­²ã
 */
public interface UserService {
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
