package com.kite.joco.retrooldfileupload;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kite.joco.retrooldfileupload.rest.OldFileService;

import java.io.File;
import java.util.Date;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;

public class MainActivity extends AppCompatActivity {

    private static final int SELECT_PICTURE = 1;

    private String selectedImagePath;
    private ImageView img;
    private TextView tvPicturePath;
    private String res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvPicturePath = (TextView) findViewById(R.id.tvKepPath);
    }

    public void onClick(View v){
        switch (v.getId()){
            case (R.id.btnSelect):
                selectFromGallery();
                break;
            case (R.id.btnSend):
                sendPicOld();
                break;
            default:
        }
    }

    public void selectFromGallery(){
        //if (Build.VERSION.SDK_INT < 19) {
            Intent selectIntent = new Intent();
            selectIntent.setType("image/*");
            selectIntent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(selectIntent, "Válassz ki egy képet"), SELECT_PICTURE);
        /*}
        else {
            Intent selectIntent = new Intent();
            selectIntent.addCategory(Intent.CATEGORY_OPENABLE);
            selectIntent.setType("image/jpeg");
            startActivityForResult(selectIntent, SELECT_PICTURE);
        }*/
    }
    /*
    if (Build.VERSION.SDK_INT <19){
    Intent intent = new Intent();
    intent.setType("image/jpeg");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(Intent.createChooser(intent, getResources().getString(R.string.select_picture)),GALLERY_INTENT_CALLED);
} else {
    Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
    intent.addCategory(Intent.CATEGORY_OPENABLE);
    intent.setType("image/jpeg");
    startActivityForResult(intent, GALLERY_KITKAT_INTENT_CALLED);
}
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("ONACTRES", "STARTED");
        if (resultCode == RESULT_OK){
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                Log.i("ONACTRES","getPath jön");
                selectedImagePath = getPath(selectedImageUri);
                Log.i("Path of image ",selectedImagePath);
                if (!selectedImagePath.equals(null)) {
                    tvPicturePath.setText(selectedImagePath);
                }
                else
                    tvPicturePath.setText("Null lett???");
            }
        }
    }
    /*
     Cursor cursor = getContentResolver().query(_uri, new String[] { android.provider.MediaStore.Images.ImageColumns.DATA }, null, null, null);
                cursor.moveToFirst();

                //Link to the image
                final String imageFilePath = cursor.getString(0);
     */

    /*
    String[] fileSizeColumn = { OpenableColumns.SIZE };

Cursor cursor = getContentResolver().query(selectedImage,
            fileSizeColumn, null, null, null);
cursor.moveToFirst();

int sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE);
String size = cursor.getString(sizeIndex);
cursor.close();

ObjectMetadata metadata = new ObjectMetadata();
metadata.setContentType(getContentResolver().getType(selectedImage));
if(size != null){
    metadata.setContentLength(Long.parseLong(size));
}
     */

    public String getPath(Uri uri){
       // String [] projection = {OpenableColumns.SIZE};
        String [] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor.moveToFirst()) {
            //int column_index = cursor.getColumnIndex(OpenableColumns.SIZE);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index); // original was column_index
        }
        cursor.close();
        Log.i("Filepath",res);
        return res;
    }

    public void sendPicOld(){
        //Toast.makeText(this,"Ezt fogja elküldeni: "+selectedImagePath,Toast.LENGTH_LONG).show();
        File file = new File(selectedImagePath);
        //OldFIleApi fileAPIService = OldFileService.get.(OldFIleApi.class);

        TypedFile typedFile = new TypedFile("multipart/form-data", file);

        //RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);

  /*      try {
            OldFileService.get().upload(typedFile, new Callback<String>() {
                @Override
                public void success(String s, Response response) {
                    Log.i("UPLOAD","Succes");
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.e("UPLOAD","failure "+error.getResponse());
                }
            });

        } catch (Exception ex ){
            System.out.println(ex.getStackTrace());
        }*/

        try {
            OldFileService.get().datumkuld(new Date(), new Callback<String>() {
                @Override
                public void success(String s, Response response) {
                    Log.i("Datumos","send date");
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.i("Datumos"," problem "+ error.getResponse());
                }
            });
        }
        catch ( Exception ex){

        }

    }


}
