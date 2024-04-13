package daos;

import java.util.Date;

import entities.Formation;
import entities.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
@Table(name="inscription")
public class InscriptionDaos {
    @Id
    @GeneratedValue(generator ="IDINSCRIPTION")
    @SequenceGenerator(
            name="IDINSCRIPTION",
            sequenceName="INSCRIPTION_ID_SEQ",
            allocationSize=1
    )
    private static int idInscription;
    @Column()
    private static Long frais;

    @Column()
    private int dateInscription;

    @ManyToOne
    @JoinColumn(name="idUtilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="idFormation")
    private Formation formation;

    public InscriptionDaos(){

    }


    public static Long getFrais(){
        return frais;
    }

    public static int getIdInscription() {
        return idInscription;

    }

    public int getDateInscription(){
        return dateInscription;
    }

    // Getter and setter for Utilisateur
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Getter and setter for Formation
    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription=idInscription;
    }

    public void setFrais(Long frais) {
        this.frais=frais;
    }

    public void setDateInscription(int dateInscription) {
        this.dateInscription=dateInscription;
    }
}

