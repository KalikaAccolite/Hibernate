package Hibernate.OneToManyMapping;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "State")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int State_ID;
    private String State_Name;
    private int NumberOfCities;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Country_ID")
    private Country country;
    
    public int getState_ID() {
		return State_ID;
	}

	public void setState_ID(int state_ID) {
		State_ID = state_ID;
	}

	public String getState_Name() {
		return State_Name;
	}

	public void setState_Name(String state_Name) {
		State_Name = state_Name;
	}

	public int getNumberOfCities() {
		return NumberOfCities;
	}

	public void setNumberOfCities(int numberOfCities) {
		NumberOfCities = numberOfCities;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "State [State_ID=" + State_ID + ", State_Name=" + State_Name + ", NumberOfCities=" + NumberOfCities
				+ ", country=" + country.getCountry_ID() + "]";
	}

	
	

   
    
}