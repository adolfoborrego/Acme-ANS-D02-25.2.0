
package acme.entities.aircraft;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import acme.entities.airline.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Aircraft extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(max = 50)
	private String				model;

	@Mandatory
	@ValidString(max = 50)
	@Column(unique = true)
	private String				registrationNumber;

	@Mandatory
	private int					capacity;

	@Mandatory
	@Min(2000)
	@Max(50000)
	private int					cargoWeight;

	@Mandatory
	@ValidString(pattern = "^(ACTIVE|MAINTENANCE)$")
	private String				status;

	@Optional
	@ValidString(max = 255)
	private String				details;

	@Mandatory
	@ManyToOne
	private Airline				airline;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
