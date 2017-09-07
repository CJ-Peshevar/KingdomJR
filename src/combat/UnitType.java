package combat;

import java.awt.Image;

import ui.Resources;

public enum UnitType {
	Soldier,
	Archer,
	Mage,
	Enchanter,
	Guardian;

	public Image GetBadgeIcon() {
		switch (this) {
		case Soldier:
			return Resources.loadImageOrFallback("units", "Class_Badge_Soldier.png");
		case Archer:
			return Resources.loadImageOrFallback("units", "Class_Badge_Archer.png");
		case Mage:
			return Resources.loadImageOrFallback("units", "Class_Badge_Mage.png");
		case Enchanter:
			return Resources.loadImageOrFallback("units", "Class_Badge_Enchanter.png");
		case Guardian:
			return Resources.loadImageOrFallback("units", "Class_Badge_Guardian.png");
		default:
			return Resources.loadImageOrFallback("units", "non-existing");
		}
	}
}
