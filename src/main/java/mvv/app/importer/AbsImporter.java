package mvv.app.importer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.StringUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Manh on 12/9/2015.
 */
public abstract class AbsImporter {
	private static final Logger log = LogManager.getLogger(AbsImporter.class);

	public boolean importFile(String filePath) {

		Path path = Paths.get(filePath);
		if (!Files.exists(path)) {
			log.error("File [{}] does not exist", filePath);
			return false;
		}

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(path.toFile());

			boolean flag = readFile(path);

			if (!flag) {
				log.error("Read file error");
				return false;
			}

			return processData();
		} catch (IOException e) {
			log.error("Can not read file", e);

		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}

		return false;
	}

	protected abstract boolean readFile(Path path) throws IOException;
	protected abstract boolean processData();
}
