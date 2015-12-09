package mvv.app;

import java.io.File;

import mvv.app.importer.AbsImporter;
import mvv.app.importer.ecabinet.ExcelImporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {
	private static final Logger log = LogManager.getLogger(MainClass.class);

	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		log.info("App start at {}, current directory: {}", t1, System.getProperty("user.dir"));

		MainClass mainClass = new MainClass();
		mainClass.onStart(args);
		mainClass.run(args);
		mainClass.onFinish(args);

		long t2 = System.currentTimeMillis();
		log.info("App end at {}; executed time: {}", t2, t2 - t1);
	}

    /**
     *
     * @author Manh Vu
	 * @param args
     */
    private void onStart(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     *
     * @author Manh Vu
	 * @param args
     */
    private void run(String[] args) {
		if (args == null || args.length < 1) {
			log.error("missing file path parameter");
			return;
		}

		AbsImporter importer = new ExcelImporter();

		importer.importFile(args[0]);
    }

    /**
     *
     * @author Manh Vu
	 * @param args
     */
    private void onFinish(String[] args) {
        // TODO Auto-generated method stub

    }
}
