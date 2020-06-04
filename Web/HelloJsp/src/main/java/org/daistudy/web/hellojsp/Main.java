package org.daistudy.web.hellojsp;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        // 创建 tomcat
        final Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.getInteger("port", 8080));
        tomcat.getConnector();

        // 创建 webapp
        final Context context = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
        final StandardRoot resources = new StandardRoot(context);
        resources.addPreResources(
                new DirResourceSet(resources, "/WEB-INF/classes", new File("target/classes").getAbsolutePath(), "/")
        );
        context.setResources(resources);

        // 启动 tomcat
        tomcat.start();
        tomcat.getServer().await();
    }
}
