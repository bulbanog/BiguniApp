package com.biguniunibratec.biguniapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListaCaronaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CaronaAdapter caronaAdapter;
    public Context context = this;
    public ProgressDialog progressDialog;
    public ArrayList<Usuario> arrayListUsers = new ArrayList<>();
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

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lerJson();
                    for (int i = 0; i < arrayListUsers.size() ; i++) {


                        Usuario  usuario = new Usuario();
                        usuario.setMatricula(arrayListUsers.get(i).getMatricula());
                        usuario.setNome(arrayListUsers.get(i).getNome());
                        usuario.setEmail(arrayListUsers.get(i).getEmail());
                        final String concat = usuario.getMatricula()+" "+usuario.getNome()+" "+usuario.getEmail();

                        caronaList = new ArrayList<>();

                        caronaList.add(new Carona(usuario.getNome(),usuario.getEmail(),usuario.getNome(),3));
                        caronaList.add(new Carona("Rayssa", "Olinda","Unibratec", 3));

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                                Toast.makeText(context,concat,Toast.LENGTH_LONG).show();

                            }
                        });

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();

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

    public void lerJson() throws ExecutionException, InterruptedException,JSONException {
        BaseRequester baseRequester = new BaseRequester();
        baseRequester.setUrl("http://barcodepapelorigami.hol.es/listacarona.php");
        baseRequester.setContext(context);

        //Enviar dados ao servidor
        //JSONObject jsonPut = new JSONObject();
        //jsonPut.put("matricula","32016123456");
        //jsonPut.put("senha","senha123");
        //baseRequester.setJsonString(jsonPut.toString());

        String jsonString = baseRequester.execute(baseRequester).get();
        JSONArray jsonArrayUsers = new JSONArray(jsonString);

        for (int i = 0; i < jsonArrayUsers.length(); i++) {
            JSONObject jsonObjectUsuario = jsonArrayUsers.getJSONObject(i);

            Usuario usuario = new Usuario();
            usuario.setMatricula(Integer.parseInt(jsonObjectUsuario.get("matricula").toString()));
            usuario.setEmail(jsonObjectUsuario.get("email").toString());
            usuario.setSenha(jsonObjectUsuario.get("senha").toString());
            usuario.setNome(jsonObjectUsuario.get("nome").toString());
            usuario.setTelefone(jsonObjectUsuario.get("telefone").toString());
            arrayListUsers.add(usuario);
        }
    }

}
