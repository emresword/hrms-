package kodlamaio.hrms.business.services.storage;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import kodlamaio.hrms.entities.concretes.enums.StorageType;

public class LocalFileManager implements FileService{

	@Override
	public String uploadFile(MultipartFile file) throws IOException {
		
		File convFile = new File("src/main/resources/temporaryFolder/"+file.getOriginalFilename());
		String path = convFile.getAbsolutePath();
		file.transferTo(Path.of(convFile.getAbsolutePath()));
		
		return path;
	}

	@Override
	public StorageType getFileStorageName() {
		
		return StorageType.Local;
	}

}
