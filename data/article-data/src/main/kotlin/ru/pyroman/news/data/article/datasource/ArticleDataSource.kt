package ru.pyroman.news.data.article.datasource

import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.DefaultUriBuilderFactory
import ru.pyroman.news.data.article.dto.ArticleListDto
import ru.pyroman.news.domain.article.model.ArticlesRequest

internal class ArticleDataSource {

    fun getArticles(request: ArticlesRequest): ArticleListDto {
        val uriBuilder = DefaultUriBuilderFactory(
            "https://newsapi.org/v2",
        ).builder()

        val uri = uriBuilder
            .queryParam("q", "apple")
            .queryParam("sortBy", "popularity")
            .queryParam("apiKey", "dc32a0db5f3d4d8fa0582922bcd8181c")
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