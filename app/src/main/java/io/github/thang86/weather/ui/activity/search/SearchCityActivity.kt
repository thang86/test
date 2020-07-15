package io.github.thang86.weather.ui.activity.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.thang86.weather.R
import io.github.thang86.weather.domain.model.Location
import io.github.thang86.weather.domain.model.SearchRespone
import io.github.thang86.weather.domain.model2.Resource
import kotlinx.android.synthetic.main.activity_search_city.*
import retrofit2.Call


/**
 * ThangTX2
 */
class SearchCityActivity : AppCompatActivity(), SearchCityView, SearchLocationAdapter.Interaction {
    private lateinit var adapterSearch: SearchLocationAdapter
    private lateinit var mResult: MutableList<Resource>
    private lateinit var presenter: SearchCityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_city)
        presenter = SearchCityPresenter()
        presenter.attachView(this)
        initViews()

        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    mResult.clear();
                    adapterSearch.submitList(mResult)
                } else if (newText.length >= 2) {
                    presenter.searchCityByNames(newText)
                }


                return true
            }
        })

    }

/*    fun getResultSearch(query: String) {
        callback = ApiUtils.getResult().getLocation("97458007F5CB49C89F1481E7C3733299", query)
        callback.enqueue(object : Callback<SearchRespone> {
            override fun onResponse(
                call: Call<SearchRespone>,
                response: Response<SearchRespone>
            ) {
                var call: Call<SearchRespone>? = call

                if (call != null) {
                    call.cancel()
                    call = null
                }
                if (response.isSuccessful && response.body()!!.locations != null) {
                    Log.d(
                        "HHAHHAHAHA",
                        "onResponse: " + response.body()!!.locations!!.size
                    )
                    response.body()?.locations?.let { adapterSearch.submitList(it) }
//                    adapterSearch.notifyDataSetChanged()
                }
            }

            override fun onFailure(
                call: Call<SearchRespone>,
                t: Throwable
            ) {
                if (call.isCanceled) {
                    Log.d("HHAHHAHAHA", "onFailure: is cancel")
                } else {
                    Log.d("HHAHHAHAHA", "onFailure: " + t.message)
                }
            }
        })

    }*/

    companion object {
        fun newIntent(applicationContext: Context): Intent {
            return Intent(applicationContext, SearchCityActivity::class.java)
        }
    }

    override fun initViews() {
        mResult = ArrayList<Resource>()
        adapterSearch = SearchLocationAdapter()
        adapterSearch.submitList(mResult)

        recyclerViewSearchResults.apply {
            layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            recyclerViewSearchResults.adapter = adapterSearch
            setHasFixedSize(true)
        }


    }

    override fun displayCityData(cities: List<Resource>?) {

        if (cities != null) {
            mResult.clear()

            mResult.addAll(cities)
            adapterSearch.submitList(cities!!)
        }

    }

    override fun showMessage(msg: String?) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show();
    }

    override fun showProgressDialog() {
        progressDialog.visibility = View.VISIBLE
    }

    override fun hideProgressDialog() {

        try {
            progressDialog.visibility = View.GONE

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    override fun onItemSelected(position: Int, item: Resource) {
        Toast.makeText(this, "hshshs" + item.name, Toast.LENGTH_LONG)
    }
}
