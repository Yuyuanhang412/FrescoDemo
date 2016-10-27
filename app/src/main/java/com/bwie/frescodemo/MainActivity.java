package com.bwie.frescodemo;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends AppCompatActivity {

    String str1="http://resource.jufan.tv/jufan/ad20161026/28a85360f2a2a79ac549.png";
    String str2="http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1209/10/c1/13758581_1347257278695.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse(str1);
        //找到控件
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.user_avator);
        draweeView.setImageURI(uri);

        //定义控制类的监听对象
        ControllerListener listener=new BaseControllerListener(){};

        //创建一个Drawee控件的监听类
        DraweeController controller= Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .setOldController(draweeView.getController())
                .setControllerListener(listener)
                .build();

        draweeView.setController(controller);

       /* Animatable animatable = draweeView.getController().getAnimatable();
        if (animatable != null) {
            animatable.start();
            // later
            animatable.stop();
        }*/

    }
}
