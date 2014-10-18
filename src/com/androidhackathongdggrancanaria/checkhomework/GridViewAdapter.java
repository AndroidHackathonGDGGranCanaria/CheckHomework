package com.androidhackathongdggrancanaria.checkhomework;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {
	
	private HashMap<String, Subjects> subsjects = getAllSubjects();
	private ArrayList<Task> tasks;
	private Context context;
	
	public GridViewAdapter(Context context, ArrayList<Task> tasks) {
		this.context = context;
		this.tasks = tasks;
	}
	
	private HashMap<String, Subjects> getAllSubjects() {
		HashMap<String, Subjects> res = new HashMap<String, Subjects>();
		res.put("MAT", Subjects.MATHEMATICS);
		res.put("SCI", Subjects.SCIENS);
		res.put("LAN", Subjects.LANGUAGE);
		res.put("ENG", Subjects.ENGLISH);
		return res;
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
		tvAsignatura.setText(subsjects.get(tasks.get(position).getSubject()).getName());
		
		((LinearLayout) convertView.findViewById(R.id.llCell))
		.setBackgroundColor(context.getResources().getColor(subsjects.get(tasks.get(position).getSubject()).getColor()));
		
		tvDescripcion.setText(tasks.get(position).getDescription());
		if (tasks.get(position).isDone()) {
			((ImageView) convertView.findViewById(R.id.ivCheckItem)).setVisibility(View.VISIBLE);
		}
		
		return convertView;
	}

}
