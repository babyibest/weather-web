package com.by.hctm.project.entity;

/**
 * AbstractTyxs212Id entity provides the base persistence definition of the
 * Tyxs212Id entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTyxs212Id implements java.io.Serializable {

	// Fields

	private String heth;
	private Integer hangh;

	// Constructors

	/** default constructor */
	public AbstractTyxs212Id() {
	}

	/** full constructor */
	public AbstractTyxs212Id(String heth, Integer hangh) {
		this.heth = heth;
		this.hangh = hangh;
	}

	// Property accessors

	public String getHeth() {
		return this.heth;
	}

	public void setHeth(String heth) {
		this.heth = heth;
	}

	public Integer getHangh() {
		return this.hangh;
	}

	public void setHangh(Integer hangh) {
		this.hangh = hangh;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractTyxs212Id))
			return false;
		AbstractTyxs212Id castOther = (AbstractTyxs212Id) other;

		return ((this.getHeth() == castOther.getHeth()) || (this.getHeth() != null
				&& castOther.getHeth() != null && this.getHeth().equals(
				castOther.getHeth())))
				&& ((this.getHangh() == castOther.getHangh()) || (this
						.getHangh() != null && castOther.getHangh() != null && this
						.getHangh().equals(castOther.getHangh())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getHeth() == null ? 0 : this.getHeth().hashCode());
		result = 37 * result
				+ (getHangh() == null ? 0 : this.getHangh().hashCode());
		return result;
	}

}