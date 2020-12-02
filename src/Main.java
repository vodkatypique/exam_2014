import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vehicule> tab = new ArrayList<Vehicule>();
        tab.add(new Voiture("XXX-ZZZ-2B", 150, 6));
        tab.add(new Voiture("YYY-xZF-56", 120, 3));
        tab.add(new Voiture("XXX-ZZZ-51", 150, 6));

        tab.add(new Fourgonnette("eez-ZZZ-2B", 150, 6.5, 190));
        tab.add(new Fourgonnette("Ygfg-xZF-56", 80, 30, 210.6));
        tab.add(new Fourgonnette("eez-dss-23", 240, 23.3, 197.7));
        tab.add(new Fourgonnette("eez-ZZZ-2B", 150, 6.5, 190));

        tab.add(new Camion("eez-ZZZ-2B", 150, 6.5, 190, 1200.5));
        tab.add(new Camion("Ygfg-xZF-56", 80, 30, 210.6, 1000.9));
        tab.add(new Camion("eez-dss-23", 240, 23.3, 197.7, 3500));
        tab.add(new Camion("eez-ZZZ-2B", 150, 6.5, 190, 1200.5));

/**
        for (Vehicule v : tab) {
            System.out.println(v);
            System.out.println(v.calculerCout() + "euros");
        }

        System.out.println(tab.get(0).equals(tab.get(1)));
        System.out.println(tab.get(0).equals(tab.get(2)));
        System.out.println(tab.get(0).equals(tab.get(3)));
        System.out.println(tab.get(3).equals(tab.get(4)));
        System.out.println(tab.get(3).equals(tab.get(6)));
        System.out.println(tab.get(7).equals(tab.get(7)));
        System.out.println(tab.get(7).equals(tab.get(10)));**/

        Loueur loueur = new Loueur();
        loueur.ajouterClient("client", "1");
        loueur.ajouterClient("client", "2");
        loueur.ajouterClient("client", "1");
        for (Vehicule v : tab) {
            if (!loueur.getVlibres().contains(v)){
                loueur.ajouterVehicule(v);
            }
        }

        for (Vehicule v : loueur.getVlibres()) {
            System.out.println(v.calculerCout() +" " + v);
        }

        loueur.getMeilleurProfit();

        loueur.louer(tab.get(0), "client", "1");
        loueur.louer(tab.get(1), "client", "2");
        loueur.louer(tab.get(2), "client", "1");
        loueur.louer(tab.get(3), "client", "2");
        for (Vehicule v : loueur.getVlibres()) {
            System.out.println(v + "\n");
        }
        for (Client c : loueur.getClients().values()) {
            for (Vehicule v : c.getEnLocation()) {
                System.out.println(c + " loue "+ v + "\n");
            }
        }

        loueur.rendre(tab.get(0));
        loueur.rendre(tab.get(1));
        for (Vehicule v : loueur.getVlibres()) {
            System.out.println(v + "\n");
        }
        for (Client c : loueur.getClients().values()) {
            for (Vehicule v : c.getEnLocation()) {
                System.out.println(c + " loue "+ v + "\n");
            }
        }

        System.out.println(loueur.getMeilleurProfit());
        loueur.louer("client", "1");
        System.out.println(loueur.getMeilleurProfit());
        loueur.louer("client", "1");
        System.out.println(loueur.getMeilleurProfit());
    }
}
