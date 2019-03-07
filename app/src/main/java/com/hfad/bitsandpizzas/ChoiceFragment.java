package com.hfad.bitsandpizzas;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public abstract class ChoiceFragment extends ListFragment {

    private int ARRAY_ID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(ARRAY_ID));
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void setArrayId(int id) {
        this.ARRAY_ID = id;
    }

}
