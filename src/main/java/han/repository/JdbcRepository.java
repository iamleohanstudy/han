package han.repository;

public interface JdbcRepository {
	public String getData(String sql);
	
	
	public void updateData(String sql);
}
