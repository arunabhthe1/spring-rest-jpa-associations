package com.dash.demoproject.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="EMPLOYEE_ADDRESS")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long addressid;
	@Column(name="empid")
	private Long empid;
	private String lane;
	private String city;
	private String state;
	private String addresstype;
	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", empid=" + empid + ", lane=" + lane + ", city=" + city + ", state="
				+ state + ", addresstype=" + addresstype + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(addressid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressid, other.addressid);
	}	

}
