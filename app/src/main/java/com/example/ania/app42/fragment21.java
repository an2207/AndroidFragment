package com.example.ania.app42;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment21 extends Fragment implements RadioGroup.OnCheckedChangeListener {
    Activity A1;
    OnWyborOpcjiListener sluchaczF1;
    private RadioGroup radioGroup;



    public fragment21() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V =  inflater.inflate(R.layout.fragment_fragment21, container, false);

        radioGroup = (RadioGroup) V.findViewById(R.id.myRadioGroup);


        return V;


    }

    public void onActivityCreated (Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        ((RadioGroup) getActivity().findViewById(R.id.myRadioGroup)).setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId)
        {
            case(R.id.radioButton):
                sluchaczF1.onWyborOpcji(1);
                break;
            case(R.id.radioButton2):
                sluchaczF1.onWyborOpcji(2);
                break;
        }


    }


    public interface OnWyborOpcjiListener{
        public void onWyborOpcji(int opcja);
    }



    @Override
    public void onAttach(Activity context)
    {
        super.onAttach(context);
        try
        {
            A1 = context;
            sluchaczF1 = (OnWyborOpcjiListener) context;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(A1.toString() + " musi impementować OnWyborOpcjiListener");
        }
    }

}