package com.motorogy.testapp

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import com.motorogy.testapp.data.db.dao.ReceipDao
import com.motorogy.testapp.ui.receip.RecipViewModel
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext
import org.koin.standalone.get
import org.koin.test.KoinTest
import org.mockito.Mockito

class ReceipViewModelTest  : KoinTest {
    private lateinit var viewModel: RecipViewModel

    @Before
    fun before() {
        StandAloneContext.startKoin(listOf(testApiModule))

        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
            override fun isMainThread(): Boolean  = true
            override fun postToMainThread(runnable: Runnable) = runnable.run()
        })

        viewModel = RecipViewModel(get(), get())
    }

    @After
    fun after() {
        ArchTaskExecutor.getInstance().setDelegate(null)
        StandAloneContext.stopKoin()
    }

    @Test
    fun viewModelNotNull() {
        MatcherAssert.assertThat(viewModel, Matchers.notNullValue())
    }
}