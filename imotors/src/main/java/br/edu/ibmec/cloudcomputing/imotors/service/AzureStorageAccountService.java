package br.edu.ibmec.cloudcomputing.imotors.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;

@Service
public class AzureStorageAccountService {
    public String uploadFileToAzurePost(MultipartFile file) throws IOException{
        String connectionString = "DefaultEndpointsProtocol=https;AccountName=ibmecprojetocloudvh;AccountKey=USOOzGeGOp4qxzGADk9Q6p3yW4UgW3Mmpf3vlGjzfMcTW5Z4wRulcFNappA/O2i0pPtdqjLANPkd+ASt01e9Ww==;EndpointSuffix=core.windows.net";

        BlobContainerClient client = new BlobContainerClientBuilder()
            .connectionString(connectionString)
            .containerName("posts")
            .buildClient();

        BlobClient blob = client.getBlobClient(file.getOriginalFilename());

        blob.upload(file.getInputStream(), file.getSize(), true);

        return "https://ibmecprojetocloudvh.blob.core.windows.net/posts/" + file.getOriginalFilename();
    }

    public String uploadFileToAzureLogo(MultipartFile file) throws IOException{
        String connectionString = "DefaultEndpointsProtocol=https;AccountName=ibmecprojetocloudvh;AccountKey=USOOzGeGOp4qxzGADk9Q6p3yW4UgW3Mmpf3vlGjzfMcTW5Z4wRulcFNappA/O2i0pPtdqjLANPkd+ASt01e9Ww==;EndpointSuffix=core.windows.net";

        BlobContainerClient client = new BlobContainerClientBuilder()
            .connectionString(connectionString)
            .containerName("logos")
            .buildClient();

        BlobClient blob = client.getBlobClient(file.getOriginalFilename());

        blob.upload(file.getInputStream(), file.getSize(), true);

        return "https://ibmecprojetocloudvh.blob.core.windows.net/logos/" + file.getOriginalFilename();
    }
}
