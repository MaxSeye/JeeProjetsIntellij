package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Salle")

public class Salle {
    @Id
    @GeneratedValue(generator = "IDSALLE")
    @SequenceGenerator(
            name="IDSALLE",
            sequenceName = "centre_formation",
            allocationSize = 1

    )
    private int idSalle;

    @Column
    private int numSalle;

    @Column
    private int capacite;

    @ManyToOne
    @JoinColumn(name = "idCentre")
    private Centre centre;


    // Constructeur
    // int idSalle, int numSalle, int capacite, int idCentre
    public Salle() {
        // this.idSalle = idSalle;
        // this.numSalle = numSalle;
        // this.capacite = capacite;
        // this.idCentre = idCentre;
    }

    // Getters
    public int getIdSalle() {
        return idSalle;
    }

    public int getNumSalle() {
        return numSalle;
    }

    public int getCapacite() {
        return capacite;
    }


    public Centre getCentre(){
        return centre;
    }

    // Setters
    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public void setNumSalle(int numSalle) {
        this.numSalle = numSalle;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setIdCentre(Centre centre) {
        this.centre = centre;
    }



}
