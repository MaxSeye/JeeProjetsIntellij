package entities;
import java.util.Date;
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
public class Inscription {
    @Id
    @GeneratedValue(generator ="IDINSCRIPTION")
    @SequenceGenerator(
            name="IDINSCRIPTION",
            sequenceName="INSCRIPTION_ID_SEQ",
            allocationSize=1
    )
    private int idInscription;
    @Column()
    private Long frais;

    @Column()
    private Date dateInscription;

    @ManyToOne
    @JoinColumn(name="idUtilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="idFormation")
    private Formation formation;

    public Inscription(){

    }

    public int getIdinscription(){
        return idInscription;
    }

    public Long getFrais(){
        return frais;
    }

    public Date getDateInscription(){
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
}
