package kodlamaio.hrms.business.adapters.cloudinary;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.business.services.storage.FileOperations;
import kodlamaio.hrms.business.services.storage.FileService;
import kodlamaio.hrms.entities.concretes.enums.StorageType;
@Service
public class CloudinaryFileManager implements FileService{
	@Autowired
	private Environment environment;

	@Override
	public String uploadFile(MultipartFile file) throws IOException {

        Map<String, String> config = new HashMap<String, String>();
        config.put("cloud_name", environment.getProperty("cloudinary.cloud_name"));
        config.put("api_key", environment.getProperty("cloudinary.api_key"));
        config.put("api_secret", environment.getProperty("cloudinary.api_secret"));
        Cloudinary cloudinary = new Cloudinary(config);


        //file operations
        String fileNameWithExtension = FileOperations.getFileNameWithExtension(file);
        String fileName = FileOperations.getFileName(file);
        byte[] fileBytes = FileOperations.getFileBytes(file);
        String filePath = environment.getProperty("cloudinary.file_folder_name") + fileName;

        Object imageVersion;

        try {
            imageVersion = cloudinary.uploader().upload(fileBytes, ObjectUtils.asMap("public_id", filePath)).get("version");
        } catch (IOException exception) {
            throw new RuntimeException("Error uploading file to Cloudinary: " + exception.getMessage(), exception);
        }

        String fileFullPath = "v" + imageVersion + "/" + environment.getProperty("cloudinary.file_folder_name") + fileNameWithExtension;


// Transform
        //String url = cloudinary.url().transformation(new Transformation<>().width(100).height(150).crop("fill")).generate(environment.getProperty("cloudinary.file_folder_name") + fileNameWithExtension);
        //System.out.println(url);
        return  fileFullPath;
	}

	@Override
	public StorageType getFileStorageName() {
		return StorageType.Cloudinary;
	}
}
