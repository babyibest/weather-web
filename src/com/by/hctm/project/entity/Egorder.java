package com.by.hctm.project.entity;

import java.util.Date;

/**
 * Tyxs211 entity. @author MyEclipse Persistence Tools
 */
public class Egorder extends AbstractTyxs211 implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Egorder() {
	}

	/** minimal constructor */
	public Egorder(String kehu, Double yunf, Double zongje, Double peijje,
			Double jineDp, Double jineFj, Double pingsjg, String caiwzt,
			String hetzt) {
		super(kehu, yunf, zongje, peijje, jineDp, jineFj, pingsjg, caiwzt,
				hetzt);
	}

	/** full constructor */
	public Egorder(String zhuangt, Date hetrq, Date jiaohrq, Date shengxrq,
			Date shixrq, Date shoujsj, Short nian, Byte yue, String xuhao,
			String kehu, String kehu2, String diq, String shangdc, String yewy,
			String yewymc, Double qiandsl, Double tihsl, String huob,
			Double huil, Double jine, Double shuie, Double hansje, Double yunf,
			Double zongje, Double zongjeDollar, Double dingj, String xianjzk,
			Double peijje, Double jineDp, Double jineFj, Double pingsjg,
			Double xiaosfy, String hetlx, String shengclx, String chxdl,
			String tihfs, String yunsfs, Double yunstqq, String jiaohtj,
			String jiaohdz, String fuktj, String fukfs, String yewlx,
			String maoyfs, String jiesfs, String lianxr, String laiy,
			String dingdh, Integer hangh, String ccheth, String chushth,
			String shuom, String hsheth, String banb, String chanpxh,
			String chanpxhsm, String dipxh, String chexcc, Integer dipid,
			Date dpdcrq, String bianzr, String dingdgly, String bumen,
			Date pingswcrq, String bohyy, String shenhr, String pizr,
			String caiwzt, String hetzt, String hetbz, String hettbz,
			String qkbz, String poNo, String cankxx, String bianh, String dih,
			String yeyxt, Double id, String dayzt, String beiz, String jingxs,
			String guangly1, String diq2, String jiagdzht, String jiagqrd) {
		super(zhuangt, hetrq, jiaohrq, shengxrq, shixrq, shoujsj, nian, yue,
				xuhao, kehu, kehu2, diq, shangdc, yewy, yewymc, qiandsl, tihsl,
				huob, huil, jine, shuie, hansje, yunf, zongje, zongjeDollar,
				dingj, xianjzk, peijje, jineDp, jineFj, pingsjg, xiaosfy,
				hetlx, shengclx, chxdl, tihfs, yunsfs, yunstqq, jiaohtj,
				jiaohdz, fuktj, fukfs, yewlx, maoyfs, jiesfs, lianxr, laiy,
				dingdh, hangh, ccheth, chushth, shuom, hsheth, banb, chanpxh,
				chanpxhsm, dipxh, chexcc, dipid, dpdcrq, bianzr, dingdgly,
				bumen, pingswcrq, bohyy, shenhr, pizr, caiwzt, hetzt, hetbz,
				hettbz, qkbz, poNo, cankxx, bianh, dih, yeyxt, id, dayzt, beiz,
				jingxs, guangly1, diq2, jiagdzht, jiagqrd);
	}

}
