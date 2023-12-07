//package com.biie.tenantfeedback.activity;
//
//import static android.app.Activity.RESULT_CANCELED;
//import static android.app.Activity.RESULT_OK;
//
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//
//import android.os.Environment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.Spinner;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.widget.AppCompatButton;
//import androidx.appcompat.widget.AppCompatImageView;
//import androidx.fragment.app.Fragment;
//
////import com.biie.tenantfeedback.api.RetrofitBuilder;
//
//import com.biie.tenantfeedback.R;
//import com.biie.tenantfeedback.model.SampleResp;
//import com.biie.tenantfeedback.api.APIService;
////import com.biie.tenantfeedback.utils.FileUtils;
////import com.biie.tenantfeedback.utils.ImageResizer;
//import com.bumptech.glide.Glide;
//import com.github.dhaval2404.imagepicker.ImagePicker;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//import java.io.File;
//
//import okhttp3.MediaType;
//import okhttp3.MultipartBody;
//import okhttp3.RequestBody;
//import okhttp3.internal.connection.RealCall;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class SampleActivity extends Fragment {
//
//    FloatingActionButton fab;
//    ImageView cover;
//    Spinner spinner;
//    ProgressDialog pd;
//    AppCompatButton btnSubmit;
//    EditText etKet, etOthers;
//    private CharSequence[] options= {"Camera","Cancel"};
//    String selectedImage;
//    String pos ="";
//    String other=" ";
//    private Uri mCameraUri;
//    RealCall RetrofitBuilder;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View v =  inflater.inflate(R.layout., container, false);
//
////        cover = v.findViewById(R.id.image);
////        fab = v.findViewById(R.id.fab);
////        spinner = v.findViewById(R.id.sp_pos);
////        btnSubmit = v.findViewById(R.id.btn_submit);
////        etKet = v.findViewById(R.id.et_ket);
////        etOthers = v.findViewById(R.id.et_lainnya);
//        pd = new ProgressDialog(getContext());
//        pd.setMessage("loading ... ");
//        pd.setCancelable(false);
//
////        Log.e("kargu id : ", API.currentUser().getKargu());
//        ArrayAdapter<CharSequence>adapter= ArrayAdapter.createFromResource(getContext(), R.array.pos, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        spinner.setAdapter(adapter);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Toast.makeText(getContext(), "testt", Toast.LENGTH_SHORT).show();
//                //ambilGambar();
//                ImagePicker.with(getActivity())
//                        .crop()                 //Crop image(Optional), Check Customization for more option
//                        .cameraOnly()
//                        .saveDir(getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES))
//                        .compress(1024)         //Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)  //Final image resolution will be less than 1080 x 1080(Optional)
//                        .createIntent(intent -> {
//                            startActivityForResult(intent, 0);
//                            return null;
//                        });
//            }
//        });
//
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                uploadFile();
//            }
//        });
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                //Toast.makeText(getContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
//                pos = parent.getItemAtPosition(position).toString();
//                if (pos.equals("Others")){
//                    etOthers.setVisibility(View.VISIBLE);
//                }else {
//                    etOthers.setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        return v;
//    }
//
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        Uri uri = data.getData();
//
//        if(resultCode !=RESULT_CANCELED){
//
//            switch (requestCode){
//                case 0:
//                    AppCompatImageView img = getView().findViewById(R.id.);
//                    mCameraUri = uri;
//                    Glide.with(getContext())
//                            .load(uri)
//                            .into(img);
//
//                    break;
//                case 1:
//                    if(resultCode == RESULT_OK && data !=null){
//
//                    }
//            }
//
//        }
//    }
//
//
//    public void uploadFile(){
//        pd.show();
////        Bitmap image = BitmapFactory.decodeFile(selectedImage);
////        Bitmap compress = ImageResizer.reduceBitmapSize(image, 240000);
//
//        File file =new File( mCameraUri.getPath());
//
//        if (etOthers.getText().length() > 0){
//            other = etOthers.getText().toString();
//        }
//        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
//        MultipartBody.Part filePart = MultipartBody.Part.createFormData("sendimage",file.getName(),requestBody);
//        RequestBody keterngan = RequestBody.create(MediaType.parse("text/plain"),
//                etKet.getText()
//                        .toString());
//
//
//        APIService service = RetrofitBuilder.getClient().create(APIService.class);
//
//        Call<SampleResp> call = service.callUploadApi(filePart,);
//        call.enqueue(new Callback<SampleResp>(){
//            @Override
//            public void onResponse(Call<SampleResp> call, Response<SampleResp> response) {
//                pd.dismiss();
//                SampleResp sampleResp = response.body();
//                if (sampleResp.getStatus()){
//                    Glide.with(getContext()).load(R.drawable.)
//                            .fitCenter()
//                            .into(cover);
//                    etKet.setText("");
//
//                }
//                Toast.makeText(getContext(), sampleResp.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<SampleResp> call, Throwable t) {
//                pd.dismiss();
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}