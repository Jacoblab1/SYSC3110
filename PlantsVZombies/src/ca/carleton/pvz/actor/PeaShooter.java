package ca.carleton.pvz.actor;

import java.awt.Point;
import java.io.InputStream;

import ca.carleton.pvz.level.Level;
import javafx.scene.image.Image;

/**
 * A class for the pea-shooting plant.
 *
 */
public class PeaShooter extends Plant {

	private int hits; // number of hits on zombies

	/**
	 * Creates a new pea-shooting plant. This type of plant can shoot and "kill"
	 * zombies.
	 */
	public PeaShooter() {
		hits = 0;
	}

	/**
	 * Gets the number of times this pea shooter has hit a zombie with its
	 * projectile.
	 *
	 * @return The number of times this pea shooter has hit a zombie with its
	 *         projectile.
	 */
	public int getHits() {
		return hits;
	}

	/**
	 * Resets this pea shooter's hits upon advancing to the next turn.
	 */
	public void newTurn() {
		hits = 0;
	}

	/**
	 * Increments this pea shooter's number of hits by one.
	 */
	public void addHit() {
		++hits;
	}

	/**
	 * Calls upon each pea shooter on map to shoot at any zombies in the same
	 * lane.
	 *
	 * @param game The gameWorld to be modified by this method.
	 */
	public static void shootZombies(Level level) {

		// TODO : Emigrate this method ...

		for (int i = 0; i < level.getDimension().height; ++i) {
			for (int j = 0; j < level.getDimension().width; ++j) {
				Actor o = level.getCell(i, j);
				if (o instanceof PeaShooter) { // if peashooter, shoot all
												// zombies to the right of
												// peashooter
					((PeaShooter) o).newTurn();
					int i1 = i;
					for (int index = i1; index < level.getDimension().height; ++index) {
						Actor o1 = level.getCell(index, j);
						if (o1 instanceof Zombie) {
							while (((PeaShooter) o).getHits() < 4) {

								// while loop - zombie gets hit up to 4 times or
								// health becomes zero
								((Zombie) o1).setHealth(((Zombie) o1).getHealth() - 100);
								((PeaShooter) o).addHit();
								if (((Zombie) o1).getHealth() <= 0) {
									level.placeActor(null, new Point(index, j));
								}

								// if zombie dies and peashooter isn't done
								// shooting, progress to zombies to
								// right
								if (((Zombie) o1).getHealth() == 0 && ((PeaShooter) o).getHits() < 4) {
									for (int i2 = i1 + 1; i2 < level.getDimension().height; ++i2) {
										Actor o2 = level.getCell(i2, j);
										if (o2 instanceof Zombie) {
											while (((PeaShooter) o).getHits() < 4) {
												((Zombie) o2).setHealth(((Zombie) o2).getHealth() - 100);
												((PeaShooter) o).addHit();
												if (((Zombie) o2).getHealth() <= 0) {
													level.placeActor(null, new Point(index, j));
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Gets the peashooter sprite.
	 *
	 * @return The peashooter sprite.
	 */
	@Override
	public Image getSprite() {
		InputStream stream = getClass().getResourceAsStream("peashooter.png");
		return new Image(stream);
	}

}