package tacos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date placedAt;
	@NotBlank(message = "Obowiazkowe")
	private String name;
	@NotBlank(message = "Obowiazkowe")
	private String street;
	@NotBlank(message = "Obowiazkowe")
	private String city;
	@NotBlank(message = "Obowiazkowe")
	private String state;
	@NotBlank(message = "Obowiazkowe")
	private String zip;
	@CreditCardNumber(message = "Zły numer karty")
	private String ccNumber;
	@Pattern(regexp = "^([1-9][0-2])([\\/])([1-9][0-9])$", message = "Format MM/RR")
	private String ccExpiration;
	@Digits(integer = 3, fraction = 0, message = "Zły kod")
	private String ccCVV;
	@ManyToMany(targetEntity = Taco.class) 
	private List<Taco> tacos;
	 @PrePersist
	  void placedAt() {
		  this.placedAt = new Date();
	  }

}
