package br.com.brsantiago.network

import br.com.brsantiago.domain.Issue
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface IssueService {

    @GET("{repo}/{issueType}/issues")
    fun getAll(@Path("repo") repo: String, @Path("issueType") issueType: String): Deferred<ArrayList<Issue>>
}