package mvv.app.importer.cellparser;

/**
 * Created by Manh on 12/9/2015.
 */
public class LengthCellProcessor extends AbsCellProcessor<Double> {

	private static LengthCellProcessor instance;

	public LengthCellProcessor() {
		super(0d);
	}

	@Override
	protected Double parse(String str) {
		return Double.parseDouble(str.substring(0, str.length() - 2));
	}

	public static LengthCellProcessor getInstance() {

		if (instance == null) {
			instance = new LengthCellProcessor();
		}

		return instance;
	}
}
