package com.example.imagegallery.APIService;

import android.app.ProgressDialog;

import androidx.recyclerview.widget.RecyclerView;

import com.example.imagegallery.Activities.MainActivity;
import com.example.imagegallery.Adapters.ImageAdapter;
import com.example.imagegallery.Models.ImageModel;
import com.example.imagegallery.Models.results;
import com.example.imagegallery.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetImageService {
    public MainActivity mainActivity;
    public RecyclerView recyclerView;
    public ImageAdapter adapter;
    List<com.example.imagegallery.Models.results> results;

    public GetImageService(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void getImage(){final ProgressDialog progressDialog = new ProgressDialog(mainActivity);
        progressDialog.setMessage("Please Wait... ");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
        String query,per_page,client_id;
        query = "rocket";
        per_page = "40";
        client_id = "3LG8LwNcmXYZQCplMqCw93lAlSu52v2QecSbAe-xWj8";
        recyclerView = mainActivity.findViewById(R.id.imagelist);
        APIClient service = ServiceGenerator.getImages(APIClient.class);
        Call<ImageModel> call = service.GetImages(query,per_page,client_id);
        call.enqueue(new Callback<ImageModel>() {
            @Override
            public void onResponse(Call<ImageModel> call, Response<ImageModel> response) {
                progressDialog.dismiss();
                if(response.isSuccessful() && response.body()!=null){
                    results = response.body().getResults();
                    adapter = new ImageAdapter(mainActivity,results);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ImageModel> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }

}
