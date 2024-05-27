package org.example.imports;

import org.example.beans.OtherBeanAnno;
import org.example.myComponent.OtherBean;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        // 需要被封装的Spring容器中的类的全限类名
        return new String[]{OtherBeanAnno.class.getName()};
    }
}
