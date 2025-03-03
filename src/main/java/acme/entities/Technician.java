
package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Technician extends AbstractEntity {

	// Serialisation version -------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------------------------------------------------
	@Mandatory
	@ValidString(pattern = "^[A-Z]{2-3}\\d{6}$")
	@Column(unique = true)
	private String				license;

	@Mandatory
	@ValidString(pattern = "^\\+?\\d{6,15}$")
	private String				phoneNumber;

	@Mandatory
	@ValidString(min = 1, max = 50)
	private String				specialisation;

	@Mandatory
	private Boolean				annualHealthTestPassed;

	@Mandatory
	@ValidNumber(min = 0, max = 80, fraction = 0)
	private Integer				yearsExperience;

	@Optional
	@ValidString(min = 0, max = 255)
	private String				certifications;

}
