package daos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="formateur")

public class FormateurDaos {
    @Id
    @GeneratedValue(generator ="IDFORMATEUR")
    @SequenceGenerator(
            name = "IDFORMATEUR",
            sequenceName="centre_formation",
            allocationSize = 1


    )
    private int idFormateur;

    @Column
    private int numFormateur;
    @Column
    private String prenomFormateur;
    @Column
    private String specialite;





    // Constructeur
    // int idFormateur, int numFormateur, String prenomFormateur, String specialite
    public FormateurDaos() {
        // this.idFormateur = idFormateur;
        // this.numFormateur = numFormateur;
        // this.prenomFormateur = prenomFormateur;
        // this.specialite = specialite;
    }

    // Getters
    public int getIdFormateur() {
        return idFormateur;
    }

    public int getNumFormateur() {
        return numFormateur;
    }

    public String getPrenomFormateur() {
        return prenomFormateur;
    }

    public String getSpecialite() {
        return specialite;
    }

    // Setters
    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }

    public void setNumFormateur(int numFormateur) {
        this.numFormateur = numFormateur;
    }

    public void setPrenomFormateur(String prenomFormateur) {
        this.prenomFormateur = prenomFormateur;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

}

