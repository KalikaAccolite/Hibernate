package Hibernate.OneToOneMapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PM {
	@Id
    @Column(name = "PM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PM_ID;
	
	@Column(name="PM_Name")
	private String PM_Nme;
	
	 @OneToOne
	 @JoinColumn(name = "Country_ID")
	private Country country;
	
	public int getPM_ID() {
		return PM_ID;
	}

	public void setPM_ID(int pM_ID) {
		PM_ID = pM_ID;
	}

	public String getPM_Nme() {
		return PM_Nme;
	}

	public void setPM_Nme(String pM_Nme) {
		PM_Nme = pM_Nme;
	}

	

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "PM [PM_ID=" + PM_ID + ", PM_Nme=" + PM_Nme + ", country=" + country.getCountry_Name() + "]";
	}

	
	
}
