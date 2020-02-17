package com.by.hctm.project.entity;

import java.util.Date;

/**
 * AbstractTyxs211 entity provides the base persistence definition of the
 * Tyxs211 entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTyxs211 implements java.io.Serializable {

	// Fields

	private String heth;
	private String zhuangt;
	private Date hetrq;
	private Date jiaohrq;
	private Date shengxrq;
	private Date shixrq;
	private Date shoujsj;
	private Short nian;
	private Byte yue;
	private String xuhao;
	private String kehu;
	private String kehu2;
	private String diq;
	private String shangdc;
	private String yewy;
	private String yewymc;
	private Double qiandsl;
	private Double tihsl;
	private String huob;
	private Double huil;
	private Double jine;
	private Double shuie;
	private Double hansje;
	private Double yunf;
	private Double zongje;
	private Double zongjeDollar;
	private Double dingj;
	private String xianjzk;
	private Double peijje;
	private Double jineDp;
	private Double jineFj;
	private Double pingsjg;
	private Double xiaosfy;
	private String hetlx;
	private String shengclx;
	private String chxdl;
	private String tihfs;
	private String yunsfs;
	private Double yunstqq;
	private String jiaohtj;
	private String jiaohdz;
	private String fuktj;
	private String fukfs;
	private String yewlx;
	private String maoyfs;
	private String jiesfs;
	private String lianxr;
	private String laiy;
	private String dingdh;
	private Integer hangh;
	private String ccheth;
	private String chushth;
	private String shuom;
	private String hsheth;
	private String banb;
	private String chanpxh;
	private String chanpxhsm;
	private String dipxh;
	private String chexcc;
	private Integer dipid;
	private Date dpdcrq;
	private String bianzr;
	private String dingdgly;
	private String bumen;
	private Date pingswcrq;
	private String bohyy;
	private String shenhr;
	private String pizr;
	private String caiwzt;
	private String hetzt;
	private String hetbz;
	private String hettbz;
	private String qkbz;
	private String poNo;
	private String cankxx;
	private String bianh;
	private String dih;
	private String yeyxt;
	private Double id;
	private String dayzt;
	private String beiz;
	private String jingxs;
	private String guangly1;
	private String diq2;
	private String jiagdzht;
	private String jiagqrd;

	// Constructors

	/** default constructor */
	public AbstractTyxs211() {
	}

	/** minimal constructor */
	public AbstractTyxs211(String kehu, Double yunf, Double zongje,
			Double peijje, Double jineDp, Double jineFj, Double pingsjg,
			String caiwzt, String hetzt) {
		this.kehu = kehu;
		this.yunf = yunf;
		this.zongje = zongje;
		this.peijje = peijje;
		this.jineDp = jineDp;
		this.jineFj = jineFj;
		this.pingsjg = pingsjg;
		this.caiwzt = caiwzt;
		this.hetzt = hetzt;
	}

	/** full constructor */
	public AbstractTyxs211(String zhuangt, Date hetrq, Date jiaohrq,
			Date shengxrq, Date shixrq, Date shoujsj, Short nian, Byte yue,
			String xuhao, String kehu, String kehu2, String diq,
			String shangdc, String yewy, String yewymc, Double qiandsl,
			Double tihsl, String huob, Double huil, Double jine, Double shuie,
			Double hansje, Double yunf, Double zongje, Double zongjeDollar,
			Double dingj, String xianjzk, Double peijje, Double jineDp,
			Double jineFj, Double pingsjg, Double xiaosfy, String hetlx,
			String shengclx, String chxdl, String tihfs, String yunsfs,
			Double yunstqq, String jiaohtj, String jiaohdz, String fuktj,
			String fukfs, String yewlx, String maoyfs, String jiesfs,
			String lianxr, String laiy, String dingdh, Integer hangh,
			String ccheth, String chushth, String shuom, String hsheth,
			String banb, String chanpxh, String chanpxhsm, String dipxh,
			String chexcc, Integer dipid, Date dpdcrq, String bianzr,
			String dingdgly, String bumen, Date pingswcrq, String bohyy,
			String shenhr, String pizr, String caiwzt, String hetzt,
			String hetbz, String hettbz, String qkbz, String poNo,
			String cankxx, String bianh, String dih, String yeyxt, Double id,
			String dayzt, String beiz, String jingxs, String guangly1,
			String diq2, String jiagdzht, String jiagqrd) {
		this.zhuangt = zhuangt;
		this.hetrq = hetrq;
		this.jiaohrq = jiaohrq;
		this.shengxrq = shengxrq;
		this.shixrq = shixrq;
		this.shoujsj = shoujsj;
		this.nian = nian;
		this.yue = yue;
		this.xuhao = xuhao;
		this.kehu = kehu;
		this.kehu2 = kehu2;
		this.diq = diq;
		this.shangdc = shangdc;
		this.yewy = yewy;
		this.yewymc = yewymc;
		this.qiandsl = qiandsl;
		this.tihsl = tihsl;
		this.huob = huob;
		this.huil = huil;
		this.jine = jine;
		this.shuie = shuie;
		this.hansje = hansje;
		this.yunf = yunf;
		this.zongje = zongje;
		this.zongjeDollar = zongjeDollar;
		this.dingj = dingj;
		this.xianjzk = xianjzk;
		this.peijje = peijje;
		this.jineDp = jineDp;
		this.jineFj = jineFj;
		this.pingsjg = pingsjg;
		this.xiaosfy = xiaosfy;
		this.hetlx = hetlx;
		this.shengclx = shengclx;
		this.chxdl = chxdl;
		this.tihfs = tihfs;
		this.yunsfs = yunsfs;
		this.yunstqq = yunstqq;
		this.jiaohtj = jiaohtj;
		this.jiaohdz = jiaohdz;
		this.fuktj = fuktj;
		this.fukfs = fukfs;
		this.yewlx = yewlx;
		this.maoyfs = maoyfs;
		this.jiesfs = jiesfs;
		this.lianxr = lianxr;
		this.laiy = laiy;
		this.dingdh = dingdh;
		this.hangh = hangh;
		this.ccheth = ccheth;
		this.chushth = chushth;
		this.shuom = shuom;
		this.hsheth = hsheth;
		this.banb = banb;
		this.chanpxh = chanpxh;
		this.chanpxhsm = chanpxhsm;
		this.dipxh = dipxh;
		this.chexcc = chexcc;
		this.dipid = dipid;
		this.dpdcrq = dpdcrq;
		this.bianzr = bianzr;
		this.dingdgly = dingdgly;
		this.bumen = bumen;
		this.pingswcrq = pingswcrq;
		this.bohyy = bohyy;
		this.shenhr = shenhr;
		this.pizr = pizr;
		this.caiwzt = caiwzt;
		this.hetzt = hetzt;
		this.hetbz = hetbz;
		this.hettbz = hettbz;
		this.qkbz = qkbz;
		this.poNo = poNo;
		this.cankxx = cankxx;
		this.bianh = bianh;
		this.dih = dih;
		this.yeyxt = yeyxt;
		this.id = id;
		this.dayzt = dayzt;
		this.beiz = beiz;
		this.jingxs = jingxs;
		this.guangly1 = guangly1;
		this.diq2 = diq2;
		this.jiagdzht = jiagdzht;
		this.jiagqrd = jiagqrd;
	}

	// Property accessors

	public String getHeth() {
		return this.heth;
	}

	public void setHeth(String heth) {
		this.heth = heth;
	}

	public String getZhuangt() {
		return this.zhuangt;
	}

	public void setZhuangt(String zhuangt) {
		this.zhuangt = zhuangt;
	}

	public Date getHetrq() {
		return this.hetrq;
	}

	public void setHetrq(Date hetrq) {
		this.hetrq = hetrq;
	}

	public Date getJiaohrq() {
		return this.jiaohrq;
	}

	public void setJiaohrq(Date jiaohrq) {
		this.jiaohrq = jiaohrq;
	}

	public Date getShengxrq() {
		return this.shengxrq;
	}

	public void setShengxrq(Date shengxrq) {
		this.shengxrq = shengxrq;
	}

	public Date getShixrq() {
		return this.shixrq;
	}

	public void setShixrq(Date shixrq) {
		this.shixrq = shixrq;
	}

	public Date getShoujsj() {
		return this.shoujsj;
	}

	public void setShoujsj(Date shoujsj) {
		this.shoujsj = shoujsj;
	}

	public Short getNian() {
		return this.nian;
	}

	public void setNian(Short nian) {
		this.nian = nian;
	}

	public Byte getYue() {
		return this.yue;
	}

	public void setYue(Byte yue) {
		this.yue = yue;
	}

	public String getXuhao() {
		return this.xuhao;
	}

	public void setXuhao(String xuhao) {
		this.xuhao = xuhao;
	}

	public String getKehu() {
		return this.kehu;
	}

	public void setKehu(String kehu) {
		this.kehu = kehu;
	}

	public String getKehu2() {
		return this.kehu2;
	}

	public void setKehu2(String kehu2) {
		this.kehu2 = kehu2;
	}

	public String getDiq() {
		return this.diq;
	}

	public void setDiq(String diq) {
		this.diq = diq;
	}

	public String getShangdc() {
		return this.shangdc;
	}

	public void setShangdc(String shangdc) {
		this.shangdc = shangdc;
	}

	public String getYewy() {
		return this.yewy;
	}

	public void setYewy(String yewy) {
		this.yewy = yewy;
	}

	public String getYewymc() {
		return this.yewymc;
	}

	public void setYewymc(String yewymc) {
		this.yewymc = yewymc;
	}

	public Double getQiandsl() {
		return this.qiandsl;
	}

	public void setQiandsl(Double qiandsl) {
		this.qiandsl = qiandsl;
	}

	public Double getTihsl() {
		return this.tihsl;
	}

	public void setTihsl(Double tihsl) {
		this.tihsl = tihsl;
	}

	public String getHuob() {
		return this.huob;
	}

	public void setHuob(String huob) {
		this.huob = huob;
	}

	public Double getHuil() {
		return this.huil;
	}

	public void setHuil(Double huil) {
		this.huil = huil;
	}

	public Double getJine() {
		return this.jine;
	}

	public void setJine(Double jine) {
		this.jine = jine;
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

	public Double getZongje() {
		return this.zongje;
	}

	public void setZongje(Double zongje) {
		this.zongje = zongje;
	}

	public Double getZongjeDollar() {
		return this.zongjeDollar;
	}

	public void setZongjeDollar(Double zongjeDollar) {
		this.zongjeDollar = zongjeDollar;
	}

	public Double getDingj() {
		return this.dingj;
	}

	public void setDingj(Double dingj) {
		this.dingj = dingj;
	}

	public String getXianjzk() {
		return this.xianjzk;
	}

	public void setXianjzk(String xianjzk) {
		this.xianjzk = xianjzk;
	}

	public Double getPeijje() {
		return this.peijje;
	}

	public void setPeijje(Double peijje) {
		this.peijje = peijje;
	}

	public Double getJineDp() {
		return this.jineDp;
	}

	public void setJineDp(Double jineDp) {
		this.jineDp = jineDp;
	}

	public Double getJineFj() {
		return this.jineFj;
	}

	public void setJineFj(Double jineFj) {
		this.jineFj = jineFj;
	}

	public Double getPingsjg() {
		return this.pingsjg;
	}

	public void setPingsjg(Double pingsjg) {
		this.pingsjg = pingsjg;
	}

	public Double getXiaosfy() {
		return this.xiaosfy;
	}

	public void setXiaosfy(Double xiaosfy) {
		this.xiaosfy = xiaosfy;
	}

	public String getHetlx() {
		return this.hetlx;
	}

	public void setHetlx(String hetlx) {
		this.hetlx = hetlx;
	}

	public String getShengclx() {
		return this.shengclx;
	}

	public void setShengclx(String shengclx) {
		this.shengclx = shengclx;
	}

	public String getChxdl() {
		return this.chxdl;
	}

	public void setChxdl(String chxdl) {
		this.chxdl = chxdl;
	}

	public String getTihfs() {
		return this.tihfs;
	}

	public void setTihfs(String tihfs) {
		this.tihfs = tihfs;
	}

	public String getYunsfs() {
		return this.yunsfs;
	}

	public void setYunsfs(String yunsfs) {
		this.yunsfs = yunsfs;
	}

	public Double getYunstqq() {
		return this.yunstqq;
	}

	public void setYunstqq(Double yunstqq) {
		this.yunstqq = yunstqq;
	}

	public String getJiaohtj() {
		return this.jiaohtj;
	}

	public void setJiaohtj(String jiaohtj) {
		this.jiaohtj = jiaohtj;
	}

	public String getJiaohdz() {
		return this.jiaohdz;
	}

	public void setJiaohdz(String jiaohdz) {
		this.jiaohdz = jiaohdz;
	}

	public String getFuktj() {
		return this.fuktj;
	}

	public void setFuktj(String fuktj) {
		this.fuktj = fuktj;
	}

	public String getFukfs() {
		return this.fukfs;
	}

	public void setFukfs(String fukfs) {
		this.fukfs = fukfs;
	}

	public String getYewlx() {
		return this.yewlx;
	}

	public void setYewlx(String yewlx) {
		this.yewlx = yewlx;
	}

	public String getMaoyfs() {
		return this.maoyfs;
	}

	public void setMaoyfs(String maoyfs) {
		this.maoyfs = maoyfs;
	}

	public String getJiesfs() {
		return this.jiesfs;
	}

	public void setJiesfs(String jiesfs) {
		this.jiesfs = jiesfs;
	}

	public String getLianxr() {
		return this.lianxr;
	}

	public void setLianxr(String lianxr) {
		this.lianxr = lianxr;
	}

	public String getLaiy() {
		return this.laiy;
	}

	public void setLaiy(String laiy) {
		this.laiy = laiy;
	}

	public String getDingdh() {
		return this.dingdh;
	}

	public void setDingdh(String dingdh) {
		this.dingdh = dingdh;
	}

	public Integer getHangh() {
		return this.hangh;
	}

	public void setHangh(Integer hangh) {
		this.hangh = hangh;
	}

	public String getCcheth() {
		return this.ccheth;
	}

	public void setCcheth(String ccheth) {
		this.ccheth = ccheth;
	}

	public String getChushth() {
		return this.chushth;
	}

	public void setChushth(String chushth) {
		this.chushth = chushth;
	}

	public String getShuom() {
		return this.shuom;
	}

	public void setShuom(String shuom) {
		this.shuom = shuom;
	}

	public String getHsheth() {
		return this.hsheth;
	}

	public void setHsheth(String hsheth) {
		this.hsheth = hsheth;
	}

	public String getBanb() {
		return this.banb;
	}

	public void setBanb(String banb) {
		this.banb = banb;
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

	public String getDipxh() {
		return this.dipxh;
	}

	public void setDipxh(String dipxh) {
		this.dipxh = dipxh;
	}

	public String getChexcc() {
		return this.chexcc;
	}

	public void setChexcc(String chexcc) {
		this.chexcc = chexcc;
	}

	public Integer getDipid() {
		return this.dipid;
	}

	public void setDipid(Integer dipid) {
		this.dipid = dipid;
	}

	public Date getDpdcrq() {
		return this.dpdcrq;
	}

	public void setDpdcrq(Date dpdcrq) {
		this.dpdcrq = dpdcrq;
	}

	public String getBianzr() {
		return this.bianzr;
	}

	public void setBianzr(String bianzr) {
		this.bianzr = bianzr;
	}

	public String getDingdgly() {
		return this.dingdgly;
	}

	public void setDingdgly(String dingdgly) {
		this.dingdgly = dingdgly;
	}

	public String getBumen() {
		return this.bumen;
	}

	public void setBumen(String bumen) {
		this.bumen = bumen;
	}

	public Date getPingswcrq() {
		return this.pingswcrq;
	}

	public void setPingswcrq(Date pingswcrq) {
		this.pingswcrq = pingswcrq;
	}

	public String getBohyy() {
		return this.bohyy;
	}

	public void setBohyy(String bohyy) {
		this.bohyy = bohyy;
	}

	public String getShenhr() {
		return this.shenhr;
	}

	public void setShenhr(String shenhr) {
		this.shenhr = shenhr;
	}

	public String getPizr() {
		return this.pizr;
	}

	public void setPizr(String pizr) {
		this.pizr = pizr;
	}

	public String getCaiwzt() {
		return this.caiwzt;
	}

	public void setCaiwzt(String caiwzt) {
		this.caiwzt = caiwzt;
	}

	public String getHetzt() {
		return this.hetzt;
	}

	public void setHetzt(String hetzt) {
		this.hetzt = hetzt;
	}

	public String getHetbz() {
		return this.hetbz;
	}

	public void setHetbz(String hetbz) {
		this.hetbz = hetbz;
	}

	public String getHettbz() {
		return this.hettbz;
	}

	public void setHettbz(String hettbz) {
		this.hettbz = hettbz;
	}

	public String getQkbz() {
		return this.qkbz;
	}

	public void setQkbz(String qkbz) {
		this.qkbz = qkbz;
	}

	public String getPoNo() {
		return this.poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getCankxx() {
		return this.cankxx;
	}

	public void setCankxx(String cankxx) {
		this.cankxx = cankxx;
	}

	public String getBianh() {
		return this.bianh;
	}

	public void setBianh(String bianh) {
		this.bianh = bianh;
	}

	public String getDih() {
		return this.dih;
	}

	public void setDih(String dih) {
		this.dih = dih;
	}

	public String getYeyxt() {
		return this.yeyxt;
	}

	public void setYeyxt(String yeyxt) {
		this.yeyxt = yeyxt;
	}

	public Double getId() {
		return this.id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public String getDayzt() {
		return this.dayzt;
	}

	public void setDayzt(String dayzt) {
		this.dayzt = dayzt;
	}

	public String getBeiz() {
		return this.beiz;
	}

	public void setBeiz(String beiz) {
		this.beiz = beiz;
	}

	public String getJingxs() {
		return this.jingxs;
	}

	public void setJingxs(String jingxs) {
		this.jingxs = jingxs;
	}

	public String getGuangly1() {
		return this.guangly1;
	}

	public void setGuangly1(String guangly1) {
		this.guangly1 = guangly1;
	}

	public String getDiq2() {
		return this.diq2;
	}

	public void setDiq2(String diq2) {
		this.diq2 = diq2;
	}

	public String getJiagdzht() {
		return this.jiagdzht;
	}

	public void setJiagdzht(String jiagdzht) {
		this.jiagdzht = jiagdzht;
	}

	public String getJiagqrd() {
		return this.jiagqrd;
	}

	public void setJiagqrd(String jiagqrd) {
		this.jiagqrd = jiagqrd;
	}

}