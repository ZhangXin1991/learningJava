package BiXiangDong.XML_Learning;

/**
 *
 */
/*<!--
XML语法
文档声明:
    <?xml 版本号         编码集           ?>
    <?xml version="1.0" encoding="ISO-8859-1"?>
    在编写XML文件时,有些内容不想让解析引擎解析执行, 而是当作原始内容处理
    可以把这些内容放在CDATA区里, 对于CDATA区域内的内容,XML解析程序不会处理,
    而是直接原封不动的输出
    语法: <![CDATA[内容]]>
    <![CDATA[
        <itcast>
        <br/>
        </itcast>
    ]]>
属性值类型:
    EMPTY   :   实体
    ID      :   表示属性的设置值为一个唯一值(由字母,下划线开始)
    ENUMERATED:
    CDATA   :   字符串
转义字符:
    <,>,&....直接百度.....
处理指令:
    处理指令用来指挥解析引擎如何解析XML文档内容
    例如:在XML文档中可以使用xml-stylesheet指令, 通知XML解析引擎,应用css文件显示xml文档内容
        <?xml-stylesheet type="text/css" href="1.css"?>
    处理指令必须以"<?"作为开头,以"?>"作为结尾, XML声明语句就是最常见的一种处理指令
XML约束:
    常用的XML约束技术:
    XML DTD:
        DTD约束(Document Type Definition),全称为文档类型定义
        范例:     文件清单: book.dtd
            <!ELEMENT 书架 (书+)>
            <!ELEMENT 书 (书名,作者,售价)>
            <!ELEMENT 书名 (#PCDATA)>
            <!ELEMENT 作者 (#PCDATA)>
            <!ELEMENT 售价 (#PCDATA)>
        引用DTD约束
        XML文件使用DOCTYPE声明语句来指明它所遵循的DTD文件,DOCTYPE声明语句有两种形式:
            - 当引用的文件在本地时,采用如下方式:
            <!DOCTYPE 文档根节点 SYSTEM"DTD文件的URL">
        例如:<!DOCTYPE 书架 SYSTEM "book.dtd">
            - 当引用的文件是一个公共的文件时, 采用如下方式:
            <!DOCTYPE web-app PUBLIC
            "-//Sun Microsystems, Inc//DTD Web Application 2.3//EN"
            "http://java.sun.com/dtd/web-app_2_3.dtd">
        在DTD文档中使用ELEMENT声明一个XML元素, 语法格式如下所示:
            <!ELEMENT 元素名称 元素类型>
        元素类型可以是元素内容, 或类型
            - 如为元素内容: 则需要使用()括起来, 如:
                <!ELEMENT 书架(书名,作者,售价)>
                <!ELEMENT 书名(#PCDATA)>
            - 如为元素类型,则直接书写,DTD规范定义了如下几种类型:
                |- EMPTY : 用于定义空元素 , 例如: <br/> <hr/>
                |- ANY   : 表示元素内容为任意类型
        在DTD文档中使用ATTLIST声明一个XML属性, 语法格式如下所示:
            <!ATTLIST 元素名
                属性名1 属性值类型 设置说明
                属性名2 属性值类型 设置说明
                ......
            >

        XML Schema
        -->*/
public class L01_XML {
}
