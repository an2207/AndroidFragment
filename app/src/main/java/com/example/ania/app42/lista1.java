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
public class lista1 extends Fragment {
    String imie, rasa, wiek, typ, wyk;
    TextView make, mode, disp, type, wykast;

    public lista1()
    {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_lista1, container, false);

        Bundle bundle = this.getArguments();
        imie = bundle.getString("imie");
        rasa = bundle.getString("rasa");
        wiek = bundle.getString("wiek");
        typ = bundle.getString("typ");
        wyk = bundle.getString("wykastrowany");

        make = (TextView) v.findViewById(R.id.textView12);
        mode = (TextView) v.findViewById(R.id.textView13);
        disp = (TextView) v.findViewById(R.id.textView14);
        type = (TextView) v.findViewById(R.id.textView15);
        wykast = (TextView) v.findViewById(R.id.textView16);

        make.setText(imie);
        mode.setText(rasa);
        disp.setText(wiek);
        type.setText(typ);
        wykast.setText(wyk);



        return v;
    }

}
