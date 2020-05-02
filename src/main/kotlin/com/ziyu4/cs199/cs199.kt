package com.ziyu4.cs199

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.File

interface GitHubApi {
    @GET("/repos/{owner}/{repo}")
    fun getRepository(@Path("owner") owner: String, @Path("repo")repo: String):Call<Repository>
}

fun main() {
    val gitHubApi = Retrofit.Builder().baseUrl("http://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GitHubApi::class.java)

    val response = gitHubApi.getRepository("JetBrains", "Kotlin").execute()
    val repository = response.body()
    if (repository == null) {
        println("Error! ${response.code()} - ${response.message()}")
    } else {
        println(repository.name)
        println(repository.owner.login)
        println(repository.subscribers_count)
        println(repository.owner.html_url)
        println(repository.owner.avatar_url)
        println(repository.owner.gravatar_id)

        File("Kotlin.html").writeText("""
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset= "UTF-8">
              <title>${repository.owner.login} - ${repository.name}</title>
            <head>
            <body>
              <h1><a href= '${repository.owner.html_url}'>${repository.owner.login} - ${repository.name}</a></h1>
              <p>${repository.owner.avatar_url}
              <p>Gravatar_id: ${repository.owner.id}
              <p>Subscribers: ${repository.subscribers_count}</p>
            </body>
            </html>
            
        """.trimIndent())
    }
}