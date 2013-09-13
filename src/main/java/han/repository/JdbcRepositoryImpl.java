package han.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class JdbcRepositoryImpl implements JdbcRepository {
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	JdbcRepositoryImpl(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@SuppressWarnings("deprecation")
	@Override
	public String getData(String sql) {
		
		String result = jdbcTemplate.queryForObject(sql, String.class);
		
		System.out.println("query result is :"+result);
		
		return result;
		
	}

	@Override
	public void updateData(String sql) {
		// TODO Auto-generated method stub
		
		jdbcTemplate.update(sql);
		
	}
	
}
