package daos;

import java.util.Date;
import java.util.List;

import entities.Formateur;
import entities.Inscription;
import entities.Salle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "formation")

public class FormationDaos {
    @Id
    @GeneratedValue(generator = "IDFORMATION")
    @SequenceGenerator(
            name = "IDFORMATION",
            sequenceName = "IDFORMATION_SEQ",
            allocationSize=1
    )
    private int idFormation;

    @Column
    private String titre;

    @Column
    private String description;

    @Column
    private Date dateDebut;

    @Column
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name="idFormateur")
    private Formateur formateur;

    @ManyToOne
    @JoinColumn(name = "idSalle")
    private Salle salle;

    @OneToMany(mappedBy="formation")
    List<Inscription> participants;

    // Constructeur
    // int idFormation, String titre, String description, Date dateDebut, Date dateFin, int idFormateur, int idCentre
    public FormationDaos() {
        // this.idFormation = idFormation;
        // this.titre = titre;
        // this.description = description;
        // this.dateDebut = dateDebut;
        // this.dateFin = dateFin;
        // this.idFormateur = idFormateur;
        // this.idCentre = idCentre;
    }

    // Getters
    public int getIdFormation() {
        return idFormation;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public Formateur getIdFormateur() {
        return formateur;
    }

    public Salle getSalle() {
        return salle;
    }

    // Setters
    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setIdFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }


}


