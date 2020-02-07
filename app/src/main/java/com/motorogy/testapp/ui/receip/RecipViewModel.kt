package com.motorogy.testapp.ui.receip

import android.widget.Toast
import com.motorogy.testapp.AppClassApplication
import com.motorogy.testapp.core.BaseViewModel
import com.motorogy.testapp.data.db.AppDataBase
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.domain.model.ReceipDoamainModel
import com.motorogy.testapp.domain.model.ReceipApiResponseModel
import com.motorogy.testapp.domain.model.response.ErrorResponse
import com.motorogy.testapp.domain.model.response.SuccessResponse
import com.motorogy.testapp.domain.model.response.UseCaseResponse
import com.motorogy.testapp.domain.usecaes.GetAllReceipLocalUseCase
import com.motorogy.testapp.domain.usecaes.GetAllReceipUseCase
import com.motorogy.testapp.domain.usecaes.GetAllReceipUseCaseImpl
import com.motorogy.testapp.util.NotNullMutableLiveData
import com.motorogy.testapp.util.ioThread
import java.util.ArrayList


class RecipViewModel(private val useCaseItem: GetAllReceipUseCase, private val useCaseItemLocal: GetAllReceipLocalUseCase) : BaseViewModel() {
    private var query: String = ""
        get() = if (field.isEmpty()) "MVVM" else field

   private val params: String = "9d17ab17e29848599905f1bdc3b14016"
   private var errorItem: String? = null
   //  private val dao: ReceipDao = ReceipDao

    private val _refreshing: NotNullMutableLiveData<Boolean> = NotNullMutableLiveData(false)
    val refreshing: NotNullMutableLiveData<Boolean>
        get() = _refreshing

    private val _items: NotNullMutableLiveData<ArrayList<ReceipDoamainModel>> = NotNullMutableLiveData(arrayListOf())
    val items: NotNullMutableLiveData<ArrayList<ReceipDoamainModel>>
        get() = _items

    var mUseCaseItemLocal: GetAllReceipLocalUseCase = useCaseItemLocal

    fun doSearch(items: ArrayList<ReceipDoamainModel>) {
        _items.value = items
    }

    init {
            useCaseItem.execute(disposables, this::getReceipResponse, params)
    }


    fun getReceipResponse(responseReceip: UseCaseResponse<ReceipApiResponseModel>){

        when(responseReceip){
            is SuccessResponse -> doSearch(responseReceip.value.resultLst)
            is ErrorResponse -> errorItem = responseReceip.error.message
        }
    }
}