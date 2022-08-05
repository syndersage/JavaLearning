package com.SchildtBeginnersGuide.randomtasks.enumerations.selftest.s12.t03;

enum Tools {
    SCREWDRIVER, HAMMER, WRENCH, PLIERS
}

public class ToolsEnumerations {
    public static void main(String[] args) {
        for (Tools tool: Tools.values()) {
            System.out.println(tool + " ordinal value is: " + tool.ordinal());
        }
    }
}
