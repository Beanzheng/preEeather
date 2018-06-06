package pre.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AbstractDAOImpl {
	protected Connection conn;
	protected PreparedStatement psta;
	public PreparedStatement pstm;
	
	public AbstractDAOImpl(Connection conn){
		this.conn=conn;
	}
}
