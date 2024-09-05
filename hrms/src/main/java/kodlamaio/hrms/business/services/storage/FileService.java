package kodlamaio.hrms.business.services.storage;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.entities.concretes.enums.StorageType;
public interface FileService {
	String uploadFile(MultipartFile file) throws IOException;
	StorageType getFileStorageName();
}
