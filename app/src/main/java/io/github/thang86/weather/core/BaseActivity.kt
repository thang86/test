package io.github.thang86.weathers.core

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import io.github.thang86.weather.core.BaseView
import kotlinx.android.synthetic.main.toolbar.*

/**
 * ThangTX2
 */
open class BaseActivity: AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBar()
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        setupToolbar()
    }

    open fun setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar)
        }
    }

    /**
     * hide status bar
     */
    private fun hideStatusBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

    }


}