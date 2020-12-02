import java.util.*;

public class Client {
    private String nom;
    private String prenom;
    private HashSet<Vehicule> enLocation;

    public Client (String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        enLocation = new HashSet<Vehicule>();
    }

    public void ajouterLocation(Vehicule v){
        this.enLocation.add(v);
        v.setProprio(this);
    }

    public void supprimerLocation(Vehicule v){
        this.enLocation.remove(v);
        v.setProprio(null);
    }

    @Override
    public String toString() {
        return  "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'';
    }

    public HashSet<Vehicule> getEnLocation() {
        return enLocation;
    }
}
