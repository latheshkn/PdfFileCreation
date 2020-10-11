//package com.example.pdfuploadactivity;
//
//import android.Manifest;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Paint;
//import android.os.Bundle;
//import android.os.Environment;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//
//import com.example.pdfuploadactivity.Json.Api;
//import com.example.pdfuploadactivity.Json.BaseClient;
//import com.example.pdfuploadactivity.Json.JobData;
//import com.example.pdfuploadactivity.Json.JobResponse;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.MalformedURLException;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class PDFactivity extends AppCompatActivity {
//    //        https://www.youtube.com/watch?v=0mXHCoKOd9I&feature=youtu.be
////        video refrence
//    private File pdffile;
//    OutputStream outputStream;
//    Context context;
//    TextView text_view;
//    String jobId,jobTitle,location,experience,companyName,role;
//
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_p_d_factivity);
//        text_view=findViewById(R.id.text_view_pdf);
//
//        text_view.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                creaatePdf();
//            }
//        });
//
//        if (ActivityCompat.checkSelfPermission(PDFactivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
//            Toast.makeText(PDFactivity.this, "permission granted", Toast.LENGTH_SHORT).show();
//        }else{
//            ActivityCompat.requestPermissions(PDFactivity.this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
//        }
//
//    }
//
//    public void creaatePdf() {
//
//        Api api = BaseClient.getBaseClient().create(Api.class);
//        Call<JobResponse> call = api.searchJob("p","");
//        call.enqueue(new Callback<JobResponse>() {
//            @Override
//            public void onResponse(Call<JobResponse> call, Response<JobResponse> response) {
//                JobResponse jobResponse = response.body();
//
//                if (response.isSuccessful() && jobResponse.getStatus().equals("1")){
//
//
//                    List<JobData> jobData = jobResponse.getData();
//
//                    for(int i = 0; i<jobData.size(); i++) {
//                        jobId = jobData.get(i).getJob_id();
//                        jobTitle = jobData.get(i).getJob_title();
//                        location = jobData.get(i).getLocation();
//                        experience = jobData.get(i).getExperience();
//                        companyName = jobData.get(i).getCompany_name();
//                        role = jobData.get(i).getRole();
//                    }
//
//                    Toast.makeText(PDFactivity.this, jobId + " on Success "+ jobTitle, Toast.LENGTH_SHORT).show();
//
//                }else{
//                    Toast.makeText(PDFactivity.this, "Wromg", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<JobResponse> call, Throwable t) {
//                Toast.makeText(PDFactivity.this, "On Failure", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
////        creating folder in external storage
//        File docsFolder = new File(Environment.getExternalStorageDirectory() + "/invoice");
////        if the folder already exists it not create otherwise it ll
//        if (!docsFolder.exists()) {
//            docsFolder.mkdir();
//        }
//
//        String pdfname = "Invoice.pdf";
//        pdffile = new File(docsFolder.getAbsolutePath(), pdfname);
//
//        try {
//            outputStream = new FileOutputStream(pdffile);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Document document = new Document(PageSize.A4);
//
//        PdfPTable table = new PdfPTable(new float[]{2, 6, 4});
//
//        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.getDefaultCell().setFixedHeight(50);
//        table.setTotalWidth(PageSize.A4.getWidth());
//        table.setWidthPercentage(100);
//        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
//        table.getDefaultCell().setFixedHeight(50);
//        table.setTotalWidth(PageSize.A4.getWidth());
//        table.setWidthPercentage(100);
//        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell("SL NO");
//        table.addCell("PRODUCT");
//        table.addCell("BASE PRICE");
//
//        table.setHeaderRows(1);
//
//        PdfPCell[] cell = table.getRow(0).getCells();
//        for (int j = 0; j < cell.length; j++) {
//            cell[j].setBackgroundColor(BaseColor.GRAY);
//        }
//        Toast.makeText(PDFactivity.this, jobId + " "+ jobTitle, Toast.LENGTH_SHORT).show();
//
//        table.addCell(jobId);
//        table.addCell(jobTitle);
//        table.addCell(location);
//
//        try {
//            if (outputStream != null) {
//                PdfWriter.getInstance(document, outputStream);
//            } else {
//                Toast.makeText(PDFactivity.this, "outputstream", Toast.LENGTH_SHORT).show();
//            }
//
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//
//
//        document.open();
//        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.NORMAL, BaseColor.BLACK);
//
//
//        try {
//            document.add(new Paragraph("From\n", f));
//            document.add(new Paragraph("Email:prapulla.mn@gmail.com\n", f));
//            document.add(new Paragraph("Phone:9632589632\n", f));
//            document.add(new Paragraph("GSTIn :\n\n", f));
//            document.add(new Paragraph("To\n", f));
//            document.add(new Paragraph("prapulla\n", f));
//            document.add(new Paragraph("mysore\n", f));
//            document.add(new Paragraph("Email :prapu@gmail.com\n", f));
//            document.add(new Paragraph("Phone :9632589631\n", f));
//            document.add(new Paragraph("\t\tGSTIn :18AABCT3518Q1ZV\n\n", f));
//
//
//            Paragraph paragraph=new Paragraph("Invoice :pra/20-21/2\n",f);
//            paragraph.setAlignment(Element.ALIGN_RIGHT);
//            document.add(paragraph);
//
//            Paragraph paragraporder=new Paragraph("Order id: 3",f);
//            paragraporder.setAlignment(Element.ALIGN_RIGHT);
//            document.add(paragraporder);
//
//
//            Paragraph pr= new Paragraph("Payment Type: Cash\n\n", f);
//            pr.setAlignment(Element.ALIGN_RIGHT);
//
//            document.add(pr);
//            InputStream ims = getAssets().open("music_bg.jpg");
//            Bitmap bmp = BitmapFactory.decodeStream(ims);
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            Image image = Image.getInstance(stream.toByteArray());
//            image.setAbsolutePosition(250f,750f);
//
//            image.scaleToFit(300,78);
//            document.add(image);
//            document.add(table);
//
//
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        document.close();
//
//
//
//    }
//
//
//
//}