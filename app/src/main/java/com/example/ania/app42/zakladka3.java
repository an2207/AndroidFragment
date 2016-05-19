package com.example.ania.app42;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * A simple {@link Fragment} subclass.
 */
public class zakladka3 extends Fragment {
    File root;
    File file;
    String[] pozycje;

    final zakladka3 context = this;
    ArrayList<String> lista1;

    public zakladka3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_zakladka3, container, false);

        createList();
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_expandable_list_item_1, pozycje);
        ListView lista = (ListView) v.findViewById(R.id.listView);
        lista.setAdapter(adap);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {

                String[] details;
                String imie, rasa, wiek, typ, wyk;
                details = lista1.get(pos).split("@");
                imie = details[0];
                rasa = details[1];
                wiek = details[2];
                typ = details[3];
                wyk = details[4];
                Fragment newFragment = new lista1();
                Fragment newFragment2 = new lista2();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("imie", imie);
                bundle.putString("rasa", rasa);
                bundle.putString("wiek", wiek);
                bundle.putString("typ", typ);
                bundle.putString("wykastrowany", wyk);

                if (details[5].equals("pies"))
                {
                    transaction.replace(R.id.kontener2, newFragment);
                    newFragment.setArguments(bundle);
                }else
                {
                    transaction.replace(R.id.kontener2, newFragment2);
                    newFragment2.setArguments(bundle);
                }
                transaction.addToBackStack(null);


                transaction.commit();
            }
        });



        return v;
    }

    private void createList()
    {
        String[] data;
        int i = 0;
        StringTokenizer st;
        root = Environment.getExternalStorageDirectory();
        File dir = new File (root.getAbsolutePath() + "/MyApp");
        lista1 = new ArrayList<String>();
        file = new File(dir, "myData.txt");
        StringBuilder text = new StringBuilder();

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


        pozycje = new String[lista1.size()];
        for (String elem : lista1)
        {
            data = elem.split("@");
            pozycje[i] = data[0];
            i++;
        }

    }

}
