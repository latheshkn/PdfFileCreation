package com.example.pdfuploadactivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText edt_name,edt_cmp,edt_item1,edt_item2;
    Spinner spinner_iten,spinner_iten2;
    Button btn_generate;
    Bitmap bitmap,scaledbtmp;
    int pageWidth=1200;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_name=findViewById(R.id.edt_name);
        edt_cmp=findViewById(R.id.edt_cmp);
        edt_item1=findViewById(R.id.edt_item1);
        edt_item2=findViewById(R.id.edt_item2);
        btn_generate=findViewById(R.id.btn_generate);
        spinner_iten=findViewById(R.id.spinner_iten);
        spinner_iten2=findViewById(R.id.spinner_iten2);
        btn_generate=findViewById(R.id.btn_generate);

        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.music_bg);
        scaledbtmp=Bitmap.createScaledBitmap(bitmap,1200,518,false);
        CreatePDF();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void CreatePDF() {
        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (edt_name.getText().toString().length()==0 ||
//                        edt_cmp.getText().toString().length()==0 ||
//                        edt_item1.getText().toString().length()==0 ||
//                        edt_item2.getText().toString().length()==0
//                        ){
//                    Toast.makeText(MainActivity.this, "some fields are empty", Toast.LENGTH_SHORT).show();
//                }else{
//                    PdfDocument pdfDocument=new PdfDocument();
//                    Paint paint=new Paint();
////                    to add the titile
//                    Paint Titlepaint=new Paint();
//
//                    PdfDocument.PageInfo pageInfo=new PdfDocument.PageInfo.Builder(1200,2010,1).create();
//                    PdfDocument.Page mypage=pdfDocument.startPage(pageInfo);
//                    Canvas canvas=mypage.getCanvas();
//                     canvas.drawBitmap(scaledbtmp,0,0,paint);
//
//                     Titlepaint.setTextAlign(Paint.Align.CENTER);
//                     Titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
//                     Titlepaint.setTextSize(70);
//                     canvas.drawText("Diamond Pizza",pageWidth/2,270,Titlepaint);
//
//                     paint.setColor(Color.rgb(0,113,188));
//                     paint.setTextSize(30f);
//                     paint.setTextAlign(Paint.Align.RIGHT);
//                     canvas.drawText("call-8792130224",1160,40,paint);
//
//                     canvas.drawText("8792130224",1160,40,paint);
//                     Titlepaint.setTextAlign(Paint.Align.CENTER);
//                     Titlepaint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.ITALIC));
//                     Titlepaint.setTextSize(70);
//                     canvas.drawText("Invoice",pageWidth/2,500,Titlepaint);
//
//                     paint.setTextAlign(Paint.Align.LEFT);
//                     paint.setTextSize(35f);
//                     paint.setColor(Color.BLACK);
//                     canvas.drawText("Customer Name"+edt_name.getText(),20,590,paint);
//                     canvas.drawText("Contact number"+edt_cmp.getText(),20,640,paint);
//
//                    pdfDocument.finishPage(mypage);
//
//                    File file=new File(Environment.getExternalStorageDirectory(),"/hello.pdf");
//
//                    try {
//                        pdfDocument.writeTo(new FileOutputStream(file));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    pdfDocument.close();
//                }


            }
        });


    }


}