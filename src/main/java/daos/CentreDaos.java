package daos;

import java.util.List;

public class CentreDaos {

    private int idCentre;


    private int numCentre;

    private String adresse;

    List<SalleDaos> salles;
    // Constructeur
    // int idCentre, int numCentre, String adresse
    public CentreDaos() {
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

