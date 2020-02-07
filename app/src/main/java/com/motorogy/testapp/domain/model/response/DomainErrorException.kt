package com.motorogy.testapp.domain.model.response

class DomainErrorException(val errorModel: ErrorModel): Throwable() {
}