package com.by.hctm.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import oracle.sql.CLOB;
import PluSoft.Utils.JSON;

public class DBUtil {	
	//mysql
//	public static String driver = "com.mysql.jdbc.Driver";
//	public static String url = "jdbc:mysql://localhost/plusproject?useUnicode=true&characterEncoding=GBK";
//	public static String user = "root";
//	public static String pwd = "";
	
	//oracle
	public static String driver = "oracle.jdbc.driver.OracleDriver";
	public static String url = "jdbc:oracle:thin:@192.168.2.100:1521:jbzx";
	public static String user = "plus";
	public static String pwd = "sa";
//	
	//sqlserver
//	public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	public static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=plusoft;";
//	public static String user = "sa";
//	public static String pwd = "sa"; 
	
	//项目操作
	public ArrayList SelectProjects() throws Exception{
		Connection conn = getConn();
		Statement stmt = conn.createStatement();
		
		String sql = "select * from plus_project";
		ResultSet rst = stmt.executeQuery(sql);
		ArrayList list = ResultSetToList(rst);
		
		rst.close();
		stmt.close();
		conn.close();
		
		return list;
	}
	
	// 
	public HashMap SelectProject(String projectUID) throws Exception{
		Connection conn = getConn();		
		Statement stmt = conn.createStatement();
		
		String sql = "select * from plus_project where UID_ ='" + projectUID + "'";
		ResultSet rst = stmt.executeQuery(sql);		
		ArrayList list = ResultSetToList(rst);
		
		rst.close();
		stmt.close();
		conn.close();
		
		return list.size() == 0 ? null : (HashMap)list.get(0); 		
	}	
	public void DeleteProject(String projectUID) throws Exception
    {
		Connection conn = getConn();		
		Statement stmt = conn.createStatement();
		
		String sql = "delete from plus_project where UID_ ='" + projectUID + "'";
        stmt.executeUpdate(sql);
                
		stmt.close();
		conn.close();
    }
    public void InsertProject(Map project) throws Exception
    {
    	Connection conn = getConn();
    	
    	String sql = "insert into plus_project(UID_, NAME_, STARTDATE_, FINISHDATE_, LASTSAVED_, CALENDARUID_, CALENDARS_)" +
        			"values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		project.put("Calendars", JSON.Encode(project.get("Calendars")));
		
		stmt.setString(1, project.get("UID").toString());
		stmt.setString(2, project.get("Name") == null ? "" : project.get("Name").toString());		
		stmt.setTimestamp(3, new java.sql.Timestamp(((Date)project.get("StartDate")).getTime()));
		stmt.setTimestamp(4, new java.sql.Timestamp(((Date)project.get("FinishDate")).getTime()));
		stmt.setString(5, "");
		stmt.setString(6, project.get("CalendarUID") == null ? null : project.get("CalendarUID").toString());
		stmt.setString(7, project.get("Calendars") == null ? null : project.get("Calendars").toString());		
		
		stmt.executeUpdate();
        
        stmt.close();
		conn.close();	
    }	
    
	//任务操作
	public ArrayList SelectTasks(String projectUID) throws Exception{
		Connection conn = getConn();
		Statement stmt = conn.createStatement();
		
		String sql = "select * from plus_task where PROJECTUID_ ='" + projectUID + "' order by ID_";
		ResultSet rst = stmt.executeQuery(sql);		
		ArrayList list = ResultSetToList(rst);
		
		rst.close();
		stmt.close();
		conn.close();	
		
		return list;
	}
	public void DeleteTasks(String projectUID) throws Exception
    {
		Connection conn = getConn();		
		Statement stmt = conn.createStatement();
		
        String sql = "delete from plus_task where PROJECTUID_ ='" + projectUID + "'";
        stmt.executeUpdate(sql);
                
		stmt.close();
		conn.close();
    }
	public void DeleteTasks(ArrayList tasks, String projectUID) throws Exception
    {
		if(tasks.size() == 0) return;
    	Connection conn = getConn();
    	
    	String sql = "delete from plus_task where PROJECTUID_ = '"+projectUID+"' and (";    			
		for(int i=0,l=tasks.size(); i<l; i++){
			HashMap task = (HashMap)tasks.get(i);
			if(i != 0) sql += " or ";
			sql += "UID_ = '"+ task.get("UID").toString()+"'";			
		}
		sql += ")";
		
		Statement stmt = conn.createStatement();		
        stmt.executeUpdate(sql);		
        
        stmt.close();
		conn.close();	
    }
	public void DeleteTask(String taskUID, String projectUID) throws Exception
    {		
		Connection conn = getConn();		
		Statement stmt = conn.createStatement();
		
        String sql = "delete from plus_task where PROJECTUID_ = '"+projectUID+"' and UID_ = '" + taskUID+"'";
        stmt.executeUpdate(sql);
                
		stmt.close();
		conn.close();
    }	
    public void InsertTasks(ArrayList tasks, String projectUID) throws Exception
    {
    	if(tasks == null || tasks.size() == 0) return;
    	Connection conn = getConn();	
    	
    	String sql = "insert into plus_task(UID_, ID_, NAME_, START_, FINISH_, DURATION_, WORK_, PERCENTCOMPLETE_, WEIGHT_, CONSTRAINTTYPE_, CONSTRAINTDATE_, MILESTONE_, SUMMARY_, CRITICAL_, PRIORITY_, NOTES_, DEPARTMENT_, PRINCIPAL_, PREDECESSORLINK_, FIXEDDATE_, PARENTTASKUID_, PROJECTUID_, ACTUALSTART_, ACTUALFINISH_, ACTUALDURATION_, ASSIGNMENTS_, WBS_, CRITICAL2_)" +
        				"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		conn.setAutoCommit(false);
		for(int i=0,l=tasks.size(); i<l; i++){
			HashMap task = (HashMap)tasks.get(i);
			task.put("ProjectUID", projectUID);
			task.put("PredecessorLink", JSON.Encode(task.get("PredecessorLink")));
			task.put("Assignments", JSON.Encode(task.get("Assignments")));
			
			//SQL参数设置
			stmt.setString(1, task.get("UID").toString());
			stmt.setString(2, task.get("ID").toString());
			stmt.setString(3, task.get("Name") != null ? task.get("Name").toString() : "");
			stmt.setTimestamp(4, task.get("Start") != null ? new java.sql.Timestamp(((Date)task.get("Start")).getTime()) : null);
			stmt.setTimestamp(5, task.get("Finish") != null ? new java.sql.Timestamp(((Date)task.get("Finish")).getTime()) : null);
			stmt.setInt(6, toInt(task.get("Duration")));
			stmt.setInt(7, toInt(task.get("Work"))); 
			stmt.setInt(8, toInt(task.get("PercentComplete")));
			stmt.setInt(9, toInt(task.get("Weight")));
			stmt.setInt(10, toInt(task.get("ConstraintType")));	
			stmt.setTimestamp(11, task.get("ConstraintDate") != null ? new java.sql.Timestamp(((Date)task.get("ConstraintDate")).getTime()) : null);			
			stmt.setInt(12, toInt(task.get("Milestone")));
			stmt.setInt(13, toInt(task.get("Summary")));
			stmt.setInt(14, toInt(task.get("Critical")));
			stmt.setInt(15, toInt(task.get("Priority")));
			stmt.setString(16, task.get("Notes") == null ? "" : task.get("Notes").toString());
			stmt.setString(17, task.get("Department") == null ? null : task.get("Department").toString());
			stmt.setString(18, task.get("Principal") == null ? null : task.get("Principal").toString());
			stmt.setString(19, task.get("PredecessorLink") == null ? null : task.get("PredecessorLink").toString());			
			stmt.setInt(20, toInt(task.get("FixedDate")));
			stmt.setString(21, task.get("ParentTaskUID") == null ? null : task.get("ParentTaskUID").toString());
			stmt.setString(22, task.get("ProjectUID") == null ? null : task.get("ProjectUID").toString());
			stmt.setTimestamp(23, task.get("ActualStart") != null ? new java.sql.Timestamp(((Date)task.get("ActualStart")).getTime()) : null);
			stmt.setTimestamp(24, task.get("ActualFinish") != null ? new java.sql.Timestamp(((Date)task.get("ActualFinish")).getTime()) : null);			
			stmt.setInt(25, toInt(task.get("ActualDuration")));
			stmt.setString(26, task.get("Assignments") == null ? null : task.get("Assignments").toString());
			stmt.setString(27, task.get("WBS") == null ? "" : task.get("WBS").toString());			
			stmt.setInt(28, toInt(task.get("Critical2")));
			
			stmt.addBatch();			
		}
		stmt.executeBatch();
		conn.commit();
        
        stmt.close();
		conn.close();
    }
	//资源操作
    public ArrayList SelectResources(String projectUID) throws Exception
    {
    	Connection conn = getConn();		
		Statement stmt = conn.createStatement();
    	
        String sql = "select * from plus_resource where PROJECTUID_ ='" + projectUID + "'";
        ResultSet rst = stmt.executeQuery(sql);		
		ArrayList list = ResultSetToList(rst);
		
        return list;
    }
    public void InsertResources(String projectUID, ArrayList resources) throws Exception
    {
    	if(resources == null || resources.size() == 0) return;
    	Connection conn = getConn();	
    	
    	String sql = "insert into plus_resource(UID_, NAME_, TYPE_, MAXUNITS_, WORK_, PROJECTUID_)" +
        			"values(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		conn.setAutoCommit(false);
		for(int i=0,l=resources.size(); i<l; i++){
			HashMap re = (HashMap)resources.get(i);
			re.put("ProjectUID", projectUID);			
			
			stmt.setString(1, re.get("UID").toString());
			stmt.setString(2, re.get("Name").toString());
			stmt.setInt(3, (Integer)re.get("Type"));
			stmt.setInt(4, (Integer)re.get("MaxUnits"));
			stmt.setInt(5, toInt(re.get("Work")));
			stmt.setString(6, re.get("ProjectUID").toString());			
			
			stmt.addBatch();			
		}
		stmt.executeBatch();
		conn.commit();
        
        stmt.close();
		conn.close();	
    }
    public void DeleteResources(String projectUID) throws Exception
    {              
    	
        Connection conn = getConn();
		Statement stmt = conn.createStatement();
		
		String sql = "delete from plus_resource where PROJECTUID_ ='" + projectUID + "'";
        stmt.executeUpdate(sql);
        
		stmt.close();
		conn.close();
    }    
	////////////////////////////////////////	
    private String toString(Object obj){
    	return "";
    }
    public static int toInt(Object o){
    	if(o == null) return 0;
    	double d = Double.parseDouble(o.toString());
    	int i = 0;
		i -= d;
		return -i;			
    }    
	private Connection getConn() throws Exception{		
		Class.forName(driver).newInstance();
		Connection conn = null;
		if(user == null || user.equals("")){
			conn = java.sql.DriverManager.getConnection(url);
		}else{
			conn = java.sql.DriverManager.getConnection(url, user, pwd);
		}
			
		return conn;
	}
    private static ArrayList ResultSetToList(ResultSet   rs) throws Exception{    	
    	ResultSetMetaData md = rs.getMetaData();
    	int columnCount = md.getColumnCount();
    	ArrayList list = new ArrayList();
    	Map rowData;
    	while(rs.next()){
	    	rowData = new HashMap(columnCount);
	    	for(int i = 1; i <= columnCount; i++)   {	 	    		
	    		Object v = rs.getObject(i);	    		
	    		
	    		if(v != null && (v.getClass() == Date.class || v.getClass() == java.sql.Date.class)){
	    			Timestamp ts= rs.getTimestamp(i);
	    			v = new java.util.Date(ts.getTime());
	    		}else if(v != null && v.getClass() == CLOB.class){
	    			v = clob2String((CLOB)v);
	    		}
	    		rowData.put(md.getColumnName(i),   v);
	    	}
	    	list.add(rowData);	    	
    	}
    	return list;
	} 	
    private static String clob2String(CLOB clob) throws Exception {
        return (clob != null ? clob.getSubString(1, (int) clob.length()) : null);
    }  		
}
