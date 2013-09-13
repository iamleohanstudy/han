package han;
import han.repository.JdbcRepository;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testdata-config.xml")
@Transactional
public class handatatest extends TestCase {
	
	@Autowired
	private JdbcRepository jdbcRepository;
	
	
	
	
	@Test
	public void testData1(){
		
		
		String sqlchange ="update t_account set name ='leohan' where number = 123456789";
		
		jdbcRepository.updateData(sqlchange);
		
		String sql1 = "select name from t_account where number = 123456789";
		
		String result = jdbcRepository.getData(sql1);
		
		
		assertEquals("leohan", result);
		
	}
	
	
	

	@Test
	public void testData2(){
		
		String sql1 = "select name from t_account where number = 123456789";
		
		String result = jdbcRepository.getData(sql1);
		
		assertEquals("Keith and Keri Donald", result);
	}
	
	

}
