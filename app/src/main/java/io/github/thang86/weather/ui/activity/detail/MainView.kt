package io.github.thang86.weather.ui.activity.detail

import io.github.thang86.weather.core.BaseView
import io.github.thang86.weather.domain.model.Address

/**
 * ThangTX2
 */
interface MainView: BaseView {
    fun loadAddress(addressList: MutableList<Address>?)
}