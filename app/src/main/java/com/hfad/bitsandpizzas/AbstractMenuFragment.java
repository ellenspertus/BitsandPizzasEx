package com.hfad.bitsandpizzas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public abstract class AbstractMenuFragment extends ListFragment {

    private int id;

    // constructor
    AbstractMenuFragment(int id){
        this.id = id;
    }

    @ Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(id));
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static Fragment makeMenuFragment(String fragType){
        switch (fragType) {
            case "Home":
                return new TopFragment();
            case "Pizzas":
                return new PizzaFragment();
            case "Pasta":
                return new PastaFragment();
            case "Stores":
                return new StoresFragment();
            case "Appies":
                return new AppetizersFragment();
        }
        return null;
    }
}
