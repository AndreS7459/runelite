import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public final class NPC extends Actor {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "Ljx;"
	)
	NPCDefinition definition;

	NPC() {
	} // L: 12

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "(IBI)V",
		garbageValue = "307957287"
	)
	final void method2115(int var1, byte var2) {
		int var3 = super.pathX[0]; // L: 15
		int var4 = super.pathY[0]; // L: 16
		if (var1 == 0) { // L: 17
			--var3; // L: 18
			++var4; // L: 19
		}

		if (var1 == 1) { // L: 21
			++var4;
		}

		if (var1 == 2) { // L: 22
			++var3; // L: 23
			++var4; // L: 24
		}

		if (var1 == 3) { // L: 26
			--var3;
		}

		if (var1 == 4) { // L: 27
			++var3;
		}

		if (var1 == 5) { // L: 28
			--var3; // L: 29
			--var4; // L: 30
		}

		if (var1 == 6) { // L: 32
			--var4;
		}

		if (var1 == 7) { // L: 33
			++var3; // L: 34
			--var4; // L: 35
		}

		if (super.sequence != -1 && WorldMapRegion.SequenceDefinition_get(super.sequence).field3541 == 1) {
			super.sequence = -1; // L: 37
		}

		if (super.pathLength < 9) { // L: 38
			++super.pathLength;
		}

		for (int var5 = super.pathLength; var5 > 0; --var5) { // L: 39
			super.pathX[var5] = super.pathX[var5 - 1]; // L: 40
			super.pathY[var5] = super.pathY[var5 - 1]; // L: 41
			super.pathTraversed[var5] = super.pathTraversed[var5 - 1]; // L: 42
		}

		super.pathX[0] = var3; // L: 44
		super.pathY[0] = var4; // L: 45
		super.pathTraversed[0] = var2; // L: 46
	} // L: 47

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(IIZI)V",
		garbageValue = "-1230759297"
	)
	final void method2121(int var1, int var2, boolean var3) {
		if (super.sequence != -1 && WorldMapRegion.SequenceDefinition_get(super.sequence).field3541 == 1) { // L: 50
			super.sequence = -1;
		}

		if (!var3) { // L: 51
			int var4 = var1 - super.pathX[0]; // L: 52
			int var5 = var2 - super.pathY[0]; // L: 53
			if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) { // L: 54
				if (super.pathLength < 9) { // L: 55
					++super.pathLength;
				}

				for (int var6 = super.pathLength; var6 > 0; --var6) { // L: 56
					super.pathX[var6] = super.pathX[var6 - 1]; // L: 57
					super.pathY[var6] = super.pathY[var6 - 1]; // L: 58
					super.pathTraversed[var6] = super.pathTraversed[var6 - 1]; // L: 59
				}

				super.pathX[0] = var1; // L: 61
				super.pathY[0] = var2; // L: 62
				super.pathTraversed[0] = 1; // L: 63
				return; // L: 64
			}
		}

		super.pathLength = 0; // L: 67
		super.field973 = 0; // L: 68
		super.field1032 = 0; // L: 69
		super.pathX[0] = var1; // L: 70
		super.pathY[0] = var2; // L: 71
		super.x = super.pathX[0] * 128 + super.field1014 * 64; // L: 72
		super.y = super.pathY[0] * 128 + super.field1014 * 64; // L: 73
	} // L: 74

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		descriptor = "(I)Ler;",
		garbageValue = "-2026237468"
	)
	protected final Model getModel() {
		if (this.definition == null) { // L: 77
			return null;
		} else {
			SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? WorldMapRegion.SequenceDefinition_get(super.sequence) : null; // L: 78
			SequenceDefinition var2 = super.movementSequence == -1 || super.movementSequence == super.idleSequence && var1 != null ? null : WorldMapRegion.SequenceDefinition_get(super.movementSequence); // L: 79
			Model var3 = this.definition.getModel(var1, super.sequenceFrame, var2, super.movementFrame); // L: 80
			if (var3 == null) { // L: 81
				return null;
			} else {
				var3.calculateBoundsCylinder(); // L: 82
				super.defaultHeight = var3.height; // L: 83
				if (super.spotAnimation != -1 && super.spotAnimationFrame != -1) { // L: 84
					Model var4 = Tiles.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame); // L: 85
					if (var4 != null) { // L: 86
						var4.offsetBy(0, -super.field1003, 0); // L: 87
						Model[] var5 = new Model[]{var3, var4}; // L: 88
						var3 = new Model(var5, 2); // L: 89
					}
				}

				if (this.definition.size == 1) { // L: 92
					var3.isSingleTile = true;
				}

				return var3; // L: 93
			}
		}
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "68470795"
	)
	final boolean isVisible() {
		return this.definition != null; // L: 97
	}
}
