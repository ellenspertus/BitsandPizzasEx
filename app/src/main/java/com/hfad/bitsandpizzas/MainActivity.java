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
    private static int numTabs;
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
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            if (numTabs == 0) {
                numTabs = getResources().getStringArray(R.array.tabs).length;
            }
            return numTabs;
        }

        @Override
        public Fragment getItem(int position) {
            CharSequence title = getPageTitle(position);
            if (title == null) {
                return null;
            }

            if (title.equals(getResources().getString(R.string.home_tab))) {
                return new TopFragment();
            } else if (title.equals(getResources().getString(R.string.pizza_tab))) {
                return new PizzaFragment();
            } else if (title.equals(getResources().getString(R.string.pasta_tab))) {
                return new PastaFragment();
            } else if (title.equals(getResources().getString(R.string.store_tab))) {
                return new StoresFragment();
            } else {
                return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position >= 0 && position < getCount()) {
                return getResources().getStringArray(R.array.tabs)[position];
            } else {
                return null;
            }
        }
    }
}






















