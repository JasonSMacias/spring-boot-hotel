package com.revature.boot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;

/**
 * We can add validation that follows the JSR303 specification for bean validation
 *
 */

@Entity
@Table(name = "HOTEL_ROOM")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ApiModelProperty(example = "Two Queen Suite")
	@Column
	@NotEmpty(message = "Description can't be null or empty")
	@Length(min = 1, max = 250)
	private String description;
	
	@Column
	@Min(value = 0)
	private double price;
	
	@Column
	@Min(value = 1)
	@Max(value = 4)
	private int occupancy;
	
	@Column
	private int beds;
	
	/**
	 * If we had a child object property.
	 * @Valid
	 * 	ensures that the child object is also valid
	 */
	
	public Hotel(int id, String description, double price, int occupancy, int beds) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.occupancy = occupancy;
		this.beds = beds;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", description=" + description + ", price=" + price + ", occupancy=" + occupancy
				+ ", beds=" + beds + "]";
	}

	public Hotel(String description, double price, int occupancy, int beds) {
		super();
		this.description = description;
		this.price = price;
		this.occupancy = occupancy;
		this.beds = beds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public Hotel() {
		
	}
}
