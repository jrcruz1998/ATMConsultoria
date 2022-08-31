//FEITO COM BIBLIOTECA IMPORTADA

package com.example.atmconsultoria.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descicao = "A ATM Consultoria tem como missão apoiar organizações que desejam " +
                "alcançar o sucesso através da excelência e da busca pela qualidade.";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        return new AboutPage(getActivity()) //usar getActivity(), ele peermite acessar o contexto da activity
                .setImage(R.drawable.logo)
                .setDescription(descicao)

                .addGroup("Entree em Contato")
                .addEmail("atendimento@atmconsultoria.com.br", "Envie um e-mail")
                .addWebsite("https://www.google.com/", "Acessee nosso site")

                .addGroup("Redes Sociais")
                .addFacebook("jhoooooww", "Facebook")
                .addInstagram("jhxwjhxw", "Instagram")
                //.addTwitter("uZazerr", "Twitter")
                .addYoutube("UCyq8h-M3W3ucuqqjf_rBy7A", "Youtube")
                .addGitHub("jrcruz1998", "GitHub")
                //.addPlayStore("com.google.android.apps.plus", "Download App")

                .addItem(versao)

                .create();


        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}