package net.pachattiere.thedesserthero;

import android.os.AsyncTask;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yohann on 27/01/2015.
 */
public class DessertHero extends AsyncTask<Void, Void, Void> {
    private static DessertHero jeu;

    private BigInteger compteurCal;
    private HashMap<Idle,Integer> idles;
    private int waitTime = 1000;

    public DessertHero() {
        this.compteurCal = new BigInteger("0");
        this.idles = new HashMap<>();

        for(Idle i : Idle.values())
            idles.put(i, 0);

    }

    public int getNb(Idle i) {
        return this.idles.get(i);
    }

    public Void doInBackground(Void... v) {
        try {
            while(true) {
                autoIncrementCals();
                System.out.println("Mis à jour.");
                publishProgress(v);
                Thread.sleep(waitTime);
            }
        } catch(InterruptedException e) {
            Thread.interrupted();
        }

        return null;
    }

    protected void onProgressUpdate(Void... i) {
        super.onProgressUpdate(i);

        updateCals();
    }

    public static void begin() {
        jeu = new DessertHero();

        jeu.execute();
    }

    public void buyNourrisseur(Idle i) {
        if( i.getCout().compareTo(this.compteurCal) <= 0 ) {
            this.compteurCal = this.compteurCal.subtract(i.getCout());
            this.idles.put(i, this.idles.get(i) + 1);
            majIdle(i);
        }
    }

    public void majIdle(Idle i) {
        TextView tv = NourriTab.compteurs.get(i);

        tv.setText(Integer.toString(idles.get(i)));
    }

    public void autoIncrementCals() {
        for(Map.Entry<Idle, Integer> entry : this.idles.entrySet())
            if(entry.getValue() != 0)
                this.compteurCal = this.compteurCal.add(entry.getKey().getIncParSeconde().multiply(new BigInteger(Integer.toString(this.getNb(entry.getKey())))));
    }

    public void manuallyIncrementCals() {
        this.compteurCal = this.compteurCal.add(new BigInteger("1"));
        updateCals();
    }

    public void updateCals() {
        ((TextView) StatusTab.view.findViewById(R.id.compteurCal)).setText(Utils.formatCalories(this.compteurCal));
        ((TextView) StatusTab.view.findViewById(R.id.uniteCal)).setText(Utils.formatUnite(this.compteurCal));
    }

    public static DessertHero getJeu() {
        if(jeu == null)
            jeu = new DessertHero();

        return jeu;
    }

    public BigInteger getCompteurCal() {
        return this.compteurCal;
    }


}
