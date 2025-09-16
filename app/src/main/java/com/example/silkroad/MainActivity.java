package com.example.silkroad;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_inicio) {
            Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_administradores) {
            Toast.makeText(this, "Administradores", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, GuiasActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_guias) {
            Toast.makeText(this, "Guías", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AdministradoresActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_clientes) {
            Toast.makeText(this, "Clientes", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ClientesActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_reportes) {
            Toast.makeText(this, "Reportes", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ReportesActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_logs) {
            Toast.makeText(this, "Logs", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LogsActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_grupo_iot_item) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // El ActionBarDrawerToggle también maneja los clics en el ícono de navegación (hamburguesa)
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        
        int itemId = item.getItemId();


        return super.onOptionsItemSelected(item);
    }


}