package com.fentao.tech.mylolviewpager

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fentao.tech.mylolviewpager.viewpager.CommonViewPager
import com.fentao.tech.mylolviewpager.viewpager.DataEntry
import com.fentao.tech.mylolviewpager.viewpager.ViewPagerHolder
import com.fentao.tech.mylolviewpager.viewpager.ViewPagerHolderCreator
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(findViewById(R.id.toolbar))
//
//        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        initView()
    }

    var mCommonViewPager:CommonViewPager<DataEntry>? = null;

    private fun initView() {
        mCommonViewPager =
            findViewById<CommonViewPager<DataEntry>>(R.id.activity_common_view_pager)
        //设置数据  设置ViewHolder生成器（数据与ViewHolder生成器生成的ViewHolder一一对应）
        mCommonViewPager?.setPages(mockData(), ViewPagerHolderCreator { // 返回ViewPagerHolder
            ViewImageHolder()
        })
    }

    fun mockData():List<DataEntry>{

        var list :ArrayList<DataEntry> = ArrayList<DataEntry>()

        var data = DataEntry()
        data.desc = "the first"
        data.imageResId = R.mipmap.ic_launcher

        var data1 = DataEntry()
        data1.desc = "the second"
        data1.imageResId = R.mipmap.ic_launcher_round

        list.add(data)
        list.add(data1)


        return list

    }

    /**
     * 提供ViewPager展示的ViewHolder
     * <P>用于提供布局和绑定数据</P>
     */
    class ViewImageHolder : ViewPagerHolder<DataEntry?> {
        private var mImageView: ImageView? = null
        private var mTextView: TextView? = null
        override fun createView(context: Context?): View {
            // 返回ViewPager 页面展示的布局
            val view: View = LayoutInflater.from(context).inflate(R.layout.view_pager_item, null)
            mImageView = view.findViewById(R.id.viewPager_item_image) as ImageView?
            mTextView = view.findViewById(R.id.item_desc) as TextView
            return view
        }

        override fun onBind(context: Context?, position: Int, data: DataEntry?) {
            // 数据绑定
            // 自己绑定数据，灵活度很大
            data?.imageResId?.let { mImageView?.setImageResource(it) }
            mTextView?.setText(data?.desc)
        }
    }


}