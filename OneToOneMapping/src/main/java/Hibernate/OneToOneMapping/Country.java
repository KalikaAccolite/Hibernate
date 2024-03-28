package Hibernate.OneToOneMapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Country")
public class Country {
	@Id
	@Column(name="Country_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Country_ID;
	
	@Column(name="Country_Name")
	private String Country_Name;
	
	@Column(name="Country_Code")
	private int Counttry_Code;
	
	@OneToOne(mappedBy = "country", cascade = CascadeType.ALL)
	private PM pm;
	
	
	public int getCountry_ID() {
		return Country_ID;
	}
	public void setCountry_ID(int country_ID) {
		Country_ID = country_ID;
	}
	public String getCountry_Name() {
		return Country_Name;
	}
	public void setCountry_Name(String country_Name) {
		Country_Name = country_Name;
	}
	public int getCounttry_Code() {
		return Counttry_Code;
	}
	public void setCounttry_Code(int counttry_Code) {
		Counttry_Code = counttry_Code;
	}
	
	

	public PM getPm() {
		return pm;
	}

	public void setPm(PM pm) {
		this.pm = pm;
	}
	@Override
	public String toString() {
		return "Country [Country_ID=" + Country_ID + ", Country_Name=" + Country_Name + ", Counttry_Code="
				+ Counttry_Code + ", pm=" + pm.getPM_Nme() + "]";
	}

	
	
	
	
	
	
}
