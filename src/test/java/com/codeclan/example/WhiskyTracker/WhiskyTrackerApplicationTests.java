package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> whiskies = whiskyRepository.findByYear(2018);
		assertEquals(6, whiskies.size());
	}

	@Test
	public void canFindDistilleriesByRegion(){
		List<Distillery> distilleries = distilleryRepository.findByRegionIgnoreCase("Speyside");
		assertEquals(3, distilleries.size());
	}

	@Test
	public void canFindWhiskyFromDistilleryByAge(){
		List<Whisky> whiskies = whiskyRepository.findByDistilleryIdAndAge(1L,15);
		assertEquals(1, whiskies.size());
	}

}
