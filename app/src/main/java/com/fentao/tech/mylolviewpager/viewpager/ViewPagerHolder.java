package com.fentao.tech.mylolviewpager.viewpager;

import android.content.Context;
import android.view.View;

/**
 * @ProjectName: MyLOLViewPager
 * @Package: com.fentao.tech.mylolviewpager.viewpager
 * @ClassName: ViewPagerHolder
 * @Description: java类作用描述
 * @Author: allen
 * @CreateDate: 2021/1/28 14:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/1/28 14:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ViewPagerHolder<T> {


    /**
     * @method  
     * @description 创建view   提供布局
     * @date: 2021/1/28 14:21
     * @author: allen
     * @param 
     * @return 
     */
    View createView(Context context);


    /**
     * @method
     * @description 绑定数据
     * @date: 2021/1/28 14:22
     * @author: allen
     * @param
     * @return
     */
    void onBind(Context context,int position,T data);




}
