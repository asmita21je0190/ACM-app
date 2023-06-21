package com.acmiitism.acm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class navigation_home extends Fragment implements View.OnClickListener {

    RecyclerView recyclerViewEvents;
    DatabaseReference myRef;
    Query query;
    static ProgressBar bar_home;
    String number,email;
    NavController navController;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation_home, container, false);
        myRef = FirebaseDatabase.getInstance().getReference().child("EVENTS");
        query = myRef.orderByChild("year").limitToLast(10);
        query.keepSynced(true);
        bar_home = view.findViewById(R.id.progressHome);
        bar_home.setVisibility(View.VISIBLE);

        recyclerViewEvents =(RecyclerView) view.findViewById(R.id.homeRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,true);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerViewEvents.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);
        view.findViewById(R.id.fab_achievements).setOnClickListener(this);
        view.findViewById(R.id.fab_events).setOnClickListener(this);
        view.findViewById(R.id.fab_team).setOnClickListener(this);
        view.findViewById(R.id.homeSeeAll).setOnClickListener(this);
        view.findViewById(R.id.contact_call1).setOnClickListener(this);
        view.findViewById(R.id.contact_call2).setOnClickListener(this);
        view.findViewById(R.id.contact_send_mail1).setOnClickListener(this);
        view.findViewById(R.id.contact_send_mail2).setOnClickListener(this);

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Events, navigation_home.EventsViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Events, navigation_home.EventsViewHolder>
                (Events.class,R.layout.home_event_model, navigation_home.EventsViewHolder.class,query) {
            @Override
            protected void populateViewHolder(navigation_home.EventsViewHolder eventsViewHolder, final Events events, int i) {

                eventsViewHolder.setImage(events.getImageURL());
                eventsViewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getContext(),DisplayEvents.class);
                        intent.putExtra("IMAGEURL",events.getImageURL());
                        intent.putExtra("TITLE",events.getTitle());
                        intent.putExtra("DESCRIPTION",events.getDescription());

                        startActivity(intent);
                    }
                });
            }
        };
        recyclerViewEvents.setAdapter(firebaseRecyclerAdapter);
    }

    public static class EventsViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public EventsViewHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
        }
        public void setImage(final String imageUrl)
        {
            bar_home.setVisibility(View.GONE);
            StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("IMAGES/").child(imageUrl);
            ImageView imageViewRecent = (ImageView)mView.findViewById(R.id.homeModelImage);
            GlideApp.with(mView.getContext())
                    .load(storageReference)
                    .into(imageViewRecent);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.fab_achievements :
                navController.navigate(R.id.action_navigation_home_to_navigation_benefits);
                break;
            case R.id.fab_events :
                navController.navigate(R.id.action_navigation_home_to_navigation_event);
                break;
            case R.id.fab_team :
                navController.navigate(R.id.action_navigation_home_to_navigation_team);
                break;
            case R.id.homeSeeAll :
                navController.navigate(R.id.action_navigation_home_to_navigation_event);
                break;
            case R.id.contact_call1 :
                number = "7864024344";
                makeCall(number);
                break;
            case R.id.contact_call2 :
                number = "9079868390";
                makeCall(number);
                break;
            case R.id.contact_send_mail1 :
                email = "swapism7@gmail.com";
                sendMail(email);
                break;
            case R.id.contact_send_mail2 :
                email = "abhishekraj29011998@gmail.com";
                sendMail(email);
        }
    }

    public void makeCall(String num) {
        if(!num.trim().equals("0")){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num.trim()));
            startActivity(intent);}
        else{
            Toast.makeText(getContext(),"Sorry number not available",Toast.LENGTH_LONG).show();
        }
    }

    public void sendMail(String s) {
        if(!s.trim().isEmpty()) {
            Intent send = new Intent(Intent.ACTION_SENDTO);
            String uriText = "mailto:" + Uri.encode(s.trim()) +
                    "?subject=" + Uri.encode("Subject") +
                    "&body=" + Uri.encode("Your Message");
            Uri uri = Uri.parse(uriText);

            send.setData(uri);
            startActivity(Intent.createChooser(send, "Send mail..."));
        }
        else{
            Toast.makeText(getContext(),"Sorry email not available",Toast.LENGTH_LONG).show();
        }
    }
}