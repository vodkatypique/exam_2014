import java.util.*;

public class Loueur {
    private Collection<Vehicule> vlibres;
    private Map<String, Client> clients;
    private  PriorityQueue<Vehicule> vLibreEfficace;

    public Loueur(){
        this.clients = new HashMap<String, Client>();
        this.vlibres = new HashSet<Vehicule>();
        this.vLibreEfficace = new PriorityQueue<Vehicule>(new VehiculeComparator());
    }

    @Override
    public String toString() {
        String retour = "vLibre : ";
        for (Vehicule v : vlibres) {
            retour += v.toString()+"\n";
        }
        retour += "Client : ";
        for (Client c : clients.values()) {
            retour += c.toString()+", loué : ";
            for (Vehicule v : c.getEnLocation()) {
                retour += "   -"+v.toString()+"\n";
            }
        }
    return retour;
    }

    public void ajouterVehicule(Vehicule v){
        if (!vlibres.contains(v)){
            vlibres.add(v);
            vLibreEfficace.add(v);
        } else {
            throw new IllegalArgumentException("vehicule deja add");
        }
    }

    public Client ajouterClient(String nom, String prenom){
        this.clients.putIfAbsent(
                nom+prenom,
                this.clients.put(nom+prenom, new Client(nom, prenom)));
        return this.clients.get(prenom+nom);
    }

    public void louer(Vehicule v, String nom, String prenom){ //O(1)
        if (vlibres.contains(v) && clients.containsKey(nom+prenom)){
            clients.get(nom+prenom).ajouterLocation(v);
            vlibres.remove(v);
        }else {
            throw new IllegalArgumentException("vehicule pas libre ou client inconnu");
        }
    }

    public void louer(String nom, String prenom){ //O(log(n))
        Vehicule v = vLibreEfficace.poll();
        if (v!=null && clients.containsKey(nom+prenom)){
            clients.get(nom+prenom).ajouterLocation(v);
            vlibres.remove(v);
        }else {
            throw new IllegalArgumentException("vehicule pas libre ou client inconnu");
        }
    }

    public void rendre(Vehicule v){ //O(log(n))
        if (v.getProprio() != null){
            v.getProprio().supprimerLocation(v);
            v.setProprio(null);
            vlibres.add(v);
            vLibreEfficace.offer(v);
        }else {
            throw new IllegalArgumentException("vehicule sans proprio");
        }
    }

    public Collection<Vehicule> getVlibres() {
        return vlibres;
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    public PriorityQueue<Vehicule> getvLibreEfficace() {
        return vLibreEfficace;
    }

    public Vehicule getMeilleurProfit(){
        return this.vLibreEfficace.peek(); //O(1)
    }
}

class VehiculeComparator implements Comparator<Vehicule>{

    @Override
    public int compare(Vehicule vehicule, Vehicule t1) {
        if (vehicule.calculerCout()<t1.calculerCout()){
            return 1;
        }
        else if (vehicule.calculerCout()>t1.calculerCout()){
            return -1;
        }
        return 0;
    }
}
