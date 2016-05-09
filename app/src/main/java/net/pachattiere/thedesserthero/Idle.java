package net.pachattiere.thedesserthero;

import java.math.BigInteger;

/**
 * Created by Yohann on 27/01/2015.
 */

public enum Idle {

    PETIT_CHINOIS("Petit Chinois Nourrisseur", "1", "50",R.drawable.hihihimanger),
    MAMIE("Grand-mère Gâteau", "20", "500" ,R.drawable.lucienne),
    INTRA_VEINEUSE("Desserts par Intraveineuse.", "100", "1500" ,R.drawable.perfusion);

    private String nomIdle;
    private BigInteger incParSeconde;
    private BigInteger cout;
    private int idImage;

    Idle(String nomIdle, String incParSeconde, String cout, int idImage) {
        this.idImage = idImage;
        this.incParSeconde = new BigInteger(incParSeconde);
        this.cout = new BigInteger(cout);
        this.nomIdle = nomIdle;
    }

    public String getNomIdle() {
        return this.nomIdle;
    }

    public BigInteger getIncParSeconde() {
        return this.incParSeconde;
    }

    public BigInteger getCout() {
        return this.cout;
    }

    public int getIdImage() {
        return this.idImage;
    }
}
