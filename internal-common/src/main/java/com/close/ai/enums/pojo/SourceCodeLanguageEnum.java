package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author taifu
 * @since 2025-01-20
 */
@Getter
@AllArgsConstructor
public enum SourceCodeLanguageEnum {
    JAVA("Java"),
    PYTHON("Python"),
    JAVASCRIPT("JavaScript"),
    GO("Go"),
    C("C"),
    CPP("C++"),
    RUST("Rust"),
    RUBY("Ruby"),
    PHP("PHP"),
    TYPESCRIPT("TypeScript"),
    KOTLIN("Kotlin"),
    SWIFT("Swift"),
    CSHARP("C#"),
    DART("Dart"),
    SCALA("Scala"),
    PERL("Perl"),
    R("R"),
    LUA("Lua"),
    GROOVY("Groovy"),
    SQL("SQL"),
    ;

    private final String language;
}
