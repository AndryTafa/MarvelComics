package com.andry.marvelapplication.utils

object AppConstants {

    private const val PRIVATE_API_KEY = "37ccadd67a08a7e70759984a0061a5e6274cde6e"
    const val API_URL = "https://gateway.marvel.com/v1/public/"
    const val PUBLIC_API_KEY = "d3f0977ec788aa8d4ac03f265866d09c"
    val TIMESTAMP = System.currentTimeMillis() / 1000
    val API_HASH = Md5Converter.stringToMd5("$TIMESTAMP$PRIVATE_API_KEY$PUBLIC_API_KEY")
}