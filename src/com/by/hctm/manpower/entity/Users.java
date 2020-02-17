package com.by.hctm.manpower.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Long userId;
	private String userName;
	private String userPassword;
	private String userChinesename;
	private String userSex;
	private Timestamp birthday;
	private String political;//政治面貌
	private String politicalCn;//政治面貌(中文)
	private String degree;
	private String degreeCn;
	private Long depId;
	private String depName;
	private String station;
	private String rank;
	private String upManager;
	private String upManagerName;//领导中文名
	private Timestamp inDate;
	private Timestamp outDate;
	private String outReason;
	private String idCard;
	private String property;
	private String propertyCn;
	private String status;
	private String statusCn;
	private String sysStatus;
	private String writer;
	private String writerCn;
	private Timestamp writeDate;
	private String selflevCode;
	private String isUsable ;
	private String remark;
	private Set<Certificates> certificates = new HashSet<Certificates>();

	// 临时变量
    private String j_username ;
    private String j_password ;
    //临时变量 查询总监在建项目的次数
    private String num;
    
	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String userName, String userPassword, String userChinesename) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userChinesename = userChinesename;
	}

	/** full constructor */
	public Users(String userName, String userPassword, String userChinesename,
			String userSex, Timestamp birthday, String political,
			String degree, Long depId, String station, String rank,
			String upManager, Timestamp inDate, Timestamp outDate,
			String outReason, String idCard, String property, String status,
			String writer, Timestamp writeDate, String remark, Set<Certificates> certificates,
			String propertyCn, String statusCn, String degreeCn, String depName,
			String writerCn, String upManagerName, String politicalCn,String num) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userChinesename = userChinesename;
		this.userSex = userSex;
		this.birthday = birthday;
		this.political = political;
		this.degree = degree;
		this.depId = depId;
		this.station = station;
		this.rank = rank;
		this.upManager = upManager;
		this.inDate = inDate;
		this.outDate = outDate;
		this.outReason = outReason;
		this.idCard = idCard;
		this.property = property;
		this.status = status;
		this.writer = writer;
		this.writeDate = writeDate;
		this.remark = remark;
		this.certificates = certificates;
		this.propertyCn = propertyCn;
		this.statusCn = statusCn;
		this.degreeCn = degreeCn;
		this.depName = depName;
		this.writerCn = writerCn;
		this.upManagerName = upManagerName;
		this.politicalCn = politicalCn;
		this.num = num;
	}

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserChinesename() {
		return this.userChinesename;
	}

	public void setUserChinesename(String userChinesename) {
		this.userChinesename = userChinesename;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPolitical() {
		return this.political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Long getDepId() {
		return this.depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getRank() {
		return this.rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getUpManager() {
		return this.upManager;
	}

	public void setUpManager(String upManager) {
		this.upManager = upManager;
	}

	public Timestamp getInDate() {
		return this.inDate;
	}

	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}

	public Timestamp getOutDate() {
		return this.outDate;
	}

	public void setOutDate(Timestamp outDate) {
		this.outDate = outDate;
	}

	public String getOutReason() {
		return this.outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSysStatus() {
		return sysStatus;
	}

	public void setSysStatus(String sysStatus) {
		this.sysStatus = sysStatus;
	}

	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Set<Certificates> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<Certificates> certificates) {
		this.certificates = certificates;
	}

	public String getSelflevCode() {
		return selflevCode;
	}

	public void setSelflevCode(String selflevCode) {
		this.selflevCode = selflevCode;
	}

	public String getIsUsable() {
		return isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}

	public String getJ_username() {
		return j_username;
	}

	public void setJ_username(String j_username) {
		this.j_username = j_username;
	}

	public String getJ_password() {
		return j_password;
	}

	public void setJ_password(String j_password) {
		this.j_password = j_password;
	}

	public String getPropertyCn() {
		return propertyCn;
	}

	public void setPropertyCn(String propertyCn) {
		this.propertyCn = propertyCn;
	}

	public String getStatusCn() {
		return statusCn;
	}

	public void setStatusCn(String statusCn) {
		this.statusCn = statusCn;
	}

	public String getDegreeCn() {
		return degreeCn;
	}

	public void setDegreeCn(String degreeCn) {
		this.degreeCn = degreeCn;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getWriterCn() {
		return writerCn;
	}

	public void setWriterCn(String writerCn) {
		this.writerCn = writerCn;
	}

	public String getUpManagerName() {
		return upManagerName;
	}

	public void setUpManagerName(String upManagerName) {
		this.upManagerName = upManagerName;
	}

	public String getPoliticalCn() {
		return politicalCn;
	}

	public void setPoliticalCn(String politicalCn) {
		this.politicalCn = politicalCn;
	}

}