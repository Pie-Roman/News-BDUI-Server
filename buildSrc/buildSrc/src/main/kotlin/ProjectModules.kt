object ProjectModules {

    object Common {
        private const val common = ":common"
        const val view = "$common:view"
    }

    object Feature {
        private const val feature = ":feature"
        const val newsCardFeature = "$feature:news-card-feature"
        const val newsListFeature = "$feature:news-list-feature"
        const val searchFeature = "$feature:search-feature"
        const val searchResultFeature = "$feature:search-result-feature"
        const val tabsFeature = "$feature:tabs-feature"
    }

    object Domain {
        private const val domain = ":domain"
        const val articleDomain = "$domain:article-domain"
    }

    object Data {
        private const val data = ":data"
        const val articleData = "$data:article-data"
    }
}