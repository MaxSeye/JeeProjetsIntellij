package entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="centre")
public class Centre {
    @Id
    @GeneratedValue(generator = "IDCENTRE")
    @SequenceGenerator(
            name = "IDCENTRE",
            sequenceName = "centre_formation",
            allocationSize = 1
    )
    private int idCentre;

    @Column
    private int numCentre;
    @Column
    private String adresse;

    @OneToMany(mappedBy="centre")
    List <Salle> salles;

    // Constructeur
    // int idCentre, int numCentre, String adresse
    public Centre() {
        // this.idCentre = idCentre;
        // this.numCentre = numCentre;
        // this.adresse = adresse;
    }

    // Getters
    public int getIdCentre() {
        return idCentre;
    }

    public int getNumCentre() {
        return numCentre;
    }

    public String getAdresse() {
        return adresse;
    }

    // Setters
    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public void setNumCentre(int numCentre) {
        this.numCentre = numCentre;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}

