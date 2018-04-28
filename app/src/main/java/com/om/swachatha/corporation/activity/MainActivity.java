package com.om.swachatha.corporation.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.om.swachatha.corporation.R;
import com.om.swachatha.corporation.fragment.AddProfileFragment;
import com.om.swachatha.corporation.fragment.GiveRatingAfterCloseComplaintFragment;
import com.om.swachatha.corporation.fragment.HomeFragment;
import com.om.swachatha.corporation.fragment.ProfileFragment;
import com.om.swachatha.corporation.fragment.SelectComplaintFragment;
import com.om.swachatha.corporation.fragment.TrackComplaintFragment;
import com.om.swachatha.corporation.fragment.ZonalSupervisorCompliantDetailFragment;
import com.om.swachatha.corporation.fragment.ZonalSupervisorHomeFragment;

import static com.om.swachatha.corporation.utils.Constant.COME_FROM_VERIFY;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String TAG = MainActivity.class.getSimpleName();

    private ActionBarDrawerToggle toggle;
    public static Toolbar toolbar;
    public static DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpView();
        setToolbar();
        toggleClickEvent();
        isComeFromVerify();
        hideShowNavigationMenuItem(false);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //  super.onBackPressed();
        }

        Log.d(TAG, "On Back Entry Count =" + getSupportFragmentManager().getBackStackEntryCount());
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            showExitDialog();
        } else {
            getSupportFragmentManager().popBackStack();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            loadFragment(new HomeFragment(), true, "");
        } else if (id == R.id.nav_profile) {
            loadFragment(new ProfileFragment(), true, "");
        } else if (id == R.id.nav_rate_us) {
            loadFragment(new TrackComplaintFragment(), true, "");
        } else if (id == R.id.nav_about) {
            loadFragment(new SelectComplaintFragment(), true, "");
        } else if(id == R.id.nav_open_comp) {
           // loadFragment(new Onen(), true, "");
        } else if(id == R.id.nav_close_comp) {

        } else if(id == R.id.nav_share) {
            loadFragment(new ZonalSupervisorHomeFragment(), true, "");
        } else if(id ==R.id.nav_setting) {
            loadFragment(new ZonalSupervisorCompliantDetailFragment(), true, "");
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /***
     * Set Up View
     */
    private void setUpView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
    }

    /**
     * Set toolbar
     */
    private void setToolbar() {

        //Set Transparent Toolbar
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        setSupportActionBar(toolbar);
        ///Hide Toolbar Title
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Set Navigation Home Icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.mipmap.ic_nav);

        //Set Transparent Toolbar  For Above The Lolipop
        Window window = this.getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

    }

    /**
     * Click event of the toggle button
     */
    private void toggleClickEvent() {
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
    }

    /**
     * Load Fragment
     *
     * @param fragment
     * @param isMenuItem
     */
    public void loadFragment(Fragment fragment, boolean isMenuItem, String title) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.contentArea, fragment, fragment.getClass().getSimpleName());
        if (isMenuItem) {
            FragmentManager fm = getSupportFragmentManager();
            for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                // Log.d(TAG,"Back Stack Entry--->" + getFragmentManager().getBackStackEntryCount());
                //Clear Fragment Back Stack
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                //titleList.clear();
            }
        }
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();

    }

    /**
     * Show Exit Dialog
     */
    private void showExitDialog() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Close App")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    /**
     * Get Data From the Intent And Redirect
     * If User Come From Sign Up Then Redirect To The Add Profile Else Home Fragment
     */
    private void isComeFromVerify() {
        Intent intent = getIntent();
        if (intent.getBooleanExtra(COME_FROM_VERIFY, false)) {
            loadFragment(new AddProfileFragment(), false, "");
            //Hide Navigation Drawer Icon
            toolbar.setNavigationIcon(null);
            ///Disable Navigation Drawer For Swapping Open
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        } else {
            loadFragment(new HomeFragment(), false, "");
        }
    }

    /**
     * Show Hide Navigation Menu Item According To Login User
     * If Login as Supervisor Then Show Open And Close Complain Menu Else Other Menu
     * @param isZonalSuperVisor
     */
    private void hideShowNavigationMenuItem(Boolean isZonalSuperVisor) {
        Menu nav_Menu = navigationView.getMenu();
        if (isZonalSuperVisor) {
            nav_Menu.findItem(R.id.nav_profile).setVisible(false);
            nav_Menu.findItem(R.id.nav_notification).setVisible(false);
            nav_Menu.findItem(R.id.nav_about).setVisible(false);
            nav_Menu.findItem(R.id.nav_share).setVisible(false);
            nav_Menu.findItem(R.id.nav_rate_us).setVisible(false);
            nav_Menu.findItem(R.id.nav_setting).setVisible(false);

            nav_Menu.findItem(R.id.nav_open_comp).setVisible(true);
            nav_Menu.findItem(R.id.nav_close_comp).setVisible(true);

        } else {
            nav_Menu.findItem(R.id.nav_open_comp).setVisible(false);
            nav_Menu.findItem(R.id.nav_close_comp).setVisible(false);

            nav_Menu.findItem(R.id.nav_profile).setVisible(true);
            nav_Menu.findItem(R.id.nav_notification).setVisible(true);
            nav_Menu.findItem(R.id.nav_about).setVisible(true);
            nav_Menu.findItem(R.id.nav_share).setVisible(true);
            nav_Menu.findItem(R.id.nav_rate_us).setVisible(true);
            nav_Menu.findItem(R.id.nav_setting).setVisible(true);
        }
    }
}
