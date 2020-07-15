package io.github.thang86.weather.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import io.github.thang86.weather.R
import io.github.thang86.weather.domain.model.Address
import io.github.thang86.weather.ui.activity.detail.WeatherFragment

/**
 * ThangTX2
 */
class FragmentPageAdapter :
    FragmentStatePagerAdapter {

    private var mContext: Context
    private var mAddress: MutableList<Address>

    companion object {
        private var NUM_ITEMS = 1
    }

    constructor(
        fragmentManager: FragmentManager,
        context: Context,
        address: MutableList<Address>
    ) : super(fragmentManager) {
        NUM_ITEMS = address.size
        mContext = context
        mAddress = address

    }

    override fun getItem(position: Int): Fragment {
        return WeatherFragment.newInstance(mAddress[position])
    }

    override fun getCount(): Int {
        return NUM_ITEMS
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.getString(R.string.tab) + " " + (position + 1).toString()
    }
}