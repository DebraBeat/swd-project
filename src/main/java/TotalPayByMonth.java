/**
 * This is an interface for total by month.
 * To be used by TotalPayByMonthJobTitle and TotalPayByMonthDivision
 */
public interface TotalPayByMonth {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/swd_company_db";
	public static final String USER = "root";
	public static final String PASS = "root";
	
	public void getTotalPayByMonth(String month);
}
