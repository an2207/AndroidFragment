package com.example.ania.app42;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class zakladka1 extends Fragment {
    File root;
    File file;
    TextView suma, kot, pies;
    int liczbaPsy = 0;



    ArrayList<String> lista1;

    public zakladka1()
    {

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_zakladka1, container, false);

        pies = (TextView) v.findViewById(R.id.textView23);
        kot = (TextView) v.findViewById(R.id.textView24);
        suma = (TextView) v.findViewById(R.id.textView25);
        readNumber();
        for (String elem : lista1)
        {
            if (elem.contains("pies"))
                liczbaPsy++;

        }
        pies.setText(Integer.toString(liczbaPsy));
        int wSumie = lista1.size();
        suma.setText(Integer.toString(wSumie));
        kot.setText(Integer.toString(lista1.size() - liczbaPsy));


        return v;
    }

    public void readNumber()
    {


        root = Environment.getExternalStorageDirectory();
        File dir = new File (root.getAbsolutePath() + "/MyApp");
        lista1 = new ArrayList<String>();
        file = new File(dir, "myData.txt");


        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {

                lista1.add(line);

            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }




    }





}
