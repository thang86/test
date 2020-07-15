package io.github.thang86.weather.core

/**
 * ThangTX2
 */
open class BasePresenter<T : BaseView> : MvpPresenter<T> {

    private var mView: T? = null

    override fun attachView(view: T) {
        this.mView = view
    }

    override fun detachView() {
        mView = null
    }

    open fun getMView(): T? {
        return this.mView
    }

    fun isViewAttached(): Boolean {
        return this.mView != null
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw ViewNotAttachedException()
    }
}