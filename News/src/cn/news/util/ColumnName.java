package cn.news.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2017/10/26.
 */
/*Ԫע��  ����ע������÷�Χ  ����������ע���������ʲô�ط�
* ȡֵ(ElementType)�У�
��������1.CONSTRUCTOR:��������������
��������2.FIELD:����������
��������3.LOCAL_VARIABLE:���������ֲ�����
��������4.METHOD:������������
��������5.PACKAGE:����������
��������6.PARAMETER:������������
��������7.TYPE:���������ࡢ�ӿ�(����ע������) ��enum����*/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ColumnName {
    //execl�е�����
    String getName();
}
