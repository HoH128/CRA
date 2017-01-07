
package cra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "projet")
@NamedQueries({
@NamedQuery(name = "get.all.projects", query = "SELECT p FROM Projet p"),
@NamedQuery(name = "get.project.bylogin", query = "SELECT p FROM Projet p where p.idP = :idP")})
public class Projet implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idP;
	
	@Column
	private String nomProjet;
	
	@Column
	private String entite;
	
	@Column
	private String responsable;
	
	@Column
	private String description;

	public Integer getIdP() {
		return idP;
	}

	public void setIdP(Integer idP) {
		this.idP = idP;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public String getEntite() {
		return entite;
	}

	public void setEntite(String entite) {
		this.entite = entite;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Projet [id=" + idP + ", nomProjet=" + nomProjet + ", entite="
				+ entite + ", responsable=" + responsable + ", description="
				+ description + "]";
	}


}
