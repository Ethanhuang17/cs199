package com.ziyu4.cs199

/**
 * Created by mac on 2020-04-24
 */
data class Repository(
    var id: Int,
    var node_id: String,
    var name: String,
    var full_name: String,
    var private: Boolean,
    var owner: Owner,
    var network_count: Int,
    var subscribers_count: Int
) {
    data class Owner(
        var login: String,
        var id: Int,
        var node_id: String,
        var avatar_url: String,
        var gravatar_id: String,
        var url: String,
        var html_url: String,
        var followers_url: String,
        var following_url: String,
        var gists_url: String,
        var starred_url: String,
        var subscriprions_url: String,
        var organizations_url: String,
        var repos_url: String,
        var events_url: String,
        var received_events_url: String,
        var type: String,
        var site_admin: Boolean
    )
}