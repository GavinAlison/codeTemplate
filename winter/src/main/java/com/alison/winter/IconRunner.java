package com.alison.winter;

import com.alison.winter.scray.domain.po.App;
import com.alison.winter.scray.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class IconRunner implements CommandLineRunner {

    @Autowired
    private AppRepository appRepository;

    @Override
    public void run(String... args) throws Exception {
        File[] files = new File("D:\\icon").listFiles((dir, name) ->
                name.substring(name.lastIndexOf(".")).equals(".png"));
        if (files == null || files.length == 0) {
            return;
        }
        for (File file : files) {
            String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
            if (appRepository.findByName(fileName) != null) {
                continue;
            }
            byte[] icon = null;
            try {
                InputStream in = new BufferedInputStream(new FileInputStream(file));
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] temp = new byte[1000];
                int n;
                while ((n = in.read(temp)) != -1) {
                    out.write(temp, 0, n);
                }
                in.close();
                out.close();
                icon = out.toByteArray();
                App app = new App();
                app.setName(fileName);
                app.setIcon(icon);
                appRepository.save(app);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
