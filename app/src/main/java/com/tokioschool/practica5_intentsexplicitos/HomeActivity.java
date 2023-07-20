package com.tokioschool.practica5_intentsexplicitos;

import static com.tokioschool.practica5_intentsexplicitos.Constants.KEY_NAME_STRING;
import static com.tokioschool.practica5_intentsexplicitos.Constants.KEY_PASSWORD_STRING;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.tokioschool.practica5_intentsexplicitos.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private String name;
    private String password;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getNameAndPass();
        listeners();
    }

    private void listeners() {
        binding.mainActivityToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_coche){
                    getSupportFragmentManager().beginTransaction().add(binding.homeactivityFragmentFrame.getId(), new RentCarFragment()).commitAllowingStateLoss();
                }
                if (item.getItemId() == R.id.menu_disney){
                    String url = "https://www.disneylandparis.com/";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    private void getNameAndPass() {
        try {
            bundle = getIntent().getExtras().getBundle("bundle");
            name = bundle.getString(KEY_NAME_STRING);
            password = bundle.getString(KEY_PASSWORD_STRING);
            Log.i("Nombre","Nombre: "+name);
            Log.i("Pass","Contraseña: "+password);
        }catch (Exception e){
            Log.i("Mensaje", "No hay password ni contraseña");
        }

    }
}