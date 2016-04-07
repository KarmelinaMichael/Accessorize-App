package com.example.km.accessorize;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;



public class ImageAdapter extends BaseAdapter{



    private Context context;

    private String[] items;



    //Constructor de dos parámetros

    public ImageAdapter(Context context, String[] items){

        super();

        this.context = context;

        this.items = items;

    }



    //Obetenemos la cantidad de imágenes

    @Override

    public int getCount() {

        return items.length;

    }



    //Obtenemos el objeto a partir de su posición

    @Override

    public Object getItem(int position) {

        return items[position];

    }



    @Override

    public long getItemId(int position) {

        return position;

    }



    //Generamos la vista

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

               ImageView img = null;

        if (convertView == null) {
            img = new ImageView(context);
            convertView = img;

            img.setPadding(5, 5, 5, 5);

        } else {

            img = (ImageView) convertView;

        }





        //Uso de la librería Picasso

        Picasso.with(context).load(items[position])
                .placeholder(R.drawable.loading4)
                .resize(300, 500)
                .into(img);
        Picasso.with(this.context).setLoggingEnabled(true);



        return convertView;

    }



}

