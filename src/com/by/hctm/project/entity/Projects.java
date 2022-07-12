package com.by.hctm.project.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



/**
 * Projects entity. @author MyEclipse Persistence Tools
 */

public class Projects implements java.io.Serializable {

	// Fields

	private Long projectId;
	private String projectCode;//��Ŀ���
	private String projectName;//��Ŀ���
	private String upProject;//�ܹ������
	private Long depId;//部门
	private String depName;//部门名称(数据库不存在)
	private String ownerName;//���赥λ
	private String ownerSimpname;//���赥λ���
	private String ownerTel;//���赥λ�绰
	private String ownerAddress;//���赥λ��ַ
	private String ownerLegalname;//���赥λ������
	private String ownerLinkname;//���赥λ��ϵ����
	private String ownerLinktel;//���赥λ��ϵ�˵绰
	private Long subjId;//专业
	private String subjName;//专业名称(数据库不存在)
	private String projectIntroduce;//��Ŀ���
	private Date setupDate;//��������
	private Date startDate;//��������
	private String masterName;//��Ŀ��������
	private String masterTel;//��Ŀ�����˹̶��绰
	private String masterMobil;//��Ŀ�������ֻ�
	private String projectProvince;//��Ŀ����ʡ��
	private String projectArea;//��Ŀ���ڵ���
	private String ifKey;//�Ƿ��ص���Ŀ
	private String ifFine;//�Ƿ�����Ŀ
	private String ifWin;//是否中标
	private String ifContract;//是否有合同
	private String builder;//ʩ����λ���
	private String designer;//��Ƶ�λ���
	private String voltage;//��ѹ�ȼ�
	private String status;//合同当前状态
	private String statusCn;//合同当前状态中文名(数据库不存在)
	private String remark;//��ע
	private String writer;//������
	private String writerCn;//����������
	private Date writeDate;//��������
	private String operator;//�޸���
	private Date operatorDate;//�޸�����
	private String isUsable;//删除字段
	private String projectAddress;//项目所在地址
	private Set constructProjectses = new HashSet();
	private Set bids = new HashSet(); 
    private Set contracts = new HashSet();
    private Set tasks = new HashSet();
    private Set dirs = new HashSet();
	// Constructors



	/** default constructor */
	public Projects() {
	}

	/** minimal constructor */
	public Projects(String projectName) {
		this.projectName = projectName;
	}

	/** full constructor */
	public Projects(String projectCode, String projectName, String upProject,
			Long depId, String ownerName, String ownerSimpname,
			String ownerTel, String ownerAddress, String ownerLegalname,
			String ownerLinkname, String ownerLinktel, Long subjId,
			String projectIntroduce, Date setupDate, Date startDate,
			String masterName, String masterTel, String masterMobil,
			String projectProvince, String projectArea, String ifKey,
			String ifFine, String ifWin, String ifContract, String builder, 
			String designer, String voltage, String depName, String subjName,
			String status, String remark, String writer, String writerCn,
			Date writeDate, String operator, Date operatorDate, String statusCn,
			Set constructProjectses,Set bids,Set contracts, Set dirs,
			String isUsable, String projectAddress) {
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.upProject = upProject;
		this.depId = depId;
		this.depName = depName;
		this.ownerName = ownerName;
		this.ownerSimpname = ownerSimpname;
		this.ownerTel = ownerTel;
		this.ownerAddress = ownerAddress;
		this.ownerLegalname = ownerLegalname;
		this.ownerLinkname = ownerLinkname;
		this.ownerLinktel = ownerLinktel;
		this.subjId = subjId;
		this.subjName = subjName;
		this.projectIntroduce = projectIntroduce;
		this.setupDate = setupDate;
		this.startDate = startDate;
		this.masterName = masterName;
		this.masterTel = masterTel;
		this.masterMobil = masterMobil;
		this.projectProvince = projectProvince;
		this.projectArea = projectArea;
		this.ifKey = ifKey;
		this.ifFine = ifFine;
		this.ifWin = ifWin;
		this.ifContract = ifContract;
		this.builder = builder;
		this.designer = designer;
		this.voltage = voltage;
		this.status = status;
		this.remark = remark;
		this.writer = writer;
		this.writerCn = writerCn;
		this.writeDate = writeDate;
		this.operator = operator;
		this.operatorDate = operatorDate;
		this.constructProjectses = constructProjectses;
		this.bids = bids;
		this.contracts = contracts;
		this.dirs = dirs;
		this.statusCn = statusCn;
		this.isUsable = isUsable;
		this.projectAddress = projectAddress;
	}

	// Property accessors

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUpProject() {
		return this.upProject;
	}

	public void setUpProject(String upProject) {
		this.upProject = upProject;
	}

	public Long getDepId() {
		return this.depId;
	}

	public void setDepId(Long depId) {
		this.depId = depId;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerSimpname() {
		return this.ownerSimpname;
	}

	public void setOwnerSimpname(String ownerSimpname) {
		this.ownerSimpname = ownerSimpname;
	}

	public String getOwnerTel() {
		return this.ownerTel;
	}

	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}

	public String getOwnerAddress() {
		return this.ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getOwnerLegalname() {
		return this.ownerLegalname;
	}

	public void setOwnerLegalname(String ownerLegalname) {
		this.ownerLegalname = ownerLegalname;
	}

	public String getOwnerLinkname() {
		return this.ownerLinkname;
	}

	public void setOwnerLinkname(String ownerLinkname) {
		this.ownerLinkname = ownerLinkname;
	}

	public String getOwnerLinktel() {
		return this.ownerLinktel;
	}

	public void setOwnerLinktel(String ownerLinktel) {
		this.ownerLinktel = ownerLinktel;
	}

	public Long getSubjId() {
		return this.subjId;
	}

	public void setSubjId(Long subjId) {
		this.subjId = subjId;
	}

	public String getProjectIntroduce() {
		return this.projectIntroduce;
	}

	public void setProjectIntroduce(String projectIntroduce) {
		this.projectIntroduce = projectIntroduce;
	}

	public Date getSetupDate() {
		return this.setupDate;
	}

	public void setSetupDate(Date setupDate) {
		this.setupDate = setupDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getMasterName() {
		return this.masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getMasterTel() {
		return this.masterTel;
	}

	public void setMasterTel(String masterTel) {
		this.masterTel = masterTel;
	}

	public String getMasterMobil() {
		return this.masterMobil;
	}

	public void setMasterMobil(String masterMobil) {
		this.masterMobil = masterMobil;
	}

	public String getProjectProvince() {
		return this.projectProvince;
	}

	public void setProjectProvince(String projectProvince) {
		this.projectProvince = projectProvince;
	}

	public String getProjectArea() {
		return this.projectArea;
	}

	public void setProjectArea(String projectArea) {
		this.projectArea = projectArea;
	}

	public String getIfKey() {
		return this.ifKey;
	}

	public void setIfKey(String ifKey) {
		this.ifKey = ifKey;
	}

	public String getIfFine() {
		return this.ifFine;
	}

	public void setIfFine(String ifFine) {
		this.ifFine = ifFine;
	}

	public String getBuilder() {
		return this.builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public String getDesigner() {
		return this.designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getVoltage() {
		return this.voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWriter() {
		return this.writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Set getContracts() {
		return contracts;
	}

	public void setContracts(Set contracts) {
		this.contracts = contracts;
	}

	public String getWriterCn() {
		return this.writerCn;
	}

	public void setWriterCn(String writerCn) {
		this.writerCn = writerCn;
	}

	public Date getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOperatorDate() {
		return this.operatorDate;
	}

	public void setOperatorDate(Date operatorDate) {
		this.operatorDate = operatorDate;
	}
	public Set getBids() {
		return bids;
	}

	public void setBids(Set bids) {
		this.bids = bids;
	}

	public Set getConstructProjectses() {
		return constructProjectses;
	}

	public void setConstructProjectses(Set constructProjectses) {
		this.constructProjectses = constructProjectses;
	}

	public Set getTasks() {
		return tasks;
	}

	public void setTasks(Set tasks) {
		this.tasks = tasks;
	}

	public Set getDirs() {
		return dirs;
	}

	public void setDirs(Set dirs) {
		this.dirs = dirs;
	}

	public String getIfWin() {
		return ifWin;
	}

	public void setIfWin(String ifWin) {
		this.ifWin = ifWin;
	}

	public String getIfContract() {
		return ifContract;
	}

	public void setIfContract(String ifContract) {
		this.ifContract = ifContract;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getSubjName() {
		return subjName;
	}

	public void setSubjName(String subjName) {
		this.subjName = subjName;
	}

	public String getStatusCn() {
		return statusCn;
	}

	public void setStatusCn(String statusCn) {
		this.statusCn = statusCn;
	}

	public String getIsUsable() {
		return isUsable;
	}

	public void setIsUsable(String isUsable) {
		this.isUsable = isUsable;
	}

	public String getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}
    
   



}