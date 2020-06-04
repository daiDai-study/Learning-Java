package org.daistudy.web.mvc;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        final Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.getInteger("port", 8080));
        tomcat.getConnector();

        final Context context = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
        final StandardRoot standardRoot = new StandardRoot(context);
        standardRoot.addPreResources(
                new DirResourceSet(standardRoot, "/WEB-INF/classes", "target/classes", "/")
        );
        context.setResources(standardRoot);

        tomcat.start();
        tomcat.getServer().await();
    }
}
