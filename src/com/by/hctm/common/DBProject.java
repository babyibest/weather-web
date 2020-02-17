package com.by.hctm.common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import PluSoft.Utils.JSON;
import PluSoft.Utils.StringUtil;

import com.by.hctm.common.utils.TreeUtil;

public class DBProject {		
    //根据项目UID, 从数据库查找项目对象
    public static ArrayList LoadProjects() throws Exception
    {
    	DBUtil db = new DBUtil();
    	return db.SelectProjects();
    }
    //根据项目UID, 从数据库查找项目对象
    public static HashMap LoadProject(String projectUID) throws Exception
    {
    	DBUtil db = new DBUtil();
        HashMap dataProject = db.SelectProject(projectUID);
        if (dataProject == null) throw new Exception("没有找到项目, UID:" + projectUID);
        
        HashMap project = new HashMap();
        project.put("UID", projectUID);
        project.put("Name", dataProject.get("NAME_"));
//        project.put("StartDate", dataProject.get("STARTDATE_"));
//        project.put("FinishDate", dataProject.get("FINISHDATE_"));
        
//        Timestamp ts= new Timestamp ();
        
        project.put("StartDate", new java.util.Date() );
        project.put("FinishDate", new java.util.Date(System.currentTimeMillis()+1000) );
        
//        project.put("LastSaved", dataProject.get("LASTSAVED_"));
//        project.put("CalendarUID", dataProject.get("CALENDARUID_"));
//        project.put("Calendars", JSON.Decode(dataProject.get("CALENDARS_").toString()));
        
        //任务
        ArrayList tasks = SelectTasks(projectUID);
        project.put("TaskCount", tasks.size());

        //列表转树形
        tasks = TreeUtil.ToTree(tasks, "children", "UID", "ParentTaskUID");        
        project.put("Tasks", tasks);                
        
        //资源
//        project.put("Resources", SelectResources(projectUID));

        //部门, 负责人
//        project.put("Departments", GetDepartments(projectUID));
//        project.put("Principals", GetPrincipals(projectUID));            
        
        return project;
    }
    //将项目对象, 保存到数据库
    public static String SaveProject(Map project) throws Exception
    {
        //return SaveAll(project);

        return SavePart(project);
    }
    ///////////////////////////////////////////////////////////////////
    public static String SaveAll(Map dataProject) throws Exception
    {    	
        //保存项目表
        String projectUID = SaveProjectOnly(dataProject);       
        
        DBUtil db = new DBUtil();
        
        //删除任务        
    	db.DeleteTasks(projectUID);
        
        //树形转列表
        ArrayList tasks = TreeUtil.ToList((ArrayList)dataProject.get("Tasks"),"-1", "children", "UID", "ParentTaskUID");
        
        //System.out.println("Tasks: " + tasks.size());
        
        //保存任务表
        db.InsertTasks(tasks, projectUID);
        
        return projectUID;
    }
    public static String SavePart(Map dataProject) throws Exception
    {        
        boolean isNewProject = dataProject.get("UID") == null;
        if (isNewProject == false)
        {
        	DBUtil db = new DBUtil();
        	Map p = db.SelectProject(dataProject.get("UID").toString());            
            isNewProject = p == null;
        }
        String projectUID = null;
        
        if(isNewProject){
        	projectUID = SaveAll(dataProject);
        }else{
        	//保存项目表数据
            projectUID = SaveProjectOnly(dataProject);
            
          //树形转列表
            ArrayList tasks = (ArrayList)dataProject.get("Tasks");
            if(dataProject.get("listTask") == null){
            	tasks = TreeUtil.ToList(tasks,"-1", "children", "UID", "ParentTaskUID");
            }
            //把被删除的任务，加入遍历的集合中
            ArrayList removedTasks = (ArrayList)dataProject.get("RemovedTasks");
            if (removedTasks != null)
            {
                tasks.addAll(removedTasks);
            }
            
            DBUtil db = new DBUtil();
            
            ArrayList InsertTasks = new ArrayList();
            ArrayList DeleteTasks = new ArrayList();
            
            //获取变动的任务, 分别保存
            for(Object task_o : tasks)
            {
            	HashMap task = (HashMap)task_o;
                task.put("ProjectUID", projectUID);
                String state = task.get("_state") == null ? "" : task.get("_state").toString();
                                
        	    if(state.equals("added")){//新增
        	    	DeleteTasks.add(task);
        	    	InsertTasks.add(task);
        	    	//db.DeleteTask(task, projectUID);
        	    	
//        	    	ArrayList newTasks = new ArrayList();
//                    newTasks.add(task);
//                    db.InsertTasks(projectUID, newTasks);
        	    }else if(state.equals("modified")){//修改
        	    	DeleteTasks.add(task);
        	    	InsertTasks.add(task);
//        	    	db.DeleteTask(task, projectUID);
//        	    	
//                    ArrayList editTasks = new ArrayList();
//                    editTasks.add(task);
//                    db.InsertTasks(projectUID, editTasks);
        	    }else if(state.equals("removed")){//删除
        	    	DeleteTasks.add(task);
        	    }
            }
            
            //批量操作
            db.DeleteTasks(DeleteTasks, projectUID);
            db.InsertTasks(InsertTasks, projectUID);
        }

        return dataProject.get("UID").toString();
    }
    public static String SaveProjectOnly(Map dataProject) throws Exception
    {
        if (dataProject.get("UID") == null)
        {            
            dataProject.put("UID", UUID.randomUUID().toString());
        }

        String projectUID = dataProject.get("UID").toString();
        
        DBUtil db = new DBUtil();
        
        //更新项目        
        db.DeleteProject(projectUID);        
        db.InsertProject(dataProject);        
        
        //更新资源
        db.DeleteResources(projectUID); 
        db.InsertResources(projectUID, (ArrayList)dataProject.get("Resources"));        
        
        return projectUID;    	
    }
    //根据项目UID, 删除项目
    public static void DeleteProject(String projectUID) throws Exception
    {
    	DBUtil db = new DBUtil();
    	
    	db.DeleteProject(projectUID);    	
            	
    	db.DeleteResources(projectUID);

    	db.DeleteTasks(projectUID);
    }
	/////////////////////////////////////////////////////////////////////
    //新建任务UID
    public static String CreateTaskUID()
    {
        return UUID.randomUUID().toString();
    }	    
    //任务增/删/查询操作
    public static ArrayList SelectTasks(String projectUID) throws Exception
    {
    	DBUtil db = new DBUtil();
        ArrayList dbtasks = db.SelectTasks(projectUID);
        
        //遍历任务, 处理属性转换
        ArrayList tasks = new ArrayList();   
        for (Object dbtask_o : dbtasks)
        {
        	HashMap dbtask = (HashMap)dbtask_o;
            HashMap task = new HashMap();
            task.put("UID", dbtask.get("UID_"));   //唯一标识符
            task.put("ID", dbtask.get("ID_"));     //序号
            task.put("Name", dbtask.get("NAME_"));
            task.put("Start", dbtask.get("START_"));
            task.put("Finish", dbtask.get("FINISH_"));
            task.put("Duration", dbtask.get("DURATION_"));
            task.put("Work", dbtask.get("WORK_"));
            task.put("PercentComplete", dbtask.get("PERCENTCOMPLETE_"));
            task.put("Weight", dbtask.get("WEIGHT_"));
            task.put("ConstraintType", dbtask.get("CONSTRAINTTYPE_"));
            task.put("ConstraintDate", dbtask.get("CONSTRAINTDATE_"));
            task.put("Milestone", dbtask.get("MILESTONE_"));
            task.put("Summary", dbtask.get("SUMMARY_"));
            task.put("Critical", dbtask.get("CRITICAL_"));
            task.put("Priority", dbtask.get("PRIORITY_"));
            task.put("Notes", dbtask.get("NOTES_"));
            task.put("Department", dbtask.get("DEPARTMENT_"));
            task.put("Principal", dbtask.get("PRINCIPAL_"));
            if (!StringUtil.isNullOrEmpty(dbtask.get("PREDECESSORLINK_")))
            {
                task.put("PredecessorLink", JSON.Decode(dbtask.get("PREDECESSORLINK_").toString()));
            }
            if (!StringUtil.isNullOrEmpty(dbtask.get("ASSIGNMENTS_")))
            {
                task.put("Assignments", JSON.Decode(dbtask.get("ASSIGNMENTS_").toString()));
            }
            task.put("FixedDate", dbtask.get("FIXEDDATE_"));
            task.put("ParentTaskUID", dbtask.get("PARENTTASKUID_"));
            task.put("ProjectUID", dbtask.get("PROJECTUID_"));
            task.put("ActualStart", dbtask.get("ACTUALSTART_"));
            task.put("ActualFinish", dbtask.get("ACTUALFINISH_"));
            task.put("ActualDuration", dbtask.get("ACTUALDURATION_"));
            task.put("WBS", dbtask.get("WBS_"));
            task.put("Critical2", dbtask.get("CRITICAL2_"));
            tasks.add(task);            
        }
        return tasks;
    }
    //资源操作
    public static ArrayList SelectResources(String projectUID) throws Exception
    {
    	DBUtil db = new DBUtil();        
        ArrayList dbres = db.SelectResources(projectUID);
        
        //遍历资源, 处理属性转换
        ArrayList res = new ArrayList();
        for (Object dbre_o : dbres)
        {
        	HashMap dbre = (HashMap)dbre_o;        
            HashMap re = new HashMap();
            re.put("UID", dbre.get("UID_"));        
            re.put("Name", dbre.get("NAME_"));
            re.put("Type", dbre.get("TYPE_"));
            re.put("MaxUnits", dbre.get("MAXUNITS_"));
            re.put("Work", dbre.get("WORK_"));
            res.add(re);
        }
        return res;
    }   
    //////////////////////////////////////////////////////////////////////
    //获取部门集合
    public static ArrayList GetDepartments(String projectuid)
    {
        //这里创建静态数据, 实际应使用项目projectuid从数据找出分配给此项目的部门列表
        ArrayList Departments = new ArrayList();

        HashMap d1 = new HashMap();
        d1.put("UID", 1);
        d1.put("Name",  "研发部");
        Departments.add(d1);

        HashMap d2 = new HashMap();
        d2.put("UID",  2);
        d2.put("Name",  "财务部");
        Departments.add(d2);

        HashMap d3 = new HashMap();
        d3.put("UID",  3);
        d3.put("Name",  "人事部");
        Departments.add(d3);

        return Departments;
    }
    //获取负责人集合
    public static ArrayList GetPrincipals(String projectuid)
    {
        //实际应用, 从数据库查询此项目的负责人集合
        ArrayList Principals = new ArrayList();        

        //这里造一些数据
        HashMap p1 = new HashMap();
        p1.put("UID", 1);
        p1.put("Name", "张三");
        p1.put("Department", "1");

        HashMap p2 = new HashMap();
        p2.put("UID", 2);
        p2.put("Name", "李四");
        p2.put("Department", "1");

        HashMap p3 = new HashMap();
        p3.put("UID", 3);
        p3.put("Name", "赵五");
        p3.put("Department", "1");

        HashMap p4 = new HashMap();
        p4.put("UID", 4);
        p4.put("Name", "Jack");
        p4.put("Department", "2");

        HashMap p5 = new HashMap();
        p5.put("UID", 5);
        p5.put("Name", "Rose");
        p5.put("Department", "2");

        HashMap p6 = new HashMap();
        p6.put("UID", 6);
        p6.put("Name", "Mark");
        p6.put("Department", "2");

        HashMap p7 = new HashMap();
        p7.put("UID", 7);
        p7.put("Name", "Niko");
        p7.put("Department", "2");

        HashMap p8 = new HashMap();
        p8.put("UID", 8);
        p8.put("Name", "李泉");
        p8.put("Department", "3");

        HashMap p9 = new HashMap();
        p9.put("UID", 9);
        p9.put("Name", "陈光");
        p9.put("Department", "3");

        HashMap p10 = new HashMap();
        p10.put("UID", 10);
        p10.put("Name", "李健");
        p10.put("Department", "3");

        HashMap p11 = new HashMap();
        p11.put("UID", 11);
        p11.put("Name", "顾姗姗");
        p11.put("Department", "3");

        Principals.add(p1);
        Principals.add(p2);
        Principals.add(p3);
        Principals.add(p4);
        Principals.add(p5);
        Principals.add(p6);
        Principals.add(p7);
        Principals.add(p8);
        Principals.add(p9);
        Principals.add(p10);
        Principals.add(p11);

        return Principals;
    }	
}
