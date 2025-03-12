
package acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z0-9]{6,8}$")
	private String				locatorCode;

	@Mandatory
	@Automapped
	@ValidMoment(past = true)
	@Temporal(TemporalType.DATE)
	private Date				purchaseMoment;

	@Mandatory
	@Automapped
	@ValidString(pattern = "^(ECONOMY|BUSINESS)$")
	private String				travelClass;

	@Mandatory
	@Automapped
	@ValidMoney(min = 0.00)
	private Money				price;

	@Optional
	@Automapped
	@ValidString(pattern = "^\\d{4}$")
	private String				lastNibble;

	@Optional
	@Automapped
	@ManyToOne
	@Valid
	private Customers			customers;

	@Optional
	@Automapped
	@ManyToOne
	@Valid
	private Flight				flight;

}
