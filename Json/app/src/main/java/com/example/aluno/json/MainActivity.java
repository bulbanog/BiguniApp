package com.example.aluno.json;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public Context context=this;
    public ArrayList<User> arrayListUsers=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lerJson();


                    for (int i = 0; i < arrayListUsers.size(); i++) {

                        User user= new User();
                        user.setId(arrayListUsers.get(i).getId());
                        user.setNome(arrayListUsers.get(i).getNome());
                        user.setUsernome(arrayListUsers.get(i).getUsernome());

                        String concat= user.getId() + ""+user.getNome() + ""+ user.getUsernome()+"";
                        Toast.makeText(context,concat,Toast.LENGTH_LONG).show();

                    }

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void lerJson() throws ExecutionException, InterruptedException, JSONException {

        //
        BaseRequester baseRequester=    new BaseRequester();
        baseRequester.setUrl("https://jsonplaceholder.typicode.com/users");

        //baseRequester.setMethod("POST");
        baseRequester.setContext(context);
        String jsonString = baseRequester.execute(baseRequester).get();

        //transformando o json texto em JsonObject
        //JSONObject jsonObject = new JSONObject(jsonString);

        //array de usuarios
        JSONArray jsonArrayUsers = new JSONArray(jsonString);

        for (int i=0; i < jsonArrayUsers.length();i++){
            JSONObject jsonObjectUsuario = jsonArrayUsers.getJSONObject(i);
            User user = new User();
            user.setId(Integer.parseInt(jsonObjectUsuario.get("id").toString()));
            user.setNome(jsonObjectUsuario.get("name").toString());
            user.setUsernome(jsonObjectUsuario.get("username").toString());
            arrayListUsers.add(user);




        }



    }
}
