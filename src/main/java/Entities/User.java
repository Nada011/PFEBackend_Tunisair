package Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="User")
public class User  {
	@Id
	@Column(name = "ID_USER")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	private String Firstname;
	private String Lastname;
	private String Email ;
	private String Password ;
	private Boolean AccountStatut ;
}
