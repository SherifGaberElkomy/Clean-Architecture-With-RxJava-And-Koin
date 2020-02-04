package com.motorogy.testapp.ui.receipdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.motorogy.testapp.R
import com.motorogy.testapp.data.remote.domain.ReceipDoamainModel

class ReceipDetailsActivity : AppCompatActivity() {

    lateinit var mItemReceipModel: ReceipDoamainModel

    lateinit var mTextViewtitle: TextView
    lateinit var mImgVwItem: ImageView
    lateinit var mTxtVwReadyValue: TextView
    lateinit var mTxtVwServingValue: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receip_details)
        loadControl()

        intent.extras?.getSerializable("recipItem")?.let {
            mItemReceipModel = intent.extras?.getSerializable("recipItem") as ReceipDoamainModel

            if(mItemReceipModel != null){
                mTextViewtitle.text = mItemReceipModel?.title
                mTxtVwReadyValue.text = mItemReceipModel?.readyInMin.toString()
                mTxtVwServingValue.text = mItemReceipModel?.serving.toString()
                Glide.with(applicationContext).load("https://spoonacular.com/recipeImages/" + mItemReceipModel?.imgItem).into(mImgVwItem)
            }

        }




    }

    private fun loadControl() {
        mTextViewtitle = findViewById(R.id.textTitle)
        mImgVwItem = findViewById(R.id.imgVwItem)
        mTxtVwReadyValue = findViewById(R.id.readyInMinutesTxt)
        mTxtVwServingValue = findViewById(R.id.servingsTxt)
    }
}
