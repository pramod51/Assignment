package com.assign.assignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.assign.assignment.Database.LanguageDB;
import com.assign.assignment.Database.MyAppDatabase;
import com.assign.assignment.Database.PostDB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //private TextView textViewResult;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<Post> posts;
    public static MyAppDatabase myAppDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class,"userdb").allowMainThreadQueries().build();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {

                    return;
                }
                List<Post> posts = response.body();
                for (Post post : posts) {
                    PostDB postDB=new PostDB();
                    LanguageDB languageDB=new LanguageDB();
                    for (Languages languages:post.getLanguages()) {
                        languageDB.setName(languages.getName());
                        languageDB.setNativeName(languages.getNativeName());
                    }
                    postDB.setName(post.getName());
                    postDB.setCapital(post.getCapital());
                    //postDB.setBorders(post.getBorders());
                    postDB.setFlag(post.getFlag());
                    //postDB.setLanguages(post.getLanguages());
                    postDB.setPopulation(post.getPopulation());
                    postDB.setRegion(post.getRegion());
                    postDB.setSubregion(post.getSubregion());
                    Log.v("tag",post.getName());
                    MainActivity.myAppDatabase.myDao().addUser(postDB);
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                Log.v("tag",t.getMessage());
            }
        });


        posts=new ArrayList<>();
        List<PostDB> postDB=MainActivity.myAppDatabase.myDao().getPosts();
        for (PostDB post:postDB){
            Log.v("tttt",post.getCapital());
            posts.add(new Post(post.getName(), post.getCapital(), post.getRegion(), post.getSubregion(), post.getFlag(), null,null, post.getPopulation()));
        }
        adapter=new PostAdopter(posts,this);
        recyclerView.setAdapter(adapter);
    }
}