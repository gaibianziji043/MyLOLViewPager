package com.fentao.tech.mylolviewpager.viewpager;

/**
 * @ProjectName: MyLOLViewPager
 * @Package: com.fentao.tech.mylolviewpager.viewpager
 * @ClassName: ViewPagerHolderCreator
 * @Description: java类作用描述
 * @Author: allen
 * @CreateDate: 2021/1/28 14:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/1/28 14:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface ViewPagerHolderCreator<VH extends ViewPagerHolder> {

    public VH createViewHolder();

}
