package com.example.pdfuploadactivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class pdf extends AppCompatActivity {
private File pdffile;
    OutputStream outputStream;
    Context context;
    TextView text_view;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        text_view=findViewById(R.id.text_view);

        text_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creaatePdf();
            }
        });
    }

   public void creaatePdf()  {
//        creating folder in external storage
        File docsFolder=new  File(Environment.getExternalStorageDirectory()+ "/invoice");
//        if the folder already exists it not create otherwise it ll
        if (!docsFolder.exists()){
            docsFolder.mkdir();
        }

        String pdfname="Invoice.pdf";
        pdffile=new File(docsFolder.getAbsolutePath(),pdfname);
       try {
           outputStream=new FileOutputStream(pdffile);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       Document document=new Document(PageSize.A4);
       PdfPTable table =new PdfPTable(new float[] {3,3,3,3,3});
       table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
       table.getDefaultCell().setFixedHeight(50);
       table.setTotalWidth(PageSize.A4.getWidth());
       table.setWidthPercentage(100);
       table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
       table.addCell("Invoice");
       table.addCell("1234");
       table.addCell("type");
       table.addCell("url");
       table.addCell("Date");
       table.setHeaderRows(1);
       PdfPCell[] cell=table.getRow(0).getCells();
       for (int j=0;j<cell.length;j++){
           cell[j].setBackgroundColor(BaseColor.GRAY);
       }

       table.addCell("lathesh");
       table.addCell("price");
       table.addCell("type");
       table.addCell("url");
       table.addCell("date");

       try {
           if (outputStream!=null){
               PdfWriter.getInstance(document,outputStream);
           }else{
               Toast.makeText(pdf.this, "outputstream", Toast.LENGTH_SHORT).show();
           }

       } catch (DocumentException e) {
           e.printStackTrace();
       }
   document.open();
       Font f=new Font(Font.FontFamily.TIMES_ROMAN,30.0f,Font.UNDEFINED,BaseColor.BLUE);
       Font g=new Font(Font.FontFamily.TIMES_ROMAN,20.0f,Font.NORMAL,BaseColor.BLUE);
       try {
           document.add(new Paragraph("pdf Data\n\n",f));
           document.add(new Paragraph("pdf File Through itext\n\n",g));
           document.add(table);
       } catch (DocumentException e) {
           e.printStackTrace();
       }


       document.close();
       PreviewPdf();
   }

   private void PreviewPdf(){
       PackageManager packageManager=getPackageManager();
       Intent intent=new Intent(Intent.ACTION_VIEW);
       intent.setType("application/pdf");

       List list= packageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);
       if (list.size()>0){
           Intent intent1=new Intent();
           intent1.setAction(Intent.ACTION_VIEW);
           Uri uri= Uri.fromFile(pdffile);
           intent1.setDataAndType(uri,"application/pdf");
           startActivity(intent1);
       }else{
           Toast.makeText(context, "Donload a pdf viewer", Toast.LENGTH_SHORT).show();
       }

   }
}