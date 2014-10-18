package com.androidhackathongdggrancanaria.checkhomework;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {
	

	private ArrayList<Task> tasks;
	private Context context;
	
	public GridViewAdapter(Context context, ArrayList<Task> tasks) {
		this.context = context;
		this.tasks = tasks;
	}
	
	@Override
	public int getCount() {
		return tasks.size();
	}

	@Override
	public Task getItem(int position) {
		return tasks.get(position);
	}

	@Override
	public long getItemId(int position) {
		return tasks.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_item, null);
        }
		TextView tvAsignatura = (TextView) convertView.findViewById(R.id.tvAsignatura);
		TextView tvDescripcion = (TextView) convertView.findViewById(R.id.tvDescripcion);
		tvAsignatura.setText(tasks.get(position).getSubject());
		tvDescripcion.setText(tasks.get(position).getDescription());
		if (tasks.get(position).isDone()) {
			((ImageView) convertView.findViewById(R.id.ivCheckItem)).setVisibility(View.VISIBLE);
		}
		
		return convertView;
	}

}
