package daos;

import java.util.List;

import entities.Inscription;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="utilisateur")
public class UtilisateurDaos {
    @Id
    @GeneratedValue(generator = "IDUTILISATEUR")
    @SequenceGenerator(
            name = "IDUTILISATEUR",
            sequenceName = "IDUTILISATEUR_SEQ",
            allocationSize = 1
    )
    private int idUtilisateur;

    @Column(unique=true)
    private String nomUtilisateur;
    @Column
    private String motDePasse;
    @Column
    private String role;

    @OneToMany(mappedBy="utilisateur")
    List<Inscription> inscriptions;
    // Constructeur
    // int idUtilisateur, String nomUtilisateur, String motDePasse
    public UtilisateurDaos() {
        // this.idUtilisateur = idUtilisateur;
        // this.nomUtilisateur = nomUtilisateur;
        // this.motDePasse = motDePasse;
    }

    // Getters
    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
    public String getRole(){
        return role;
    }

    // Setters
    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public void setRole(String role){
        this.role=role;
    }


}

