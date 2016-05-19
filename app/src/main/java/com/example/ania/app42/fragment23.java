package com.example.ania.app42;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment23 extends Fragment implements AdapterView.OnItemSelectedListener{
    fragment23 context = this;
    String dane, czar;
    private TextView make, mode, displ;
    private CheckBox czarny;
    Spinner spin;
    String selected;
    boolean isloaded = false;

    File file;
    File root;


    public fragment23() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment23, container, false);

        super.onActivityCreated(savedInstanceState);
        Button b1 = (Button) v.findViewById(R.id.button3);

        assert b1 != null;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getData()) {

                    try {

                        writeToFile(dane);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getActivity(),
                            "Zapisano!",
                            Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(),
                            "Wprowadz pełne dane!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        String [] values = {"Mały","Duży"};
        spin = (Spinner) v.findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spin.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        return v;


    }

    private void writeToFile(String data) throws IOException {


        root = Environment.getExternalStorageDirectory();
        File dir = new File(root.getAbsolutePath() + "/MyApp");

        file = new File(dir, "myData.txt");
        if (!file.exists()) {
            dir.mkdirs();
            file.createNewFile();
        }


        try {

            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.write(dane);
            pw.println();
            pw.flush();
            pw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private Boolean getData()
    {
        make = (EditText) getActivity().findViewById(R.id.editText31);
        mode = (EditText) getActivity().findViewById(R.id.editText32);
        displ = (EditText) getActivity().findViewById(R.id.editText33);
        czarny = (CheckBox) getActivity().findViewById(R.id.checkBox3);
        czar = "NIE";
        if (make.getText().toString().matches("") || mode.getText().toString().matches("") || displ.getText().toString().matches(""))
            return false;
        if (czarny.isChecked())
        {
            czar ="TAK";
        }
        dane = (make.getText().toString() + "@" + mode.getText().toString() + "@" + displ.getText().toString() + "@" + selected + "@" + czar + "@pies");
        return true;


    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
