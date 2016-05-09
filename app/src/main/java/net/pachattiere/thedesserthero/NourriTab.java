package net.pachattiere.thedesserthero;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Yohann on 26/01/2015.
 */
public class NourriTab extends Fragment implements View.OnClickListener{
    public static View view;
    public static HashMap<Idle, TextView> compteurs;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        view = inflater.inflate(R.layout.ongletnourriture, container, false);
        compteurs = new HashMap<>();

        TableLayout ll = (TableLayout) view.findViewById(R.id.contenuNourriTab);

        for(Idle i : Idle.values()) {
            TableRow tr = new TableRow(getActivity());
            tr.setGravity(Gravity.CENTER_VERTICAL);

            // On crée et ajoute le bouton pour recruter
            ImageButton ib = new ImageButton(getActivity());
            ib.setImageResource(i.getIdImage());
            ib.setTag(i);
            ib.setActivated(false);

            ib.setOnClickListener(this);

            tr.addView(ib);

            // On fait un layout vertical regroupant et le titre, et son coût en calories
            LinearLayout l2 = new LinearLayout(getActivity());
            l2.setOrientation(LinearLayout.VERTICAL);

            TextView t1 = new TextView(getActivity());
            t1.setText(i.getNomIdle());
            TextView t2 = new TextView(getActivity());
            t2.setText("Effet : " + Utils.formatCalories(i.getIncParSeconde()) + " " + Utils.formatUnite(i.getIncParSeconde()) + " / sec");
            TextView t3 = new TextView(getActivity());
            t3.setText("Cout : " + Utils.formatCalories(i.getCout()) + " " + Utils.formatUnite(i.getCout()));

            l2.addView(t1);
            l2.addView(t2);
            l2.addView(t3);

            tr.addView(l2);

            // On récupère le nombre de nourrisseurs possédés

            TextView t4 = new TextView(getActivity());
            t4.setText(Integer.toString(DessertHero.getJeu().getNb(i)));
            t4.setTextSize(30);
            compteurs.put(i, t4);

            tr.addView(t4);

            ll.addView(tr);
        }

        return view;
    }

    public void onClick(View v) {
        DessertHero.getJeu().buyNourrisseur((Idle) v.getTag());
    }
}
