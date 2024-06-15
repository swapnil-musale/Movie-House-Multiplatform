package com.devx.moviehouse.domain.util

interface Mapper<T> {
    fun mapToDomain(): T
}
