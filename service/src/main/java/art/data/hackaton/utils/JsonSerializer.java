package art.data.hackaton.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

public class JsonSerializer {

    private static final Logger logger = LoggerFactory.getLogger(JsonSerializer.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final ObjectWriter objectWriter;

    static {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss.SSS"));
        objectMapper.setTimeZone(TimeZone.getTimeZone("CET"));

        objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
    }

    private JsonSerializer() {
        throw new UnsupportedOperationException("no instantiation");
    }

    public static String objectToJson(Object object) {
        return objectToJson(objectWriter, object);
    }

    public static <T> T jsonToObject(String json, Class<T> clazz) {
        return jsonToObject(objectMapper, json, clazz);
    }

    public static <T> List<T> jsonToObjectList(String json, Class<T> clazz) {
        return jsonToObjectList(objectMapper, json, clazz);
    }

    public static <T> String objectListToJson(List<T> list) {
        return objectListToJson(objectWriter, list);
    }

    public static String objectToJson(ObjectWriter objectWriter, Object obj) {

        String json = null;

        try {
            json = objectWriter.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("Error in objectToJson()", e);
        }
        return json;
    }

    public static <T> T jsonToObject(ObjectMapper objectMapper, String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            logger.error("Error in jsonToObject()", e);
        }
        return null;
    }

    public static <T> List<T> jsonToObjectList(ObjectMapper objectMapper, String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            logger.error("Error in jsonToObjectList()", e);
        }
        return null;
    }

    public static <T> String objectListToJson(ObjectWriter objectWriter, List<T> list) {
        try {
            return objectWriter.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            logger.error("Error in objectListToJson()", e);
        }
        return null;
    }
}
