package hxl.cn.com.ewhat.activity;

import android.support.v4.app.FragmentTransaction;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import hxl.cn.com.ewhat.R;
import hxl.cn.com.ewhat.fragment.HomeFragment;
import hxl.cn.com.ewhat.fragment.HomeFragment_;


@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {


    @AfterViews
    public void initView(){

        HomeFragment homeFragment = HomeFragment_.builder().build();
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_FrameLayout,homeFragment,homeFragment.getClass().getSimpleName());
        fragmentTransaction.commit();


    }


}
