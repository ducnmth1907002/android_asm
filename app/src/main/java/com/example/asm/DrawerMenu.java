package com.example.asm;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class DrawerMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, NavigationBarView.OnItemSelectedListener{
    DrawerLayout drawerLayout;
    BottomNavigationView navigationView;
    FrameLayout frameLayout;
    CreateExpendituresFragment createExpendituresFragment;
    ListExpendituresFragment listExpendituresFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_menu);
        initView();
    }

    private void initView() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.drawer_bottom_view);
        navigationView.bringToFront();
        navigationView.setOnItemSelectedListener(this);

        //gán fragment vào frame layout
        frameLayout = findViewById(R.id.main_content);
        createExpendituresFragment = new CreateExpendituresFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content, createExpendituresFragment, CreateExpendituresFragment.class.getName())
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.list:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_content, listExpendituresFragment, ListExpendituresFragment.class.getName())
                        .commit();
                break;
            case R.id.create:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_content, createExpendituresFragment, CreateExpendituresFragment.class.getName())
                        .commit();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        return false;
    }
}
