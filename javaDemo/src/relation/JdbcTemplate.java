package relation;

public class JdbcTemplate {
     //has a (关联关系:JdbcTemplate关联dataSource)
	 //也可以理解为JdbcTemplate依赖于DataSource对象
	 private DataSource dataSource;
}
