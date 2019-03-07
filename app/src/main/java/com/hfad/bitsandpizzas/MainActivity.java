package com.hfad.bitsandpizzas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Want to join me for pizza?");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setShareActionIntent(String text) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(shareIntent);
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        private String[] TABS;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            TABS = getResources().getStringArray(R.array.tabs);
        }

        @Override
        public int getCount() {
            return TABS.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (TABS[position]) {
                case "Home":
                    return new TopFragment();
                case "Breads":
                    return new BreadFragment();
                case "Pizzas":
                    return new PizzaFragment();
                case "Pasta":
                    return new PastaFragment();
                case "Stores":
                    return new StoresFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            try {
                return TABS[position];
            } catch (NullPointerException exception) {
                return null;
            }
        }
    }

}






















