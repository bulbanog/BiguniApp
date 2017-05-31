package com.biguniunibratec.biguniapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaCaronaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CaronaAdapter caronaAdapter;
    List<Carona> caronaList; //lista com os objetos que serão exibidos na RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carona);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_layout_recycler);
        //informas que a nossa lista terá um tamanho fixo, isso melhor a performance do app
        recyclerView.setHasFixedSize(true);

        // Configurando o gerenciador de layout para ser uma lista.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Adicionando objetos a lista
        // a lista pode ser carregada de um banco de dados ou web  service
        caronaList = new ArrayList<>();
        caronaList.add(new Carona("Miqueias", "Janga","Unibratec", 3));
        caronaList.add(new Carona("Rayssa", "Olinda","Unibratec", 3));
        caronaList.add(new Carona("Luiz", "Madalena","Unibratec", 3));
        caronaList.add(new Carona("Lucicleydson", "Cordeiro","Unibratec", 3));
        caronaList.add(new Carona("Vinicius", "Cordeiro","Unibratec", 1));

        // Adiciona o adapter que irá anexar os objetos à lista.
        // Está sendo criado com lista vazia, pois será preenchida posteriormente.
        caronaAdapter = new CaronaAdapter(caronaList);
        recyclerView.setAdapter(caronaAdapter);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

}
