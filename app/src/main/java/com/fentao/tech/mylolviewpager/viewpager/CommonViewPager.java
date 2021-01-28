package com.fentao.tech.mylolviewpager.viewpager;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;

import com.fentao.tech.mylolviewpager.R;

import java.util.List;

/**
 * @ProjectName: MyLOLViewPager
 * @Package: com.fentao.tech.mylolviewpager.viewpager
 * @ClassName: CommonViewPager
 * @Description: java类作用描述
 * @Author: allen
 * @CreateDate: 2021/1/28 14:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/1/28 14:48
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CommonViewPager<T> extends RelativeLayout {
    private ViewPager viewPager;
    private CommonViewPagerAdapter adapter;



    public CommonViewPager(Context context) {
        super(context);
        init();
    }

    public CommonViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CommonViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CommonViewPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.common_view_pager_layout,this,true);
        viewPager = view.findViewById(R.id.view_pager);
    }

    /**
     * @method  
     * @description 设置数据
     * @date: 2021/1/28 15:06
     * @author: allen
     * @param 
     * @return 
     */
    public void setPages(List<T> data, ViewPagerHolderCreator creator){
        adapter = new CommonViewPagerAdapter(data,creator);
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void setCurrentItem(int currentItem){
        viewPager.setCurrentItem(currentItem);
    }

    public int getCurrentItem(){
        return viewPager.getCurrentItem();
    }

    public void setOffscreenPageLimit(int limit){
        viewPager.setOffscreenPageLimit(limit);
    }

    /**
     * 设置切换动画，see {@link ViewPager#setPageTransformer(boolean, ViewPager.PageTransformer)}
     * @param reverseDrawingOrder
     * @param transformer
     */
    public void setPageTransformer(boolean reverseDrawingOrder, ViewPager.PageTransformer transformer){
        viewPager.setPageTransformer(reverseDrawingOrder,transformer);
    }

    /**
     * see {@link ViewPager#setPageTransformer(boolean, ViewPager.PageTransformer)}
     * @param reverseDrawingOrder
     * @param transformer
     * @param pageLayerType
     */
    public void setPageTransformer(boolean reverseDrawingOrder, ViewPager.PageTransformer transformer,
                                   int pageLayerType) {
        viewPager.setPageTransformer(reverseDrawingOrder,transformer,pageLayerType);
    }

    /**
     * see {@link ViewPager#addOnPageChangeListener(ViewPager.OnPageChangeListener)}
     * @param listener
     */
    public void addOnPageChangeListener(ViewPager.OnPageChangeListener listener){
        viewPager.addOnPageChangeListener(listener);
    }

    public ViewPager getViewPager(){
        return viewPager;
    }



}
