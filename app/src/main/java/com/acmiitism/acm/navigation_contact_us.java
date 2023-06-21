package com.acmiitism.acm;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class navigation_contact_us extends Fragment implements View.OnClickListener{

    //HTextView hTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_navigation_contact_us, container, false);

        view.findViewById(R.id.facebook).setOnClickListener(this);
        view.findViewById(R.id.youtube).setOnClickListener(this);
        view.findViewById(R.id.linkedin).setOnClickListener(this);
        view.findViewById(R.id.instagram).setOnClickListener(this);

        /*hTextView = (HTextView) view.findViewById(R.id.reach);
        hTextView.setAnimateType(HTextViewType.TYPER);
        hTextView.animateText("Reach us at...");*/

        return view;

    }

    public static String FACEBOOK_URL = "https://www.facebook.com/acm.iitismdhn";
    public static String FACEBOOK_PAGE_ID = "acm.iitismdhn";

    //method to get the right URL to use in the intent
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.facebook:
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFacebookPageURL(getContext());
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);
                break;
            case R.id.youtube :
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/channel/UCaXEPdTHm08sxKlTJjRVxJA"));
                startActivity(intent);
                break;
            case R.id.linkedin :
                String pageId = "acm-student-chapter-iit-ism-dhanbad";
                final String linkedinUrl = "linkedin://" + pageId;
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(linkedinUrl));

                final PackageManager packageManager = getContext().getPackageManager();
                List<ResolveInfo> list = packageManager.queryIntentActivities(intent1,
                        PackageManager.MATCH_DEFAULT_ONLY);

                if (list.size() == 0) {
                    final String urlBrowser = "http://www.linkedin.com/company/" + pageId;
                    intent1.setData(Uri.parse(urlBrowser));
                }
                this.startActivity(intent1);
                break;
            case R.id.instagram :
                Uri uri = Uri.parse("http://instagram.com/_u/acm_iitism/");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
                likeIng.setPackage("com.insta.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/acm_iitism/")));
                }


        }
    }
}