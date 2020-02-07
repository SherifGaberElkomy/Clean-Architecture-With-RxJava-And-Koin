package com.motorogy.testapp.domain.usecaes

import android.widget.Toast
import com.motorogy.testapp.AppClassApplication
import com.motorogy.testapp.domain.model.ReceipApiResponseModel
import com.motorogy.testapp.domain.model.response.SuccessResponse
import com.motorogy.testapp.domain.model.response.UseCaseResponse
import com.motorogy.testapp.domain.repositeries.GetAllReceip
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class GetAllReceipUseCaseImpl(private val getAllReceipRepositery: GetAllReceip): GetAllReceipUseCase {
    override fun execute(
        compositeDisposable: CompositeDisposable,
        onResponse: (UseCaseResponse<ReceipApiResponseModel>) -> Unit,
        stringKey: String
    ): Disposable {
        var mDisposable: Disposable =  getAllReceipRepositery.getAllReceip(stringKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onResponse(SuccessResponse(it))
                },
                {
                    if(it.message != null) {
                        var mErrorResponse: String = it.message!!
                        Toast.makeText(AppClassApplication.mContext, mErrorResponse, Toast.LENGTH_LONG).show()
                    }
                })
        compositeDisposable.add(mDisposable)
        return compositeDisposable
    }


}