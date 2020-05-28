package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int pic_id = 12;
    Button cam;
    ImageView img_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cam = (Button)findViewById(R.id.btn1);
       img_view = (ImageView)findViewById(R.id.img);
       cam.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent camera_intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(camera_intent, pic_id);
           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == pic_id) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            img_view.setImageBitmap(photo);
        }
    }
}
