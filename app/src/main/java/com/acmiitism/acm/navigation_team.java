package com.acmiitism.acm;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class navigation_team extends Fragment {
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation_team, container, false);
        ArrayList<ExampleforTeam> exampleList = new ArrayList<>();
        exampleList.add(new ExampleforTeam(R.drawable.facultysponsor, "Rajendra Pamula", "Faculty Sponsor"));
        exampleList.add(new ExampleforTeam(R.drawable.facultycosponsot, "Madhulika Mohanty", "Faculty Co-Sponsor"));
        exampleList.add(new ExampleforTeam(R.drawable.swapnil, "Swapnil Narayan", "ChairMan ACM IIT(ISM) Dhanbad"));
        exampleList.add(new ExampleforTeam(R.drawable.abhishekraj, "Abhishek Raj", "Vice Chair ACM IIT(ISM) Dhanbad"));
        exampleList.add(new ExampleforTeam(R.drawable.shailsiyag, "Sahil Siyag", "Secretary And Management Head"));
        exampleList.add(new ExampleforTeam(R.drawable.samirjain, "Sameer Jain", "Treasurer"));
        exampleList.add(new ExampleforTeam(R.drawable.satyavart, "Satyavart", "Membership Chair"));
        exampleList.add(new ExampleforTeam(R.drawable.prince, "Prince Kumar", "PR Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.dhyeysir, "Dhyey Mistry", "Tech Head"));
        exampleList.add(new ExampleforTeam(R.drawable.ishanthapa, "Ishan Thapa", "Promotion Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.madhavaggar, "Madhav Aggarwal", "Content Writing Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.avinashsir, "Avinash", "Campus Ambassador Program Head"));
        exampleList.add(new ExampleforTeam(R.drawable.rashmikiranpandit, "Rashmikiran Pandit", "Sponsor Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.subhagyata, "Subhagyata Swaraj Jaiswal", "Content Writing and Promotion Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.saurabh, "Saurabh Raj", "Designing Team Head"));
        exampleList.add(new ExampleforTeam(R.drawable.aashisha, "Aashisha Singh", "Android Developer"));
        exampleList.add(new ExampleforTeam(R.drawable.akshat, "Akshat Tripathi", "Android Developer"));

        final ArrayList<Pair<String, String>> l = new ArrayList<>();
        l.add(new Pair<>("rajendra@iitism.ac.in","https://www.linkedin.com/in/rajendra-pamula-98125a79/"));
        l.add(new Pair<>("madhulika@iitism.ac.in","https://www.linkedin.com/in/madhulikamohanty/"));
        l.add(new Pair<>("swapism7@gmail.com", "https://www.linkedin.com/in/swapzism/"));
        l.add(new Pair<>("abhishekraj29011998@gmail.com", "https://www.linkedin.com/in/abhishek-raj-permani-495483156/"));
        l.add(new Pair<>("sahilsiyag88@gmail.com", "https://www.linkedin.com/in/sahil-siyag-4aa893191/"));
        l.add(new Pair<>("sameer2000jain12@gmail.com", "https://www.linkedin.com/in/sameer-jain-882589158/"));
        l.add(new Pair<>("genrousurfer@gmail.com", "https://www.linkedin.com/in/satyavart-b8630b173/"));
        l.add(new Pair<>("princegup678@gmail.com", "https://www.linkedin.com/in/princegup678/"));
        l.add(new Pair<>("dhyeybm@gmail.com", "https://www.linkedin.com/in/dhyey-mistry-859177177/"));
        l.add(new Pair<>("ishanthapa2607@gmail.com", "https://www.linkedin.com/in/ishan-thapa-426722194/"));
        l.add(new Pair<>("Madhav.21.2k@gmail.com", "https://www.linkedin.com/in/madhav-agarwal-021a55180/"));
        l.add(new Pair<>("avinash21997@gmail.com", "https://www.linkedin.com/in/avinash-b904a8194/"));
        l.add(new Pair<>("panditrk2000@gmail.com", "https://www.linkedin.com/in/rashmikiran-pandit-358196189/"));
        l.add(new Pair<>("Shubhagytaswaraj@gmail.com", "https://www.linkedin.com/in/shubhagyta-395ab4185/"));
        l.add(new Pair<>("saurabhraj.18je0747@pe.iitism.ac.in", "https://www.linkedin.com/in/saurabh-raj-aab418184/"));
        l.add(new Pair<>("iamaashisha@gmail.com", "https://www.linkedin.com/in/aashisha-singh-3b6906195/"));
        l.add(new Pair<>("akshatofficial2019@gmail.com", "https://www.linkedin.com/in/akshat-kumar-tripathi-b8a1161a3/"));
        ExampleTeamAdapter adapter = new ExampleTeamAdapter(exampleList,l,getContext());
        mRecyclerView = view.findViewById(R.id.recyclerViewTeam);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerView.setAdapter(adapter);

        return view;
    }

}