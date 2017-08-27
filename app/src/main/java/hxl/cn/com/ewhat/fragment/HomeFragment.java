package hxl.cn.com.ewhat.fragment;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import java.util.List;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import cn.finalteam.galleryfinal.widget.GFImageView;
import hxl.cn.com.ewhat.R;
import hxl.cn.com.ewhat.loader.PicassoImageLoader;

@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment implements  ImageLoader{

    private final int REQUEST_CODE_CAMERA = 1000;
    private final int REQUEST_CODE_GALLERY = 1001;
    private final int REQUEST_CODE_CROP = 1002;
    private final int REQUEST_CODE_EDIT = 1003;
    private List<PhotoInfo> mPhotoList;

    @AfterViews
    public void init(){

    }


    @Click(R.id.home_fragment_photo_select_button)
    public void photoButtonOnTap(){
        //设置主题
//        //ThemeConfig.CYAN
        ThemeConfig theme = new ThemeConfig.Builder().setTitleBarBgColor(Color.GREEN)
        .build();

        //配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true).setForceCrop(true).setEnableEdit(true).setEnableCrop(true)
                .setCropSquare(true).setEnableRotate(true).build();

        //配置imageloader
        PicassoImageLoader imageLoader = new PicassoImageLoader();
        CoreConfig coreConfig = new CoreConfig.Builder(getContext(), imageLoader, theme)
                .setFunctionConfig(functionConfig).setNoAnimcation(true).build();
        GalleryFinal. init(coreConfig);

        GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, functionConfig, new GalleryFinal.OnHanlderResultCallback() {
            @Override
            public void onHanlderSuccess(int requestCode, List<PhotoInfo> resultList) {

                resultList.get(0).getPhotoPath();

            }

            @Override
            public void onHanlderFailure(int requestCode, String errorMsg) {

            }
        });
    }


    @Override
    public void displayImage(Activity activity, String path, GFImageView imageView, Drawable defaultDrawable, int width, int height) {

    }

    @Override
    public void clearMemoryCache() {

    }


}
