package com.example.emrullah.githubrepoviewer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.emrullah.githubrepoviewer.Models.ExampleModel;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sort_spinner)
    Spinner _sortSpinner;
    @BindView(R.id.repo_name)
    EditText _repoName;
    @BindView(R.id.btn_search)
    Button _btn_search;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private RepoAdapter _Adapter;
    private RecyclerView.LayoutManager _LayoutManager;
    ArrayList<RepoItem> repoItems;
    String userName;
    String sortType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        repoItems = new ArrayList<>();


        _LayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        _Adapter = new RepoAdapter(repoItems);
        recyclerView.setLayoutManager(_LayoutManager);
        recyclerView.setAdapter(_Adapter);
        _Adapter.setOnClickItemListener(new RepoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                goWebView(position);
            }
        });

    }


    @OnClick(R.id.btn_search)
    public void searchOnClick() {

        clearData(repoItems,_Adapter);
        doTheThings();
    }


    public void doTheThings() {
        userName = _repoName.getText().toString();
        sortType = _sortSpinner.getSelectedItem().toString().toLowerCase();

        System.out.println("Here: " + userName + "  " + sortType);
        BaseWorks baseWorks = new BaseWorks();
        JsonApiHolder jsonApiHolder = baseWorks.getRetrofit(getApplicationContext()).create(JsonApiHolder.class);

        Call<List<ExampleModel>> call = jsonApiHolder.getTheRepo(userName, sortType);
        call.enqueue(new Callback<List<ExampleModel>>() {
            @Override
            public void onResponse(Call<List<ExampleModel>> call, Response<List<ExampleModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                    System.out.println("Here" + response.code());
                    return;
                } else if (response == null) {
                    Toast.makeText(getApplicationContext(), "No one is there!", Toast.LENGTH_LONG).show();
                } else {
                    List<ExampleModel> exampleModelRes = response.body();
                    for (ExampleModel items : exampleModelRes) {

                        String avatarHtml = items.getOwner().getAvatarUrl();
                        String repoName = items.getName();
                        String repoFullName = items.getFullName();
                        String repoHtml = items.getHtmlUrl();
                        repoItems.add(new RepoItem(avatarHtml, repoName, repoFullName, repoHtml));

                    }

                }
            }

            @Override
            public void onFailure(Call<List<ExampleModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("Here" + t.getMessage());
            }
        });
    }

    public void goWebView(int position) {

        String pageUrl = repoItems.get(position).get_repoHtmlUrl();
        Intent intent = new Intent(getApplicationContext(), RepoWebView.class);
        intent.putExtra("htmlUrl", pageUrl);
        startActivity(intent);
        _Adapter.notifyAll();
    }

    public void clearData(ArrayList<RepoItem> repoItems, RepoAdapter _Adapter) {
        repoItems.clear();
        _Adapter.notifyDataSetChanged();
    }

}
