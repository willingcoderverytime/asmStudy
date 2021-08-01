package com.willing.asmbuilder;

import com.willing.asmbuilder.node.KlassNode;
import org.objectweb.asm.ClassWriter;

public abstract class AbstractNode implements AsmValidate {
    // 隔离级别
    private Integer access;

    // 泛型
    private String signature;

    private boolean isJson=false;
    private boolean isXml=false;


    protected abstract void nameValidate();

    protected abstract void signatureValidate();


    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }


    public abstract void beforeVisit(ClassWriter cw, KlassNode cn);

    public abstract void afterVisit(ClassWriter cw, KlassNode cn);

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setJson(boolean json) {
        isJson = json;
    }

    public void setXml(boolean xml) {
        isXml = xml;
    }

    public String descriptor(IClass output, IClass... inputs) {
        String returns = "V";
        String args = "()";
        if (output != null) {
            returns = output.generatorArgs();
        }
        if (inputs != null) {
            String arrysArgs = "";
            for (IClass input : inputs) {
                String s = input.generatorArgs();
                arrysArgs += s;
            }
            args = "(" + arrysArgs + ")";
        }
        return args + returns;
    }

    public   boolean isJson(){
        return isJson;
    }

    public void setIsJson(){
        isJson=true;
    }
    public boolean isXml(){
        return isXml;
    }
    public void setIsXml(){
        isXml=true;
    }
}
