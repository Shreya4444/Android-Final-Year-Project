package com.technotalkative.beproject.Individual;

/**
 * Created by ADMIN on 27/03/2017.
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.technotalkative.beproject.R;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.technotalkative.beproject.Constants;
import com.technotalkative.beproject.R;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.io.IOException;
import java.util.UUID;



public class Indi_UP extends AppCompatActivity {
    EditText name, email, phone, user, pass,addr,help,amount,reason;
    private ImageView pp;
    private ImageView pan,aadhar,certificate;
    private EditText editText;
    private int PICK_IMAGE_REQUEST = 1;

    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;

    //Bitmap to get image from gallery
    private Bitmap bitmap,bitmap2,bitmap3,bitmap4;

    private Uri filePath,filePath2,filePath3,filePath4;

    Button register;
    private    int t=0;

    String u_name,st_username,st_password,st_emailid,st_phoneno,st_help,st_amount,st_address,st_reason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indi__up);

        name = (EditText) findViewById(R.id.i2name);
        email = (EditText) findViewById(R.id.i2email);
        phone = (EditText) findViewById(R.id.i2phone);
        user = (EditText) findViewById(R.id.i2username);
        pass = (EditText) findViewById(R.id.i2password);
        addr = (EditText) findViewById(R.id.i2address);
        help = (EditText) findViewById(R.id.i2need);
        amount=(EditText)findViewById(R.id.i2amount);
        reason=(EditText)findViewById(R.id.i2reason);
        pp=(ImageView)findViewById(R.id.i2profile_pic);
        pan=(ImageView)findViewById(R.id.i2pan);
        aadhar=(ImageView)findViewById(R.id.i2aadhar);
        register=(Button)findViewById(R.id.i2register);
        editText = (EditText) findViewById(R.id.i2username);

        requestStoragePermission();

        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==pp) {
                    showFileChooser1();
                }
                t=1;
            }

        });


        pan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==pan) {
                    showFileChooser2();
                }
                t=2;
            }

        });

        aadhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==aadhar) {
                    showFileChooser3();
                }
                t=3;
            }

        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == register) {
                    System.out.println("HELLO");
                    onReg(v);
                }

            }
        });


    }
    public void onReg(View view) {

        u_name = name.getText().toString();
        st_username = user.getText().toString();
        st_password = pass.getText().toString();
        st_emailid = email.getText().toString();
        st_phoneno = phone.getText().toString();
        st_address = addr.getText().toString();
        st_help = help.getText().toString();
        st_amount = amount.getText().toString();
        st_reason = reason.getText().toString();
        if (!validate()) {
            Toast.makeText(this, "Signup failure", Toast.LENGTH_SHORT).show();
        } else {
            String type = "registerup";
            uploadMultipart1();
            uploadMultipart2();
            uploadMultipart3();
            BackgroundWorkerI backgroundWorker = new BackgroundWorkerI(this);
            backgroundWorker.execute(type, u_name, st_username, st_password, st_address, st_emailid, st_phoneno,st_help,st_amount,st_reason);

        }
    }

    public boolean validate()
    {
        boolean valid=true;
        if(u_name.isEmpty() || u_name.length()>50) {
            name.setError("Please Enter valid name");
            valid=false;
        }

        if(st_emailid.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(st_emailid).matches())
        {
            email.setError("Please enter valid email address");
            valid=false;
        }
        if(st_password.isEmpty() || st_password.length()>12)
        {
            pass.setError("Password shouls be less than 12 characters");
            valid=false;
        }
        if(st_phoneno.isEmpty() || st_phoneno.length()>10 || st_phoneno.length()<10)
        {
            phone.setError("Enter valid phone number");
            valid=false;
        }
        return valid;
    }

    public void uploadMultipart1() {
        //getting name for the image
        String name = editText.getText().toString().trim();
        //getting the actual path of the image
        String path = getPath1(filePath);
        System.out.println("In try");

        //Uploading code
        try {
            String uploadId = UUID.randomUUID().toString();

            //Creating a multi part request
            new MultipartUploadRequest(this, uploadId, Constants.UPLOADupi1_URL)
                    .addFileToUpload(path, "image") //Adding file
                    .addParameter("name", name)//Adding text parameter to the request
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(2)
                    .startUpload(); //Starting the upload

        } catch (Exception exc) {
            Toast.makeText(this, exc.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    //method to show file chooser
    private void showFileChooser1() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    //handling the image chooser activity result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            System.out.println("Filepath is "+filePath);
            if(t==1) {
                try {
                    filePath = data.getData();
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                    pp.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                if(t==2)
                {
                    try {
                        filePath2 = data.getData();
                        bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath2);
                        pan.setImageBitmap(bitmap2);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    if (t == 3) {
                        try {
                            filePath3 = data.getData();
                            bitmap3 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath3);
                            aadhar.setImageBitmap(bitmap3);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (t == 4) {
                            try {
                                filePath4 = data.getData();
                                bitmap4 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath4);
                                certificate.setImageBitmap(bitmap4);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    //method to get the file path from uri
    public String getPath1(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }


    //Requesting permission
    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }


    //This method will be called when the user will tap on allow or deny
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }





    public void uploadMultipart2() {
        //getting name for the image
        String name = editText.getText().toString().trim();
        //getting the actual path of the image
        String path = getPath2(filePath2);
        System.out.println("In try");

        //Uploading code
        try {
            String uploadId = UUID.randomUUID().toString();

            //Creating a multi part request
            new MultipartUploadRequest(this, uploadId, Constants.UPLOADupi2_URL)
                    .addFileToUpload(path, "image") //Adding file
                    .addParameter("name", name)//Adding text parameter to the request
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(2)
                    .startUpload(); //Starting the upload

        } catch (Exception exc) {
            Toast.makeText(this, exc.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    //method to show file chooser
    private void showFileChooser2() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    //method to get the file path from uri
    public String getPath2(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }




    public void uploadMultipart3() {
        //getting name for the image
        String name = editText.getText().toString().trim();
        //getting the actual path of the image
        String path = getPath3(filePath3);
        System.out.println("In try");

        //Uploading code
        try {
            String uploadId = UUID.randomUUID().toString();

            //Creating a multi part request
            new MultipartUploadRequest(this, uploadId, Constants.UPLOADupi3_URL)
                    .addFileToUpload(path, "image") //Adding file
                    .addParameter("name", name)//Adding text parameter to the request
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(2)
                    .startUpload(); //Starting the upload

        } catch (Exception exc) {
            Toast.makeText(this, exc.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    //method to show file chooser
    private void showFileChooser3() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }


    //method to get the file path from uri
    public String getPath3(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }
}
