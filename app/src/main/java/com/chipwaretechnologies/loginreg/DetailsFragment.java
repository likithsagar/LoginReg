package com.chipwaretechnologies.loginreg;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    List<User> listing=new ArrayList<>();

    public DetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_details, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        DetailsAdapter detailsAdapter =new DetailsAdapter(listing);
        recyclerView.setAdapter(detailsAdapter);

        return view;

        //RecyclerView rv = new RecyclerView(getContext());
        //rv.setLayoutManager(new LinearLayoutManager(getContext()));
        //ArrayList<User> serverResponses =(ArrayList<User>)getArguments().getSerializable("key");
        //detailsAdapter = new DetailsAdapter(serverResponses);
    //return rv;
    }


}
