import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.quarkus.jackson.ObjectMapperCustomizer
import javax.inject.Singleton

@Singleton
class ObjectMapperConfiguration : ObjectMapperCustomizer {
    override fun customize(mapper: ObjectMapper) {
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    }
}