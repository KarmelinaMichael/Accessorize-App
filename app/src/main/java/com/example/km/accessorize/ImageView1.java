package com.example.km.accessorize;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;


//import android.support.v7.app.ActionBarActivity;


public class ImageView1 extends Activity {
    static int fCount = 0;
    private ImageView i;

    final Context context = this;
    private EditText result;
    File file;

    //Array de String que contiene las URL de las imágenes externas que usemos
    // String[] text = readFileFromAssets("nimages.txt",context).split(" ");

String item;


    Nature n=new Nature();
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image_view1);

         Intent intent = getIntent();
        item = intent.getStringExtra("firstKeyName");

      i=(ImageView) findViewById(R.id.imageview);
        Picasso.with(context)

                .load(item)
                .resize(450,550)
                .placeholder(R.drawable.loading)

                .into(i);
        Picasso.with(this.context).setLoggingEnabled(true);
        addListenerOnButton();




        //gridView1.setAdapter(imageAdapter);


      //  i= (ImageView) findViewById(R.id.imageview);

       // imageAdapter = new ImageAdapter1(ImageView1.this, items);

    //  imageAdapter=new ImageAdapter1(ImageView1.this,item);

     /*   Picasso.with(context).load(item)
                .placeholder(R.mipmap.ic_launcher)
                .resize(500,700)
                .into(i);
        Picasso.with(this.context).setLoggingEnabled(true); */





    }
    private final String PATH = "Accessorize";  //put the downloaded file here
    int ii=0;
    public void addListenerOnButton() {
        final Context context = this;
        Button button = (Button) findViewById(R.id.button1);
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        button.setOnClickListener(

                new Button.OnClickListener() {

                    public void onClick(View arg0) {

                        //  DownloadFromUrl(item,PATH);
                        URL url = null;
                        InputStream input = null;

                        try {
                            url = new URL(item);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }

                        try {
                            try {
                                url = new URL(item);
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }

                            try {
                                input = url.openStream();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
//The sdcard directory e.g. '/sdcard' can be used directly, or
//more safely abstracted with getExternalStorageDirectory()
//
                            long startTime = System.currentTimeMillis();
                            Log.d("ImageManager", "download begining");
                            Log.d("ImageManager", "download url:" + url);


                            File storagePath = Environment.getExternalStorageDirectory();

                            //note a single Random object is reused here


                            file = new File(Environment.getExternalStorageDirectory()
                                    + File.separator + "/image" + String.valueOf(fCount++) + ".jpg");
    if (file.exists() && !file.isDirectory()) {



        alertDialog.setTitle("Warning");
                            alertDialog.setMessage("An image has the same name\nDo you want to replace it?");
                            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

// here you can add functions
                                }
                            });

                            alertDialog.setButton2("Rename", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    LayoutInflater li = LayoutInflater.from(context);
                                    View promptsView = li.inflate(R.layout.dialog, null);

                                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                            context);

                                    // set prompts.xml to alertdialog builder
                                    alertDialogBuilder.setView(promptsView);

                                    final EditText userInput = (EditText) promptsView
                                            .findViewById(R.id.editTextDialogUserInput);

                                    // set dialog message
                                    alertDialogBuilder
                                            .setCancelable(false)
                                            .setPositiveButton("OK",
                                                    new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            // get user input and set it to result
                                                            // edit text
                                                            result.setText(userInput.getText());
                                                            file = new File(Environment.getExternalStorageDirectory()
                                                                    + File.separator + "/" + result + String.valueOf(fCount++) + ".jpg");
                                                        }
                                                    })
                                            .setNegativeButton("Cancel",
                                                    new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int id) {
                                                            dialog.cancel();
                                                        }
                                                    });

                                    // create alert dialog
                                    AlertDialog alertDialog = alertDialogBuilder.create();

                                    // show it
                                    alertDialog.show();

                                }


                            });

                            alertDialog.setIcon(R.mipmap.ic_launcher);
                            alertDialog.show();
                        }


                            OutputStream output = new FileOutputStream(file);
                            try {
                                int aReasonableSize = 100;
                                byte[] buffer = new byte[aReasonableSize];
                                int bytesRead = 0;
                                while ((bytesRead = input.read(buffer, 0, buffer.length)) >= 0) {
                                    output.write(buffer, 0, bytesRead);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    output.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                input.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }


                    }
                });


    }






  /*public void DownloadFromUrl(String imageURL, String fileName) {  //this is the downloader method

        try {
            URL url = new URL( imageURL); //you can write here any link
                    File file = new File(context.getFilesDir(), fileName);

            long startTime = System.currentTimeMillis();
            Log.d("ImageManager", "download begining");
            Log.d("ImageManager", "download url:" + url);
            Log.d("ImageManager", "downloaded file name:" + fileName);
                        // Open a connection to that URL.
            URLConnection ucon = url.openConnection();

                        //        Define InputStreams to read from the URLConnection.

            InputStream is = ucon.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);

                        //    Read bytes to the Buffer until there is nothing more to read(-1).

            ByteArrayBuffer baf = new ByteArrayBuffer(50);
            int current = 0;
            while ((current = bis.read()) != -1) {
                baf.append((byte) current);
            }

                        // Convert the Bytes read to a String.
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baf.toByteArray());
            fos.close();
            Log.d("ImageManager", "download ready in"
                    + ((System.currentTimeMillis() - startTime) / 1000)
                    + " sec");

        } catch (IOException e) {
            Log.d("ImageManager", "Error: " + e);
        }

    }*/


}
