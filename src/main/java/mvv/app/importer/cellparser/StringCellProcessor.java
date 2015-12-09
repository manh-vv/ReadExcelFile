package mvv.app.importer.cellparser;

/**
 * Created by Manh on 12/9/2015.
 */
public class StringCellProcessor extends AbsCellProcessor<String> {

	private static StringCellProcessor instance;

	private StringCellProcessor() {
		super("");
	}

	@Override
	protected String parse(String str) {
		return null;
	}

	public static StringCellProcessor getInstance() {

		if (instance == null) {
			instance = new StringCellProcessor();
		}

		return instance;
	}
}
