package com.xgteam.socialapp;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Text;

import com.xgteam.model.*;
import com.xgteam.userwalllist.UserWallListAdapter;
import com.xgteam.userwalllist.UserWallListAdapter;
import com.xgteam.userwalllist.UserWallListModel;
import com.xgteam.utils.DownloadImageTask;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.LayoutDirection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class HomeFragment extends Fragment {
	private  ArrayList<UserWallListModel> userWallList = new ArrayList<UserWallListModel>();
	
	public HomeFragment(){}
	
	@SuppressWarnings("unused")
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		ListView listview =(ListView)rootView.findViewById(R.id.userWall);
		
		for (int i = 0; i < 11; i++) {
            
            final UserWallListModel sched = new UserWallListModel();
                 
              /******* Firstly take data in model object ******/
               sched.setUserName("Andrew "+i);
               //sched.setImage("image"+i);
               sched.setText("http:\\www."+i+".com");
                
            /******** Take Model Object in ArrayList **********/
               userWallList.add( sched );
        }
		
		Resources res =getResources();
		//ArrayAdapter<UserWallListModel> adapter =
		           new ArrayAdapter<UserWallListModel>(getActivity(), R.layout.user_wall_list_item, userWallList);
		UserWallListAdapter adapter=new UserWallListAdapter( this.getActivity(), userWallList,res );
		listview.setAdapter( adapter );
		//ImageView userPicture = (ImageView)rootView.findViewById(R.id.profilePicture);
		
        return rootView;
    }

}
