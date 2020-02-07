package com.motorogy.testapp.di


import com.motorogy.testapp.domain.model.ReceipApiResponseModel
import com.motorogy.testapp.domain.usecaes.GetAllReceipLocalUseCase
import com.motorogy.testapp.domain.usecaes.GetAllReceipLocalUseCaseImpl
import com.motorogy.testapp.domain.usecaes.GetAllReceipUseCase
import com.motorogy.testapp.domain.usecaes.GetAllReceipUseCaseImpl
import org.koin.dsl.module.module

val useCasesModule = module {
factory<GetAllReceipUseCase> { GetAllReceipUseCaseImpl(get())}
  factory<GetAllReceipLocalUseCase> { GetAllReceipLocalUseCaseImpl(get()) }
}