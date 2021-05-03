package tacos.model;
import java.util.Date;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

import lombok.AccessLevel;
//end::allButValidation[]
//tag::allButValidation[]
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import tacos.model.Ingredient.Type;
import lombok.Data;
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Taco {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private Date createdAt;
  @NonNull
  private String name;
  @ManyToMany(targetEntity = Ingredient.class)
  private List<Ingredient> ingredients;
  
  @PrePersist
  void createdAt() {
	  this.createdAt = new Date();
  }

}
