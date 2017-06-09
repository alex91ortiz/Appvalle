package com.jcsoluciones.appvalle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jcsoluciones.appvalle.adapters.ViewPagerAdapter;
import com.jcsoluciones.appvalle.adapters.dummy.DummyContent;
import com.jcsoluciones.appvalle.fragments.lists.HotelesListFragment;
import com.jcsoluciones.appvalle.fragments.lists.OperadoresListFragment;
import com.jcsoluciones.appvalle.fragments.lists.SitiosTuristicosListFragment;

public class MainActivity extends AppCompatActivity implements SitiosTuristicosListFragment.OnListFragmentInteractionListener, HotelesListFragment.OnListFragmentInteractionListener, OperadoresListFragment.OnListFragmentInteractionListener {
    private ViewPagerAdapter adapterViewpager;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(getApplication(),RegistroActivity.class);
                startActivity(intent);
            }
        });

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapterViewpager = new ViewPagerAdapter(getSupportFragmentManager());

        SitiosTuristicosListFragment sitiosTuristicosListFragment = SitiosTuristicosListFragment.newInstance(4);
        adapterViewpager.addFragment(sitiosTuristicosListFragment, "Sitios");

        HotelesListFragment hotelesListFragment = HotelesListFragment.newInstance(6);
        adapterViewpager.addFragment(hotelesListFragment, "Hoteles");

        OperadoresListFragment operadoresListFragment = OperadoresListFragment.newInstance(7);
        adapterViewpager.addFragment(operadoresListFragment, "Operadores");

        viewPager.setAdapter(adapterViewpager);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
