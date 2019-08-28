package entityTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.genesys.c5_back.entities.Player;
import com.genesys.c5_back.entities.PlayerType;

public class PlayerTests {

	@Test
	public void playerReturnsCreateType() {
		Player player = new Player(PlayerType.ONE);
		assertEquals(player.getType(), PlayerType.ONE);
	}

	@Test
	public void playerHashCodeFromPlayerTypeBytes() {
		Player p1 = new Player(PlayerType.TWO);
		Player p2 = new Player(PlayerType.TWO);
		Player p3 = new Player(PlayerType.ONE);
		Player p4 = new Player(PlayerType.ONE);

		assertEquals(p1.hashCode(), p2.hashCode());
		assertEquals(p3.hashCode(), p4.hashCode());
	}

	@Test
	public void playerComparesEqualityByType() {
		Player p1 = new Player(PlayerType.TWO);
		Player p2 = new Player(PlayerType.TWO);

		assertTrue(p1.equals(p2));
	}
}
