package com.motorogy.testapp

import com.motorogy.testapp.data.remote.api.ReceipAPI
import com.motorogy.testapp.domain.model.ReceipApiResponseModel
import com.motorogy.testapp.domain.repositeries.GetAllReceip
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
 class ReceipAPI {

    @Mock
    lateinit var appRepository: GetAllReceip

    @Test
    fun testReceipApi(){
        Mockito.`when`(appRepository.getAllReceip("9d17ab17e29848599905f1bdc3b14016")).thenReturn(mock<Single<ReceipApiResponseModel>>())
    }

}