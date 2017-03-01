package com.company.interesting_tasks.teg_parser;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Сторонние библиотеки такие как " jsoup"о спользовать НЕЛЬЗЯ !
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        String file = "";
        String openTeg = "<span";
        String closeTeg = "</span>";
        while (fileReader.ready()) {
            file += fileReader.readLine();
        }
        file = file.substring(file.indexOf(openTeg), file.lastIndexOf(closeTeg) + closeTeg.length());
        while (file.contains(openTeg)){
            file = getTeg(file, openTeg, closeTeg);
        }
    }

    public static String getTeg(String file, String openTeg, String closeTeg){
        String teg = file.substring(file.indexOf(openTeg), openTeg.length());
        String rest = file.substring(file.indexOf(openTeg) + openTeg.length(), file.lastIndexOf(closeTeg) + closeTeg.length());
        String close = rest.substring(0, rest.indexOf(closeTeg) + closeTeg.length());
        while(close.contains(openTeg)){
            teg += close.substring(0, close.indexOf(openTeg) + openTeg.length());
            close = close.substring(close.indexOf(openTeg) + openTeg.length());
            close += rest.substring(rest.indexOf(close) + close.length(), rest.indexOf(closeTeg, rest.indexOf(close) + close.length()) + closeTeg.length());
        }
        System.out.println(teg + close);
        if (rest.contains(openTeg))
            rest = rest.substring(rest.indexOf(openTeg));
        return rest;
    }
}
