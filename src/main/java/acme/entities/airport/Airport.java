
package acme.entities.airport;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import acme.constraints.ValidUniqueIataCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airport extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(max = 50)
	private String				name;

	@Mandatory
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z]{3}$")
	@ValidUniqueIataCode
	private String				iataCode;

	@Mandatory
	@ValidString(pattern = "^(INTERNATIONAL|DOMESTIC|REGIONAL)$")
	private String				operationalScope;

	@Mandatory
	@ValidString(max = 50)
	private String				city;

	@Mandatory
	@ValidString(max = 50)
	private String				country;

	@Optional
	@ValidUrl
	private String				website;

	@Optional
	@ValidEmail
	private String				email;

	@Optional
	@ValidString
	private String				address;

	@Optional
	@ValidString(pattern = "^\\+?\\d{6,15}$")
	private String				contactPhoneNumber;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
