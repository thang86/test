package io.github.thang86.weather.ui.activity.search

import io.github.thang86.weather.core.BaseView
import io.github.thang86.weather.domain.model.Location
import io.github.thang86.weather.domain.model2.Resource
import io.github.thang86.weather.domain.model2.ResourceSet


/**
 * ThangTX2
 */
interface SearchCityView:BaseView {

    // bind views
    fun initViews()


    fun displayCityData(cities: List<Resource>?)

    // To display message as Toast messages
    fun showMessage(msg: String?)


    // Show and hide progress dialog
    fun showProgressDialog()
    fun hideProgressDialog()
}