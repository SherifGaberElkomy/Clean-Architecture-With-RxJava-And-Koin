package com.motorogy.testapp.receipusecases

import com.motorogy.testapp.domain.model.ReceipApiResponseModel
import com.motorogy.testapp.domain.model.response.ErrorResponse
import com.motorogy.testapp.domain.model.response.SuccessResponse
import com.motorogy.testapp.domain.model.response.UseCaseResponse
import com.motorogy.testapp.domain.repositeries.GetAllReceip
import com.motorogy.testapp.domain.repositeries.GetAllReceipLocalData
import com.motorogy.testapp.domain.usecaes.GetAllReceipUseCaseImpl
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import com.nhaarman.mockito_kotlin.whenever
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ReceipUseCasesTest {

    @Mock
    lateinit var appRepository: GetAllReceip

    @InjectMocks
    lateinit var getAllReceipUseCase: GetAllReceipUseCaseImpl


    @Test
    fun `execute should get a single instance from repository`() {
        // GIVEN
        val mockedSingle = mock<Single<ReceipApiResponseModel>>()
        whenever(appRepository.getAllReceip("9d17ab17e29848599905f1bdc3b14016")).thenReturn(mockedSingle)

        // WHEN
        var compositeDisposable: CompositeDisposable = CompositeDisposable()
        val result = getAllReceipUseCase.execute(compositeDisposable, this::getReceipResponse, "9d17ab17e29848599905f1bdc3b14016")
        // THEN
        MatcherAssert.assertThat(result, Matchers.notNullValue())
    }


    fun getReceipResponse(responseReceip: UseCaseResponse<ReceipApiResponseModel>){

        when(responseReceip){
            is SuccessResponse ->"Done"
            is ErrorResponse -> "Error"
        }
    }

}