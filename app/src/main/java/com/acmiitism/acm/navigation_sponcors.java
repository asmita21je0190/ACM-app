package com.acmiitism.acm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class navigation_sponcors extends Fragment implements View.OnClickListener {
    String url;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_sponcors, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.samsung).setOnClickListener(this);
        view.findViewById(R.id.walmart).setOnClickListener(this);
        view.findViewById(R.id.mozilla).setOnClickListener(this);
        view.findViewById(R.id.github).setOnClickListener(this);
        view.findViewById(R.id.hackerrank).setOnClickListener(this);
        view.findViewById(R.id.codingblocks).setOnClickListener(this);
        view.findViewById(R.id.vedanta).setOnClickListener(this);
        view.findViewById(R.id.codingninja).setOnClickListener(this);
        view.findViewById(R.id.teqip).setOnClickListener(this);
        view.findViewById(R.id.gfg).setOnClickListener(this);
        view.findViewById(R.id.hackerearth).setOnClickListener(this);
        view.findViewById(R.id.dev).setOnClickListener(this);
        view.findViewById(R.id.techgig).setOnClickListener(this);
        view.findViewById(R.id.foxmula).setOnClickListener(this);
        view.findViewById(R.id.chef).setOnClickListener(this);
        view.findViewById(R.id.skill).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.samsung :
                url="https://www.samsung.com/in/";
                break;
            case R.id.walmart :
                url="https://www.walmart.com/";
                break;
            case R.id.mozilla:
                url="https://www.mozilla.org/en-US/";
                break;
            case R.id.github :
                url="https://github.com/";
                break;
            case R.id.hackerrank :
                url="https://www.hackerrank.com/";
                break;
            case R.id.codingblocks :
                url="https://codingblocks.com/";
                break;
            case R.id.vedanta :
                url="https://www.vedantalimited.com/Pages/Home.aspx";
                break;
            case R.id.codingninja :
                url="https://www.codingninjas.com/";
                break;
            case R.id.teqip :
                url="https://www.teqip.in/";
                break;
            case R.id.gfg :
                url="https://www.geeksforgeeks.org/";
                break;
            case R.id.hackerearth :
                url="https://www.hackerearth.com/";
                break;
            case R.id.dev :
                url="https://devfolio.co/";
                break;
            case R.id.techgig :
                url="https://www.techgig.com/";
                break;
            case R.id.foxmula :
                url="https://foxmula.com/";
                break;
            case R.id.chef :
                url="https://www.codechef.com/";
                break;
            case R.id.skill :
                url="https://skillenza.com/";
        }
        openWebsite(url);
    }

    public void openWebsite(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}