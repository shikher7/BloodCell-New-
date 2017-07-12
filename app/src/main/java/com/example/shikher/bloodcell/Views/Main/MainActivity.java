package com.example.shikher.bloodcell.Views.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.shikher.bloodcell.Views.Authentication.LoginActivity;
import com.example.shikher.bloodcell.Views.Fragments.FragmentAboutUs;
import com.example.shikher.bloodcell.Views.Fragments.FragmentContactUs;
import com.example.shikher.bloodcell.Views.Fragments.FragmentDonate;
import com.example.shikher.bloodcell.Views.Fragments.FragmentFeedback;
import com.example.shikher.bloodcell.Views.Fragments.FragmentRequest;

import com.example.shikher.bloodcell.R;
import com.example.shikher.bloodcell.Views.Fragments.FragmentSearch;
import com.example.shikher.bloodcell.Views.Fragments.LearnFragment;

import butterknife.OnClick;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @OnClick(R.id.logout)

    public void onLogout(View v) {
        Intent i = new Intent(this, LoginActivity.class);
        this.startActivity(i);
        this.finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void displayselectedscreen(int id) {
        Fragment fragment = null;
        switch (id) {
            case R.id.donate:
                fragment = new FragmentDonate();
                break;
            case R.id.request:
                fragment = new FragmentRequest();
                break;
            case R.id.search:
                fragment = new FragmentSearch();
                break;
            case R.id.feedback:
                fragment = new FragmentFeedback();
                break;
            case R.id.about_us:
                fragment = new FragmentAboutUs();
                break;
            case R.id.contact_us:
                fragment = new FragmentContactUs();
                break;
            case R.id.info:
                fragment = new LearnFragment();
                break;
        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main,fragment);
            ft.commit();
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);


        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        displayselectedscreen(id);
        return true;
    }
}
