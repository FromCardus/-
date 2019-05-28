package extractor.controll;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

import extractor.service.AADLResolver;
import extractor.service.IntegrationService;
import extractor.service.SYSMLResolver;

@Controller
@EnableAutoConfiguration
public class MainController {
	@Autowired
	AADLResolver ms;
	@Autowired
	SYSMLResolver sr;
	@Autowired
	IntegrationService is;
	
	Map<String, String> aadlFiles = new HashMap<String, String>();
	Map<String, String> sysmlFiles=new HashMap<String, String>();
	
	public void setAadlFiles(Map<String, String> aadlFiles) {
		this.aadlFiles = aadlFiles;		
	}
	public void setSysmlFiles(Map<String, String> sysmlFiles) {
		this.sysmlFiles = sysmlFiles;
	}

	String markedfolder = "src/main/resources/modelresource/MarkedModelFile/";
	public void startIntegration() {
		is.GenerateIntegaraton("wk.xml");
	}
	public void restore() throws Exception {
		aadlFiles.forEach((k, v) -> {
			if(v.contains(";")) {
				String[] innersysfile=v.split(";");
				for(String v2:innersysfile) {
					File s = new File(v2);
					File d = new File(markedfolder + getName(v2));

					try {
						Files.copy(s.toPath(), d.toPath(), StandardCopyOption.REPLACE_EXISTING);
						aadlFiles.put(k, d.getPath());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}else {
				File s = new File(v);
				File d = new File(markedfolder + getName(v));

				try {
					Files.copy(s.toPath(), d.toPath(), StandardCopyOption.REPLACE_EXISTING);
					aadlFiles.put(k, d.getPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
						
		});
		sysmlFiles.forEach((k, v) -> {
			File s = new File(v);
			File d = new File(markedfolder + getName(v));

			try {
				Files.copy(s.toPath(), d.toPath(), StandardCopyOption.REPLACE_EXISTING);
				sysmlFiles.put(k, d.getPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		});
		
	}

	public void SetSysFileID(String archfilepath, String sysfilepath) throws Exception {
		ms.initComponentID(archfilepath);
		//TODO 重复操作了
		ms.SetSysFileID(archfilepath, sysfilepath);
		ms.setAadlFiles(aadlFiles);
		
		
		sr.setSysmlFiles(sysmlFiles);
		
		//foreach是倒序的
	}
	public void begin() throws Exception {
		ms.srvmatchmeta();
		sr.srvmatchmeta();
	}
	private static String getName(String typepath) {
		if (typepath.contains("/")) {
			String[] s = typepath.split("/");
			return s[s.length - 1];
		}
		return "";
	}
	
}
