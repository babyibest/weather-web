package com.by.hctm.project.entity;

/**
 * AbstractTyxs213Id entity provides the base persistence definition of the
 * Tyxs213Id entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTyxs213Id implements java.io.Serializable {

	// Fields

	private String heth;
	private Short hangh;
	private Short seq;

	// Constructors

	/** default constructor */
	public AbstractTyxs213Id() {
	}

	/** full constructor */
	public AbstractTyxs213Id(String heth, Short hangh, Short seq) {
		this.heth = heth;
		this.hangh = hangh;
		this.seq = seq;
	}

	// Property accessors

	public String getHeth() {
		return this.heth;
	}

	public void setHeth(String heth) {
		this.heth = heth;
	}

	public Short getHangh() {
		return this.hangh;
	}

	public void setHangh(Short hangh) {
		this.hangh = hangh;
	}

	public Short getSeq() {
		return this.seq;
	}

	public void setSeq(Short seq) {
		this.seq = seq;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractTyxs213Id))
			return false;
		AbstractTyxs213Id castOther = (AbstractTyxs213Id) other;

		return ((this.getHeth() == castOther.getHeth()) || (this.getHeth() != null
				&& castOther.getHeth() != null && this.getHeth().equals(
				castOther.getHeth())))
				&& ((this.getHangh() == castOther.getHangh()) || (this
						.getHangh() != null && castOther.getHangh() != null && this
						.getHangh().equals(castOther.getHangh())))
				&& ((this.getSeq() == castOther.getSeq()) || (this.getSeq() != null
						&& castOther.getSeq() != null && this.getSeq().equals(
						castOther.getSeq())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getHeth() == null ? 0 : this.getHeth().hashCode());
		result = 37 * result
				+ (getHangh() == null ? 0 : this.getHangh().hashCode());
		result = 37 * result
				+ (getSeq() == null ? 0 : this.getSeq().hashCode());
		return result;
	}

}