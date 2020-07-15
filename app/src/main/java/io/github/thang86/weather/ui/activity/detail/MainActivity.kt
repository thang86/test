package io.github.thang86.weather.ui.activity.detail

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.thang86.weather.R
import io.github.thang86.weather.adapter.FragmentPageAdapter
import io.github.thang86.weather.adapter.NavigationAdapter
import io.github.thang86.weather.core.BaseDrawerActivity
import io.github.thang86.weather.domain.model.Address
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

/**
 * ThangTX2
 */
class MainActivity : BaseDrawerActivity(), MainView {
    private lateinit var naviationAdapter: NavigationAdapter
    private var mListAddress: MutableList<Address> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var mAdapterPage: FragmentPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
        presenter.attachView(this)
        presenter.loadAddress()
        bindView()
    }

    private fun bindView() {
        if (mListAddress.isNullOrEmpty()) {
            return
        }
        mAdapterPage = FragmentPageAdapter(supportFragmentManager, this, mListAddress)
        viewpager.adapter = mAdapterPage

    }

    override fun onResume() {
        super.onResume()
        if (mAdapterPage != null) {
            mAdapterPage.notifyDataSetChanged()
        }
    }

    override fun setNavigationItemSelected() {
        // infilate view for item
        menurv.apply {
            naviationAdapter = NavigationAdapter(applicationContext, mListAddress)
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            adapter = naviationAdapter
            setHasFixedSize(true)
        }

        // set event onclick for item of navigation
        naviationAdapter!!.setItemClickListener(object : NavigationAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                drawerLayout.closeDrawers()
                viewpager.currentItem = position
                Toast.makeText(
                    applicationContext,
                    mListAddress[position].address.toString() + " Menu Clicked !",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun loadAddress(addressList: MutableList<Address>?) {
        if (!addressList.isNullOrEmpty()) {
            mListAddress.clear()
            mListAddress.addAll(addressList)
            naviationAdapter.notifyDataSetChanged()
        }

    }

}
