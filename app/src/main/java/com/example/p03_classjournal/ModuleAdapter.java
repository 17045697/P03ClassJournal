package com.example.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter<module> {
    private ArrayList<module> module;
    private Context context;
    private TextView tvWeek;
    private TextView tvGrade;
    private  TextView tvDG;
    private ImageView imageView;

    public ModuleAdapter(Context context, int resource, ArrayList<module> objects){
        super(context,resource,objects);
        module = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvWeek = rowView.findViewById(R.id.textViewWeek);
        imageView = rowView.findViewById(R.id.imageView1);
        tvGrade = rowView.findViewById(R.id.textViewGrade);
        tvDG = rowView.findViewById(R.id.textViewDaily);

        module currentModule = module.get(position);

        tvWeek.setText("Week " + currentModule.getWeek());
        tvGrade.setText(currentModule.getGrade());
        imageView.setImageResource(R.drawable.dg);
        tvDG.setText("DG");
        return rowView;
    }
 }
