package com.biguniunibratec.biguniapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import android.app.ProgressDialog;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by JOHN on 12/04/2017.
 */

public class SecondActivity extends AppCompatActivity {

    public Context context = this;
    public ArrayList<Usuario> arrayListUsers = new ArrayList<>();
    public ProgressDialog progressDialog;
    private Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //progressDialog = ProgressDialog.show(SecondActivity.this, "Unibratec", "Baixando imagem...");

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
        //Toolbar
        Toolbar mytoolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mytoolbar);

        //associamos os componentes da nossa tela a nossa activity
        //estamos criando variaveis dos tipos correespondentes no layout
        //referenciando essas variaveis atreves do id de cada elemento

        TextView txtmatriculaacesso = (TextView) findViewById(R.id.txtmatriculaacesso);
        TextView txtsenhaacesso = (TextView) findViewById(R.id.txtsenhaacesso);
        Button btnlogin = (Button) findViewById(R.id.btnlogin);
        TextView txtNaoCadastrou = (TextView) findViewById(R.id.txtops);
        TextView txtCriarConta = (TextView) findViewById(R.id.txtcriarConta);

        //importando a fonte
        Typeface roboto = Typeface.createFromAsset(getResources().getAssets(), "Roboto-Light.ttf");

        //atribuindo a fonte ao botão
        txtmatriculaacesso.setTypeface(roboto);
        txtsenhaacesso.setTypeface(roboto);
        txtNaoCadastrou.setTypeface(roboto);
        txtCriarConta.setTypeface(roboto);
        btnlogin.setTypeface(roboto);

        //definimos o evento de click do botão
        //caso tenhamos mais botões, cada botão tem o seu proprio evento
        txtCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c,NewAccountActivity.class);
                startActivity(intent);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c,ListaCaronaActivity.class);
                startActivity(intent);
            }
        });
    }
    public void lerJson() throws ExecutionException, InterruptedException,JSONException{
        BaseRequester baseRequester = new BaseRequester();
        baseRequester.setUrl("http://barcodepapelorigami.hol.es/WebServiceBiguni/listacarona.php");
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toolbar tb = (Toolbar) findViewById(R.id.my_toolbar);
        tb.inflateMenu(R.menu.menu);
        tb.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return onOptionsItemSelected(item);
                    }

                });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                final AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                builder.setMessage("Configurações")
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}