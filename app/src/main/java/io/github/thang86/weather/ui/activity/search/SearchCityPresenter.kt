package io.github.thang86.weather.ui.activity.search

import android.util.Log
import io.github.thang86.weather.BuildConfig
import io.github.thang86.weather.core.BasePresenter
import io.github.thang86.weather.domain.model2.ResourceSet
import io.github.thang86.weather.domain.model2.SearchRespone
import retrofit2.Response

/**
 * ThangTX2
 */
class SearchCityPresenter : BasePresenter<SearchCityView>(), SearchCityContract.OnFinishedListener {
    var model = GetCityIntractor()


    fun searchCityByNames(query: String) {
        getMView()!!.showProgressDialog()
        model.getCityByNames(BuildConfig.BING_API_KEY, query, this)
    }


    override fun onSuccess(response: Response<SearchRespone>) {
        Log.d("SearchCityPresenter1", " " + response.body()!!.resourceSets!!.size);
        getMView()!!.hideProgressDialog()
        Log.d("SearchCityPresenter2", " " + response.body()!!.resourceSets[0].resources.size);
        getMView()!!.displayCityData(response.body()!!.resourceSets[0].resources)
    }

    override fun onError(response: Response<SearchRespone>) {
        getMView()!!.hideProgressDialog()
        getMView()!!.showMessage("Not found result");
    }

    override fun onFailure(throwable: Throwable?) {
        getMView()!!.hideProgressDialog()
        getMView()!!.showMessage(throwable!!.message);
        Log.e("ThangTX2",throwable!!.message)
    }


}