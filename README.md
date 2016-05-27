# 4pics1word-tips

Generate words from dictionary for the iOS game *4 Pics 1 Word*!

## Usage:

`java -jar guess-word-1.0.jar '*****' DLKSQEIOUCNM`

Parameter 1 '*****' represents the target word having 5 letters and these letters can be anything

Parameter 2 'DLKSQEIOUCNM' represents the letters given to form the word

Require: **JRE 8**

## Result:

A list of 5-letter words that can be comprised of given letters will be listed, as well as their Chinese explanations. 

```
dunce	n.劣学生,傻瓜
dulse	n.[植] 掌状红皮藻
semon	n.[语](层次语法中的)语义子,义符
snick	n.刻痕v.刻细痕于
snide	n.骗子,卑鄙勾当,赝品,假珠宝adj.伪造的,不诚实的,卑鄙的,暗讽的
...
```

## Programmatic Usage:

```java
import com.sshwind.*;

...

GuessWord.listWords("*****", "DLKSQEIOUCNM")
			.forEach(System.out::println);
```

## Use Another Dictionary:

By default, the program will use its builtin English-Chinese dictionary, which contains approximately 100k words. You can explicitly specify the dictionary you would like to use if the desired word isn't included.

Specify in the argument:

`java -jar guess-word-1.0.jar '*****' DLKSQEIOUCNM -dict dict_file.txt`

Or specify in program:

```java
import com.sshwind.*;

...

Dict.loadFromFile("dict_file.txt");

GuessWord.listWords("*****", "DLKSQEIOUCNM")
			.forEach(System.out::println);
```

The dictionary file has to be plain text file with one word in each line. And each word can then be followed by a tab and its explanation.

## Compiling

Use any Java IDE such as Eclipse to create a project and include the source code, then you can edit and re-compile the program.

Use `make` command to generate the jar package.

## Author
Cheng Chang 2016

