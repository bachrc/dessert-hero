package net.pachattiere.thedesserthero;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Yohann on 26/01/2015.
 */
public class StatusTab extends Fragment implements View.OnClickListener {
    public static View view;
    TextView tv1, tv2;
    private Handler mHandler = new Handler();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.ongletcompteurs, container, false);
        ImageButton ib = (ImageButton) view.findViewById(R.id.boutonDessert);
        ib.setOnClickListener(this);
        tv1 = (TextView) view.findViewById(R.id.compteurCal);
        tv2 = (TextView) view.findViewById(R.id.uniteCal);

        DessertHero.begin();
        System.out.println("Thread débuté");

        return view;
    }



    public void onClick(View v) {
        DessertHero.getJeu().manuallyIncrementCals();
    }
}
