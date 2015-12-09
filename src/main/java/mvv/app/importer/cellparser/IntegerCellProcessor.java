package mvv.app.importer.cellparser;

/**
 * Created by Manh on 12/9/2015.
 */
public class IntegerCellProcessor extends AbsCellProcessor<Integer> {

	private static IntegerCellProcessor instance;

	public IntegerCellProcessor() {
		super(1);
	}

	@Override
	protected Integer parse(String str) {
		return Integer.valueOf(str);
	}

	public static IntegerCellProcessor getInstance() {
		if(instance == null) {
			instance = new IntegerCellProcessor();
		}

		return instance;
	}
}
