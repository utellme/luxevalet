package com.example.deca.luxevalet;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    DrawerLayout dlDrawer;
    ActionBarDrawerToggle  mDrawerToggle;
    NavigationView nvDrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the toolbar view inside the activity layout
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        //setSupportActionBar(toolbar);
        // Find our drawer view

        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawerToggle = setupDrawerToggle();

        mDrawerToggle = setupDrawerToggle();

        // Tie DrawerLayout events to the ActionBarToggle
        //dlDrawer.setDrawerListener(mDrawerToggle);
        dlDrawer.addDrawerListener(mDrawerToggle);



        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        nvDrawer.getMenu().getItem(0).setChecked(true);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.flContent, new SouthParkFragment()).commit();
        //setTitle(R.string.profile);



    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the planet to show based on
        // position
        Fragment fragment = null;

//        Class fragmentClass;
//        switch(menuItem.getItemId()) {
//            case R.id.nav_south_fragment:
//                fragmentClass = SouthParkFragment.class;
//                break;
//            case R.id.nav_simpsons_fragment:
//                fragmentClass = SimpsonsFragment.class;
//                break;
//            case R.id.nav_familguy_fragment:
//                fragmentClass = FamilyGuyFragment.class;
//                break;
//            default:
//                fragmentClass = FuturamaFragment.class;
//        }
//
//        try {
//            fragment = (Fragment) fragmentClass.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // Insert the fragment by replacing any existing fragment
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        dlDrawer.closeDrawers();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, dlDrawer,(Toolbar)findViewById(R.id.toolbar) , R.string.drawer_open,  R.string.drawer_close);
        //return new ActionBarDrawerToggle(this, dlDrawer , R.string.drawer_open,  R.string.drawer_close);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle
        // If it returns true, then it has handled
        // the nav drawer indicator touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }
}