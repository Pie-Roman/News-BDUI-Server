## News BDUI Server

[![Static Badge](https://img.shields.io/badge/divkit-orange)](https://github.com/divkit/divkit) ![Static Badge](https://img.shields.io/badge/spring-green)

Серверная часть Backend-driven UI приложения по просмотру новостей News24

[Figma](https://www.figma.com/design/syzUlOab6zEarNDqGbXfCh/Simple-News-UI-Kit-|-Developer-Practice-Kit-|-iPhone-13-(Community)?node-id=0-1&t=qkKZcpD4pt70r0BE-0)

### Необходимые условия

- **Java Development Kit (JDK):** Рекомендуемая версия 8 или выше.
- **Gradle:** Версия 8.2 или выше.
- **DivKit:** Версия 29.15.0 или выше.

### Начало работы

#### Клонирование репозитория

```sh
git clone https://github.com/Pie-Roman/News-BDUI-Server
cd News-BDUI-Server
```

#### Сборка и запуск

- Используйте Gradle для сборки проекта.
- Запустите `NewsApplication`
- Сервер запустится на `http://localhost:8080`

#### REST Endpoints:
- GET Tabs - `http://localhost:8080/tabs` - получить корневой экран табов
- GET NewsList - `http://localhost:8080/patch/news-list` - получить таб списка новостей в формате divkit patch
- GET Search - `http://localhost:8080/patch/search` - получить таб поиска новостей в формате divkit patch
- GET SearchResult - `http://localhost:8080/patch/search-result` - получить список найденных новостей по поиску в формате divkit patch

### Лицензия

Этот проект лицензирован под MIT License - смотрите файл [LICENSE](LICENSE) для деталей.