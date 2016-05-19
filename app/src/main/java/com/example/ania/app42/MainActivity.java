package com.example.ania.app42;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, fragment21.OnWyborOpcjiListener{

    zakladka1 f11;
    zakladka2 f12;
    FragmentTransaction transakcja;
    private int index;
    fragment22 f22;
    fragment23 f23;


    List<Fragment> fragList = new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int i=1; i <= 3; i++) {
            Tab tab = bar.newTab();
            tab.setText("Tab " + i);
            tab.setTabListener(this);
            bar.addTab(tab);

        }


        f22 = new fragment22();
        f23 = new fragment23();
        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener, f22);
        transakcja.detach(f22);
        transakcja.add(R.id.kontener, f23);
        transakcja.detach(f23);
        transakcja.commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }








    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        zakladka1 tf = null;


        String nazwa = tab.getText().toString();




            switch(nazwa) {
                case "Tab 1":

                    tf = new zakladka1();
                    ft.replace(android.R.id.content, tf);
                    break;
                case "Tab 2":

                    ft.replace(android.R.id.content, new zakladka2());
                    break;
                case "Tab 3":

                    ft.replace(android.R.id.content, new zakladka3kont());
                    break;
            }






    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if (fragList.size() > tab.getPosition()) {
            ft.remove(fragList.get(tab.getPosition()));
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onWyborOpcji(int opcja) {

        FragmentTransaction transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.detach(f22);
        transakcja.detach(f23);

        switch(opcja)
        {
            case 1:
                transakcja.attach(f22);
                break;
            case 2:
                transakcja.attach(f23);
                break;
        }



        transakcja.commit();
    }
}
