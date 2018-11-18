package ca.carleton.pvz.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ca.carleton.pvz.level.LevelOne;
import ca.carleton.pvz.level.Wave;

public class LevelOneTest {
	
	private LevelOne testLevelOne;

	@Before
	public void setUp() throws Exception {
		testLevelOne = new LevelOne();
	}
	
	/**
	 * Tests the method for initial waves
	 * @result All initial waves are created successfully, and for LevelOne, that entails 3 waves
	 */
	@Test
	public void testInitWaves() {
		Wave testWave;
		
		testLevelOne.initWaves();
		testWave = new Wave(1,2);
		assertEquals(testWave.getNum(), testLevelOne.getWave().getNum());
		assertEquals(testWave.getTotalNumZombies(), testLevelOne.getWave().getTotalNumZombies());
		
		testWave = new Wave(2,3);
		testLevelOne.dequeueWave();
		assertEquals(testWave.getNum(), testLevelOne.getWave().getNum());
		assertEquals(testWave.getTotalNumZombies(), testLevelOne.getWave().getTotalNumZombies());
		
		testWave = new Wave(3,4);
		testLevelOne.dequeueWave();
		assertEquals(testWave.getNum(), testLevelOne.getWave().getNum());
		assertEquals(testWave.getTotalNumZombies(), testLevelOne.getWave().getTotalNumZombies());
	}

	// tearDown() is not necessary here, as garbage collection of objects
	// after the test class concludes. Other things that consume system
	// resources may need tearDown() however.

}
