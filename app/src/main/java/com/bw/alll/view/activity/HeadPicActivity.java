package com.bw.alll.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bw.alll.R;
import com.bw.alll.base.BaseActivity;
import com.bw.alll.contract.MovieContract;
import com.bw.alll.model.bean.HeadPicBean;
import com.bw.alll.presenter.MoviewPresenter;
import com.bw.alll.widget.MyUrls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Url;

public class HeadPicActivity extends BaseActivity<MoviewPresenter> implements MovieContract.IView {

    @BindView(R.id.head)
    ImageView head;

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {

    }

    @Override
    protected MoviewPresenter initPresenter() {
        return new MoviewPresenter();
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_head_pic;
    }

    @Override
    protected void destroy() {

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onFailure(Throwable e) {
        Toast.makeText(this, e +"", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.head)
    public void onViewClicked() {
        Intent img = new Intent(Intent.ACTION_PICK);
        img.setType("image/*");
        startActivityForResult(img,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        yaSuo(uri);
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, options);
            Log.e("xx","未压缩:"+bitmap.getByteCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //上传头像
    private void loadHeadPic(Uri uri) {

        File file = uri2File(uri);
        Glide.with(head)
                .load(uri)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(head);
        //创建文件请求对象
        //设置content-type类型
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);

        //多表单上传的工具类
        MultipartBody.Part image = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
        //发起上传图片请求
        mPresenter.postDoHeadPic(MyUrls.BASE_HEAD, HeadPicBean.class, image);

    }
    //uri---file
    private File uri2File(Uri uri) {
        Bitmap bitmap = yaSuo(uri);
        Uri parse = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, null, null));
        String img_path;
        //图片绝对路径
        String[] proj = {MediaStore.Images.Media.DATA};
        /*Cursor actualimagecursor = managedQuery(uri, proj, null,
                null, null);*/
        //查询图片 返回一个Cursor
        Cursor actualimagecursor = getContentResolver().query(parse, proj, null,
                null, null);
        if (actualimagecursor == null) {
            img_path = parse.getPath();
        } else {
            int actual_image_column_index = actualimagecursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualimagecursor.moveToFirst();
            img_path = actualimagecursor
                    .getString(actual_image_column_index);
        }
        File file = new File(img_path);
        return file;
    }

    public Bitmap yaSuo(Uri uri){
        Bitmap bitmap = null;
        try {
            //解析工具
            BitmapFactory.Options options = new BitmapFactory.Options();
            //inJustDecoedBounds设置为true的话，解码bitmap时可以只返回其高、宽和Mime类型
            options.inJustDecodeBounds=true;
            //解析图片信息
            bitmap = BitmapFactory.decodeStream(this.getContentResolver().openInputStream(uri), null, options);
            //获取原始图片的宽高
            int width = options.outWidth;
            int height = options.outHeight;
            //获取字节数
            if (bitmap!=null){
                Log.e("xx","size=1:"+bitmap.getByteCount());
            }else {
                Log.e("xx","null");
            }

            //设置采样率
            options.inSampleSize = 4;
            //if (bitmap.isRecycled() == false) { bitmap.recycle(); }
            //System.gc();
            options.inJustDecodeBounds=false;
            bitmap = BitmapFactory.decodeStream(this.getContentResolver().openInputStream(uri), null, options);
            Log.e("xx","size=2:"+bitmap.getByteCount());
            head.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
