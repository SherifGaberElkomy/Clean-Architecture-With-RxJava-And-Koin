package com.motorogy.testapp

import android.content.Intent
import org.junit.runner.RunWith
import androidx.test.runner.AndroidJUnit4
import com.motorogy.testapp.domain.model.ReceipDoamainModel
import com.motorogy.testapp.ui.receip.ReceipActivity
import com.motorogy.testapp.ui.receipdetails.ReceipDetailsActivity
import org.junit.Before
import org.junit.Test


@RunWith(AndroidJUnit4::class)
class NavigationActivty {

    lateinit var receipModel: ReceipDoamainModel

    @Before
    fun init(){
        var mLstItemString: ArrayList<String> = java.util.ArrayList<String>()
        receipModel = ReceipDoamainModel(1, "", 1, 1, "", mLstItemString)
    }

    @Test
    fun navigateToAnotherActivity(){

        var mIntent: Intent = Intent(
            AppClassApplication.mContext,
            ReceipDetailsActivity::class.java
        )
        mIntent.putExtra("recipItem", receipModel)
        AppClassApplication.mContext.startActivity(mIntent)
    }

}