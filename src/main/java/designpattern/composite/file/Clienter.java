package designpattern.composite.file;

import java.io.File;

public class Clienter {
    public static void createTree(Node node) throws Exception{
        File file = new File(node.name);
        File[] f = file.listFiles();
        for(File fi : f){
            if(fi.isFile()){
                Filer filer = new Filer(fi.getAbsolutePath());
                node.addNode(filer);
            }
            if(fi.isDirectory()){
                Noder noder = new Noder(fi.getAbsolutePath());
                node.addNode(noder);
                createTree(noder);//使用递归生成树结构
            }
        }
    }
    public static void main(String[] args) {
        Node noder = new Noder("F:/DemoWork/studyDemo/src/main/java/designpattern/composite");
        try {
            createTree(noder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        noder.display();
    }
}