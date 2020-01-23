import java.net.URL


inline class Selector(val value: String)
data class WebsiteTarget(
    val url: URL,
    val selectors: Map<String, String>
)
