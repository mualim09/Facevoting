package com.berkatfaatulohalawa1711010164.facevoting.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.berkatfaatulohalawa1711010164.facevoting.API.APIService;
import com.berkatfaatulohalawa1711010164.facevoting.API.NoConnectivityException;
import com.berkatfaatulohalawa1711010164.facevoting.R;
import com.berkatfaatulohalawa1711010164.facevoting.adapter.VoteAdapter;
import com.berkatfaatulohalawa1711010164.facevoting.config.Constants;
import com.berkatfaatulohalawa1711010164.facevoting.model.VoteModel;
import com.berkatfaatulohalawa1711010164.facevoting.response.GetVote;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class votefragment extends Fragment {
    private RecyclerView voteView;
    private VoteAdapter voteAdapter;
    private List<VoteModel> daftarVote;
    private ProgressDialog progressDialog;
    private Toolbar toolbar;
    private Context mContext;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_votefragment, container, false);

        dataInit(view);
        if(getActivity() != null){
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(toolbar);
            toolbar.setTitle("Bukti Pemilihan");
        }

        setupRecyclerView();
        setData(getContext());

        return view;
    }

    public void setData(Context mContext) {
        tampilLoading();
        try{
            SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(
                    Constants.USER_KEY, Context.MODE_PRIVATE);
            String idUser = sharedPreferences.getString("id_user", "");
            Call<GetVote> call = APIService.Factory.create(mContext).tampilVote(idUser);
            call.enqueue(new Callback<GetVote>() {
                @EverythingIsNonNull
                @Override
                public void onResponse(Call<GetVote> call, Response<GetVote> response) {
                    hideLoading();
                    if(response.isSuccessful()){
                        daftarVote = response.body().getListVote();
                        voteAdapter.replaceData(daftarVote);
                    }
                }
                @EverythingIsNonNull
                @Override
                public void onFailure(Call<GetVote> call, Throwable t) {
                    hideLoading();
                    if(t instanceof NoConnectivityException) {
                        tampilPesan("Offline, cek koneksi internet anda!");
                    }
                }
            });
        }catch (Exception e){
            hideLoading();
            e.printStackTrace();
            tampilPesan(e.getMessage());
        }
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()){
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        };

        voteAdapter = new VoteAdapter(getContext(),new ArrayList<>());
        voteView.setLayoutManager(linearLayoutManager);
        voteView.setAdapter(voteAdapter);
    }


    private void dataInit(View mview){
        toolbar = mview.findViewById(R.id.toolbarVote);
        voteView = mview.findViewById(R.id.rcVote);
//        mSwipeRefreshLayout = mview.findViewById(R.id.refresh);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading.....");
    }


    /* Menampilkan Loading */
    private void tampilLoading(){
        if(!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    /* Menghilangkan Loading */
    private void hideLoading(){
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }

    /* Menampilkan pesan notifikasi */
    public void tampilPesan(String pesan)
    {
        Toast.makeText(getContext(), pesan, Toast.LENGTH_LONG).show();
    }


}