package ca.carleton.pvz;

import java.util.ArrayList;

import ca.carleton.pvz.level.Level;
import ca.carleton.pvz.level.LevelOne;

public class World {
	private ArrayList<Level> levels;
	private Level currentLevel;
	
	public World() {
		levels = new ArrayList<Level>();
	}
	
	/**
	 * Initialize levels ArrayList with level objects.
	 * @param numLevels number of levels for the current world to have
	 */
	public void addLevelToWorld(Level level) {
		if(level != null) {
			levels.add(level);
		}
	}
	
	/**
	 * Get the currently active level
	 * @return
	 */
	public Level getCurrentLevel() {
		return currentLevel;
	}
	 
}
