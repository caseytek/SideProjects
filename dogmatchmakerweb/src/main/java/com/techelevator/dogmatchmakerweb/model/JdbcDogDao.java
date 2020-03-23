package com.techelevator.dogmatchmakerweb.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JdbcDogDao implements DogDao {
	
	private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcDogDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public Dog getDogByType(String dogType) {
		String sql = "SELECT * FROM dog WHERE dog_type = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, dogType);
		Dog dog = new Dog();
		if(result.next()) {
			dog = mapRowToDog(result);
		}
		return dog;
	}

	@Override
	public List<Dog> getAllDogs() {
		List <Dog> dogList = new ArrayList<>();
		String sql = "SELECT * FROM dog";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Dog dog = mapRowToDog(results);
			dogList.add(dog);
		}
		return dogList;
	}
	
	
	private Dog mapRowToDog(SqlRowSet results) {
		Dog dog = new Dog();
		dog.setDogType(results.getString("dog_type"));
		dog.setHairType(results.getString("hair_type"));
		dog.setSheddingLevel(results.getString("shedding_level"));
		dog.setSize(results.getString("size"));
		dog.setActivityLevel(results.getString("activity_level"));
		dog.setHypoallergenic(results.getBoolean("is_hypoallergenic"));
		dog.setGoodWithAllPeople(results.getBoolean("good_with_all_people"));
		dog.setGoodWithCats(results.getBoolean("good_with_cats"));
		dog.setGoodWithDogs(results.getBoolean("good_with_dogs"));
		dog.setEasilyTrainable(results.getBoolean("easily_trainable"));
		dog.setWatchDog(results.getBoolean("is_watch_dog"));
		dog.setDescription(results.getString("description"));
		dog.setName(results.getString("dog_name"));
		
		return dog;
	}
}

