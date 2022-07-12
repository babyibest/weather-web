package com.by.hctm.project.entity;

import java.util.Date;

/**
 * AbstractTyxs212 entity provides the base persistence definition of the
 * Tyxs212 entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTyxs212 implements java.io.Serializable {

	// Fields

	private Tyxs212Id id;
	private String xiangm;
	private String chanpxh;
	private String chanpxhsm;
	private String biaop;
	private String diph;
	private Double shul;
	private String xiaosdw;
	private Double hansdj;
	private Double shuil;
	private Double shuie;
	private Double hansje;
	private Double yunf;
	private Date jiaohrq;
	private Double biaozj;
	private Double weigj;
	private Double hetj;
	private Double chuxtz;
	private Double beizjg1;
	private Double beizjg2;
	private String gonggh;
	private String chex;
	private String wuliao;
	private String shuom;
	private String xinghgg;
	private String cangk;
	private Double jiag;
	private Double zhek;
	private Double jine;
	private Double huil;
	private String huob;
	private String gongcbh;
	private Double sclsl;
	private String scbj;
	private String jisgf;
	private String mobbh1;
	private String bommb;
	private String hsheth;
	private String zhuangt;
	private String yicl;
	private String shiftg;
	private Integer pingsbh;
	private Date fabrq;
	private String pingsyq;
	private String pingsyj;
	private String pszjr;
	private Date jielrq;
	private String fsingscl;
	private String fsingwl;
	private String fsing;
	private Double weigfs;
	private String shuomEn;
	private String hegz;
	private Double guac;
	private Date shijjhrq;
	private Double ticsl;
	private String pinp;
	private String daxcc;
	private String caiz;
	private String banh;
	private String kaim;
	private String youg;
	private String youb;
	private String waikcc;
	private String beiz;
	private Double specid;
	private String beiz1;
	private String waixcc;
	private String you;
	private String jusxs;
	private String daxys;
	private String kehu2;
	private String qityq;
	private String fsingxhc;
	private String jiagbbm;
	private String chanpcxjjzcbh;
	private Date zuofrq;
	private String zuofbz;
	private Double cuxj;
	private Double quycxj;
	private Double qudcxj;
	private Double zhuanxcxj;
	private Double dawgj;
	private Double xiaowgj;
	private Double bujsj;
	private String zhengcbh;
	private String pipdh;
	private String shiffbc;

	// Constructors

	/** default constructor */
	public AbstractTyxs212() {
	}

	/** minimal constructor */
	public AbstractTyxs212(Tyxs212Id id, Double shul, String zhuangt) {
		this.id = id;
		this.shul = shul;
		this.zhuangt = zhuangt;
	}

	/** full constructor */
	public AbstractTyxs212(Tyxs212Id id, String xiangm, String chanpxh,
			String chanpxhsm, String biaop, String diph, Double shul,
			String xiaosdw, Double hansdj, Double shuil, Double shuie,
			Double hansje, Double yunf, Date jiaohrq, Double biaozj,
			Double weigj, Double hetj, Double chuxtz, Double beizjg1,
			Double beizjg2, String gonggh, String chex, String wuliao,
			String shuom, String xinghgg, String cangk, Double jiag,
			Double zhek, Double jine, Double huil, String huob, String gongcbh,
			Double sclsl, String scbj, String jisgf, String mobbh1,
			String bommb, String hsheth, String zhuangt, String yicl,
			String shiftg, Integer pingsbh, Date fabrq, String pingsyq,
			String pingsyj, String pszjr, Date jielrq, String fsingscl,
			String fsingwl, String fsing, Double weigfs, String shuomEn,
			String hegz, Double guac, Date shijjhrq, Double ticsl, String pinp,
			String daxcc, String caiz, String banh, String kaim, String youg,
			String youb, String waikcc, String beiz, Double specid,
			String beiz1, String waixcc, String you, String jusxs,
			String daxys, String kehu2, String qityq, String fsingxhc,
			String jiagbbm, String chanpcxjjzcbh, Date zuofrq, String zuofbz,
			Double cuxj, Double quycxj, Double qudcxj, Double zhuanxcxj,
			Double dawgj, Double xiaowgj, Double bujsj, String zhengcbh,
			String pipdh, String shiffbc) {
		this.id = id;
		this.xiangm = xiangm;
		this.chanpxh = chanpxh;
		this.chanpxhsm = chanpxhsm;
		this.biaop = biaop;
		this.diph = diph;
		this.shul = shul;
		this.xiaosdw = xiaosdw;
		this.hansdj = hansdj;
		this.shuil = shuil;
		this.shuie = shuie;
		this.hansje = hansje;
		this.yunf = yunf;
		this.jiaohrq = jiaohrq;
		this.biaozj = biaozj;
		this.weigj = weigj;
		this.hetj = hetj;
		this.chuxtz = chuxtz;
		this.beizjg1 = beizjg1;
		this.beizjg2 = beizjg2;
		this.gonggh = gonggh;
		this.chex = chex;
		this.wuliao = wuliao;
		this.shuom = shuom;
		this.xinghgg = xinghgg;
		this.cangk = cangk;
		this.jiag = jiag;
		this.zhek = zhek;
		this.jine = jine;
		this.huil = huil;
		this.huob = huob;
		this.gongcbh = gongcbh;
		this.sclsl = sclsl;
		this.scbj = scbj;
		this.jisgf = jisgf;
		this.mobbh1 = mobbh1;
		this.bommb = bommb;
		this.hsheth = hsheth;
		this.zhuangt = zhuangt;
		this.yicl = yicl;
		this.shiftg = shiftg;
		this.pingsbh = pingsbh;
		this.fabrq = fabrq;
		this.pingsyq = pingsyq;
		this.pingsyj = pingsyj;
		this.pszjr = pszjr;
		this.jielrq = jielrq;
		this.fsingscl = fsingscl;
		this.fsingwl = fsingwl;
		this.fsing = fsing;
		this.weigfs = weigfs;
		this.shuomEn = shuomEn;
		this.hegz = hegz;
		this.guac = guac;
		this.shijjhrq = shijjhrq;
		this.ticsl = ticsl;
		this.pinp = pinp;
		this.daxcc = daxcc;
		this.caiz = caiz;
		this.banh = banh;
		this.kaim = kaim;
		this.youg = youg;
		this.youb = youb;
		this.waikcc = waikcc;
		this.beiz = beiz;
		this.specid = specid;
		this.beiz1 = beiz1;
		this.waixcc = waixcc;
		this.you = you;
		this.jusxs = jusxs;
		this.daxys = daxys;
		this.kehu2 = kehu2;
		this.qityq = qityq;
		this.fsingxhc = fsingxhc;
		this.jiagbbm = jiagbbm;
		this.chanpcxjjzcbh = chanpcxjjzcbh;
		this.zuofrq = zuofrq;
		this.zuofbz = zuofbz;
		this.cuxj = cuxj;
		this.quycxj = quycxj;
		this.qudcxj = qudcxj;
		this.zhuanxcxj = zhuanxcxj;
		this.dawgj = dawgj;
		this.xiaowgj = xiaowgj;
		this.bujsj = bujsj;
		this.zhengcbh = zhengcbh;
		this.pipdh = pipdh;
		this.shiffbc = shiffbc;
	}

	// Property accessors

	public Tyxs212Id getId() {
		return this.id;
	}

	public void setId(Tyxs212Id id) {
		this.id = id;
	}

	public String getXiangm() {
		return this.xiangm;
	}

	public void setXiangm(String xiangm) {
		this.xiangm = xiangm;
	}

	public String getChanpxh() {
		return this.chanpxh;
	}

	public void setChanpxh(String chanpxh) {
		this.chanpxh = chanpxh;
	}

	public String getChanpxhsm() {
		return this.chanpxhsm;
	}

	public void setChanpxhsm(String chanpxhsm) {
		this.chanpxhsm = chanpxhsm;
	}

	public String getBiaop() {
		return this.biaop;
	}

	public void setBiaop(String biaop) {
		this.biaop = biaop;
	}

	public String getDiph() {
		return this.diph;
	}

	public void setDiph(String diph) {
		this.diph = diph;
	}

	public Double getShul() {
		return this.shul;
	}

	public void setShul(Double shul) {
		this.shul = shul;
	}

	public String getXiaosdw() {
		return this.xiaosdw;
	}

	public void setXiaosdw(String xiaosdw) {
		this.xiaosdw = xiaosdw;
	}

	public Double getHansdj() {
		return this.hansdj;
	}

	public void setHansdj(Double hansdj) {
		this.hansdj = hansdj;
	}

	public Double getShuil() {
		return this.shuil;
	}

	public void setShuil(Double shuil) {
		this.shuil = shuil;
	}

	public Double getShuie() {
		return this.shuie;
	}

	public void setShuie(Double shuie) {
		this.shuie = shuie;
	}

	public Double getHansje() {
		return this.hansje;
	}

	public void setHansje(Double hansje) {
		this.hansje = hansje;
	}

	public Double getYunf() {
		return this.yunf;
	}

	public void setYunf(Double yunf) {
		this.yunf = yunf;
	}

	public Date getJiaohrq() {
		return this.jiaohrq;
	}

	public void setJiaohrq(Date jiaohrq) {
		this.jiaohrq = jiaohrq;
	}

	public Double getBiaozj() {
		return this.biaozj;
	}

	public void setBiaozj(Double biaozj) {
		this.biaozj = biaozj;
	}

	public Double getWeigj() {
		return this.weigj;
	}

	public void setWeigj(Double weigj) {
		this.weigj = weigj;
	}

	public Double getHetj() {
		return this.hetj;
	}

	public void setHetj(Double hetj) {
		this.hetj = hetj;
	}

	public Double getChuxtz() {
		return this.chuxtz;
	}

	public void setChuxtz(Double chuxtz) {
		this.chuxtz = chuxtz;
	}

	public Double getBeizjg1() {
		return this.beizjg1;
	}

	public void setBeizjg1(Double beizjg1) {
		this.beizjg1 = beizjg1;
	}

	public Double getBeizjg2() {
		return this.beizjg2;
	}

	public void setBeizjg2(Double beizjg2) {
		this.beizjg2 = beizjg2;
	}

	public String getGonggh() {
		return this.gonggh;
	}

	public void setGonggh(String gonggh) {
		this.gonggh = gonggh;
	}

	public String getChex() {
		return this.chex;
	}

	public void setChex(String chex) {
		this.chex = chex;
	}

	public String getWuliao() {
		return this.wuliao;
	}

	public void setWuliao(String wuliao) {
		this.wuliao = wuliao;
	}

	public String getShuom() {
		return this.shuom;
	}

	public void setShuom(String shuom) {
		this.shuom = shuom;
	}

	public String getXinghgg() {
		return this.xinghgg;
	}

	public void setXinghgg(String xinghgg) {
		this.xinghgg = xinghgg;
	}

	public String getCangk() {
		return this.cangk;
	}

	public void setCangk(String cangk) {
		this.cangk = cangk;
	}

	public Double getJiag() {
		return this.jiag;
	}

	public void setJiag(Double jiag) {
		this.jiag = jiag;
	}

	public Double getZhek() {
		return this.zhek;
	}

	public void setZhek(Double zhek) {
		this.zhek = zhek;
	}

	public Double getJine() {
		return this.jine;
	}

	public void setJine(Double jine) {
		this.jine = jine;
	}

	public Double getHuil() {
		return this.huil;
	}

	public void setHuil(Double huil) {
		this.huil = huil;
	}

	public String getHuob() {
		return this.huob;
	}

	public void setHuob(String huob) {
		this.huob = huob;
	}

	public String getGongcbh() {
		return this.gongcbh;
	}

	public void setGongcbh(String gongcbh) {
		this.gongcbh = gongcbh;
	}

	public Double getSclsl() {
		return this.sclsl;
	}

	public void setSclsl(Double sclsl) {
		this.sclsl = sclsl;
	}

	public String getScbj() {
		return this.scbj;
	}

	public void setScbj(String scbj) {
		this.scbj = scbj;
	}

	public String getJisgf() {
		return this.jisgf;
	}

	public void setJisgf(String jisgf) {
		this.jisgf = jisgf;
	}

	public String getMobbh1() {
		return this.mobbh1;
	}

	public void setMobbh1(String mobbh1) {
		this.mobbh1 = mobbh1;
	}

	public String getBommb() {
		return this.bommb;
	}

	public void setBommb(String bommb) {
		this.bommb = bommb;
	}

	public String getHsheth() {
		return this.hsheth;
	}

	public void setHsheth(String hsheth) {
		this.hsheth = hsheth;
	}

	public String getZhuangt() {
		return this.zhuangt;
	}

	public void setZhuangt(String zhuangt) {
		this.zhuangt = zhuangt;
	}

	public String getYicl() {
		return this.yicl;
	}

	public void setYicl(String yicl) {
		this.yicl = yicl;
	}

	public String getShiftg() {
		return this.shiftg;
	}

	public void setShiftg(String shiftg) {
		this.shiftg = shiftg;
	}

	public Integer getPingsbh() {
		return this.pingsbh;
	}

	public void setPingsbh(Integer pingsbh) {
		this.pingsbh = pingsbh;
	}

	public Date getFabrq() {
		return this.fabrq;
	}

	public void setFabrq(Date fabrq) {
		this.fabrq = fabrq;
	}

	public String getPingsyq() {
		return this.pingsyq;
	}

	public void setPingsyq(String pingsyq) {
		this.pingsyq = pingsyq;
	}

	public String getPingsyj() {
		return this.pingsyj;
	}

	public void setPingsyj(String pingsyj) {
		this.pingsyj = pingsyj;
	}

	public String getPszjr() {
		return this.pszjr;
	}

	public void setPszjr(String pszjr) {
		this.pszjr = pszjr;
	}

	public Date getJielrq() {
		return this.jielrq;
	}

	public void setJielrq(Date jielrq) {
		this.jielrq = jielrq;
	}

	public String getFsingscl() {
		return this.fsingscl;
	}

	public void setFsingscl(String fsingscl) {
		this.fsingscl = fsingscl;
	}

	public String getFsingwl() {
		return this.fsingwl;
	}

	public void setFsingwl(String fsingwl) {
		this.fsingwl = fsingwl;
	}

	public String getFsing() {
		return this.fsing;
	}

	public void setFsing(String fsing) {
		this.fsing = fsing;
	}

	public Double getWeigfs() {
		return this.weigfs;
	}

	public void setWeigfs(Double weigfs) {
		this.weigfs = weigfs;
	}

	public String getShuomEn() {
		return this.shuomEn;
	}

	public void setShuomEn(String shuomEn) {
		this.shuomEn = shuomEn;
	}

	public String getHegz() {
		return this.hegz;
	}

	public void setHegz(String hegz) {
		this.hegz = hegz;
	}

	public Double getGuac() {
		return this.guac;
	}

	public void setGuac(Double guac) {
		this.guac = guac;
	}

	public Date getShijjhrq() {
		return this.shijjhrq;
	}

	public void setShijjhrq(Date shijjhrq) {
		this.shijjhrq = shijjhrq;
	}

	public Double getTicsl() {
		return this.ticsl;
	}

	public void setTicsl(Double ticsl) {
		this.ticsl = ticsl;
	}

	public String getPinp() {
		return this.pinp;
	}

	public void setPinp(String pinp) {
		this.pinp = pinp;
	}

	public String getDaxcc() {
		return this.daxcc;
	}

	public void setDaxcc(String daxcc) {
		this.daxcc = daxcc;
	}

	public String getCaiz() {
		return this.caiz;
	}

	public void setCaiz(String caiz) {
		this.caiz = caiz;
	}

	public String getBanh() {
		return this.banh;
	}

	public void setBanh(String banh) {
		this.banh = banh;
	}

	public String getKaim() {
		return this.kaim;
	}

	public void setKaim(String kaim) {
		this.kaim = kaim;
	}

	public String getYoug() {
		return this.youg;
	}

	public void setYoug(String youg) {
		this.youg = youg;
	}

	public String getYoub() {
		return this.youb;
	}

	public void setYoub(String youb) {
		this.youb = youb;
	}

	public String getWaikcc() {
		return this.waikcc;
	}

	public void setWaikcc(String waikcc) {
		this.waikcc = waikcc;
	}

	public String getBeiz() {
		return this.beiz;
	}

	public void setBeiz(String beiz) {
		this.beiz = beiz;
	}

	public Double getSpecid() {
		return this.specid;
	}

	public void setSpecid(Double specid) {
		this.specid = specid;
	}

	public String getBeiz1() {
		return this.beiz1;
	}

	public void setBeiz1(String beiz1) {
		this.beiz1 = beiz1;
	}

	public String getWaixcc() {
		return this.waixcc;
	}

	public void setWaixcc(String waixcc) {
		this.waixcc = waixcc;
	}

	public String getYou() {
		return this.you;
	}

	public void setYou(String you) {
		this.you = you;
	}

	public String getJusxs() {
		return this.jusxs;
	}

	public void setJusxs(String jusxs) {
		this.jusxs = jusxs;
	}

	public String getDaxys() {
		return this.daxys;
	}

	public void setDaxys(String daxys) {
		this.daxys = daxys;
	}

	public String getKehu2() {
		return this.kehu2;
	}

	public void setKehu2(String kehu2) {
		this.kehu2 = kehu2;
	}

	public String getQityq() {
		return this.qityq;
	}

	public void setQityq(String qityq) {
		this.qityq = qityq;
	}

	public String getFsingxhc() {
		return this.fsingxhc;
	}

	public void setFsingxhc(String fsingxhc) {
		this.fsingxhc = fsingxhc;
	}

	public String getJiagbbm() {
		return this.jiagbbm;
	}

	public void setJiagbbm(String jiagbbm) {
		this.jiagbbm = jiagbbm;
	}

	public String getChanpcxjjzcbh() {
		return this.chanpcxjjzcbh;
	}

	public void setChanpcxjjzcbh(String chanpcxjjzcbh) {
		this.chanpcxjjzcbh = chanpcxjjzcbh;
	}

	public Date getZuofrq() {
		return this.zuofrq;
	}

	public void setZuofrq(Date zuofrq) {
		this.zuofrq = zuofrq;
	}

	public String getZuofbz() {
		return this.zuofbz;
	}

	public void setZuofbz(String zuofbz) {
		this.zuofbz = zuofbz;
	}

	public Double getCuxj() {
		return this.cuxj;
	}

	public void setCuxj(Double cuxj) {
		this.cuxj = cuxj;
	}

	public Double getQuycxj() {
		return this.quycxj;
	}

	public void setQuycxj(Double quycxj) {
		this.quycxj = quycxj;
	}

	public Double getQudcxj() {
		return this.qudcxj;
	}

	public void setQudcxj(Double qudcxj) {
		this.qudcxj = qudcxj;
	}

	public Double getZhuanxcxj() {
		return this.zhuanxcxj;
	}

	public void setZhuanxcxj(Double zhuanxcxj) {
		this.zhuanxcxj = zhuanxcxj;
	}

	public Double getDawgj() {
		return this.dawgj;
	}

	public void setDawgj(Double dawgj) {
		this.dawgj = dawgj;
	}

	public Double getXiaowgj() {
		return this.xiaowgj;
	}

	public void setXiaowgj(Double xiaowgj) {
		this.xiaowgj = xiaowgj;
	}

	public Double getBujsj() {
		return this.bujsj;
	}

	public void setBujsj(Double bujsj) {
		this.bujsj = bujsj;
	}

	public String getZhengcbh() {
		return this.zhengcbh;
	}

	public void setZhengcbh(String zhengcbh) {
		this.zhengcbh = zhengcbh;
	}

	public String getPipdh() {
		return this.pipdh;
	}

	public void setPipdh(String pipdh) {
		this.pipdh = pipdh;
	}

	public String getShiffbc() {
		return this.shiffbc;
	}

	public void setShiffbc(String shiffbc) {
		this.shiffbc = shiffbc;
	}

}