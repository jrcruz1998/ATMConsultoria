//AULA 118 - 121

package com.example.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.atmconsultoria.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enviarEmail();

            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servico, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

        String celular = "tel:41 995386523";
        String imagem = "https://prnt.sc/TyU_SwrSqPAx";
        String endereco = "https://www.google.com.br/maps/place/Rua+Genesio+de+Souza+Nunes+-+Cajuru,+Curitiba+-+PR,+82590-300/@-25.4550097,-49.203983,18z/data=!4m5!3m4!1s0x94dce5586159b3a7:0x486a0726c002db88!8m2!3d-25.4553955!4d-49.2038983";
        //Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse("tel:41 995386523"));
        //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(imagem));
        //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(endereco));

        Intent intent = new Intent( Intent.ACTION_SEND );

        intent.putExtra( Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"} );
        intent.putExtra( Intent.EXTRA_SUBJECT, "Contato pelo App" );
        intent.putExtra( Intent.EXTRA_TEXT, "Mensagem automática" );

        intent.setType("message/rfc822");
        //intent.setType("text/plain");
        //intent.setType("image/*");
        //intent.setType("application/pdf");

        startActivity( Intent.createChooser( intent, "Escolha um App de e-mail" ) );

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}