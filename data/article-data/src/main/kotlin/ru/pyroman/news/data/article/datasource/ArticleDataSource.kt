package ru.pyroman.news.data.article.datasource

import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.DefaultUriBuilderFactory
import ru.pyroman.news.data.article.dto.ArticleListDto
import ru.pyroman.news.domain.article.model.ArticlesRequest

internal class ArticleDataSource {

    fun getArticles(request: ArticlesRequest): ArticleListDto {
        val uriBuilder = DefaultUriBuilderFactory(
            "https://newsdata.io/api/1/news",
        ).builder()

        val uri = uriBuilder
            .queryParam("apiKey", "pub_438944bc52c063137c2b1a4448b34ca9eee9a")
            .queryParam("country", "us")
            .build()

        val webClient = WebClient.builder().build()

        val response = webClient
            .get()
            .uri(uri)
            .retrieve()
            .bodyToMono(ArticleListDto::class.java)
            .block()

        return requireNotNull(response)
    }
}