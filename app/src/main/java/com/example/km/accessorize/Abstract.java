package com.example.km.accessorize;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.IOException;
import java.io.InputStream;

//import android.support.v7.app.ActionBarActivity;


public class Abstract extends Activity {

    private GridView gridView;
    private GridView gridView1;

    private ImageAdapter gridAdapter;



    final Context context = this;
    String one;


    //Array de String que contiene las URL de las imágenes externas que usemos
    // String[] text = readFileFromAssets("nimages.txt",context).split(" ");

 /* String[] items = {

            "http://static.panoramio.com/photos/large/116726502.jpg",
            "http://static.panoramio.com/photos/large/116726502.jpg",
            "http://static.panoramio.com/photos/large/116726502.jpg",
            "http://static.panoramio.com/photos/large/116726502.jpg",
            "http://static.panoramio.com/photos/large/116726502.jpg"
    };*/




    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nature);
        InputStream stream = null;
        try {
            stream = getAssets().open("abstract.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int size = 0;
        try {
            size = stream.available();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[size];
        try {
            stream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = new String(buffer);
        final String [] item=text.split(",");

        gridView = (GridView) findViewById(R.id.gridView);
        //  gridView1 = (GridView) findViewById(R.id.thumbImage1);

        gridAdapter = new ImageAdapter(Abstract.this, item);

        // i=(ImageView) findViewById(R.id.thumbImage);

        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,long id) {
                try {
    /* your code */  one=item[position];
                    // getItem();
                    ImageView1  i=new ImageView1();
                    Intent intent = new Intent(getApplicationContext(), ImageView1.class);
                    intent.putExtra("firstKeyName",item[position]);

                    startActivity(intent);
                    // gridView1.setAdapter(imageAdapter);



                } catch ( ActivityNotFoundException e) {
                    e.printStackTrace();
                }



            }

        });





    }

    public String getItem(){
        return one;

    }

 /* public String readFileFromAssets(String fileName, Context c) {
        InputStream input;
        String text = null;
        AssetManager assetManager = c.getAssets();
        try {
            input = assetManager.open(fileName);
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            buffer.toString();
            input.close();
            // byte buffer into a string
            text = new String(buffer);
        } catch (IOException e) {

            e.printStackTrace();
        }
        return text;
    }
*/

}
