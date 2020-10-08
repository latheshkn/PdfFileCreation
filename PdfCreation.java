package com.mlm.pdfcreaction;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class pdf_new extends AppCompatActivity {
private File pdffile;
    OutputStream outputStream;
    Context context;
    TextView text_view;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_new);
        text_view=findViewById(R.id.text_view);

        text_view.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creaatePdf();
            }
        });

        if (ActivityCompat.checkSelfPermission(pdf_new.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(pdf_new.this, "permission granted", Toast.LENGTH_SHORT).show();
        }else{
            ActivityCompat.requestPermissions(pdf_new.this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }

    }

   public void creaatePdf() {
//        creating folder in external storage
       File docsFolder = new File(Environment.getExternalStorageDirectory() + "/invoice");
//        if the folder already exists it not create otherwise it ll
       if (!docsFolder.exists()) {
           docsFolder.mkdir();
       }

       String pdfname = "Invoice.pdf";
       pdffile = new File(docsFolder.getAbsolutePath(), pdfname);

       try {
           outputStream = new FileOutputStream(pdffile);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }

       Document document = new Document(PageSize.A4);

       PdfPTable table = new PdfPTable(new float[]{2, 6, 4, 6, 4, (float) 5.5, (float) 5.5, 6, (float) 5.5});
       table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       table.getDefaultCell().setFixedHeight(50);
       table.setTotalWidth(PageSize.A4.getWidth());
       table.setWidthPercentage(100);
       table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
       table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
       table.getDefaultCell().setFixedHeight(50);
       table.setTotalWidth(PageSize.A4.getWidth());
       table.setWidthPercentage(100);
       table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
       table.addCell("SL NO");
       table.addCell("PRODUCT");
       table.addCell("BASE PRICE");
       table.addCell("QUANTITY");
       table.addCell("SUB TOTAL");
       table.addCell("CGST");
       table.addCell("SGST");
       table.addCell("DISCOUNT");
       table.addCell("TOTAL");
       table.setHeaderRows(1);
       PdfPCell[] cell = table.getRow(0).getCells();
       for (int j = 0; j < cell.length; j++) {
           cell[j].setBackgroundColor(BaseColor.GRAY);
       }

       table.addCell("1");
       table.addCell("KEYBOARD");
       table.addCell("2582");
       table.addCell("1 BOX");
       table.addCell("2582");
       table.addCell("12.91(.5%)");
       table.addCell("12.91(.5%)");
       table.addCell("26.07(1%)");
       table.addCell("2581.7418");

       PdfPTable table2 = new PdfPTable(new float[]{3, 3});
       table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
       table2.getDefaultCell().setFixedHeight(0);
       table2.setTotalWidth(PageSize.A4.getWidth());
       table2.setWidthPercentage(100);

       table2.getDefaultCell().setVerticalAlignment(Element.ALIGN_RIGHT);
       table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       table2.getDefaultCell().setFixedHeight(40);
       table2.setTotalWidth(PageSize.A4.getWidth());
       table2.setWidthPercentage(100);
       table2.setSpacingAfter(50);
       table2.setSpacingBefore(50);
       table2.setSplitRows(true);
       table2.getDefaultCell().setVerticalAlignment(Element.ALIGN_RIGHT);
       table2.addCell("Subtotal");
       table2.addCell("2582");
       table2.setHeaderRows(1);
       PdfPCell[] cell1 = table2.getRow(0).getCells();
       for (int j1 = 0; j1 < cell1.length; j1++) {
           cell1[j1].setBackgroundColor(BaseColor.GRAY);
       }

       table2.addCell("Tax:");
       table2.addCell("25.82");
       table2.addCell("Discount:");
       table2.addCell("26.0782");
       table2.addCell("Grnd Total:");
       table2.addCell("2581.7418");

       try {
           if (outputStream != null) {
               PdfWriter.getInstance(document, outputStream);
           } else {
               Toast.makeText(pdf_new.this, "outputstream", Toast.LENGTH_SHORT).show();
           }

       } catch (DocumentException e) {
           e.printStackTrace();
       }


       document.open();
       Font f = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.NORMAL, BaseColor.BLACK);
       Font g = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.BOLD, BaseColor.BLACK);
       Font h = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.BOLD, BaseColor.BLACK);
       Font i = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.BOLD, BaseColor.BLACK);
       Font j = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.NORMAL, BaseColor.BLACK);
       Font k = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.BOLD, BaseColor.BLACK);
       Font l = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.NORMAL, BaseColor.BLACK);
       Font m = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.NORMAL, BaseColor.BLACK);
       Font n = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.NORMAL, BaseColor.BLACK);
       Font o = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.NORMAL, BaseColor.BLACK);
       Font p = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.BOLD, BaseColor.BLACK);
       Font q = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.BOLD, BaseColor.BLACK);
       Font r = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.BOLD, BaseColor.BLACK);


       try {
           document.add(new Paragraph("From\n", f));
           document.add(new Paragraph("Email:prapulla.mn@gmail.com\n", g));
           document.add(new Paragraph("Phone:9632589632\n", h));
           document.add(new Paragraph("GSTIn :\n\n", i));
           document.add(new Paragraph("To\n", j));
           document.add(new Paragraph("prapulla\n", k));
           document.add(new Paragraph("mysore\n", l));
           document.add(new Paragraph("Email :prapu@gmail.com\n", m));
           document.add(new Paragraph("Phone :9632589631\n", n));
           document.add(new Paragraph("\t\tGSTIn :18AABCT3518Q1ZV\n\n", o));
           document.add(new Paragraph("\t\tInvoice :pra/20-21/2", p));
           document.add(new Paragraph("\t\tOrder ID: 3", q));
           document.add(new Paragraph("\t\tPayment Type: Cash\n\n", r));
           document.add(table);
           document.add(table2);
       } catch (DocumentException e) {
           e.printStackTrace();
       }
//       Document document1 = new Document(PageSize.A4);
//       document1.open();
//       Font s = new Font(Font.FontFamily.TIMES_ROMAN, 20.0f, Font.BOLD, BaseColor.BLACK);
//       try {
//           document1.add(new Paragraph("Terms And Conditions:\n\n", s));
//       } catch (DocumentException e) {
//           e.printStackTrace();
//       }
//       document1.close();
//       PreviewPdf();

       document.close();
       PreviewPdf();


   }



    private void PreviewPdf(){
       PackageManager packageManager=getPackageManager();
       Intent intent=new Intent(Intent.ACTION_VIEW);
       intent.setType("application/pdf");

       List list= packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
       if (list.size()>0){
//           Intent intent1=new Intent();
//           intent1.setAction(Intent.ACTION_VIEW);
//           Uri uri= Uri.fromFile(pdffile);
//           intent1.setDataAndType(uri,"application/pdf");
//           startActivity(intent1);
       }else{
           Toast.makeText(context, "Donload a pdf viewer", Toast.LENGTH_SHORT).show();
       }

   }
}
