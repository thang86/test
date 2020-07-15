package io.github.thang86.weather.core


/**
 * ThangTX2
 */
interface MvpPresenter<V : BaseView> {
    /**
     * attcht the view
     *
     * @param view
     */
    fun attachView(view: V)

    /**
     * detach the view
     */
    fun detachView()
}