package com.example.ania.app42;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class lista2 extends Fragment {

    String imie, rasa, wiek, typ, czarny;
    TextView make, mode, disp, type, czar;

    public lista2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_lista2, container, false);

        Bundle bundle = this.getArguments();
        imie = bundle.getString("imie");
        rasa = bundle.getString("rasa");
        wiek = bundle.getString("wiek");
        typ = bundle.getString("typ");
        czarny = bundle.getString("czarny");

        make = (TextView) v.findViewById(R.id.textView17);
        mode = (TextView) v.findViewById(R.id.textView18);
        disp = (TextView) v.findViewById(R.id.textView19);
        type = (TextView) v.findViewById(R.id.textView20);
        czar = (TextView) v.findViewById(R.id.textView21);

        make.setText(imie);
        mode.setText(rasa);
        disp.setText(wiek);
        type.setText(typ);
        czar.setText(czarny);

        return v;
    }

}
