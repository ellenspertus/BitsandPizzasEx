package com.hfad.bitsandpizzas;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public abstract class OrderFragment extends ListFragment {

    private int listType;

    public OrderFragment(int listType) {
        this.listType = listType;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(listType));
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
