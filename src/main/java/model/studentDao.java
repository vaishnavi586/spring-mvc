package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;


public class studentDao {
	
	private JdbcTemplate jdbc;
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	public Boolean save(final student s)
	{
		String str ="insert into studentinfo values(?,?,?,?)";
	    return jdbc.execute(str,new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, s.getRoll());
				ps.setString(2, s.getName());
				ps.setString(3, s.getLang());
				return ps.execute();
			}
	    	
	    });
	}
	

}
