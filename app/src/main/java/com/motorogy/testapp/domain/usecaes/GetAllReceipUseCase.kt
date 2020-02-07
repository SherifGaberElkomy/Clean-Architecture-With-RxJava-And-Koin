package com.motorogy.testapp.domain.usecaes

import com.motorogy.testapp.domain.model.ReceipApiResponseModel
import com.motorogy.testapp.domain.model.response.UseCaseResponse
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface GetAllReceipUseCase {
    fun execute(compositeDisposable: CompositeDisposable,
                onResponse: (UseCaseResponse<ReceipApiResponseModel>) -> Unit,
                stringKey: String): Disposable
}