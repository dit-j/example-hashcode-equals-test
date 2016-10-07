package de.jawb.benchmark;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import de.jawb.model.Person;
import io.github.benas.randombeans.api.EnhancedRandom;

/**
 * @author dit
 */
public class PersonLoader {

    private static Logger logger = LoggerFactory.getLogger(PersonLoader.class);

    /**
     * @param type
     * @return
     */
    static <T> List<T> loadAs(Class<T> type) {
        
        logger.debug("loadAs {}", type);
        
        InputStream stream = PersonLoader.class.getClassLoader().getResourceAsStream("persons.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            CollectionType mappingType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, type);
            return mapper.readValue(stream, mappingType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static void generate() throws JsonProcessingException {
        List<Person> persons = EnhancedRandom.randomListOf(250, Person.class);
        System.out.println(new ObjectMapper().writeValueAsString(persons));
    }

    public static void main(String[] args) throws IOException {
        generate();
    }
}