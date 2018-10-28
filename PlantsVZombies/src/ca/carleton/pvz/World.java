package ca.carleton.pvz;

import java.util.Stack;

import ca.carleton.pvz.level.Level;
import ca.carleton.pvz.level.LevelOne;

/**
 * A class to store the levels in the game.
 *
 */
public class World {

	private Stack<Level> levels;

	/**
	 * Constructs a new game world.
	 */
	public World() {
		levels = new Stack<Level>();
	}

	/**
	 * Adds a level to the stack.
	 * 
	 * @param level The level to be added to the stack.
	 */
	public void addLevelToWorld(Level level) {
		if (level != null) {
			levels.add(level);
		}
	}

	/**
	 * Get the current level.
	 * 
	 * @return The current level.
	 */
	public Level getCurrentLevel() {
		return levels.peek();
	}

}
