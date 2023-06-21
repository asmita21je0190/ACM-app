package com.acmiitism.acm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExampleTeamAdapter extends RecyclerView.Adapter<ExampleTeamAdapter.ExampleTeamViewHolder> {
    private ArrayList<ExampleforTeam> mExampleList;
    private ArrayList<Pair<String,String>> mLinks;
    String mail,linkedin;
    Context mContext;

    public static class ExampleTeamViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView,mail,linkedin;
        public TextView textName;
        public TextView positionName;

        public ExampleTeamViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.photo);
            textName = itemView.findViewById(R.id.nameTeam);
            positionName = itemView.findViewById(R.id.position);
            mail = itemView.findViewById(R.id.team_mail);
            linkedin = itemView.findViewById(R.id.team_linkedin);
        }
    }

    public ExampleTeamAdapter(ArrayList<ExampleforTeam> exampleList, ArrayList<Pair<String,String>> links, Context context){
        mExampleList = exampleList;
        mLinks = links;
        mContext = context;
    }

    @NonNull
    @Override
    public ExampleTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exampleforteam, parent, false);
        ExampleTeamViewHolder evh = new ExampleTeamViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleTeamViewHolder holder, final int position) {

        ExampleforTeam currentPos = mExampleList.get(position);
        holder.mImageView.setImageResource(currentPos.getmPhoto());
        holder.textName.setText(currentPos.getmName());
        holder.positionName.setText(currentPos.getmPosition());

        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mail = mLinks.get(position).first;

                if(!mail.trim().isEmpty()) {
                    Intent send = new Intent(Intent.ACTION_SENDTO);
                    String uriText = "mailto:" + Uri.encode(mail.trim()) +
                            "?subject=" + Uri.encode("Subject") +
                            "&body=" + Uri.encode("Your Message");
                    Uri uri = Uri.parse(uriText);
                    send.setData(uri);
                    mContext.startActivity(Intent.createChooser(send, "Send mail..."));
                }
                else{
                    Toast.makeText(mContext,"Sorry email not available",Toast.LENGTH_LONG).show();
                }
            }
        });
        holder.linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linkedin = mLinks.get(position).second;
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(linkedin));

                final PackageManager packageManager = mContext.getPackageManager();
                List<ResolveInfo> list = packageManager.queryIntentActivities(intent1,
                        PackageManager.MATCH_DEFAULT_ONLY);

                if (list.size() == 0) {
                    final String urlBrowser = "http://www.linkedin.com/company/" + linkedin;
                    intent1.setData(Uri.parse(urlBrowser));
                }
                mContext.startActivity(intent1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}


