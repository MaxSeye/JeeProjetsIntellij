package entities;
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
    private int dateInscription;

    @ManyToOne
    @JoinColumn(name="idUtilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="idFormation")
    private Formation formation;

    public Inscription(){

    }

    public int getIdInscription(){
        return idInscription;
    }

    public Long getFrais(){
        return frais;
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

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public void setFrais(Long frais) {
        this.frais = frais;
    }
    public void setDateInscription(int dateInscription) {
        this.dateInscription = dateInscription;
    }



    // Getter and setter for Formation
    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
