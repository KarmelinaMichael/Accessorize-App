package com.example.km.accessorize;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import android.support.v7.app.ActionBarActivity;


public class categories extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        initList();

        ListView lv = (ListView) findViewById(R.id.listView);

        SimpleAdapter simpleAdpt = new SimpleAdapter(this, categoriesList, android.R.layout.simple_list_item_1, new String[] {
                "category"}, new int[] {android.R.id.text1});

        lv.setAdapter(simpleAdpt);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,long id) {

                if(position==0){
                    Intent int0 = new Intent(getApplicationContext(),Abstract.class);
                    startActivity(int0);
                }
               else if(position==1){
                    Intent int0 = new Intent(getApplicationContext(),Animals.class);
                    startActivity(int0);
                }
              else  if(position==2){
                    Intent int0 = new Intent(getApplicationContext(),Flowers.class);
                    startActivity(int0);
                }
             else  if(position==3){
                   Intent int0 = new Intent(getApplicationContext(),Nature.class);
                   startActivity(int0);
               }
                else  if(position==4){
                    Intent int0 = new Intent(getApplicationContext(),Love.class);
                    startActivity(int0);
                }
                else  if(position==5){
                    Intent int0 = new Intent(getApplicationContext(),Cartoons.class);
                    startActivity(int0);
                }
                else  {
                    Intent int0 = new Intent(getApplicationContext(),Sports.class);
                    startActivity(int0);
                }

            }

        });

    }



    List<Map<String, String>> categoriesList = new ArrayList<Map<String,String>>();

    private void initList() {

        categoriesList.add(createCategory("category", "Abstract"));

        categoriesList.add(createCategory("category", "Animals"));

        categoriesList.add(createCategory("category", "Flowers"));

        categoriesList.add(createCategory("category", "Nature"));

        categoriesList.add(createCategory("category", "Love"));

        categoriesList.add(createCategory("category", "Cartoons"));

        categoriesList.add(createCategory("category", "Sports"));

    }

    private HashMap<String, String> createCategory(String key, String name) {

        HashMap<String, String> category = new HashMap<String, String>();

        category.put(key, name);

         return category;
           }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categories, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
