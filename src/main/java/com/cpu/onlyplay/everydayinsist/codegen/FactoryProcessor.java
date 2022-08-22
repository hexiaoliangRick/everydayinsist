package com.cpu.onlyplay.everydayinsist.codegen;

import com.cpu.onlyplay.everydayinsist.codegen.annotation.Factory;
import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.lang.reflect.AnnotatedElement;
import java.util.*;

/**
 * @program: everydayinsist
 * @description: 代码生成器
 * @author: cpuRick
 * @create: 2022-08-14 15:06
 **/
@AutoService(Processor.class)
public class FactoryProcessor extends AbstractProcessor {

    private Types typeUtils;

    private Elements elementUtils;

    private Filer filer;

    private Messager messager;

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(Factory.class.toString());
        return annotations;
    }


    /**
     * 支持的语言版本
     *
     * @return
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    /**
     * 被javac  annoation调用，进行初始化操作
     *
     * @param processingEnv
     */
    @Override
    public void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.typeUtils = processingEnv.getTypeUtils();
        this.elementUtils = processingEnv.getElementUtils();
        this.filer = processingEnv.getFiler();
        this.messager = processingEnv.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Factory.class)
        ) {
            if (element.getKind() != ElementKind.CLASS) {
                error(element, "only class can be used with @%s", Factory.class);
                return true;
            }
        }
        return false;
    }

    private void error(Element e, String msg, Object... args) {
        messager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args), e);
    }
}
