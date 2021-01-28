package com.fentao.tech.mylolviewpager.viewpager;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * @ProjectName: MyLOLViewPager
 * @Package: com.fentao.tech.mylolviewpager.viewpager
 * @ClassName: CommonViewPagerAdapter
 * @Description: java类作用描述
 * @Author: allen
 * @CreateDate: 2021/1/28 14:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/1/28 14:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class CommonViewPagerAdapter<T> extends PagerAdapter {
    private List<T> mDatas;
    //ViewHolder 创建器
    private ViewPagerHolderCreator mCreator;

    public CommonViewPagerAdapter(List<T> mDatas, ViewPagerHolderCreator mCreator) {
        this.mDatas = mDatas;
        this.mCreator = mCreator;
    }

    @Override
    public int getCount() {
        return mDatas==null?0:mDatas.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = getView(position,null,container);
        container.addView(view);
        return view;
    }

    /**
     * @method
     * @description 获取ViewPager
     * @date: 2021/1/28 14:34
     * @author: allen
     * @param
     * @return
     */
    private View getView(int position,View view,ViewGroup container){
            ViewPagerHolder holder = null;
            if(view == null){
                //创建ViewHolder
                holder = mCreator.createViewHolder();
                view = holder.createView(container.getContext());
                view.setTag(holder);
            }else{
                holder = (ViewPagerHolder) view.getTag();
            }

            if(holder != null && mDatas != null && mDatas.size() > 0){
                //数据绑定
                holder.onBind(container.getContext(),position,mDatas.get(position));
            }
            return view;
    }

}
