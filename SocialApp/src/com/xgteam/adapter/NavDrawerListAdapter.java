package com.xgteam.adapter;

import java.util.ArrayList;

import com.xgteam.model.NavDrawerItem;
import com.xgteam.socialapp.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavDrawerListAdapter extends BaseAdapter{
	private Context context;
	private ArrayList<NavDrawerItem> items;
	
	public NavDrawerListAdapter(Context context,ArrayList<NavDrawerItem> items){
		this.context = context;
		this.items = items;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return items.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }
		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);
        
        imgIcon.setImageResource(items.get(position).getIcon());        
        txtTitle.setText(items.get(position).getTitle());
        
        if(items.get(position).isCounterVisible()){
            txtCount.setText("+" + items.get(position).getCount());
        }else{
            // hide the counter view
            txtCount.setVisibility(View.GONE);
        }
         
        return convertView;
	}

}
