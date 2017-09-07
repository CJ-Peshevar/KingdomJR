package combat;

public enum BattleSize {
	Small,
	Medium,
	Large,
	Super;

	public int GetBacklineWidth(){
		return GetPixelSize();
	}

	public int GetBacklineHorizontalOffset(){
		return GetPixelSize();
	}

	public int GetGridPixelWidth(){
		return GetPixelSize();
	}

	public int GetGridPixelHeight(){
		return GetPixelSize();
	}

	public int GetUnitWidth(){
		return GetPixelSize();
	}

	public int GetUnitHeight(){
		return GetPixelSize();
	}

	private int GetPixelSize(){
		switch (this) {
		case Small:
			return 100;
		case Medium:
			return 80;
		case Large:
			return 65;
		case Super:
			return 50;
		}
		
		return 0;
	}

	public int GetGridWidth(){
		switch (this) {
		case Small:
			return 3;
		case Medium:
			return 4;
		case Large:
			return 5;
		case Super:
			return 6;
		}
		
		return 0;
	}

	public int GetGridHeight(){
		switch (this) {
		case Small:
			return 3;
		case Medium:
			return 4;
		case Large:
			return 5;
		case Super:
			return 6;
		}
		
		return 0;
	}
}
