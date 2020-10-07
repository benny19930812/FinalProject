package _00_init.util;

public class DBService_for_Oracle {
	public static final String host = "127.0.0.1";
	public static final String DB_ORACLE = "ORACLE";

	public static final String DB_TYPE = DB_ORACLE;


	private static final String DBURL_Oracle = "jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1";
	public static final String USERID_Oracle = "hr";
	public static final String PSWD_Oracle = "hr";


	private static final String DROP_Member_Oracle = "DROP TABLE MEMBER";

	private static final String DROP_Book_Oracle = "DROP TABLE BOOK";

	private static final String DROP_BookCompany_Oracle = "DROP TABLE BOOKCOMPANY";

	private static final String DROP_Orders_Oracle = "DROP TABLE  ORDERS ";

	private static final String DROP_OrderItems_Oracle = "DROP TABLE ORDERITEMS";

	private static final String CREATE_OrderItems_Oracle = "Create TABLE ORDERITEMS "
			+ "(seqno number generated as identity constraint ORDERITEMS_PK primary key, "
			+ " orderNo          int, "
			+ " bookId           int, "
			+ " Description      varchar2(72), "
			+ " amount           int, "
			+ " unitPrice        number(18,1), "
			+ " Discount         number "
			+ " ) ";

	

	private static final String CREATE_Orders_Oracle = "Create Table ORDERS "
			+ "(orderNo  INT GENERATED as IDENTITY constraint ORDERS_PK primary key, "
			+ " memberId          varchar2(20), "
			+ " totalAmount       number(11,1), "
			+ " shippingAddress   varchar2(64), "
			+ " BNO               varchar2(8), " 
			+ " invoiceTitle      varchar2(72), " 
			+ " orderDate         Date, "
			+ " ShippingDate      Date, " 
			+ " CancelTag         varchar2(1 char) "
			+ " )";


	private static final String CREATE_BookCompany_Oracle = "CREATE TABLE BOOKCOMPANY "
			+ "(id  INT GENERATED as IDENTITY constraint BOOKCOMPANY_PK primary key, "
			+ " name		    varchar2(60), "
			+ " address    		varchar2(60), " 
			+ " url  			varchar2(120) "
			+ " ) ";

	private static final String CREATE_Book_Oracle = "CREATE TABLE BOOK " 
			+ "(bookId INT GENERATED as IDENTITY constraint BOOK_PK primary key, "
			+ " title				varchar2(50), " 
			+ " author    			varchar2(28), " 
			+ " price				number(12,2),  "
			+ " discount			number(12,2),  "
			+ " coverImage   		BLOB," 
			+ " fileName			varchar2(20), "
			+ " bookNo 				varchar2(20), " 
			+ " stock 				int, " 
			+ " category			varchar2(28), "
			+ " companyId			int "
			+ " )";

	

	private static final String CREATE_Member_Oracle = " CREATE TABLE MEMBER " 
			+ "(seqNo INT GENERATED as IDENTITY constraint MEMBER_PK primary key, "
			+ " memberID			varchar2(20), " 
			+ " name    			varchar2(32), "
			+ " password			varchar2(32), " 
			+ " address 			varchar2(64), "
			+ " email 				varchar2(64), " 
			+ " tel  				varchar2(15), "
			+ " userType			varchar2(10), " 
			+ " registerTime    	Date, "
			+ " totalAmt     		number(12,2),  "
			+ " memberImage  		BLOB, "
			+ " fileName     		varchar2(20), " 
			+ " \"COMMENT\"     	    CLOB, "
			+ " unpaid_amount       number(12,2) "
			+ " )";

	public static String getDropBook() {
		String drop = DROP_Book_Oracle;
		return drop;
	}

	public static String getCreateBookCompany() {
		String create = CREATE_BookCompany_Oracle;
		return create;
	}
	
	public static String getDropBookCompany() {
		String drop = DROP_BookCompany_Oracle;
		return drop;
	}

	public static String getCreateBook() {
		String create = CREATE_Book_Oracle;
		
		return create;
	}

	public static String getDropMember() {
		String drop = DROP_Member_Oracle;
		return drop;
	}

	public static String getCreateMember() {
		String create = CREATE_Member_Oracle;
		return create;
	}
	
	
	public static String getDropOrders() {
		String drop = DROP_Orders_Oracle;
		return drop;
	}

	public static String getCreateOrders() {
		String create = CREATE_Orders_Oracle;
		return create;
	}
	
	public static String getDropOrderItems() {
		String drop = DROP_OrderItems_Oracle;
		
		return drop;
	}

	public static String getCreateOrderItems() {
		String create = CREATE_OrderItems_Oracle;
		return create;
	}
	
	public static String getDbUrl() {
		String url = DBURL_Oracle;
		return url;
	}

	public static String getUser() {
//		String user = "hr";
		return USERID_Oracle;
	}

	public static String getPassword() {
//		String pswd = "hr";
		return PSWD_Oracle;
	}

}
